package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AccionesPaciente;
import model.Pacientes;
import view.FrmPacientes;

public class CtrlPacientes implements ActionListener {

    private Pacientes paciente = new Pacientes();
    private AccionesPaciente accionesPaciente = new AccionesPaciente();
    private FrmPacientes frmPacientes;
    
    public CtrlPacientes (FrmPacientes frmPacientes) {
        this.frmPacientes = frmPacientes;
        this.frmPacientes.btnGuardar.addActionListener(this);
        this.frmPacientes.btnModificar.addActionListener(this);
        this.frmPacientes.btnEliminar.addActionListener(this);
        this.frmPacientes.btnMostrar.addActionListener(this);
    }

    // Carga nombre a InternalFrame Pacientes, lo muestra y carga la tabla de pacientes
    public void iniciar() {
        frmPacientes.setTitle("Pacientes");
        frmPacientes.setVisible(true);
        cargarPacientes();
    }

    // Lógica botones menu Pacientes
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPacientes.btnGuardar) {
            //JOptionPane.showMessageDialog(null, "Botón Guardar");
            guardarPaciente();
        } else if (e.getSource() == frmPacientes.btnModificar) {
            //JOptionPane.showMessageDialog(null, "Botón Modificar");
            modificarPaciente();
        } else if (e.getSource() == frmPacientes.btnEliminar) {
            //JOptionPane.showMessageDialog(null, "Botón Eliminar");
            eliminarPaciente();
        } else if (e.getSource() == frmPacientes.btnMostrar) {
            //JOptionPane.showMessageDialog(null, "Botón Mostrar");
            mostrarPaciente();
        }
    }
    
    // Guarda paciente con los datos de los TextArea
    public void guardarPaciente (){
       paciente.setDni(frmPacientes.txtDni.getText().trim());
       paciente.setApellido1(frmPacientes.txtApellido1.getText().trim());
       paciente.setApellido2(frmPacientes.txtApellido2.getText().trim());
       paciente.setLocalidad(frmPacientes.txtLocalidad.getText().trim());
       paciente.setNombre(frmPacientes.txtNombre.getText().trim());
       paciente.setSip(frmPacientes.txtSip.getText().trim());
       paciente.setTelefono(frmPacientes.txtTelefono.getText().trim());
       accionesPaciente.guardarPaciente(paciente);
    }
    
    // Modifica un paciente seleccionado segun su ID
    public void modificarPaciente() {
        
        String idPaciente = frmPacientes.txtId.getText().trim();
        if (idPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un ID de paciente válido");
            return;
        }
        String dni = frmPacientes.txtDni.getText().trim();
        if (!dni.isEmpty()) {
            paciente.setDni(dni);
        }
        String apellido1 = frmPacientes.txtApellido1.getText().trim();
        if (!apellido1.isEmpty()) {
            paciente.setApellido1(apellido1);
        }
        String apellido2 = frmPacientes.txtApellido2.getText().trim();
        if (!apellido2.isEmpty()) {
            paciente.setApellido2(apellido2);
        }
        String localidad = frmPacientes.txtLocalidad.getText().trim();
        if (!localidad.isEmpty()) {
            paciente.setLocalidad(localidad);
        }
        String nombre = frmPacientes.txtNombre.getText().trim();
        if (!nombre.isEmpty()) {
            paciente.setNombre(nombre);
        }
        String sip = frmPacientes.txtSip.getText().trim();
        if (!sip.isEmpty()) {
            paciente.setSip(sip);
        }
        String telefono = frmPacientes.txtTelefono.getText().trim();
        if (!telefono.isEmpty()) {
            paciente.setTelefono(telefono);
        }
        
        Date fechaNacimiento = frmPacientes.dcNacimiento.getDate();
        if (fechaNacimiento != null) {
        paciente.setFechaNacimiento(fechaNacimiento);
        }
        
        int sexo = frmPacientes.cbSexo.getSelectedIndex();
        if (sexo == 1) {
            paciente.setSexo("hombre");
        } else {
            paciente.setSexo("mujer");
        }
        accionesPaciente.actualizarPaciente(paciente);
        cargarPacientes();
    }
    
    // Carga paciente seleccionado en una fila de la tabla
    public void mostrarPaciente() {
        int columna = 0; 
        int fila = frmPacientes.jTPacientes.getSelectedRow();
        if (fila != -1) {
            String idPaciente = frmPacientes.jTPacientes.getModel().getValueAt(fila, columna).toString();
            if (!idPaciente.isEmpty()) {
                Long id = Long.parseLong(idPaciente);
                System.out.println("id Mostrar: "+id);
                paciente.setId(id);
            }
            Pacientes pacienteGuardado = accionesPaciente.mostrarPaciente(paciente);
            rellenarFormulario(pacienteGuardado);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
    }
    
    // Muestra los valores del paciente seleccionado en los TextAreas correspondientes
    public void rellenarFormulario(Pacientes paciente) {
        frmPacientes.txtId.setText(String.valueOf(paciente.getId()));
        frmPacientes.txtDni.setText(paciente.getDni());
        frmPacientes.txtApellido1.setText(paciente.getApellido1());
        frmPacientes.txtApellido2.setText(paciente.getApellido2());
        frmPacientes.txtLocalidad.setText(paciente.getLocalidad());
        frmPacientes.txtNombre.setText(paciente.getNombre());
        frmPacientes.txtSip.setText(paciente.getSip());
        frmPacientes.txtTelefono.setText(paciente.getTelefono());
        frmPacientes.dcNacimiento.setDate(paciente.getFechaNacimiento());
        int sexo = determinarSexo(paciente);
        frmPacientes.cbSexo.setSelectedIndex(sexo);
    }
    
    // Comprueba el sexo del cliente y devuelve un valor para seleccionar su correspondiente en un ComboBox
    public int determinarSexo(Pacientes paciente) {  
        if (paciente.getSexo().equalsIgnoreCase("hombre")) {
            return 1;
        } else {
            return 2;
        }
    }
    
    // Elimina paciente segun el id escrito en el TextArea Id
    public void eliminarPaciente() {
        String idPaciente = frmPacientes.txtId.getText().trim();
        if (!idPaciente.isEmpty()) {
            long id = Long.parseLong(idPaciente);
            System.out.println("id Eliminar: "+id);
            paciente.setId(id);
        }  
        accionesPaciente.eliminarPaciente(paciente);
        cargarPacientes();
    }
    
    // Carga los pacientes desde una lista a la tabla pacientes.
    public void cargarPacientes() {

        List<Pacientes> listaPacientes = accionesPaciente.obtenerPacientes();

        DefaultTableModel modelPaciente = new DefaultTableModel();
        modelPaciente.setColumnIdentifiers(new Object[] {"Id", "Dni","SIP","Nombre", "Apellido 1", "Apellido 2", "Teléfono", "Localidad", "Nacimiento", "Sexo"});

        for (Pacientes paciente : listaPacientes) {
            modelPaciente.addRow(new Object[] {paciente.getId(), paciente.getDni(), paciente.getSip(), paciente.getNombre(), 
            paciente.getApellido1(), paciente.getApellido2(), paciente.getTelefono(), paciente.getLocalidad(),
            paciente.getFechaNacimiento(), paciente.getSexo()});
        }

        frmPacientes.jTPacientes.setModel(modelPaciente);
    }

}
