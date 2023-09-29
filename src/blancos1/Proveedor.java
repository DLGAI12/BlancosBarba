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
public class Proveedor {
    int id;
    String nombre, telefono, correo;
    Connection conex;
    
    public Proveedor(){
        conex = Conector.getConnection();
    }
    
    public Proveedor(int Id, String Nombre, String Telefono, String Correo){
        id = Id;
        nombre = Nombre;
        telefono = Telefono;
        correo = Correo;
    }
    
    public int createProveedor (int id,String Nombre, String Telefono, String Correo){
        int r=0;
        String consulta = "INSERT INTO Proveedores(idproveedor, nombreproveedor, telefonoproveedor, correoproveedor"+
               " ) VALUES ("+id+",'"+Nombre+"', '"+Telefono+"', '"+Correo+"');";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }catch(Exception exc){
            System.out.println("Error:  en crear proveedor"+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readProveedor(String campoBusqueda){
    ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty()){
                rs = stm.executeQuery("SELECT * FROM Proveedores");
            }else if(campoBusqueda.matches("[+-]?\\d*(\\.\\d+)?")){
                rs = stm.executeQuery("SELECT * FROM proveedores WHERE idproveedor = "+campoBusqueda+" OR telefonoproveedor LIKE '"+campoBusqueda+"%'");
            }else {
                rs = stm.executeQuery("SELECT * FROM proveedores WHERE nombreproveedor LIKE '%"+campoBusqueda+"%' ");
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }finally{
            return rs;
        }
    }
    
    public int updateProveedor (int id,String Nombre, String Telefono, String Correo){
        int r=0;
        String consulta = "UPDATE proveedores SET nombreproveedor = '"+Nombre+"',  telefonoproveedor = '"+Telefono+"', correoproveedor = '"+Correo+"' "+
               " WHERE idproveedor ="+id+";";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        }catch(Exception exc){
            System.out.println("Error:  en update proveedor"+exc);
        }finally{
            return r;
        }
    }
    
}
