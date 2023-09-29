package blancos1;

import Conexion.Conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author beeet
 */
public class Empleado {
    private Connection conex;
    
    int id;
    String nombre, apellidos, direccion, cargo, telefono, status, password;
    float sueldo;
    private static Cliente c = null;
    private Venta v;
    private DetalleVenta dv;
    
    public Empleado(){
        conex = Conector.getConnection();
        v = new Venta();
        dv = new DetalleVenta();
        c = new Cliente();
        
    }
    
    public Empleado(int iId, String sNombre, String sApellidos, String sDireccion, String sCargo, String sTelefono, String sStatus, String sPassword, float fSueldo){
        conex = Conector.getConnection();
        v = new Venta();
        dv = new DetalleVenta();
        c = new Cliente();
        id = iId;
        nombre = sNombre;
        apellidos = sApellidos;
        direccion = sDireccion;
        cargo = sCargo;
        telefono = sTelefono;
        status = sStatus;
        password = sPassword;
        sueldo = fSueldo;
    }
    
    public void createEmpleado(int iId, String sNombre, String sApellidos, String sCargo, String sDireccion,  String sTelefono, float fSueldo, String sStatus, String sPassword){
        String consulta = "INSERT INTO Empleados(idEmpleado, nombreEmpleado, apellidosEmpleado, cargo, direccionEmpleado, telefonoEmpleado,sueldo, status, password)"+
                " VALUES("+getNextID("Empleados","idEmpleado")+", '"+sNombre+"','"+sApellidos+"','"+sCargo+"','"+sDireccion+"','"+sTelefono+"', "+fSueldo+", '"+sStatus+"', '"+sPassword+"')";
        try{
            Statement stm = conex.createStatement();
            stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Bienvenido a Blancos Barba "+sNombre+" "+sApellidos);
        }catch(Exception exc){
            System.out.println("Error: "+exc);
        }
    }
    
    public ResultSet readEmpleado(String campoBusqueda){
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty()){
               rs = stm.executeQuery("SELECT * FROM Empleados ORDER BY idempleado"); 
            }else if(campoBusqueda.matches("[+-]?\\d*(\\.\\d+)?")){
                rs = stm.executeQuery("SELECT * FROM Empleados WHERE idEmpleado = "+campoBusqueda+"OR telefonoEmpleado LIKE '"+campoBusqueda+"%' ORDER BY idempleado");
            }else{
                rs = stm.executeQuery("SELECT * FROM Empleados WHERE nombreEmpleado LIKE '%"+campoBusqueda+"%' OR apellidosEmpleado LIKE '%"+campoBusqueda+"%' OR status LIKE '"+campoBusqueda+"%'OR cargo LIKE '"+campoBusqueda+"%' ORDER BY idempleado");
            }
        }catch(Exception exc){
            System.out.println("Error: en read producto "+exc.getMessage());
        }finally{
            if(rs == null){ System.out.println("vacio");}
            return rs;
        }
    }
    
    public void updateEmpleado(int iId, String sCargo, String sDireccion,  String sTelefono, float fSueldo, String sStatus){
        String consulta = "UPDATE public.empleados\n" +
"	SET cargo='"+sCargo+"', direccionempleado='"+sDireccion+"', telefonoempleado ='"+sTelefono+"', sueldo="+fSueldo+", status='"+sStatus+
"'	WHERE idEmpleado = "+iId+";";
        try{
            Statement stm = conex.createStatement();
            stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Infomacion del emplead actualizada");
        }catch(Exception exc){
            System.out.println("Error: "+exc);
        }
    }
    
    public void updateEmpleado(int iId, String sPassword){
        String consulta = "UPDATE public.empleados\n" +
"	SET password = '"+sPassword+"' "+
"	WHERE idEmpleado = "+iId+";";
        try{
            Statement stm = conex.createStatement();
            stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Password actualizado");
        }catch(Exception exc){
            System.out.println("Error: "+exc);
        }
    }
    
    public int getNextID(String tabla, String campo){
        int out = 1;
            String cadena = "jdbc:postgresql://localhost:5432/Blancos";
            String User = "postgres";
            String password = "220288515";
            try{
                Class.forName("org.postgresql.Driver");
                Connection conex = DriverManager.getConnection(cadena, User, password);
                java.sql.Statement st = conex.createStatement();
                String sql = "SELECT MAX("+campo+") FROM "+tabla+";";
                ResultSet result = st.executeQuery(sql);
                result.next();
                out = result.getInt("max")+1;
                result.close();
                st.close();
                conex.close();
            }catch(Exception exc){
                System.out.println("Error: "+exc.getMessage());
            }
        return out;
    }
    
}
