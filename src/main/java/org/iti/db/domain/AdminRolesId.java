package org.iti.db.domain;// default package
// Generated Mar 23, 2021, 6:50:21 PM by Hibernate Tools 6.0.0.Alpha2


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AdminRolesId generated by hbm2java
 */
@Embeddable
public class AdminRolesId  implements java.io.Serializable {


     private String email;
     private String role;

    public AdminRolesId() {
    }

    public AdminRolesId(String email, String role) {
       this.email = email;
       this.role = role;
    }
   


    @Column(name="email", nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name="role", nullable=false, length=45)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AdminRolesId) ) return false;
		 AdminRolesId castOther = ( AdminRolesId ) other; 
         
		 return ( (this.getEmail()==castOther.getEmail()) || ( this.getEmail()!=null && castOther.getEmail()!=null && this.getEmail().equals(castOther.getEmail()) ) )
 && ( (this.getRole()==castOther.getRole()) || ( this.getRole()!=null && castOther.getRole()!=null && this.getRole().equals(castOther.getRole()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEmail() == null ? 0 : this.getEmail().hashCode() );
         result = 37 * result + ( getRole() == null ? 0 : this.getRole().hashCode() );
         return result;
   }   


}


