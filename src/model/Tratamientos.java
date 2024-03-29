package model;
// Generated 19-dic-2023 22:25:50 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tratamientos generated by hbm2java
 */
public class Tratamientos  implements java.io.Serializable {


     private Long id;
     private Citas citas;
     private TratamientoTipos tratamientoTipos;
     private Short duracion;
     private Short periodicidad;
     private String comentario;
     private Date createdAt;
     private Date updatedAt;
     private Set tratamientoArchivoses = new HashSet(0);

    public Tratamientos() {
    }

    public Tratamientos(Citas citas, TratamientoTipos tratamientoTipos, Short duracion, Short periodicidad, String comentario, Date createdAt, Date updatedAt, Set tratamientoArchivoses) {
       this.citas = citas;
       this.tratamientoTipos = tratamientoTipos;
       this.duracion = duracion;
       this.periodicidad = periodicidad;
       this.comentario = comentario;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.tratamientoArchivoses = tratamientoArchivoses;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Citas getCitas() {
        return this.citas;
    }
    
    public void setCitas(Citas citas) {
        this.citas = citas;
    }
    public TratamientoTipos getTratamientoTipos() {
        return this.tratamientoTipos;
    }
    
    public void setTratamientoTipos(TratamientoTipos tratamientoTipos) {
        this.tratamientoTipos = tratamientoTipos;
    }
    public Short getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }
    public Short getPeriodicidad() {
        return this.periodicidad;
    }
    
    public void setPeriodicidad(Short periodicidad) {
        this.periodicidad = periodicidad;
    }
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Set getTratamientoArchivoses() {
        return this.tratamientoArchivoses;
    }
    
    public void setTratamientoArchivoses(Set tratamientoArchivoses) {
        this.tratamientoArchivoses = tratamientoArchivoses;
    }




}


