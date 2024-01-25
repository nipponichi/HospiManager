
package controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.*;


public class CtrlMainMenu implements ActionListener, MouseListener, MouseMotionListener {

    private FrmMainMenu frmMainMenu;
    
    public CtrlMainMenu(){
        
    }
    
    public CtrlMainMenu (FrmMainMenu frmMainMenu) {
        this.frmMainMenu = frmMainMenu;
        this.frmMainMenu.lblMedicos.addMouseListener(this);
        this.frmMainMenu.lblMedicos.addMouseMotionListener(this);
        this.frmMainMenu.lblPacientes.addMouseListener(this);
        this.frmMainMenu.lblPacientes.addMouseMotionListener(this);
        this.frmMainMenu.lblCitas.addMouseListener(this);
        this.frmMainMenu.lblCitas.addMouseMotionListener(this);

        this.frmMainMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.frmMainMenu.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                    null, "¿Seguro que quieres cerrar la aplicación?", 
                    "Confirmación", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    frmMainMenu.dispose();
                }
            }
        });
    }

    public void iniciar(){
        frmMainMenu.setTitle("Main Menu");
        frmMainMenu.setLocationRelativeTo(null);
        frmMainMenu.setVisible(true);
        setVersion();
        setLogo();
        
    }
    //Cambia el fondo y borde del "boton" al pasar el cursor del ratón por encima
    @Override
    public void mouseMoved(MouseEvent me) {
        JLabel jl = (JLabel) me.getSource();
        jl.setBackground(new Color(255, 255, 255));
        jl.setBorder(BorderFactory.createMatteBorder(0,0,4,0, new Color(206, 32, 107)));
    }

    //Cambia el fondo y borde del "boton" al salir el cursor del ratón de encima
    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jl = (JLabel) e.getSource();
        jl.setBackground(new Color (240,240,240));
        jl.setBorder(BorderFactory.createMatteBorder(0,0,0,0, new Color(206, 32, 107)));
    }

    //Lógica de "botones" del menú principal 
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == frmMainMenu.lblMedicos){
            //JOptionPane.showMessageDialog(null,"boton medicos");
            FrmMedicos frmMedicos = new FrmMedicos();
            frmMedicos.setVisible(true);
            CtrlMedicos ctrlMedicos = new CtrlMedicos(frmMedicos);
            ctrlMedicos.iniciar();
            frmMainMenu.deskMainMenu.add(frmMedicos);
            frmMedicos.show();
        } else if (me.getSource() == frmMainMenu.lblPacientes){
            //JOptionPane.showMessageDialog(null,"boton pacientes");
            FrmPacientes frmPacientes = new FrmPacientes();
            frmPacientes.setVisible(true);
            CtrlPacientes ctrlPacientes = new CtrlPacientes(frmPacientes);
            ctrlPacientes.iniciar();
            frmMainMenu.deskMainMenu.add(frmPacientes);
            frmPacientes.show();
        } else if (me.getSource() == frmMainMenu.lblCitas){
            //JOptionPane.showMessageDialog(null,"boton citas");
            FrmCitas frmCitas = new FrmCitas();
            CtrlCitas ctrlCitas = new CtrlCitas(frmCitas);
            ctrlCitas.iniciar();
            frmCitas.setVisible(true);
            frmMainMenu.deskMainMenu.add(frmCitas);
            frmCitas.show();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
     
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public void setVersion(){
        frmMainMenu.lblVersion.setText("Ver.1.02");
    }
    
    public void setLogo() {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resource/logo.png"));
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            ImageIcon finalImageIcon = new ImageIcon(newimg);
            frmMainMenu.lblLogo.setIcon(finalImageIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
    
