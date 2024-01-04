
package view;

import javax.swing.JInternalFrame;

public class FrmMedicos extends JInternalFrame {

    public FrmMedicos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblNumColegiado = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblEspecialidad = new javax.swing.JLabel();
        cbEspecialidad = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        txtNumColegiado = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMedicos = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1280, 1024));
        setMinimumSize(new java.awt.Dimension(600, 200));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 310));
        setRequestFocusEnabled(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setText("ID:");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 26, -1, -1));

        lblNumColegiado.setText("Num. Colegiado:");
        getContentPane().add(lblNumColegiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 58, -1, -1));

        lblDni.setText("DNI:");
        getContentPane().add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 90, -1, -1));

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 122, -1, -1));

        lblApellido1.setText("Primer Apellido:");
        getContentPane().add(lblApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 154, -1, -1));

        lblApellido2.setText("Segundo Apellido:");
        getContentPane().add(lblApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 186, -1, -1));

        lblTelefono.setText("Teléfono:");
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 218, -1, -1));

        lblEspecialidad.setText("Especialidad:");
        getContentPane().add(lblEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 250, -1, -1));

        cbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Escoge una opción -", "1 - Traumatología", "2 - Neurología", "3 - Oftalmología", "4 - Pediatría", "5 - Cardiología" }));
        getContentPane().add(cbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 243, 157, -1));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 19, 157, -1));
        getContentPane().add(txtNumColegiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 51, 157, -1));
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 83, 157, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 115, 157, -1));
        getContentPane().add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 147, 157, -1));
        getContentPane().add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 179, 157, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 211, 157, -1));

        btnGuardar.setText("Guardar");
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 18, 85, -1));

        btnModificar.setText("Modificar");
        btnModificar.setMaximumSize(new java.awt.Dimension(79, 25));
        btnModificar.setMinimumSize(new java.awt.Dimension(79, 25));
        btnModificar.setPreferredSize(new java.awt.Dimension(79, 25));
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 50, 85, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 82, 85, -1));

        btnMostrar.setText("Selección");
        btnMostrar.setMaximumSize(new java.awt.Dimension(79, 25));
        btnMostrar.setMinimumSize(new java.awt.Dimension(79, 25));
        btnMostrar.setPreferredSize(new java.awt.Dimension(79, 25));
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 114, 85, -1));

        jTMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Num. Colegiado", "Nombre", "Apellido 1", "Apellido 2", "Especialidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMedicos.setToolTipText("Listado médicos");
        jScrollPane1.setViewportView(jTMedicos);
        jTMedicos.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 18, -1, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnMostrar;
    public javax.swing.JComboBox<String> cbEspecialidad;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTMedicos;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumColegiado;
    private javax.swing.JLabel lblTelefono;
    public javax.swing.JTextField txtApellido1;
    public javax.swing.JTextField txtApellido2;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNumColegiado;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
