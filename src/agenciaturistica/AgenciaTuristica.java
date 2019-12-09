/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciaturistica;

import Controlador.Agencia;
import Controlador.Cliente;
import Controlador.Hotel;
import Modelo.Mcliente;
import Modelo.Mhotel;
import Vista.ClienteView;
import Vista.HotelView;
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
        Mhotel mHotel = new Mhotel();
        Mcliente mCliente = new Mcliente();
        Cliente cliente = new Cliente(mCliente,clienteView);
        Hotel hotel = new Hotel(mHotel,hotelView);
        
        Agencia agencia = new Agencia(vistaMain,cliente,hotel);
        
        
        agencia.Iniciar();
        
    }
    
}
