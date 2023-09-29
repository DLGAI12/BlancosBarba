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
import javax.swing.JOptionPane;

/**
 *
 * @author beeet
 */
public class DetalleBaja {
    private Connection conex;
    int idDetalleBaja, idBaja,idProducto, piezas;
    String motivo;
    
    public DetalleBaja(){
        conex = Conector.getConnection();
    }
    
    public DetalleBaja(int id, int baja, int producto, int pz, String motiv){
        idDetalleBaja = id;
        idBaja = baja;
        idProducto = producto;
        piezas = pz;
        motivo = motiv;
        conex = Conector.getConnection();
    }
    
    public int createDetalleBaja(int id, int baja, int producto, int pz, String motiv){
        int r=0;
        String consulta = "INSERT INTO detallebajas (iddetallebaja,idBaja, idproducto, piezasbaja, motivo)"+
               "VALUES ("+id+", "+baja+", "+producto+", "+pz+", '"+motiv+"');";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            //JOptionPane.showMessageDialog(null, "Detalle de Baja registrada");
        }catch(Exception exc){
            System.out.println("Error en create baja: "+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readDetalleBaja(String campoBusqueda){
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty() ){
            rs = stm.executeQuery("SELECT * FROM detalleBajas");
            }else{
                rs = stm.executeQuery("SELECT * FROM detalleBajas WHERE idBaja = "+campoBusqueda);
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
        return rs;
    }
}
