/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mcliente;
import Vista.ClienteView;
import Vista.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andres
 */
public class Agencia implements ActionListener{
    
    private PrincipalView vistaPrincipal;
    private Cliente cliente;
    private Hotel hotel;
    private Aerolinea aerolinea;
    private Operador operador;

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }
    
    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public PrincipalView getVistaPrincipal() {
        return vistaPrincipal;
    }

    public void setVistaPrincipal(PrincipalView vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }

    public Agencia(PrincipalView vistaPrincipal,Cliente cliente,Hotel hotel,Aerolinea aerolinea,Operador operador) {
        this.vistaPrincipal = vistaPrincipal;
        this.cliente = cliente;
        this.hotel = hotel;
        this.aerolinea = aerolinea;
        this.operador = operador;
        
        this.vistaPrincipal.btnCliente.addActionListener(this);
        this.vistaPrincipal.btnHotel.addActionListener(this);
        this.vistaPrincipal.btnAerolinea.addActionListener(this);
        this.vistaPrincipal.btnOperadores.addActionListener(this);
    }

    
    public void Iniciar(){
       this.vistaPrincipal.setTitle("Agencia Turistica S.A.S.");
       this.vistaPrincipal.setSize(520, 520);
       this.vistaPrincipal.setLocationRelativeTo(null);
       this.vistaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if (this.vistaPrincipal.btnCliente == evento.getSource()){
            cliente.Iniciar();
        }
        if (this.vistaPrincipal.btnHotel == evento.getSource()){
            hotel.Iniciar();
        }
        if (this.vistaPrincipal.btnAerolinea == evento.getSource()){
            aerolinea.Iniciar();
        }
        if (this.vistaPrincipal.btnOperadores == evento.getSource()){
            operador.Iniciar();
        }
    }
    
    
}
