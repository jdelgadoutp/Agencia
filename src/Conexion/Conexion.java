/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Level;
import java.util.logging.Logger;
        

/**
 *
 * @author andres
 */
public class Conexion {
    
    private String URLAccess = "jdbc:postgresql://localhost:5432/agencia";
    private String usuario = "kyndo";
    private String contrasena = "kyndo.net";
    private Connection conexion;

    public String getURLAccess() {
        return URLAccess;
    }

    public void setURLAccess(String URLAccess) {
        this.URLAccess = URLAccess;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void setConexionPostgres(){
        
        try {
            setURLAccess(URLAccess);
            setUsuario(usuario);
            setContrasena(contrasena);
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(this.URLAccess, this.usuario, this.contrasena);
            System.out.println(" Conexion exitosa URL : " + this.URLAccess + " Usuario : " + this.usuario);
        } catch (Exception e) {
            System.out.println(" Error conexion : " + e.toString());
        }
        
    }
    
    public void closeConexion(){
        try {
            conexion.close();
            System.out.println(" Conexion cerrada con exito");
        } catch (Exception e) {
            System.out.println(" Error cerrando conexion : " + e.toString());
        }
        
    }
    
    public void sentenciasNoSelect(String consulta){
        
        try {
            
            Statement st = conexion.createStatement();
            st.executeUpdate(consulta);
            //conexion.commit();          
            
        } catch (Exception e) {
            System.out.println(" Error en actualizacion consulta no Select " + e.toString());
        }
        
    }
    
    public ResultSet setDatosConsulta(String consulta){
        
        ResultSet rx = null; 
        
        try {
            
            int i=0;
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            rx = rs;            
            while ( rs.next()){
                
                i++;
                
                for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {
                    
                    //System.out.println(rs.getObject(j)+"\t");
                    //System.out.println("");
                
                }
                
                return rs;
                
            }
        } catch (Exception e) {
            System.out.println(" Error en consulta Select " + e.toString());
        }
       
        return rx;
    }
    
    public void getMetaDataTable(String consulta){
        
        try {
            
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(" Número de campos : " + rs.getMetaData().getColumnCount());
            int i=1;
            
            while (i <= rs.getMetaData().getColumnCount()){
                
                System.out.println(" Campo : " + rs.getMetaData().getColumnName(i) + ",Tipo : " + rs.getMetaData().getColumnTypeName(i));
                i++;
                           
            }
        } catch (Exception e) {
            System.out.println(" Error consultado campos en tabla : " + e.toString());
        }
    }
}
