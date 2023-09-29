
package blancos1;

import Conexion.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Compra {
    private Connection conex;
    int idCompra,idProveedor,idEmpleado;
    String fechaCompra;
    
    public Compra(){
        conex = Conector.getConnection();
    }
    
    public Compra(int id, int proveedor, int empleado, String fecha){
        idCompra = id;
        idProveedor = proveedor;
        idEmpleado = empleado;
        fechaCompra = fecha;
        conex = Conector.getConnection();
    }
    
    public int createCompra(int IdCompra, String IdProveedor, int IdEmpleado, String Fecha){
        int r=0;
        String consulta = "INSERT INTO compras (idCompra, idProveedor, idempleado, fechacompra)"+
               "VALUES ("+IdCompra+", "+IdProveedor+","+IdEmpleado+", '"+Fecha+"');";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Compra registrada");
        }catch(Exception exc){
            System.out.println("Error en create venta: "+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readCompra(String campoBusqueda){
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty() ){
            rs = stm.executeQuery("SELECT * FROM Compras");
            }else{
                rs = stm.executeQuery("SELECT * FROM Compras WHERE idCompra = "+campoBusqueda);
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
        return rs;
    }
}
