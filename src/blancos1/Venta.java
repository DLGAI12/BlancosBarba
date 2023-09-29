/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blancos1;

import Conexion.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author beeet
 */
public class Venta {
    private Connection conex;
    int idVenta,idCliente,idVendedor,idRepartidor;
    String fechaVenta, fechaEntrega, status, direccion;
    
    public Venta(int IdVenta, int IdCliente, int IdVendedor, int IdRepartidor, String FechaVenta, String FechaEntrega, String Status, String Direccion){
        idVenta = IdVenta;
        idCliente = IdCliente;
        idVendedor = IdVendedor;
        idRepartidor = IdRepartidor;
        fechaVenta = FechaVenta;
        fechaEntrega = FechaEntrega; 
        status = Status;
        direccion = Direccion;
    }

    public Venta() { 
        conex = Conector.getConnection();
    }
    
    public int createVenta(int IdVenta, int IdCliente, int IdVendedor, int IdRepartidor, String FechaVenta, String FechaEntrega, String Status, String Direccion){
        int r=0;
        String consulta = "INSERT INTO public.ventas(idventa, idcliente, idvendedor, idrepartidor, fechaventa, direccionentrega,"+
               " fechaentrega, status)	VALUES (default, "+IdCliente+","+IdVendedor+", "+IdRepartidor+", '"+FechaVenta+"', '"+Direccion+"', '"+FechaEntrega+"', '"+Status+"');";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
        }catch(Exception exc){
            System.out.println("Error en create venta: "+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readVenta(String campoBusqueda){
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty() ){
            rs = stm.executeQuery("SELECT * FROM Ventas");
            }else if(campoBusqueda.matches("[+-]?\\d*(\\.\\d+)?")){
                rs = stm.executeQuery("SELECT * FROM Ventas WHERE idVenta = "+campoBusqueda);
            }else{
                rs = stm.executeQuery("SELECT * FROM Ventas WHERE status LIKE '"+campoBusqueda+"%'");
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
        return rs;
    }
    
    public int updateVenta(String id,String status){
        int r=0;
        String consulta = "UPDATE ventas SET  status='"+status+"'	WHERE idventa ="+id+";";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
        }catch(Exception exc){
            System.out.println("Error en update venta: "+exc);
        }finally{
            return r;
        }
    }
}
