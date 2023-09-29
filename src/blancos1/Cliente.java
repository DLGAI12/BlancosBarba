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
public class Cliente {
    int id;
    String nombre, apellidos, telefono, correo;
    private Connection conex;
    
    public Cliente(){
        conex = Conector.getConnection();
    }
    public Cliente(String Nombre, String Apellidos, String Telefono, String Correo){
        id = Login.emp.getNextID("Clientes", "idCliente");
        nombre = Nombre;
        apellidos = Apellidos;
        telefono = Telefono;
        correo = Correo;
    }
    
    public int createCliente (int id,String Nombre, String Apellidos, String Telefono, String Correo){
        int r=0;
        String consulta = "INSERT INTO Clientes(idcliente, nombreCliente, apellidosCliente, telefonoCliente, correoCliente"+
               " ) VALUES ("+id+",'"+Nombre+"', '"+Apellidos+"', '"+Telefono+"', '"+Correo+"');";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }catch(Exception exc){
            System.out.println("Error:  en crear cliente"+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readCliente(String campoBusqueda){
    ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty()){
                rs = stm.executeQuery("SELECT * FROM Clientes ORDER BY idCliente");
            }else if(campoBusqueda.matches("[+-]?\\d*(\\.\\d+)?")){
                rs = stm.executeQuery("SELECT * FROM Clientes WHERE idCliente = "+campoBusqueda+" OR telefonoCliente LIKE '"+campoBusqueda+"%' ORDER BY idCliente");
            }else {
                rs = stm.executeQuery("SELECT * FROM Clientes WHERE nombreCliente LIKE '%"+campoBusqueda+"%' OR apellidosCliente LIKE '%"+campoBusqueda+"%' ORDER BY idCliente");
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }finally{
            return rs;
        }
    }
    
    public int updateCliente (int id,String Nombre, String Apellidos, String Telefono, String Correo){
        int r=0;
        String consulta = "UPDATE Clientes SET nombreCliente = '"+Nombre+"', apellidosCliente = '"+Apellidos+"', telefonoCliente = '"+Telefono+"', correoCliente = '"+Correo+"' "+
               " WHERE idCliente ="+id+";";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        }catch(Exception exc){
            System.out.println("Error:  en update cliente"+exc);
        }finally{
            return r;
        }
    }
}
