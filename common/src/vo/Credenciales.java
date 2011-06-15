package vo;
// Generated 09/06/2011 05:53:40 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Credenciales generated by hbm2java
 */
public class Credenciales extends PersistenceObj implements java.io.Serializable {


     private Long id;
     private String login;
     private String pwd;
     private String rol;
     private Set<Cliente> clientes = new HashSet<Cliente>(0);
     private Set<Proveedor> proveedors = new HashSet<Proveedor>(0);

    public Credenciales() {
    }

	
    public Credenciales(String login, String pwd, String rol) {
        this.login = login;
        this.pwd = pwd;
        this.rol = rol;
    }
    public Credenciales(String login, String pwd, String rol, Set<Cliente> clientes, Set<Proveedor> proveedors) {
       this.login = login;
       this.pwd = pwd;
       this.rol = rol;
       this.clientes = clientes;
       this.proveedors = proveedors;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Set<Cliente> getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    public Set<Proveedor> getProveedors() {
        return this.proveedors;
    }
    
    public void setProveedors(Set<Proveedor> proveedors) {
        this.proveedors = proveedors;
    }




}


