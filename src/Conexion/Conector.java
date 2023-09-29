/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author beeet
 */
public class Conector {
    private static final String URL = "jdbc:postgresql://localhost:5432/Blancos";
    private static final String User = "postgres";
    private static final String Password = "220288515";
    
    public static Connection getConnection(){
        Connection conex = null;
        try{
            Class.forName("org.postgresql.Driver");
            conex = (Connection) DriverManager.getConnection(URL, User, Password);
        }
        catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
        return conex;
    }
    
    public static Connection firstConnection(){
        Connection conex = null;
        try{
            Class.forName("org.postgresql.Driver");
            conex = (Connection) DriverManager.getConnection(URL, User, Password);
            ResultSet rs = null;
            try{
                Statement stm = conex.createStatement();
                   rs = stm.executeQuery("SELECT * FROM Empleados "); 
            }catch(Exception exc){
                System.out.println(exc.getMessage());
            }finally{
                if(rs == null){
                    try{
                        Statement stm2 = conex.createStatement();
                        Statement stm3 = conex.createStatement();
                        String creabd = "CREATE TABLE Empleados (idEmpleado serial NOT NULL PRIMARY KEY,nombreEmpleado varchar NOT NULL, apellidosEmpleado varchar NOT NULL,cargo varchar NOT NULL, direccionEmpleado varchar NOT NULL, telefonoEmpleado varchar(10) NOT NULL, sueldo float NOT NULL, status varchar NOT NULL, password varchar NOT NULL);\n" +
                                        "CREATE TABLE Clientes(idCliente serial NOT NULL PRIMARY KEY,nombreCliente varchar NOT NULL,aplellidosCliente varchar NOT NULL, telefonoCliente varchar(10) NOT NULL, correoCliente varchar );\n" +
                                        "CREATE TABLE Proveedores(idProveedor serial NOT NULL PRIMARY KEY,nombreProveedor varchar NOT NULL,telefonoProveedor varchar(10) NOT NULL,correoProveedor varchar NOT NULL);\n" +
                                        "CREATE TABLE IVA(idIva serial NOT NULL PRIMARY KEY,porcentaje float NOT NULL,fechaAplicacion date NOT NULL,fechaTermino date);" +
                                        "CREATE TABLE Productos(idProducto serial NOT NULL PRIMARY KEY,descripcion varchar NOT NULL,tamanio varchar NOT NULL,color varchar NOT NULL, valorVenta float NOT NULL,existencia int);\n" +
                                        "CREATE TABLE Compras(idCompra serial NOT NULL PRIMARY KEY,idProveedor int NOT NULL,idEmpleado int NOT NULL,fechaCompra date NOT NULL,FOREIGN KEY (idProveedor) REFERENCES Proveedores(idProveedor),FOREIGN KEY (idEmpleado) REFERENCES Empleados(idEmpleado));\n" +
                                        "CREATE TABLE DetalleCompras(idDetalleCompra serial NOT NULL PRIMARY KEY,idCompra int NOT NULL,idProducto int NOT NULL,piezasProducto int NOT NULL,valorCompra float NOT NULL,FOREIGN KEY (idCompra) REFERENCES Compras(idCompra),FOREIGN KEY (idProducto) REFERENCES Productos(idProducto));\n" +
                                        "CREATE TABLE Ventas(idVenta serial NOT NULL PRIMARY KEY,idCliente int NOT NULL,idVendedor int NOT NULL,idRepartidor int NOT NULL,fechaVenta date NOT NULL,ireccionEntrega varchar NOT NULL,fechaEntrega date NOT NULL,status varchar NOT NULL, FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente),FOREIGN KEY (idVendedor) REFERENCES Empleados(idEmpleado),FOREIGN KEY (idRepartidor) REFERENCES Empleados(idEmpleado));\n" +
                                        "CREATE TABLE DetalleVentas(idDetalleVentas serial NOT NULL PRIMARY KEY,dVenta int NOT NULL,idProducto int NOT NULL,FOREIGN KEY (idVenta) REFERENCES Ventas(idVenta),FOREIGN KEY (idProducto) REFERENCES Productos(idProducto));\n" +
                                        "CREATE TABLE Bajas(idBaja serial NOT NULL PRIMARY KEY,idEmpleado int NOT NULL,fechaBaja date NOT NULL,FOREIGN KEY (idEmpleado) REFERENCES Empleados(idEmpleado));\n" +
                                        "CREATE TABLE DetalleBajas(idDetalleBaja serial NOT NULL PRIMARY KEY,idBaja int NOT NULL,idProducto int NOT NULL,piezasBaja int NOT NULL,motivo varchar NOT NULL,FOREIGN KEY (idBaja) REFERENCES Bajas(idBaja),FOREIGN KEY (idProducto) REFERENCES Productos(idProducto));";
                        String consulta = "INSERT INTO Empleados(idEmpleado, nombreEmpleado, apellidosEmpleado, cargo, direccionEmpleado, telefonoEmpleado,sueldo, status, password)"+
                                          " VALUES(0, 'Carlos Alberto','Barba Cardenas','Programador','no disponible','0', 0, 'Inactivo', '0')";
                        stm3.executeUpdate(creabd);
                        JOptionPane.showMessageDialog(null, "Creando base de datos");
                        stm2.executeUpdate(consulta);
                        JOptionPane.showMessageDialog(null, "Bienvenido a Blancos Barba ");
                    }catch(Exception exc){
                        System.out.println("Error: "+exc);
                    }
                }
            }
            
            
        }
        catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
        return conex;
    }
    
}


