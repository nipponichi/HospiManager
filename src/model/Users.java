package model;
// Generated 19-dic-2023 22:25:50 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Long id;
     private String name;
     private String email;
     private Date emailVerifiedAt;
     private String password;
     private String rememberToken;
     private Date createdAt;
     private Date updatedAt;
     private Set pacienteses = new HashSet(0);
     private Set enfermeroses = new HashSet(0);
     private Set medicoses = new HashSet(0);

    public Users() {
    }

	
    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Users(String name, String email, Date emailVerifiedAt, String password, String rememberToken, Date createdAt, Date updatedAt, Set pacienteses, Set enfermeroses, Set medicoses) {
       this.name = name;
       this.email = email;
       this.emailVerifiedAt = emailVerifiedAt;
       this.password = password;
       this.rememberToken = rememberToken;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.pacienteses = pacienteses;
       this.enfermeroses = enfermeroses;
       this.medicoses = medicoses;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getEmailVerifiedAt() {
        return this.emailVerifiedAt;
    }
    
    public void setEmailVerifiedAt(Date emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRememberToken() {
        return this.rememberToken;
    }
    
    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
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
    public Set getPacienteses() {
        return this.pacienteses;
    }
    
    public void setPacienteses(Set pacienteses) {
        this.pacienteses = pacienteses;
    }
    public Set getEnfermeroses() {
        return this.enfermeroses;
    }
    
    public void setEnfermeroses(Set enfermeroses) {
        this.enfermeroses = enfermeroses;
    }
    public Set getMedicoses() {
        return this.medicoses;
    }
    
    public void setMedicoses(Set medicoses) {
        this.medicoses = medicoses;
    }




}


