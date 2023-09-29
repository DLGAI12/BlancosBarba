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
public class Baja {
    private Connection conex;
    int idBaja,idEmpleado;
    String fechaBaja;
    
    public Baja(){
        conex = Conector.getConnection();
    }
    
    public Baja(int id, int empleado, String fecha){
        idBaja = id;
        idEmpleado = empleado;
        fechaBaja = fecha;
        conex = Conector.getConnection();
    }
    
    public int createBaja(int IdBaja, int IdEmpleado, String Fecha){
        int r=0;
        String consulta = "INSERT INTO bajas (idBaja, idEmpleado, fechabaja)"+
               "VALUES ("+IdBaja+", "+IdEmpleado+", '"+Fecha+"');";
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Baja registrada");
        }catch(Exception exc){
            System.out.println("Error en create baja: "+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readBaja(String campoBusqueda){
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty() ){
            rs = stm.executeQuery("SELECT * FROM Bajas");
            }else{
                rs = stm.executeQuery("SELECT * FROM Bajas WHERE idBaja = "+campoBusqueda);
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
        return rs;
    }
}
