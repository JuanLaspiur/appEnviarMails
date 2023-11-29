package modelo;

import java.util.Date;


public class Consulta {
    private int id;
    private Reclutador reclutador;
    private Date fecha;
    private String mensaje;

    public Consulta() {
    }

    public Consulta(Reclutador reclutador, Date fecha, String mensaje) {
        this.reclutador = reclutador;
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    public Consulta(int id, Reclutador reclutador, Date fecha, String mensaje) {
        this.id = id;
        this.reclutador = reclutador;
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reclutador getReclutador() {
        return reclutador;
    }

    public void setReclutador(Reclutador reclutador) {
        this.reclutador = reclutador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", reclutador=" + reclutador + ", fecha=" + fecha + ", mensaje=" + mensaje + '}';
    }

    
    
}
