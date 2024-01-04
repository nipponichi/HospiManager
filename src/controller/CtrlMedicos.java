package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AccionesMedico;
import model.Especialidades;
import model.Medicos;
import view.FrmMedicos;

public class CtrlMedicos implements ActionListener {

    private Medicos medico = new Medicos();
    private FrmMedicos frmMedicos;
    private AccionesMedico accionesMedico = new AccionesMedico();
    Especialidades especialidad = new Especialidades();

    public CtrlMedicos(FrmMedicos frmMedicos) {
        this.frmMedicos = frmMedicos;
        this.frmMedicos.btnGuardar.addActionListener(this);
        this.frmMedicos.btnModificar.addActionListener(this);
        this.frmMedicos.btnEliminar.addActionListener(this);
        this.frmMedicos.btnMostrar.addActionListener(this);
    }
    
    // Carga el nombre del InternalFrame y lo hace visible
    public void iniciar() {
        frmMedicos.setTitle("Médicos");
        frmMedicos.setVisible(true);
        cargarMedicos();
    }
    
    //Lógica de botones menú médicos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmMedicos.btnGuardar) {
            //JOptionPane.showMessageDialog(null, "Botón Guardar");
            guardarMedico();
        } else if (e.getSource() == frmMedicos.btnModificar) {
            //JOptionPane.showMessageDialog(null, "Botón Modificar");
            modificarMedico();
        } else if (e.getSource() == frmMedicos.btnEliminar) {
            //JOptionPane.showMessageDialog(null, "Botón Eliminar");
            eliminarMedico();
        } else if (e.getSource() == frmMedicos.btnMostrar) {
            //JOptionPane.showMessageDialog(null, "Botón Mostrar");
            mostrarMedico();
        }
    }
    
    // Guarda los datos de un nuevo médico 
    public void guardarMedico() {
        int seleccion = frmMedicos.cbEspecialidad.getSelectedIndex();
        Long id = (long) seleccion;
        especialidad.setId(id);
        medico.setEspecialidades(especialidad);
        medico.setNumeroColegiado(frmMedicos.txtNumColegiado.getText().trim());
        medico.setDni(frmMedicos.txtDni.getText().trim());
        medico.setNombre(frmMedicos.txtNombre.getText().trim());
        medico.setApellido1(frmMedicos.txtApellido1.getText().trim());
        medico.setApellido2(frmMedicos.txtApellido2.getText().trim());
        medico.setTelefono(frmMedicos.txtTelefono.getText().trim());
        accionesMedico.guardarMedico(medico);
    }

    // Modifica los datos de un médico
    public void modificarMedico() {
        String idMedico = frmMedicos.txtId.getText().trim();
        if (idMedico.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un ID de médico válido");
            return;
        }
        medico.setId(Long.parseLong(idMedico));

        int seleccion = frmMedicos.cbEspecialidad.getSelectedIndex();
        Long id = (long) seleccion;
        especialidad.setId(id);
        medico.setEspecialidades(especialidad);

        String numeroColegiado = frmMedicos.txtNumColegiado.getText().trim();
        if (!numeroColegiado.isEmpty()) {
            medico.setNumeroColegiado(numeroColegiado);
        }

        String dni = frmMedicos.txtDni.getText().trim();
        if (!dni.isEmpty()) {
            medico.setDni(dni);
        }

        String nombre = frmMedicos.txtNombre.getText().trim();
        if (!nombre.isEmpty()) {
            medico.setNombre(nombre);
        }

        String apellido1 = frmMedicos.txtApellido1.getText().trim();
        if (!apellido1.isEmpty()) {
            medico.setApellido1(apellido1);
        }

        String apellido2 = frmMedicos.txtApellido2.getText().trim();
        if (!apellido2.isEmpty()) {
            medico.setApellido2(apellido2);
        }

        String telefono = frmMedicos.txtTelefono.getText().trim();
        if (!telefono.isEmpty()) {
            medico.setTelefono(telefono);
        }

        accionesMedico.actualizarMedico(medico);
        cargarMedicos();
    }

    // Carga los datos de un médico seleccionado en la tabla
    public void mostrarMedico() {
        int columna = 0; 
        int fila = frmMedicos.jTMedicos.getSelectedRow();
        if (fila != -1) {
            String idMedico = frmMedicos.jTMedicos.getModel().getValueAt(fila, columna).toString();
            if (!idMedico.isEmpty()) {
                Long id = Long.parseLong(idMedico);
                System.out.println("id Mostrar: "+id);
                medico.setId(id);
            }
            Medicos medicoGuardado = accionesMedico.mostrarMedico(medico);
            rellenarFormulario(medicoGuardado);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
    }

    // Muestra los datos de un médico en los TextAreas
    public void rellenarFormulario(Medicos medico) {
        frmMedicos.txtId.setText(String.valueOf(medico.getId()));
        frmMedicos.txtNumColegiado.setText(medico.getNumeroColegiado());
        frmMedicos.txtDni.setText(medico.getDni());
        frmMedicos.txtNombre.setText(medico.getNombre());
        frmMedicos.txtApellido1.setText(medico.getApellido1());
        frmMedicos.txtApellido2.setText(medico.getApellido2());
        frmMedicos.txtTelefono.setText(medico.getTelefono());
        Long idMedicoL = medico.getEspecialidades().getId();
        long idMedicol = idMedicoL; 
        int idMedicoI = (int) idMedicol; 
        frmMedicos.cbEspecialidad.setSelectedIndex(idMedicoI);
    }
    
    // Elimina un médico por su id escrito en el TextArea Id
    public void eliminarMedico() {
        String idMedico = frmMedicos.txtId.getText().trim();
        if (!idMedico.isEmpty()) {
            long id = Long.parseLong(idMedico);
            System.out.println("id Eliminar: "+id);
            medico.setId(id);
        }  
        accionesMedico.eliminarMedico(medico);
        cargarMedicos();
    }

    // Carga los medicos de una lista en la tabla médicos
    public void cargarMedicos () {

            List<Medicos> listaMedicos = accionesMedico.obtenerMedicos();

            DefaultTableModel modelMedico = new DefaultTableModel();
            modelMedico.setColumnIdentifiers(new Object[] {"Id", "Num. Colegiado", "Nombre", "Apellido 1", "Apellido 2", "Especialidad"});

            for (Medicos medico : listaMedicos) {
                modelMedico.addRow(new Object[] {medico.getId(), medico.getNumeroColegiado(), medico.getNombre(), 
                    medico.getApellido1(), medico.getApellido2(), medico.getEspecialidades().getId()});
            }

            frmMedicos.jTMedicos.setModel(modelMedico);
    }

}

