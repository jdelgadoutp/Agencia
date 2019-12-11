/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciaturistica;

import Controlador.Aerolinea;
import Controlador.Agencia;
import Controlador.Cliente;
import Controlador.Hotel;
import Controlador.Operador;
import Controlador.Paquete;
import Modelo.Maerolinea;
import Modelo.Mcliente;
import Modelo.Mhotel;
import Modelo.Moperador;
import Modelo.Mpaquete;
import Vista.AerolineaView;
import Vista.ClienteView;
import Vista.HotelView;
import Vista.OperadorView;
import Vista.PaqueteView;
import Vista.PrincipalView;

/**
 *
        vista.txtEmail.setText(modelo.getEmail()
 * @author andres
 */
public class AgenciaTuristica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PrincipalView vistaMain = new PrincipalView();
        ClienteView clienteView = new ClienteView();
        HotelView hotelView = new HotelView();
        AerolineaView aerolineaView = new AerolineaView();
        OperadorView operadorView = new OperadorView();
        PaqueteView paqueteView = new PaqueteView();
        Mpaquete mPaquete = new Mpaquete();
        Moperador Moperador = new Moperador();
        Maerolinea mAaerolinea = new Maerolinea();
        Mhotel mHotel = new Mhotel();
        Mcliente mCliente = new Mcliente();
        Cliente cliente = new Cliente(mCliente,clienteView);
        Hotel hotel = new Hotel(mHotel,hotelView);
        Aerolinea aerolinea = new Aerolinea(mAaerolinea,aerolineaView);
        Operador operador = new Operador(Moperador,operadorView);
        Paquete paquete = new Paquete(mPaquete,paqueteView);
        
        Agencia agencia = new Agencia(vistaMain,cliente,hotel,aerolinea,operador,paquete);
        
        
        agencia.Iniciar();
        
    }
    
}
