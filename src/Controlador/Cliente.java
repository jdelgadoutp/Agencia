/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Mcliente;
import Vista.ClienteView;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author andres
 */
public class Cliente implements ActionListener{
    
    private Mcliente modelo;
    private ClienteView vista;
            
    public Cliente(Mcliente modelo, ClienteView vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnElminar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
                
    }

    public Mcliente getModelo() {
        return modelo;
    }

    public void setModelo(Mcliente modelo) {
        this.modelo = modelo;
    }

    public ClienteView getVista() {
        return vista;
    }

    public void setVista(ClienteView vista) {
        this.vista = vista;
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
    
    public void Iniciar(){
       this.vista.setTitle("Registro de clientes");
       this.vista.setSize(620, 520);
       this.vista.setLocationRelativeTo(null);
       this.vista.setVisible(true);
       Tabla();
    }
    
    public void Insertar() {
        modelo.Insertar();
        vista.txtId.setText(modelo.getId_pk());
        vista.txtApe1.setText(modelo.getApellido1());
        vista.txtApe2.setText(modelo.getApellido2());
        vista.txtNom1.setText(modelo.getNombre1());
        vista.txtNom2.setText(modelo.getNombre2());
        vista.txtDir.setText(modelo.getDireccion());
        vista.txtTele.setText(modelo.getTelefono());
        vista.txtEmail.setText(modelo.getEmail());
        vista.txtId.requestFocus();
    }
    public void Guardar(){
        modelo.Guardar(vista.txtId.getText(),vista.txtApe1.getText(),vista.txtApe2.getText(),vista.txtNom1.getText(),vista.txtNom2.getText(),vista.txtDir.getText(),vista.txtTele.getText(),vista.txtEmail.getText());
        Tabla();
        JOptionPane.showMessageDialog(null, "Cliente insertado exitosamente ");
    }
    
    public void Buscar(){
        modelo.Buscar(vista.txtId.getText());
        vista.txtApe1.setText(modelo.getApellido1());
        vista.txtApe2.setText(modelo.getApellido2());
        vista.txtNom1.setText(modelo.getNombre1());
        vista.txtNom2.setText(modelo.getNombre2());
        vista.txtDir.setText(modelo.getDireccion());
        vista.txtTele.setText(modelo.getTelefono());
        vista.txtEmail.setText(modelo.getEmail());
    }
    
    public void Editar(){
        modelo.Editar(vista.txtId.getText(),vista.txtApe1.getText(),vista.txtApe2.getText(),vista.txtNom1.getText(),vista.txtNom2.getText(),vista.txtDir.getText(),vista.txtTele.getText(),vista.txtEmail.getText());
        Tabla();
        JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente ");
    }
    
    public void Eliminar(){
        modelo.Elminar(vista.txtId.getText());
        vista.txtId.setText(modelo.getId_pk());
        vista.txtApe1.setText(modelo.getApellido1());
        vista.txtApe2.setText(modelo.getApellido2());
        vista.txtNom1.setText(modelo.getNombre1());
        vista.txtNom2.setText(modelo.getNombre2());
        vista.txtDir.setText(modelo.getDireccion());
        vista.txtTele.setText(modelo.getTelefono());
        vista.txtEmail.setText(modelo.getEmail());
        Tabla();
        JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente ");
    }
    
    public void Tabla(){
                
        try {
            ResultSet rs = modelo.Listar();
            DefaultTableModel model;
            String[] title = {"Id", "Apellido 1","Apellido 2","Nombre 1","Nombre 2"};
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
                
                vista.txtId.setText(rs.getString(1).toString());
                vista.txtApe1.setText(rs.getString(2).toString());
                vista.txtApe2.setText(rs.getString(3).toString());
                vista.txtNom1.setText(rs.getString(4).toString());
                vista.txtNom2.setText(rs.getString(5).toString());
                vista.txtDir.setText(rs.getString(6).toString());
                vista.txtTele.setText(rs.getString(7).toString());
                vista.txtEmail.setText(rs.getString(8).toString());
                
                model.addRow(data_table);
            } while (rs.next());
            vista.tblCliente.setModel(model);
        } catch (Exception e) {
            System.out.println("Error escribiendo datos en modelo" + e);
        }
    }
}
