/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class Mcliente {
    
    private String id_pk;
    private String apellido1;
    private String apellido2;
    private String nombre1;
    private String nombre2;
    private String direccion;
    private String telefono;
    private String email;

    public Mcliente(String id_pk, String apellido1, String apellido2, String nombre1, String nombre2, String direccion, String telefono, String email) {
        this.id_pk = id_pk;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Mcliente() {
    }
    
    
    public String getId_pk() {
        return id_pk;
    }

    public void setId_pk(String id_pk) {
        this.id_pk = id_pk;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void Guardar(String id_pk, String apellido1, String apellido2, String nombre1, String nombre2, String direccion, String telefono, String email) {
        this.id_pk = id_pk;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        
        Conexion cn = new Conexion();
        String sql = "Insert Into cliente (id_pk,apellido1,apellido2,nombre1,nombre2,direccion,telefono,email)" + " Values ('"
                + this.id_pk + "','" 
                + this.apellido1 + "','"
                + this.apellido2 + "','"
                + this.nombre1 + "','"
                + this.nombre2 + "','"
                + this.direccion + "','"
                + this.telefono + "','"
                + this.email + "');"
                ;
        cn.setConexionPostgres();
        cn.sentenciasNoSelect(sql);
        cn.closeConexion();
    }
    
    public void Buscar(String id_pk){
        
        String sql = "Select * from cliente where id_pk='" + id_pk + "';";
        Conexion cn = new Conexion();
        cn.setConexionPostgres();
        ResultSet rs = cn.setDatosConsulta(sql);
        
        try {
            this.apellido1 = rs.getObject(2).toString();
            this.apellido2 = rs.getObject(3).toString();
            this.nombre1 = rs.getObject(4).toString();
            this.nombre2 = rs.getObject(5).toString();
            this.direccion = rs.getObject(6).toString();
            this.telefono = rs.getObject(7).toString();
            this.email = rs.getObject(8).toString();
        } catch (Exception e) {
            System.out.println("Error escribiendo datos en modelo" + e);
        }
        cn.closeConexion();
    }
    
    public void Editar(String id_pk, String apellido1, String apellido2, String nombre1, String nombre2, String direccion, String telefono, String email) {
        
        this.id_pk = id_pk;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        
        Conexion cn = new Conexion();
        cn.setConexionPostgres();
        
        String sql = "Update cliente set apellido1='"
                + this.apellido1 + "',apellido2='"
                + this.apellido2 + "',nombre1='"
                + this.nombre1 + "',nombre2='"
                + this.nombre2 + "',direccion='"
                + this.direccion + "',telefono='"
                + this.telefono + "',email='"
                + this.email + "'"
                + " Where id_pk='"
                + this.id_pk + "';";
        cn.sentenciasNoSelect(sql);
        cn.closeConexion();
        
    }
    
    public void Elminar(String id_pk){
        Conexion cn = new Conexion();
        cn.setConexionPostgres();
        String sql = "Delete from cliente where id_pk='" + id_pk + "';";
        cn.sentenciasNoSelect(sql);
        cn.closeConexion();
        this.id_pk = null;
        this.apellido1 = null;
        this.apellido2 = null;
        this.nombre1 = null;
        this.nombre2 = null;
        this.direccion = null;
        this.telefono = null;
        this.email = null;
    }
    
    public ResultSet Listar(){
        String sql = "Select * from cliente order by id_pk;";
        Conexion cn = new Conexion();
        cn.setConexionPostgres();
        ResultSet rs = null;
        try {
            rs = cn.setDatosConsulta(sql);
        } catch (Exception e) {
            System.out.println("Modelo.Mcliente.Listar()" + e);
        }
        cn.closeConexion();
        return rs;
    }
    
    public void Insertar(){
        this.id_pk = null;
        this.apellido1 = null;
        this.apellido2 = null;
        this.nombre1 = null;
        this.nombre2 = null;
        this.direccion = null;
        this.telefono = null;
        this.email = null;
    }
}