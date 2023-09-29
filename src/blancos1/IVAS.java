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
public class IVAS {
    int id, porcentaje;
    String fechaInicio, fechaFin; 
    Connection conex;
    
    public IVAS(){
        conex = Conector.getConnection();
    }
    
    public IVAS( int Id, int porc, String inicio, String fin){
        conex = Conector.getConnection();
        id = Id;
        porcentaje = porc;
        fechaInicio = inicio;
        fechaFin = fin;
    }
    
    public int createIva(int Id, int porc, String Fecha, String fin){
        int r=0;
        String consulta;
        if(fin.isEmpty()){
            fin = "null";
            consulta = "INSERT INTO IVA(idiva, fechaaplicacion, fechatermino, porcentaje"+
               " )	VALUES ("+Id+",'"+Fecha+"', "+fin+", "+porc+");";
        }else{
            consulta = "INSERT INTO IVA(idiva, fechaaplicacion, fechatermino, porcentaje"+
               " )	VALUES ("+Id+",'"+Fecha+"', '"+fin+"', "+porc+");";
        }
        String update ="update iva set fechatermino = '"+Fecha+"' WHERE idIva = "+(Id-1);
        try{
            Statement stm = (Statement) conex.createStatement(), stm1 = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            stm1.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "nuevo iva creado");
        }catch(Exception exc){
            System.out.println("Error en create iva: "+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readIva(String campoBusqueda){
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty() ){
            rs = stm.executeQuery("SELECT * FROM Iva ORDER BY idIVa");
            }else if(campoBusqueda.matches("[+-]?\\d*(\\.\\d+)?")){
                rs = stm.executeQuery("SELECT * FROM Iva WHERE idIva = "+campoBusqueda+" ORDER BY idIVa");
            }else{
                rs = stm.executeQuery("SELECT * FROM Iva WHERE fechaInicio LIKE '"+campoBusqueda+"%'  ORDER BY idIVa");
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
        return rs;
    }
    
}
