/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author andres
 */
public class Maerolinea {
    
    private String nit;
    private String dv;
    private String razonSocial;
    private String razonComercial;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String pais;
    private String tipo="A";
    private String email;

    public Maerolinea() {
    }

    public String getNit() {
        return nit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonComercial() {
        return razonComercial;
    }

    public void setRazonComercial(String razonComercial) {
        this.razonComercial = razonComercial;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void Guardar(String nit, String dv, String social, String comercial, String direcion, String telefono, String ciudad, String pais,String tipo,String email) {
        this.nit = nit;
        this.dv = dv;
        this.razonSocial = social;
        this.razonComercial = comercial;
        this.direccion = direcion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tipo = tipo;
        this.email = email;
        
        Conexion cn = new Conexion();
        String sql = "Insert Into proveedor (nit,dv,razonsocial,razoncomercial,direccion,telefono,ciudad,pais,tipo,email)" + " Values ('"
                + this.nit + "','" 
                + this.dv + "','"
                + this.razonSocial + "','"
                + this.razonComercial + "','"
                + this.direccion + "','"
                + this.telefono + "','"
                + this.ciudad + "','"
                + this.pais + "','"
                + this.tipo + "','"
                + this.email + "');"
                ;
        cn.setConexionPostgres();
        cn.sentenciasNoSelect(sql);
        cn.closeConexion();
    }
    
    public void Buscar(String nit){
        
        String sql = "Select * from proveedor where nit='" + nit + "' and tipo='H';";
        Conexion cn = new Conexion();
        cn.setConexionPostgres();
        ResultSet rs = cn.setDatosConsulta(sql);
        
        try {
            this.dv = rs.getObject(2).toString();
            this.razonSocial = rs.getObject(3).toString();
            this.razonComercial = rs.getObject(4).toString();
            this.direccion = rs.getObject(5).toString();
            this.telefono = rs.getObject(6).toString();
            this.ciudad = rs.getObject(7).toString();
            this.pais = rs.getObject(8).toString();
            this.tipo = rs.getObject(9).toString();
            this.email = rs.getObject(10).toString();
        } catch (Exception e) {
            System.out.println("Error escribiendo datos en modelo" + e);
        }
        cn.closeConexion();
    }
    
    public void Editar(String nit, String dv, String social, String comercial, String direcion, String telefono, String ciudad, String pais,String tipo,String email) {
        
        this.nit = nit;
        this.dv = dv;
        this.razonSocial = social;
        this.razonComercial = comercial;
        this.direccion = direcion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tipo = tipo;
        this.email = email;
        
        Conexion cn = new Conexion();
        cn.setConexionPostgres();
        
        String sql = "Update proveedor set dv='"
                + this.dv + "',razonsocial='"
                + this.razonSocial + "',razoncomercial='"
                + this.razonComercial + "',direccion='"
                + this.direccion + "',telefono='"
                + this.telefono + "',ciudad='"
                + this.ciudad + "',pais='"
                + this.pais + "',tipo='"
                + this.tipo + "',email='"
                + this.email + "'"
                + " Where nit='"
                + this.nit + "';";
        cn.sentenciasNoSelect(sql);
        cn.closeConexion();
        
    }
    
    public void Elminar(String nit){
        Conexion cn = new Conexion();
        cn.setConexionPostgres();
        String sql = "Delete from proveedor where nit='" + nit + "';";
        cn.sentenciasNoSelect(sql);
        cn.closeConexion();
        this.nit = null;
        this.dv = null;
        this.razonSocial = null;
        this.razonComercial = null;
        this.direccion = null;
        this.telefono = null;
        this.ciudad = null;
        this.pais = null;
        this.tipo = null;
        this.email = null;
    }
    
    public ResultSet Listar(){
        String sql = "Select * from proveedor where tipo='A' order by nit;";
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
        this.nit = null;
        this.dv = null;
        this.razonSocial = null;
        this.razonComercial = null;
        this.direccion = null;
        this.telefono = null;
        this.ciudad = null;
        this.pais = null;
        this.tipo = null;
        this.email = null;
    }
    
}
