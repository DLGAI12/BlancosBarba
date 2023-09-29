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
public class DetalleVenta {
    int idDetalleVenta, idVenta, producto, piezas;
    Connection conex; 
    
    public DetalleVenta(){
        conex = Conector.getConnection();
    }
    
    public DetalleVenta(int detalle, int venta, int prod, int pz){
        idDetalleVenta = detalle;
        idVenta = venta;
        producto = prod;
        piezas = pz;
    }
    
    public int createDetalleVenta(int detalle, int venta, int prod, int pz){
        int r=0;
        String consulta = "INSERT INTO public.Detalleventas(iddetalleventas,idventa, idProducto, cantidad"+
               ")VALUES ("+String.valueOf(detalle)+", "+String.valueOf(venta)+","+String.valueOf(prod)+", "+String.valueOf(pz)+");";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
        }catch(Exception exc){
            System.out.println("Error:  en create detalle"+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readDetalleVenta(String campoBusqueda){
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty() ){
            rs = stm.executeQuery("SELECT * FROM DetalleVentas ORDER BY iddetalleventas");
            }else{
                rs = stm.executeQuery("SELECT * FROM DetalleVentas WHERE idVenta = "+campoBusqueda+" ORDER BY iddetalleventas");
            }
        }catch(Exception exc){
            System.out.println("Error:  en read detalle "+exc.getMessage());
        }
        return rs;
    }
    
}
