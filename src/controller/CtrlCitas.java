package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import model.AccionesCita;
import model.AccionesMedico;
import model.AccionesPaciente;
import model.Citas;
import model.Medicos;
import model.Pacientes;
import view.FrmCitas;

public class CtrlCitas implements ActionListener {

    private Citas cita = new Citas();
    private Medicos medico = new Medicos();
    private Pacientes paciente = new Pacientes();
    private FrmCitas frmCitas;
    private AccionesMedico accionesMedico = new AccionesMedico();
    private AccionesPaciente accionesPaciente = new AccionesPaciente();
    private AccionesCita accionesCita = new AccionesCita();

    public CtrlCitas (FrmCitas frmCitas) {
        this.frmCitas = frmCitas;
        this.frmCitas.btnGuardar.addActionListener(this);
        this.frmCitas.btnModificar.addActionListener(this);
        this.frmCitas.btnEliminar.addActionListener(this);
        this.frmCitas.btnMostrar.addActionListener(this);
        this.frmCitas.btnSelMedico.addActionListener(this);
        this.frmCitas.btnSelPaciente.addActionListener(this);
    }

    public void iniciar() {
        frmCitas.setTitle("Citas");
        frmCitas.setVisible(true);
        comprobarFecha();
        cargarMedicos();
        cargarPacientes();
        cargarCitas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmCitas.btnGuardar) {
            //JOptionPane.showMessageDialog(null, "Botón Guardar");
            guardarCita();
        } else if (e.getSource() == frmCitas.btnModificar) {
            //JOptionPane.showMessageDialog(null, "Botón Modificar");
            modificarCita();
        } else if (e.getSource() == frmCitas.btnEliminar) {
            //JOptionPane.showMessageDialog(null, "Botón Eliminar");
            eliminarCita();
        } else if (e.getSource() == frmCitas.btnMostrar) {
            //JOptionPane.showMessageDialog(null, "Botón Mostrar");
            mostrarCita();
        } else if (e.getSource() == frmCitas.btnSelPaciente) {
            seleccionarPaciente();
        } else if (e.getSource() == frmCitas.btnSelMedico) {
            seleccionarMedico();
        }
    }
    
    // Carga en la tabla médicos los médicos desde la base de datos
    public void cargarMedicos(){
        
        List<Medicos> listaMedicos = accionesMedico.obtenerMedicos();

        DefaultTableModel modelMedico = new DefaultTableModel();
        modelMedico.setColumnIdentifiers(new Object[] {"Id", "Num. Colegiado", "Nombre", "Apellido 1", "Apellido 2"});

        for (Medicos medico : listaMedicos) {
            modelMedico.addRow(new Object[] {medico.getId(), medico.getNumeroColegiado(), medico.getNombre(), 
                medico.getApellido1(), medico.getApellido2()});
        }

        frmCitas.jTMedicos.setModel(modelMedico);

    }
    
    // Comprueba que la fecha actual para restringir el DateChooser en fechas pasadas
    public void comprobarFecha() {
        Date fechaActual = new Date();
        frmCitas.dcFecha.setMinSelectableDate(fechaActual);
    }
    
    //Carga en la tabla pacientes los pacientes desde la base de datos
    public void cargarPacientes(){
        
        List<Pacientes> listaPacientes = accionesPaciente.obtenerPacientes();

        DefaultTableModel modelPaciente = new DefaultTableModel();
        modelPaciente.setColumnIdentifiers(new Object[] {"Id","SIP", "Nombre", "Apellido 1", "Apellido 2", "Nacimiento"});

        for (Pacientes paciente : listaPacientes) {
            modelPaciente.addRow(new Object[] {paciente.getId(), paciente.getSip(), paciente.getNombre(), paciente.getApellido1(), 
                paciente.getApellido2(), paciente.getFechaNacimiento()});
        }

        frmCitas.jTPacientes.setModel(modelPaciente);

    }
    
    //Carga el contenido de una lista en la tabla citas
    public void cargarCitas() {
        List<Citas> listaCitas = accionesCita.obtenerCitas();

        DefaultTableModel modelCita = new DefaultTableModel();
        modelCita.setColumnIdentifiers(new Object[] {"Id","Id Medico", "Id Paciente", "Fecha"});

        for (Citas cita : listaCitas) {
            Long medicoId = cita.getMedicos();
            Long pacienteId = cita.getPacientes();
            if (medicoId != null && pacienteId != null) {
                modelCita.addRow(new Object[] {cita.getId(), medicoId, pacienteId, cita.getFecha()});
            }
        }
        frmCitas.jTCitas.setModel(modelCita);
    }


    // Método para seleccionar la fecha desde el DateChooser
    public Date seleccionarFecha() {
        Date fecha = frmCitas.dcFecha.getDate();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.set(Calendar.SECOND, 0);

        // Comprueba si la fecha es ya pasada
        Date fechaActual = new Date();
        if (calendar.getTime().before(fechaActual)) {
            return null;
        }
        return calendar.getTime();
    }

    // Método para seleccionar la hora desde el JSpinner
    public Date seleccionarHora(Date fecha) {
        JSpinner.DateEditor de = new JSpinner.DateEditor(frmCitas.jSHora,"HH:mm:ss");
        frmCitas.jSHora.setEditor(de);
        Date horaSpinner = de.getModel().getDate();
        Calendar calSpinner = Calendar.getInstance();
        calSpinner.setTime(horaSpinner);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.set(Calendar.HOUR_OF_DAY, calSpinner.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calSpinner.get(Calendar.MINUTE));

        return calendar.getTime();
    }

    // Guarda la cita con los campos seleccionados
    public void guardarCita (){
        long idMedico = Long.parseLong(frmCitas.txtIdMedico.getText().trim());
        long idPaciente = Long.parseLong(frmCitas.txtIdPaciente.getText().trim());     
        cita.setMedicos(idMedico);
        cita.setPacientes(idPaciente);
        Date fecha = seleccionarFecha();
        if (fecha != null) {
            Date fechaHora = seleccionarHora(fecha);
            cita.setFecha(fechaHora);
            accionesCita.guardarCita(cita);
            limpiarCampos();
            cargarCitas();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha y hora válidas");
        }
    }

    //Modifica la cita con los campos modificados
    public void modificarCita() {
        String id = frmCitas.txtId.getText().trim();
        // Comprueba que el ID de la cita no sea un campo en blanco
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número de cita válido");
            return;
        }
        cita.setId(Long.parseLong(id));

        String idMedico = frmCitas.txtIdMedico.getText().trim();
        if (!idMedico.isEmpty()) {
            cita.setMedicos(Long.parseLong(idMedico));
        }

        String idPaciente = frmCitas.txtIdPaciente.getText().trim();
        if (!idPaciente.isEmpty()) {
            cita.setPacientes(Long.parseLong(idPaciente));
        }

        Date fecha = seleccionarFecha();
        if (fecha != null) {
            Date fechaHora = seleccionarHora(fecha);
            cita.setFecha(fechaHora);
            accionesCita.actualizarCita(cita);
            limpiarCampos();
            cargarCitas();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha y hora válidas");
        }
    }


    // Carga los datos de la cita
    public void mostrarCita() {
            
        int columna = 0; 
        int fila = frmCitas.jTCitas.getSelectedRow();
        if (fila != -1) {
            String idCita = frmCitas.jTCitas.getModel().getValueAt(fila, columna).toString();
            if (!idCita.isEmpty()) {
                Long id = Long.parseLong(idCita);
                System.out.println("id Mostrar: "+id);
                cita.setId(id);
            }
            Citas citaGuardada = accionesCita.mostrarCita(cita);
            rellenarFormulario(citaGuardada);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
    }
    
    // Muestra los datos de la cita en los TextArea
    public void rellenarFormulario(Citas cita) {
        frmCitas.txtId.setText(String.valueOf(cita.getId()));
        frmCitas.txtIdMedico.setText(String.valueOf(cita.getMedicos()));
        frmCitas.txtIdPaciente.setText(String.valueOf(cita.getPacientes()));
        frmCitas.dcFecha.setDate(cita.getFecha());
    }
    
    // Obtiene el ID de paciente seleccionado en la tabla para generar una cita
    public void seleccionarPaciente () {
        int columna = 0;
        int fila = frmCitas.jTPacientes.getSelectedRow();
        if (fila != -1) {
            String idPacientes = frmCitas.jTPacientes.getValueAt(fila, columna).toString();
            if (!idPacientes.isEmpty()){
                frmCitas.txtIdPaciente.setText(idPacientes);
                System.out.println("id Mostrar: "+idPacientes);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        }
    }
    
    //Obtiene el ID de médico seleccionado en la tabla para generar una cita
    public void seleccionarMedico () {
        int columna = 0;
        int fila = frmCitas.jTMedicos.getSelectedRow();
        if (fila != -1) {
            String idMedicos = frmCitas.jTMedicos.getValueAt(fila, columna).toString();
            if (!idMedicos.isEmpty()){
                frmCitas.txtIdMedico.setText(idMedicos);
                System.out.println("id Mostrar: "+idMedicos);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        }
    }
    
    // Elimina la cita por su ID escrita en el TextArea
    public void eliminarCita() {
            String idCita = frmCitas.txtId.getText().trim();
            if (!idCita.isEmpty()) {
                long id = Long.parseLong(idCita);
                System.out.println("id Eliminar: " + id);
                cita.setId(id);

                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar esta cita?", "Confirmión", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    accionesCita.eliminarCita(cita);
                    limpiarCampos();
                    cargarCitas();
            }
        }
    }
 
    //Limpia los campos del formulario de Citas
    public void limpiarCampos(){
        frmCitas.txtId.setText("");
        frmCitas.txtIdMedico.setText("");
        frmCitas.txtIdPaciente.setText("");
        frmCitas.dcFecha.setDate(null);
    }
}
