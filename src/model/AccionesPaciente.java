package model;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;

public class AccionesPaciente {
    private static SesionesBBDD sesion = new SesionesBBDD();
    
    //Guarda en BD Paciente en la base de datos
    public static void guardarPaciente(Pacientes paciente){
       sesion.iniciarOperacion();
       sesion.session.save(paciente);
       sesion.terminarOperacion();
       JOptionPane.showMessageDialog(null,"Paciente guardado");
       System.out.println("Registro insertado");
    }
        
    //Carga desde BD un paciente desde la base de datos tomando su ID
    public static Pacientes mostrarPaciente(Pacientes paciente){
        sesion.iniciarOperacion();
        System.out.println("Lectura registro con ID: "+ paciente.getId());
        Pacientes pacienteGuardado = (Pacientes) sesion.session.get(Pacientes.class, paciente.getId());
        System.out.println("Registro: "+ pacienteGuardado.getNombre()); 
        sesion.terminarOperacion();
        System.out.println("Terminado!");
        return pacienteGuardado;
    }

    //Modifica en BD el paciente con los valores recibidos del paciente modificado en el formulario    
    public static void actualizarPaciente(Pacientes paciente){
       sesion.iniciarOperacion();
       sesion.session.update(paciente);
       sesion.terminarOperacion();
       JOptionPane.showMessageDialog(null,"Paciente modificado");
    }
   
    //Elimina de la BD el paciente segun su ID
    public static void eliminarPaciente(Pacientes paciente) {
        sesion.iniciarOperacion();
        long id = paciente.getId();
        paciente = (Pacientes) sesion.session.get(Pacientes.class, id);
        if (paciente != null) {
            sesion.session.delete(paciente);
            sesion.terminarOperacion();
            JOptionPane.showMessageDialog(null,"Paciente eliminado");
            System.out.println("Paciente eliminado");
        } else {
            JOptionPane.showMessageDialog(null,"No se encontró el paciente con el ID proporcionado");
            System.out.println("No se encontró el paciente con el ID proporcionado");
        }
    }
    
    //Carga en una lista el total de pacientes de la base de datos
    public List<Pacientes> obtenerPacientes() {
        sesion.iniciarOperacion();
        Query query = sesion.session.createQuery("FROM Pacientes");
        List<Pacientes> listaPacientes = query.list();
        sesion.terminarOperacion();
        return listaPacientes;
    }

}


