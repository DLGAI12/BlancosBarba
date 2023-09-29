package blancos1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Consulta extends javax.swing.JFrame {

    /**
     * Creates new form Consulta
     */
    public Consulta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void Nota(int tipo, int idEmpleado, int idNota, int id, String fecha){
    switch(tipo){
        case 1:{
            lblTitulo.setText("Nota de Venta");
            DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
            String prod;
            int pz;
            float precio, subtotal,total = 0;
            DetalleVenta dv = new DetalleVenta();
            Producto p = new Producto();
            Cliente c = new Cliente();
            Venta v = new Venta();
            ResultSet rv = dv.readDetalleVenta(String.valueOf(idNota));
    
            try {
                while(rv.next()){
                    prod = rv.getString("idProducto");
                    pz = rv.getInt("cantidad");
                    ResultSet rp = p.readProducto(prod);
                    if(rp.next()){
                        prod = (rp.getString("Descripcion")+" "+rp.getString("tamanio")+" "+rp.getString("color"));
                        precio = rp.getFloat("valorVenta");
                        subtotal = precio * pz;
                        total = total + subtotal;
                        modelo.addRow(new Object[]{prod,precio,pz,subtotal});
                        lblSubtotal.setText("Subtotal: "+String.valueOf(total*0.84));
                        lblIva.setText("IVA: "+String.valueOf(total*0.16));
                        lblTotal.setText("Total: "+String.valueOf(total));
                        ResultSet rc = c.readCliente(String.valueOf(id));
                        if(rc.next())
                            lblCliente.setText("Cliente No:"+rc.getString("idCliente")+" "+rc.getString("NombreCliente")+" "+rc.getString("ApellidosCliente"));
                        ResultSet re = Login.emp.readEmpleado(String.valueOf(idEmpleado));
                        if(re.next())
                            lblEmpleado.setText("Empleado No: "+re.getString("idEmpleado")+" "+re.getString("NombreEmpleado")+" "+re.getString("ApellidosEmpleado"));
                        ResultSet rvv = v.readVenta(String.valueOf(idNota));
                        if(rvv.next()){
                            lblFolio.setText("Folio: "+rvv.getString("idVenta"));
                            lblStatus.setText("Estado: "+rvv.getString("Status"));
                            lblFecha.setText("Fecha: "+rvv.getString("Fechaventa"));
                            lblDireccion.setText("Direccion: "+rvv.getString("direccionentrega"));
                        }
                        
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        break;
        
        case 2:{
            lblTitulo.setText("Nota de Compra");
            DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
            String prod;
            int pz;
            float precio, subtotal,total = 0;
            DetalleCompra dc = new DetalleCompra();
            Producto p = new Producto();
            Proveedor pr = new Proveedor();
            Compra c = new Compra();
            ResultSet rc = dc.readDetalleCompra(String.valueOf(idNota));
    
            try {
                while(rc.next()){
                    prod = rc.getString("idProducto");
                    pz = rc.getInt("piezasproducto");
                    precio = rc.getFloat("valorCompra");
                    ResultSet rp = p.readProducto(prod);
                    if(rp.next()){
                        prod = (rp.getString("Descripcion")+" "+rp.getString("tamanio")+" "+rp.getString("color"));
                        subtotal = precio * pz;
                        total = total + subtotal;
                        modelo.addRow(new Object[]{prod,precio,pz,subtotal});
                        lblSubtotal.setText("");
                        lblIva.setText("");
                        lblTotal.setText("Total: "+String.valueOf(total));
                        ResultSet rpr = pr.readProveedor(String.valueOf(id));
                        if(rpr.next())
                            lblCliente.setText("Proveedor No:"+rpr.getString("idProveedor")+" "+rpr.getString("NombreProveedor"));
                        ResultSet re = Login.emp.readEmpleado(String.valueOf(idEmpleado));
                        if(re.next())
                            lblEmpleado.setText("Empleado No: "+re.getString("idEmpleado")+" "+re.getString("NombreEmpleado")+" "+re.getString("ApellidosEmpleado"));
                        ResultSet rcc = c.readCompra(String.valueOf(idNota));
                        if(rcc.next()){
                            lblFolio.setText("Folio: "+rcc.getString("idCompra"));
                            lblStatus.setText("");
                            lblFecha.setText("Fecha: "+rcc.getString("Fechacompra"));
                            lblDireccion.setText("");
                        }
                        
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        break;
        
        case 3:{
            lblTitulo.setText("Nota de Baja");
            DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
            modelo.setColumnCount(3);
            modelo.setColumnIdentifiers(new Object[] {"Producto", "piezas","Motivo"});
            String prod, motivo;
            int pz;
            float precio,total = 0;
            DetalleBaja db = new DetalleBaja();
            Producto p = new Producto();
            Baja b = new Baja();
            ResultSet rc = db.readDetalleBaja(String.valueOf(idNota));
    
            try {
                while(rc.next()){
                    prod = rc.getString("idProducto");
                    pz = rc.getInt("piezasbaja");
                    motivo = rc.getString("motivo");
                    ResultSet rp = p.readProducto(prod);
                    if(rp.next()){
                        prod = (rp.getString("Descripcion")+" "+rp.getString("tamanio")+" "+rp.getString("color"));
                        
                        modelo.addRow(new Object[]{prod,pz,motivo});
                        lblSubtotal.setText("");
                        lblIva.setText("");
                        lblTotal.setText("");
                        lblCliente.setText("");
                        ResultSet re = Login.emp.readEmpleado(String.valueOf(idEmpleado));
                        if(re.next())
                            lblEmpleado.setText("Empleado No: "+re.getString("idEmpleado")+" "+re.getString("NombreEmpleado")+" "+re.getString("ApellidosEmpleado"));
                        ResultSet rbb = b.readBaja(String.valueOf(idNota));
                        if(rbb.next()){
                            lblFolio.setText("Folio: "+rbb.getString("idBaja"));
                            lblStatus.setText("");
                            lblFecha.setText("Fecha: "+rbb.getString("FechaBaja"));
                            lblDireccion.setText("");
                        }
                        
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        break;
    
    
    }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblFolio = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblEmpleado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblSubtotal = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Blancos Barba");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setText("Nota de");

        lblFolio.setText("Folio:");

        lblFecha.setText("Fecha:");

        lblStatus.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFolio)
                .addGap(192, 192, 192)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addGap(131, 131, 131)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFolio)
                    .addComponent(lblFecha)
                    .addComponent(lblStatus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEmpleado.setText("Empleado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmpleado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmpleado)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        lblCliente.setText("Cliente:");

        lblDireccion.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(lblDireccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio unitario", "Piezas", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        lblSubtotal.setText("Subtotal:");

        lblIva.setText("IVA:");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setText("Total:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtotal)
                    .addComponent(lblIva)
                    .addComponent(lblTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubtotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
