/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mpaquete;
import Vista.PaqueteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andres
 */
public class Paquete implements ActionListener {
    
    private Mpaquete modelo;
    private PaqueteView vista;

    public Mpaquete getModelo() {
        return modelo;
    }

    public void setModelo(Mpaquete modelo) {
        this.modelo = modelo;
    }

    public PaqueteView getVista() {
        return vista;
    }

    public void setVista(PaqueteView vista) {
        this.vista = vista;
    }


    public Paquete(Mpaquete modelo, PaqueteView vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnInsertar.addActionListener(this);
        //this.vista.btnBuscar.addActionListener(this);
        //this.vista.btnEditar.addActionListener(this);
        //this.vista.btnElminar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
    }
    
    public void Iniciar(){
       this.vista.setTitle("Registro de paquetes turísticos");
       this.vista.setSize(520, 520);
       this.vista.setLocationRelativeTo(null);
       this.vista.setVisible(true);
       Tabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if (evento.getSource() == vista.btnInsertar){
            Insertar();
        }
        if (evento.getSource() == vista.btnGuardar){
            Guardar();
        }
    }
    
    public void Insertar() {
        modelo.Insertar();
        vista.txtCodigo.setText(modelo.getCodigo());
        vista.txtDescripcion.setText(modelo.getDescripcion());
        vista.txtAdulto.setText(modelo.getAdultos().toString());
        vista.txtNino.setText(modelo.getNinos().toString());
        vista.txtDias.setText(modelo.getDias().toString());
        vista.txtPrecio.setText(modelo.getPrecio().toString());
        vista.txtCodigo.requestFocus();
    }
    
    public void Guardar(){
        modelo.Guardar(vista.txtCodigo.getText(),vista.txtDescripcion.getText(),Integer.parseInt(vista.txtAdulto.getText()),Integer.parseInt(vista.txtNino.getText()),Integer.parseInt(vista.txtDias.getText()),Double.parseDouble(vista.txtPrecio.getText()));
        Tabla();
        JOptionPane.showMessageDialog(null, "Paquete insertado exitosamente ");
    }
    
    public void Tabla(){
                
        try {
            ResultSet rs = modelo.Listar();
            DefaultTableModel model;
            String[] title = {"Codigo", "Descripcion","Adultos","Niños","Dias","Precio"};
            model = new DefaultTableModel(null, title);
            String[] data_table = new String[10];
            do {
                
                for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++){
                    data_table[j-1] = rs.getString(j);
                }
                
                vista.txtCodigo.setText(rs.getString(1).toString());
                vista.txtDescripcion.setText(rs.getString(2).toString());
                vista.txtAdulto.setText(rs.getString(3).toString());
                vista.txtNino.setText(rs.getString(4).toString());
                vista.txtDias.setText(rs.getString(5).toString());
                vista.txtPrecio.setText(rs.getString(6).toString());
                            
                model.addRow(data_table);
            } while (rs.next());
            vista.tblPaquete.setModel(model);
        } catch (Exception e) {
            System.out.println("Error escribiendo datos en modelo" + e);
        }
    }
}
