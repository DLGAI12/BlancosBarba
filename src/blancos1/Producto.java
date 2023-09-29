/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blancos1;

import Conexion.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author beeet
 */
public class Producto {
    private Connection conex ;
    int id =0, existencia = 0;
    String descripcion="",tamanio="",color="";
    float precio = 0;
    
    public Producto(){
        conex = Conector.getConnection();
    }
    
    public Producto(int Id,String Descripcion, String Color, String Tamanio, float Precio, int Existencia){
        id = Id;
        descripcion = Descripcion;
        color = Color;
        tamanio = Tamanio;
        precio = Precio;
        existencia = Existencia;
    }
    
    public int createProducto(int Id,String Descripcion, String Color, String Tamanio, float Precio){
        int r = 0;
        
        String consulta = "INSERT INTO productos(idProducto, descripcion, tamanio, color, valorventa, existencia) VALUES("+Id+", '"+Descripcion+"','"+Tamanio+"','"+Color+"',"+Precio+",0)";
        try{
            Statement stm = conex.createStatement();
            r = stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Producto insertado");
        }catch(Exception exc){
            System.out.println("Error: "+exc);
        }finally{
            return r;
        }
    }
    
    public ResultSet readProducto(String campoBusqueda) {
        ResultSet rs = null;
        try{
            Statement stm = conex.createStatement();
            if(campoBusqueda.isEmpty()){
               rs = stm.executeQuery("SELECT * FROM Productos ORDER BY idproducto"); 
            }else if(campoBusqueda.matches("[+-]?\\d*(\\.\\d+)?")){
                rs = stm.executeQuery("SELECT * FROM Productos WHERE idProducto = "+campoBusqueda+"OR descripcion LIKE '%"+campoBusqueda+"%' ORDER BY idproducto");
            }else{
                rs = stm.executeQuery("SELECT * FROM Productos WHERE descripcion LIKE '%"+campoBusqueda+"%' OR color LIKE '"+campoBusqueda+"%' OR tamanio LIKE '"+campoBusqueda+"%' ORDER BY idproducto");
            }
        }catch(Exception exc){
            System.out.println("Error: en read producto "+exc.getMessage());
        }finally{
            if(rs == null){ System.out.println("vacio");}
            return rs;
        }
    }
    
    public int updateInventario(){
        int r = 0, bajas = 0, vendidos = 0, comprados = 0, cantidad = 0, p = Login.emp.getNextID("Productos", "idproducto");
        for(int i = 1; i<p; i++){
            String cantVentas = "SELECT SUM(detalleventas.cantidad) FROM detalleventas INNER JOIN ventas "
                    + "ON detalleventas.idventa = ventas.idVenta WHERE ventas.status != 'Cancelado' AND idproducto = "+i+";";
            String cantCompra = "SELECT SUM(piezasproducto)\n" +
                    "FROM detallecompras WHERE idproducto ="+i;
            String cantBaja = "SELECT SUM(piezasbaja) FROM detallebajas WHERE idproducto = "+ i;


            try{

                Statement stm = (Statement) conex.createStatement(), stm1 = conex.createStatement(), stm2 = conex.createStatement(), stm3 = conex.createStatement();

                ResultSet rv = stm.executeQuery(cantVentas);
                if(rv.next())
                    vendidos = rv.getInt("sum");
                ResultSet rc = stm1.executeQuery(cantCompra);
                if(rc.next())
                    comprados = rc.getInt("sum");
                ResultSet rb = stm2.executeQuery(cantBaja);
                if(rb.next())
                    bajas = rb.getInt("sum");
                cantidad = comprados - (vendidos + bajas);
                String consulta = "UPDATE productos	SET  existencia = "+cantidad+"WHERE idProducto = "+i; 
                r = stm3.executeUpdate(consulta);
                
            }catch(Exception exc){
                System.out.println("Error en update producto: "+exc);
            }
        }
        return r;
    }
    
    public int updateProducto(String id, String valor){
        int r=0;
        String consulta = "UPDATE productos SET" +
"	valorventa = "+valor+" WHERE idProducto = "+id;
        try{
            Statement stm = (Statement) conex.createStatement();
            r = stm.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Modificacion hecha con exito");
        }catch(Exception exc){
            System.out.println("Error en update venta: "+exc);
        }finally{
            return r;
        }
    }
}
