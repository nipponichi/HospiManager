package model;
// Generated 19-dic-2023 22:25:50 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TratamientoTipos generated by hbm2java
 */
public class TratamientoTipos  implements java.io.Serializable {


     private Long id;
     private String nombre;
     private String descripcion;
     private Date createdAt;
     private Date updatedAt;
     private Set tratamientoses = new HashSet(0);

    public TratamientoTipos() {
    }

	
    public TratamientoTipos(String nombre) {
        this.nombre = nombre;
    }
    public TratamientoTipos(String nombre, String descripcion, Date createdAt, Date updatedAt, Set tratamientoses) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.tratamientoses = tratamientoses;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public Set getTratamientoses() {
        return this.tratamientoses;
    }
    
    public void setTratamientoses(Set tratamientoses) {
        this.tratamientoses = tratamientoses;
    }




}


