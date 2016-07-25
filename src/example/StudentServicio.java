package example;
import example.Data.Asignatura;
import example.Data.Estudiante;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebService()
public class StudentServicio {

    static Map<Integer, Estudiante> Estudiantes = new HashMap<>();
    static List<Asignatura> Asignaturas = new ArrayList<>();

    @WebMethod
    public void newStudent(int matricula, String nombre, String carrera, Asignatura asig) {
        Estudiante New = new Estudiante(matricula, nombre, carrera, asig);
        this.Estudiantes.put(matricula, New);
    }

    @WebMethod
    public boolean modifyEstudiante (Integer matricula, String nombre, String carrera, ArrayList<Asignatura> asignaturas){
        Estudiante e = Estudiantes.get(matricula);

        if (e != null){
            e.setNombre(nombre);
            e.setCarrera(carrera);
            e.setAsignaturas(asignaturas);
        }

        return true;
    }
    @WebMethod
    public boolean modifyEstudiante2 (Estudiante e){
        if(Estudiantes.containsKey(e))
        Estudiantes.replace(e.getMatricula(),e);
        else
        return false;

        return true;
    }

    @WebMethod
    public Estudiante GetEstudiante (Integer matricula){
        Estudiante e = Estudiantes.get(matricula);


        return e;
    }
    @WebMethod
    public void removeEstudiante (Integer matricula){
        if(Estudiantes.containsKey(matricula)) {
            Estudiantes.remove(matricula);
        }
    }


    @WebMethod
    public List<Estudiante> Getall (){

        return new ArrayList<Estudiante>(Estudiantes.values());

    }

    @WebMethod
    public List<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    @WebMethod
    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        Asignaturas = asignaturas;
    }

    @WebMethod
    public Asignatura getAsignatura(Asignatura asignatura) {
        return Asignaturas.get(Asignaturas.indexOf(asignatura));
    }
    @WebMethod
    public List<Asignatura> getEstudianteAsignatura(int matricula) {
        return Estudiantes.get(matricula).getAsignaturas();
    }

    @WebMethod
    public void CrearAsignatura(String codigo, String nombre){
        Asignaturas.add(new Asignatura(codigo, nombre));
    }




   private static void populateAsignaturas() {

        Asignaturas.add(new Asignatura("ISC-405", "Diseño de algoritmos"));
        Asignaturas.add(new Asignatura("ISC-101", "Programacion I"));
        Asignaturas.add(new Asignatura("ISC-303", "Matematica Discreta"));
        Asignaturas.add(new Asignatura("ISC-365", "Sistemas operativos"));


    }

    public static void main(String[] argv) {
        populateAsignaturas();
        Object implementor = new StudentServicio();
        String address = "http://localhost:9001/StudentService";
        Endpoint.publish(address, implementor);
    }

}
