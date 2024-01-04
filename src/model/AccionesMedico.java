package model;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;

public class AccionesMedico {
    private static SesionesBBDD sesion = new SesionesBBDD();
    
    //Guarda en BD un registro de médico
    public static void guardarMedico(Medicos medico){
       sesion.iniciarOperacion();
       sesion.session.save(medico);
       sesion.terminarOperacion();
       JOptionPane.showMessageDialog(null,"Médico guardado");
       System.out.println("Registro insertado");
    }
    
    //Carga desde BD un médico segun su ID
    public static Medicos mostrarMedico(Medicos medico){
        sesion.iniciarOperacion();
        System.out.println("Lectura registro con ID: "+ medico.getId());
        Medicos medicoGuardado = (Medicos) sesion.session.get(Medicos.class, medico.getId());
        System.out.println("Registro: "+ medicoGuardado.getNombre()); 
        sesion.terminarOperacion();
        System.out.println("Terminado!");

        return medicoGuardado;
    }

    //Modifica en BD el registro de un médico   
    public static void actualizarMedico(Medicos medico){
       sesion.iniciarOperacion();
       sesion.session.update(medico);
       sesion.terminarOperacion();
       JOptionPane.showMessageDialog(null,"Médico modificado");
    }
   
    //Elimina en BD el registro de un médico tomando como referencia su ID
    public static void eliminarMedico(Medicos medico) {
        sesion.iniciarOperacion();
        long id = medico.getId();
        medico = (Medicos) sesion.session.get(Medicos.class, id);
        if (medico != null) {
            sesion.session.delete(medico);
            sesion.terminarOperacion();
            JOptionPane.showMessageDialog(null,"Medico eliminado");
            System.out.println("Medico eliminado");
        } else {
            JOptionPane.showMessageDialog(null,"No se encontró el medico con el ID proporcionado");
            System.out.println("No se encontró el medico con el ID proporcionado");
        }
    }
    
    //Carga en una lista el total de médicos disponibles en la base de datos
    public List<Medicos> obtenerMedicos() {
        sesion.iniciarOperacion();
        Query query = sesion.session.createQuery("FROM Medicos");
        List<Medicos> listaMedicos = query.list();
        sesion.terminarOperacion();
        return listaMedicos;
    }

}




