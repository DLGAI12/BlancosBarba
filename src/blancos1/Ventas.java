package blancos1;
// * @author beeet

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JFrame {
    
    private Venta v = null;
    private Producto p = null;
    private Cliente c = null;
    private DetalleVenta  dv= null;
    public int cliente, piezas, empleado,venta, existencia, detalle;
    float totalventa;
    
    public Ventas() {
        initComponents();
        v = new Venta();
        p = new Producto();
        p.updateInventario();
        c = new Cliente();
        dv = new DetalleVenta();
        txtIdVenta.setText(String.valueOf(Login.emp.getNextID("Ventas", "idVenta")));
        lblIdEmpleado.setText("Empleado: "+Login.emp.id);
        lblSubtotal.setText("");
        lblIva.setText("");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        txtFechaVenta.setText(dtf.format(LocalDateTime.now()));
        txtFechaEntrega.setText(dtf.format(LocalDateTime.now()));
        txtPiezas.setEnabled(false);
        btnAddProducto.setEnabled(false);
        btnRegistrar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void setCliente(int id){
        txtIdCliente.setText(String.valueOf(id));
        String nombre,apellidos;
        ResultSet rs = c.readCliente(txtIdCliente.getText());
        
        try{
        if(rs.next()){
            nombre = rs.getString("nombreCliente");
            apellidos = rs.getString("apellidosCliente");
            lblNombreCliente.setText("Cliente: "+nombre+" "+apellidos);
        }else{
            lblNombreCliente.setText("Cliente no existente");
        }
        }catch(Exception exc){
            System.out.println("Error: "+exc);
        }
    }
    
    public void setProducto(int id){
        txtIdProducto.setText(String.valueOf(id));
        String descripcion;
        ResultSet rs = p.readProducto(txtIdProducto.getText());
        try{
            if(rs.next()){
                descripcion = rs.getString("descripcion");
                existencia = rs.getInt("existencia");

                if(existencia == 0 ){
                    btnAddProducto.setEnabled(false);
                    txtPiezas.setEnabled(false);
                }else{
                    btnAddProducto.setEnabled(true);
                    txtPiezas.setEnabled(true);
                }
                lblDescripcion.setText(descripcion+" "+rs.getString("tamanio")+" "+rs.getString("color")+" $"+rs.getFloat("valorventa")+", "+rs.getString("existencia")+" Piezas");
            }else{
                lblDescripcion.setText("Producto no existente");
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblIdEmpleado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnNuevoCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        lblNombreCliente = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnAddProducto = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtPiezas = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        txtFechaVenta = new javax.swing.JTextField();
        txtFechaEntrega = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        lblSubtotal = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });
        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyReleased(evt);
            }
        });

        jLabel2.setText("ID Cliente:");

        lblIdEmpleado.setText("Empleado:");

        jLabel5.setText("Fecha de venta:");

        jLabel6.setText("Fecha de entrega:");

        jLabel7.setText("Direccion:");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });

        jLabel8.setText("Estado");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solicitado", "Enviado", "Entregado", "Cancelado" }));

        btnNuevoCliente.setText("Nuevo Cliente");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        jLabel9.setText("Productos:");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Cantidad", "Precio unitario", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        btnEliminar.setText("Eliminar producto seleccionado");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addGap(6, 6, 6))
        );

        lblNombreCliente.setText("Cliente: ");

        lblTotalVenta.setText("Total:");

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Ventas");

        jLabel11.setText("ID venta");

        txtIdVenta.setEnabled(false);

        btnRegistrar.setText("Registrar venta");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnAddProducto.setText("Añadir producto");
        btnAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductoActionPerformed(evt);
            }
        });

        jLabel12.setText("Id producto");

        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyTyped(evt);
            }
        });

        lblDescripcion.setText("Descripcion:");

        txtPiezas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPiezasKeyReleased(evt);
            }
        });

        jLabel14.setText("Piezas:");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnBuscarProducto.setText("Buscar producto");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        lblSubtotal.setText("jLabel1");

        lblIva.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtIdVenta)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIdEmpleado)
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12)
                                    .addComponent(txtIdProducto)
                                    .addComponent(txtFechaVenta))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtFechaEntrega))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnBuscarCliente)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnNuevoCliente))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14)
                                                    .addComponent(txtPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAddProducto)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarProducto))))
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalVenta)
                                .addGap(127, 127, 127)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblIva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addComponent(btncancelar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdEmpleado)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel12)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreCliente)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNuevoCliente)
                                .addComponent(btnBuscarCliente)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddProducto)
                            .addComponent(btnBuscarProducto))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtotal)
                    .addComponent(lblIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalVenta)
                    .addComponent(btnRegistrar)
                    .addComponent(btncancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int i=0, filas = tblProductos.getRowCount();
        if(filas > 0){
            venta = Integer.parseInt(txtIdVenta.getText());
            v.createVenta(venta, Integer.parseInt(txtIdCliente.getText()), Login.emp.id , 2, txtFechaVenta.getText(), txtFechaEntrega.getText(), cmbStatus.getSelectedItem().toString(), txtDireccion.getText());
            DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
            while(i < filas){
                detalle = Login.emp.getNextID("DetalleVentas","idDetalleVentas");
                dv.createDetalleVenta(detalle, venta ,Integer.parseInt(modelo.getValueAt(i, 0).toString()),Integer.parseInt(modelo.getValueAt(i, 2).toString()));
                i++;
            }
            p.updateInventario();
            JOptionPane.showMessageDialog(null, "Venta "+ venta +" registrada con "+ lblNombreCliente.getText() +", "+i+" Productos y un total de $"+ totalventa);
            
            txtIdVenta.setText(String.valueOf(Login.emp.getNextID("ventas", "idVenta")));
            txtIdCliente.setText("");
            lblNombreCliente.setText("Cliente: ");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            txtFechaVenta.setText(dtf.format(LocalDateTime.now()));
            txtFechaEntrega.setText(dtf.format(LocalDateTime.now()));
            txtDireccion.setText("");
            cmbStatus.setSelectedItem(1);
            modelo.setRowCount(0);
            totalventa = 0;
            lblTotalVenta.setText(String.valueOf("Total: "+totalventa));
        }else{
            JOptionPane.showMessageDialog(null, "La venta no tiene productos");
            
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        Clientes bc = new Clientes();
        bc.setVisible(true);
        txtIdCliente.setText(String.valueOf(cliente));
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
        ResultSet rs = p.readProducto(txtIdProducto.getText());
        String precio = "";
        String id = txtIdProducto.getText();
        String dsc = lblDescripcion.getText();
        String pz = txtPiezas.getText();
        String subtotal = "";
        try{
            if(rs.next()){
                precio = rs.getString("valorVenta");
                subtotal = String.valueOf(rs.getFloat("valorVenta")*Integer.parseInt(pz));
                
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc.getMessage());
        }
        if(modelo.getRowCount()>0){
            boolean coincidencia = false;
            int pos=0;
            for(int i=0; i < modelo.getRowCount();i++){
                if(id.equals(tblProductos.getValueAt(i,0).toString())){
                    pos = i;
                    coincidencia = true;
                }
            }
            if(coincidencia){
                pz = String.valueOf(Integer.parseInt(pz)+Integer.parseInt(modelo.getValueAt(pos, 2).toString()));
                if(Integer.parseInt(pz) > existencia){
                JOptionPane.showMessageDialog(null, "Error, cantidad de producto mayor a la disponible, disminuya las piezas de este producto");
                }else{
                    subtotal = String.valueOf(Integer.parseInt(pz)*Float.parseFloat(precio));
                    modelo.setValueAt(pz, pos, 2);
                    modelo.setValueAt(subtotal, pos, 4);
                }
            }else{
                modelo.addRow(new Object[]{id,dsc,pz,precio, subtotal});
            }
        }else{
            modelo.addRow(new Object[]{id,dsc,pz,precio, subtotal});
        }
        totalventa = 0;
        for(int i=0; i < modelo.getRowCount(); i++){
            totalventa = totalventa + Float.parseFloat(modelo.getValueAt(i, 4).toString());
        }
        btnRegistrar.setEnabled(tblProductos.getRowCount()>0 && txtIdCliente.getText().isEmpty() == false && txtDireccion.getText().isEmpty() == false);
        txtPiezas.setText("");
        txtIdProducto.setText("");
        lblDescripcion.setText("Descripcion: ");
        lblSubtotal.setText("Subtotal: "+String.valueOf(totalventa*0.84));
        lblIva.setText("IVA: "+String.valueOf(totalventa*0.16));
        lblTotalVenta.setText("Total: "+String.valueOf(totalventa));
        btnAddProducto.setEnabled(false);
        txtPiezas.setEnabled(false);
        
    }//GEN-LAST:event_btnAddProductoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        BuscarCliente bc = new BuscarCliente();
        bc.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtIdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyTyped
    int key = evt.getKeyChar();

    boolean numeros = key >= 48 && key <= 57;
        
    if (!numeros){
        evt.consume();
    }
    }//GEN-LAST:event_txtIdProductoKeyTyped

    private void txtIdProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyReleased
        if(txtIdProducto.getText().isEmpty() == false){
            int idp = Integer.parseInt(txtIdProducto.getText());
            setProducto(idp);
            txtPiezas.setEnabled(true);
            btnAddProducto.setEnabled(true);
            
        }else{
            txtPiezas.setEnabled(false);
            btnAddProducto.setEnabled(false);
            lblDescripcion.setText("Descripcion: ");
        }
    }//GEN-LAST:event_txtIdProductoKeyReleased

    private void txtIdClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyReleased
        String idcliente = txtIdCliente.getText();
        if(idcliente.isEmpty() == false){
            setCliente(Integer.parseInt(idcliente));
        }else{
            lblNombreCliente.setText("Cliente: ");
        }
    }//GEN-LAST:event_txtIdClienteKeyReleased

    private void txtPiezasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPiezasKeyReleased
        if(txtPiezas.getText().isEmpty() == false){
            piezas = Integer.parseInt(txtPiezas.getText());
            if(piezas > existencia || piezas < 1 || txtPiezas.getText().isEmpty()){
                btnAddProducto.setEnabled(false);            
            }else if(txtIdProducto.getText().isEmpty() == false){
                btnAddProducto.setEnabled(true);
            }
        }
    }//GEN-LAST:event_txtPiezasKeyReleased

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        BuscarProducto bp = new BuscarProducto();
        bp.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
        totalventa = totalventa - Float.parseFloat(tblProductos.getValueAt(tblProductos.getSelectedRow(), 4).toString());
        modelo.removeRow(tblProductos.getSelectedRow());
        
        lblTotalVenta.setText("Total venta: "+String.valueOf(totalventa));
        btnEliminar.setEnabled(false);
        if(tblProductos.getRowCount() < 1)
            btnRegistrar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProducto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaEntrega;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtPiezas;
    // End of variables declaration//GEN-END:variables
}
