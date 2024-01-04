
package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FrmMainMenu extends javax.swing.JFrame {

    public FrmMainMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon (getClass().getResource("/resource/fondo.png"));
        Image image = icon.getImage();
        deskMainMenu = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };
        jPanel1 = new javax.swing.JPanel();
        lblMedicos = new javax.swing.JLabel();
        lblPacientes = new javax.swing.JLabel();
        lblCitas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        deskMainMenu.setMinimumSize(new java.awt.Dimension(800, 600));
        deskMainMenu.setPreferredSize(new java.awt.Dimension(1280, 1024));

        javax.swing.GroupLayout deskMainMenuLayout = new javax.swing.GroupLayout(deskMainMenu);
        deskMainMenu.setLayout(deskMainMenuLayout);
        deskMainMenuLayout.setHorizontalGroup(
            deskMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1152, Short.MAX_VALUE)
        );
        deskMainMenuLayout.setVerticalGroup(
            deskMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(202, 200, 239));

        lblMedicos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblMedicos.setForeground(new java.awt.Color(32, 28, 65));
        lblMedicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMedicos.setText("MEDICOS");
        lblMedicos.setOpaque(true);

        lblPacientes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPacientes.setForeground(new java.awt.Color(32, 28, 65));
        lblPacientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPacientes.setText("PACIENTES");
        lblPacientes.setMaximumSize(new java.awt.Dimension(84, 22));
        lblPacientes.setMinimumSize(new java.awt.Dimension(84, 22));
        lblPacientes.setOpaque(true);

        lblCitas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCitas.setForeground(new java.awt.Color(32, 28, 65));
        lblCitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCitas.setText("CITAS");
        lblCitas.setMaximumSize(new java.awt.Dimension(84, 22));
        lblCitas.setMinimumSize(new java.awt.Dimension(84, 22));
        lblCitas.setOpaque(true);
        lblCitas.setPreferredSize(new java.awt.Dimension(103, 22));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HospiManager");

        lblVersion.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        lblVersion.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lblCitas, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblVersion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVersion)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deskMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deskMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane deskMainMenu;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblCitas;
    public javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblMedicos;
    public javax.swing.JLabel lblPacientes;
    public javax.swing.JLabel lblVersion;
    // End of variables declaration//GEN-END:variables
}
