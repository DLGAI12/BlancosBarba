package blancos1;

import Conexion.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author beeet
 */
public class DetalleCompra {
    int idDetalleCompra, idCompra, producto, piezas;
    float valorCompra;
    Connection conex; 
    
    public DetalleCompra(){
        conex = Conector.getConnection();
    }
    
    public DetalleCompra(int detalle, int venta, int prod, int pz, float valor){
        idDetalleCompra = detalle;
        idCompra = venta;
        producto = prod;
        piezas = pz;
        valorCompra = valor;
    }
    
    public int createDetalleCompra(int detalle, int compra, int prod, int pz, float valor){
        int r=0;
        String consulta = "INSERT INTO DetalleCompras(iddetallecompra,idCompra, idProducto, piezasProducto, valorCompra"+
               ")VALUES ("+detalle+", "+compra+","+prod+", "+pz+","+valor+");";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
        }catch(Exception exc){
            System.out.println("Error:  en create detalle compra"+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readDetalleCompra(String campoBusqueda){
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty() ){
            rs = stm.executeQuery("SELECT * FROM DetalleCompras --ORDER BY iddetallecompra");
            }else{
                rs = stm.executeQuery("SELECT * FROM DetalleCompras WHERE idCompra = "+campoBusqueda+" --ORDER BY iddetallecompra");
            }
        }catch(Exception exc){
            System.out.println("Error:  en read detalle compra"+exc.getMessage());
        }
        return rs;
    }
}
