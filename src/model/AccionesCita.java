
package model;

import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.hibernate.Query;

public class AccionesCita {
    private static SesionesBBDD sesion = new SesionesBBDD();

    //Guarda en BD la cita en base de datos
    public static void guardarCita(Citas cita){
       sesion.iniciarOperacion();
       sesion.session.save(cita);
       sesion.terminarOperacion();
       System.out.println("Registro insertado");
    }
    
    //Carga una cita desde base de datos tomando su ID
    public static Citas mostrarCita(Citas cita){
        sesion.iniciarOperacion();
        System.out.println("Lectura registro con ID: "+ cita.getId());
        Citas citaGuardada = (Citas) sesion.session.get(Citas.class, cita.getId());
        System.out.println("Registro: "+ citaGuardada.getId()); 
        sesion.terminarOperacion();
        System.out.println("Terminado!");

        return citaGuardada;
    }
    
    //Modifica en BD la cita con los valores recibidos de la cita modificada en el formulario
    public static void actualizarCita (Citas cita){
       sesion.iniciarOperacion();
       sesion.session.update(cita);
       sesion.terminarOperacion();
    }
    
    //Elimina en BD la cita según la id introducida
    public void eliminarCita(Citas cita) {
        sesion.iniciarOperacion();
        long id = cita.getId();
        cita = (Citas) sesion.session.get(Citas.class, id);
        if (cita != null) {

            Set<Tratamientos> tratamientos = cita.getTratamientoses();
            for (Tratamientos tratamiento : tratamientos) {

                sesion.session.delete(tratamiento);
            }

            sesion.session.delete(cita);
            sesion.terminarOperacion();
            JOptionPane.showMessageDialog(null,"Cita eliminada");
            System.out.println("Cita eliminada");
        } else {
            JOptionPane.showMessageDialog(null,"No se encontró la cita con el ID proporcionado");
            System.out.println("No se encontró la cita con el ID proporcionado");
        }
    }
    
    //Carga en una lista las citas de la base de datos.
    public List<Citas> obtenerCitas() {
        sesion.iniciarOperacion();
        Query query = sesion.session.createQuery("FROM Citas");
        List<Citas> listaCitas = query.list();
        sesion.terminarOperacion();
        return listaCitas;
    }
}

