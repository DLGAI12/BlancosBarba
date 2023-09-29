/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blancos1;

/**
 *
 * @author beeet
 */
public class Principal extends javax.swing.JFrame {
    public static Bajas registrarBaja;
    public static BuscarBaja buscaBaja;
    public static Clientes registrarClientes;
    public static BuscarCliente buscaCliente;
    public static Compras registraCompra;
    public static BuscarCompras buscaCompra;
    public static Empleados registraEmpleado;
    public static BuscarEmpleado buscaEmpleado;
    public static Iva iva;
    public static BuscarIVA buscaIva;
    public static Productos registraProducto;
    public static BuscarProducto buscaProducto;
    public static Proveedores registraProveedor;
    public static BuscarProveedores buscaProveedor;
    public static Ventas registraVenta;
    public static BuscarVenta buscaVenta;
    public static Login log;
    
    public Principal() {
        initComponents();
        lblBienvenido.setText("Bienvenido: "+Login.emp.nombre+" "+Login.emp.apellidos);
        this.setLocationRelativeTo(null);
        
        registrarBaja = new Bajas();
        buscaBaja = new BuscarBaja();
        registrarClientes = new Clientes();
        buscaCliente = new BuscarCliente();
        registraCompra = new Compras();
        buscaCompra = new BuscarCompras();
        registraEmpleado = new Empleados();
        buscaEmpleado = new BuscarEmpleado();
        iva = new Iva();
        buscaIva = new BuscarIVA();
        registraProducto = new Productos();
        buscaProducto = new BuscarProducto();
        registraProveedor = new Proveedores();
        buscaProveedor = new BuscarProveedores();
        registraVenta = new Ventas();
        buscaVenta = new BuscarVenta();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenido = new javax.swing.JLabel();
        BarraDeMenu = new javax.swing.JMenuBar();
        MenuClientes = new javax.swing.JMenu();
        btnRegistrarCliente = new javax.swing.JMenuItem();
        btnBuscarCliente = new javax.swing.JMenuItem();
        MenuEmpleados = new javax.swing.JMenu();
        btnRegistrarEmpleado = new javax.swing.JMenuItem();
        btnBuscarEmpleado = new javax.swing.JMenuItem();
        MenuVentas = new javax.swing.JMenu();
        btnRegistrarVenta = new javax.swing.JMenuItem();
        btnBuscarVenta = new javax.swing.JMenuItem();
        MenuCompras = new javax.swing.JMenu();
        btnRegistrarCompra = new javax.swing.JMenuItem();
        btnBuscarCompra = new javax.swing.JMenuItem();
        MenuBajas = new javax.swing.JMenu();
        btnRegistrarBaja = new javax.swing.JMenuItem();
        btnBuscarBaja = new javax.swing.JMenuItem();
        MenuProductos = new javax.swing.JMenu();
        btnRegistrarProducto = new javax.swing.JMenuItem();
        btnBuscarProductos = new javax.swing.JMenuItem();
        MenuProveedores = new javax.swing.JMenu();
        btnRegistrarProveedor = new javax.swing.JMenuItem();
        btnBuscarProveedor = new javax.swing.JMenuItem();
        MenuIVA = new javax.swing.JMenu();
        btnRegistrarIVA = new javax.swing.JMenuItem();
        bntBuscarIVa = new javax.swing.JMenuItem();
        Cerrar = new javax.swing.JMenu();
        btnCerrarSesion = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBienvenido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblBienvenido.setText("Bienvenido");

        MenuClientes.setText("Clientes");

        btnRegistrarCliente.setText("Registrar Cliente");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        MenuClientes.add(btnRegistrarCliente);

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        MenuClientes.add(btnBuscarCliente);

        BarraDeMenu.add(MenuClientes);

        MenuEmpleados.setText("Empleados");

        btnRegistrarEmpleado.setText("Registrar empleado");
        btnRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmpleadoActionPerformed(evt);
            }
        });
        MenuEmpleados.add(btnRegistrarEmpleado);

        btnBuscarEmpleado.setText("Buscar empleado");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });
        MenuEmpleados.add(btnBuscarEmpleado);

        BarraDeMenu.add(MenuEmpleados);

        MenuVentas.setText("Ventas");

        btnRegistrarVenta.setText("Registrar venta");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });
        MenuVentas.add(btnRegistrarVenta);

        btnBuscarVenta.setText("Buscar Venta");
        btnBuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaActionPerformed(evt);
            }
        });
        MenuVentas.add(btnBuscarVenta);

        BarraDeMenu.add(MenuVentas);

        MenuCompras.setText("Compras");

        btnRegistrarCompra.setText("Registrar compra");
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });
        MenuCompras.add(btnRegistrarCompra);

        btnBuscarCompra.setText("Buscar compra");
        btnBuscarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCompraActionPerformed(evt);
            }
        });
        MenuCompras.add(btnBuscarCompra);

        BarraDeMenu.add(MenuCompras);

        MenuBajas.setText("Bajas");

        btnRegistrarBaja.setText("Registrar baja");
        btnRegistrarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarBajaActionPerformed(evt);
            }
        });
        MenuBajas.add(btnRegistrarBaja);

        btnBuscarBaja.setText("buscar baja");
        btnBuscarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBajaActionPerformed(evt);
            }
        });
        MenuBajas.add(btnBuscarBaja);

        BarraDeMenu.add(MenuBajas);

        MenuProductos.setText("Productos");

        btnRegistrarProducto.setText("Registrar producto");
        btnRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductoActionPerformed(evt);
            }
        });
        MenuProductos.add(btnRegistrarProducto);

        btnBuscarProductos.setText("Buscar producto");
        btnBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductosActionPerformed(evt);
            }
        });
        MenuProductos.add(btnBuscarProductos);

        BarraDeMenu.add(MenuProductos);

        MenuProveedores.setText("Proveedores");

        btnRegistrarProveedor.setText("Registrar proveedor");
        btnRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProveedorActionPerformed(evt);
            }
        });
        MenuProveedores.add(btnRegistrarProveedor);

        btnBuscarProveedor.setText("Buscar proveedor");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });
        MenuProveedores.add(btnBuscarProveedor);

        BarraDeMenu.add(MenuProveedores);

        MenuIVA.setText("IVA");

        btnRegistrarIVA.setText("Registrar IVA");
        btnRegistrarIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIVAActionPerformed(evt);
            }
        });
        MenuIVA.add(btnRegistrarIVA);

        bntBuscarIVa.setText("Buscar IVA");
        bntBuscarIVa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarIVaActionPerformed(evt);
            }
        });
        MenuIVA.add(bntBuscarIVa);

        BarraDeMenu.add(MenuIVA);

        Cerrar.setText("Cerrar");

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        Cerrar.add(btnCerrarSesion);

        btnSalir.setText("Salir del programa");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        Cerrar.add(btnSalir);

        BarraDeMenu.add(Cerrar);

        setJMenuBar(BarraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenido)
                .addContainerGap(521, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenido)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        registrarClientes.setVisible(true);
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        buscaCliente.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoActionPerformed
        registraEmpleado.setVisible(true);
    }//GEN-LAST:event_btnRegistrarEmpleadoActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        buscaEmpleado.setVisible(true);
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        registraVenta.setVisible(true);
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnBuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaActionPerformed
        buscaVenta.setVisible(true);
    }//GEN-LAST:event_btnBuscarVentaActionPerformed

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
        registraCompra.setVisible(true);
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    private void btnBuscarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCompraActionPerformed
        buscaCompra.setVisible(true);
    }//GEN-LAST:event_btnBuscarCompraActionPerformed

    private void btnRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductoActionPerformed
        registraProducto.setVisible(true);
    }//GEN-LAST:event_btnRegistrarProductoActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductosActionPerformed
        buscaProducto.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductosActionPerformed

    private void btnRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProveedorActionPerformed
        registraProveedor.setVisible(true);
    }//GEN-LAST:event_btnRegistrarProveedorActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        buscaProveedor.setVisible(true);
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void btnRegistrarIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIVAActionPerformed
        iva.setVisible(true);
    }//GEN-LAST:event_btnRegistrarIVAActionPerformed

    private void bntBuscarIVaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarIVaActionPerformed
        buscaIva.setVisible(true);
    }//GEN-LAST:event_bntBuscarIVaActionPerformed

    private void btnRegistrarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarBajaActionPerformed
        registrarBaja.setVisible(true);
    }//GEN-LAST:event_btnRegistrarBajaActionPerformed

    private void btnBuscarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBajaActionPerformed
        buscaBaja.setVisible(true);
    }//GEN-LAST:event_btnBuscarBajaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraDeMenu;
    private javax.swing.JMenu Cerrar;
    private javax.swing.JMenu MenuBajas;
    private javax.swing.JMenu MenuClientes;
    private javax.swing.JMenu MenuCompras;
    private javax.swing.JMenu MenuEmpleados;
    private javax.swing.JMenu MenuIVA;
    private javax.swing.JMenu MenuProductos;
    private javax.swing.JMenu MenuProveedores;
    private javax.swing.JMenu MenuVentas;
    private javax.swing.JMenuItem bntBuscarIVa;
    private javax.swing.JMenuItem btnBuscarBaja;
    private javax.swing.JMenuItem btnBuscarCliente;
    private javax.swing.JMenuItem btnBuscarCompra;
    private javax.swing.JMenuItem btnBuscarEmpleado;
    private javax.swing.JMenuItem btnBuscarProductos;
    private javax.swing.JMenuItem btnBuscarProveedor;
    private javax.swing.JMenuItem btnBuscarVenta;
    private javax.swing.JMenuItem btnCerrarSesion;
    private javax.swing.JMenuItem btnRegistrarBaja;
    private javax.swing.JMenuItem btnRegistrarCliente;
    private javax.swing.JMenuItem btnRegistrarCompra;
    private javax.swing.JMenuItem btnRegistrarEmpleado;
    private javax.swing.JMenuItem btnRegistrarIVA;
    private javax.swing.JMenuItem btnRegistrarProducto;
    private javax.swing.JMenuItem btnRegistrarProveedor;
    private javax.swing.JMenuItem btnRegistrarVenta;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JLabel lblBienvenido;
    // End of variables declaration//GEN-END:variables
}
