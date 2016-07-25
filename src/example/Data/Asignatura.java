package example.Data;

/**
 * Created by Leonardo on 08/07/2016.
 */
public class Asignatura {
    private String codigo;
    private String nombre;

    public Asignatura(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    public Asignatura(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
