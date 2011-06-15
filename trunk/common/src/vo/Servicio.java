package vo;
// Generated 09/06/2011 05:53:40 PM by Hibernate Tools 3.2.1.GA



/**
 * Servicio generated by hbm2java
 */
public class Servicio extends PersistenceObj implements java.io.Serializable {


     private Long id;
     private String descripcion;
     private double costo;
     private boolean estado;
     private long idProveedor;

    public Servicio() {
    }

    public Servicio(String descripcion, double costo, boolean estado, long idProveedor) {
       this.descripcion = descripcion;
       this.costo = costo;
       this.estado = estado;
       this.idProveedor = idProveedor;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getCosto() {
        return this.costo;
    }
    
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public long getIdProveedor() {
        return this.idProveedor;
    }
    
    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }




}


