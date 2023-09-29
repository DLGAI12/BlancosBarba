package blancos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author beeet
 */
public class Blancos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena = "jdbc:postgresql://localhost:5432/Blancos";
        String User = "postgres";
        String password = "220288515";
        try{
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, User, password);
            java.sql.Statement st = conex.createStatement();
            String sql = "SELECT idEmpleado,nombreEmpleado,ApellidosEmpleado FROM Empleados";
            ResultSet result = st.executeQuery(sql);
            while (result.next()){
                String usuario = result.getString("idEmpleado");
                String nombre = result.getString("nombreEmpleado");
                String apellido = result.getString("apellidosEmpleado");
                System.out.println("Usuario: "+usuario+" Nombre: "+nombre+" "+apellido);
            }
            result.close();
            st.close();
            conex.close();
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
    }
    
}
