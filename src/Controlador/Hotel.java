/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mhotel;
import Vista.HotelView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andres
 */
public class Hotel implements ActionListener {
    
    private Mhotel modelo;
    private HotelView vista;

    public Mhotel getModelo() {
        return modelo;
    }

    public void setModelo(Mhotel modelo) {
        this.modelo = modelo;
    }

    public HotelView getVista() {
        return vista;
    }

    public void setVista(HotelView vista) {
        this.vista = vista;
    }

    public Hotel(Mhotel modelo, HotelView vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnElminar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
    }
    
    public void Iniciar(){
       this.vista.setTitle("Registro de Hoteles");
       this.vista.setSize(620, 520);
       this.vista.setLocationRelativeTo(null);
       this.vista.setVisible(true);
       Tabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if (evento.getSource() == vista.btnInsertar){
            Insertar();
        }
        if (evento.getSource() == vista.btnBuscar){
            Buscar();
        }
        if (evento.getSource() == vista.btnEditar){
            Editar();
        }
        
        if (evento.getSource() == vista.btnElminar){
            Eliminar();
        }
        
        if (evento.getSource() == vista.btnGuardar){
            Guardar();
        }
    }
    
    public void Insertar() {
        modelo.Insertar();
        vista.txtNit.setText(modelo.getNit());
        vista.txtDv.setText(modelo.getDv());
        vista.txtSocial.setText(modelo.getRazonSocial());
        vista.txtComercial.setText(modelo.getRazonComercial());
        vista.txtDireccion.setText(modelo.getDireccion());
        vista.txtTelefono.setText(modelo.getTelefono());
        vista.txtCiudad.setText(modelo.getCiudad());
        vista.txtPais.setText(modelo.getPais());
        vista.txtEmail.setText(modelo.getEmail());
        vista.txtNit.requestFocus();
    }
    public void Guardar(){
        modelo.Guardar(vista.txtNit.getText(),vista.txtDv.getText(),vista.txtSocial.getText(),vista.txtComercial.getText(),vista.txtDireccion.getText(),vista.txtTelefono.getText(),vista.txtCiudad.getText(),vista.txtPais.getText(),"H",vista.txtEmail.getText());
        Tabla();
        JOptionPane.showMessageDialog(null, "Hotel insertado exitosamente ");
    }
    
    public void Buscar(){
        modelo.Buscar(vista.txtNit.getText());
        vista.txtDv.setText(modelo.getDv());
        vista.txtSocial.setText(modelo.getRazonSocial());
        vista.txtComercial.setText(modelo.getRazonComercial());
        vista.txtDireccion.setText(modelo.getDireccion());
        vista.txtTelefono.setText(modelo.getTelefono());
        vista.txtCiudad.setText(modelo.getCiudad());
        vista.txtPais.setText(modelo.getPais());
        vista.txtEmail.setText(modelo.getEmail());
    }
    
    public void Editar(){
        modelo.Editar(vista.txtNit.getText(),vista.txtDv.getText(),vista.txtSocial.getText(),vista.txtComercial.getText(),vista.txtDireccion.getText(),vista.txtTelefono.getText(),vista.txtCiudad.getText(),vista.txtPais.getText(),"H",vista.txtEmail.getText());
        Tabla();
        JOptionPane.showMessageDialog(null, "Hotel actualizado exitosamente ");
    }
    
    public void Eliminar(){
        modelo.Elminar(vista.txtNit.getText());
        vista.txtNit.setText(modelo.getNit());
        vista.txtDv.setText(modelo.getDv());
        vista.txtSocial.setText(modelo.getRazonSocial());
        vista.txtComercial.setText(modelo.getRazonComercial());
        vista.txtDireccion.setText(modelo.getDireccion());
        vista.txtTelefono.setText(modelo.getTelefono());
        vista.txtCiudad.setText(modelo.getCiudad());
        vista.txtPais.setText(modelo.getPais());
        vista.txtEmail.setText(modelo.getEmail());
        vista.txtNit.requestFocus();
        Tabla();
        JOptionPane.showMessageDialog(null, "Hotel eliminado exitosamente ");
    }
    
    public void Tabla(){
                
        try {
            ResultSet rs = modelo.Listar();
            DefaultTableModel model;
            String[] title = {"Nit", "Dv","Razon Solcial","Razon Comercial","Direccion"};
            model = new DefaultTableModel(null, title);
            String[] data_table = new String[8];
            do {     
                data_table[0] = rs.getString(1);
                data_table[1] = rs.getString(2);
                data_table[2] = rs.getString(3);
                data_table[3] = rs.getString(4);
                data_table[4] = rs.getString(5);
                data_table[5] = rs.getString(6);
                data_table[6] = rs.getString(7);
                data_table[7] = rs.getString(8);
                
                vista.txtNit.setText(rs.getString(1).toString());
                vista.txtDv.setText(rs.getString(2).toString());
                vista.txtSocial.setText(rs.getString(3).toString());
                vista.txtComercial.setText(rs.getString(4).toString());
                vista.txtDireccion.setText(rs.getString(5).toString());
                vista.txtTelefono.setText(rs.getString(6).toString());
                vista.txtCiudad.setText(rs.getString(7).toString());
                vista.txtPais.setText(rs.getString(8).toString());
                vista.txtEmail.setText(rs.getString(10).toString());
                
                model.addRow(data_table);
            } while (rs.next());
            vista.tblHotel.setModel(model);
        } catch (Exception e) {
            System.out.println("Error escribiendo datos en modelo" + e);
        }
    }
}
