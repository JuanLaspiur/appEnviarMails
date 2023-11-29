package modelo;


public class Reclutador {
    private int id;
    private String nombre;
    private String correo;

    public Reclutador() {
    }

    public Reclutador(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }
    
        public Reclutador(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
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
        final Reclutador other = (Reclutador) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Reclutador{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + '}';
    }
    
    
    
}
