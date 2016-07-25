package example.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Leonardo on 08/07/2016.
 */
public class Estudiante {

    private int Matricula;
    private String Nombre;
    private String Carrera;
    private ArrayList<Asignatura> Asignaturas = new ArrayList<Asignatura>();


    public Estudiante(int matricula, String nombre, String carrera, Asignatura asign) {
        Matricula = matricula;
        Nombre = nombre;
        Carrera = carrera;
        this.Asignaturas.add(asign);
}
    public Estudiante(){}

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    public List<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        Asignaturas = asignaturas;
    }


}
