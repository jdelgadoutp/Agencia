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
public class Mpaquete {
    
    private String codigo;
    private String descripcion;
    private Integer adultos;
    private Integer ninos;
    private Integer dias;
    private Double precio;
    private Integer item;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAdultos() {
        return adultos;
    }

    public void setAdultos(Integer adultos) {
        this.adultos = adultos;
    }

    public Integer getNinos() {
        return ninos;
    }

    public void setNinos(Integer ninos) {
        this.ninos = ninos;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Mpaquete() {
        
    }
    
    public void Guardar(String codigo, String descripcion, Integer adultos, Integer ninos, Integer dias, Double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.adultos = adultos;
        this.ninos = ninos;
        this.dias = dias;
        this.precio = precio;
                
        Conexion cn = new Conexion();
        String sql = "Insert Into paquete (codigo_pk,descripcion,adultos,ninos,dias,precio)" + " Values ('"
                + this.codigo + "','" 
                + this.descripcion + "','"
                + this.adultos + "','"
                + this.ninos + "','"
                + this.dias + "','"
                + this.precio + "');";
        
        cn.setConexionPostgres();
        cn.sentenciasNoSelect(sql);
        cn.closeConexion();
    }
    
    public void Elminar(String codigo){
        Conexion cn = new Conexion();
        cn.setConexionPostgres();
        String sql = "Delete from paquete where codigo_pk='" + codigo + "';";
        cn.sentenciasNoSelect(sql);
        cn.closeConexion();
        
        this.codigo = null;
        this.descripcion = null;
        this.adultos = 0;
        this.ninos = 0;
        this.dias = 0;
        this.item = 1;
        this.precio = 0.0;
        this.tipo = null;
    }
    
    public void Insertar(){
        this.codigo = null;
        this.descripcion = null;
        this.adultos = 0;
        this.ninos = 0;
        this.dias = 0;
        this.item = 1;
        this.precio = 0.0;
        this.tipo = null;
    }
    
    public ResultSet Listar(){
        String sql = "Select * from paquete order by codigo_pk;";
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
    
    public ResultSet ListarK(String codigo){
        
        String sql = "Select a.codigo_fk,a.item,p.razonsocial,p.tipo"
                   + "from paquete_kits as a"
                   + "inner join proveedor as p on (a.nit_fk=p.nit)"
                   + "where codigo_fk='" + codigo + "' order by codigo_fk;" ;
        
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
}
