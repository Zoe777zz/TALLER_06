package ArchivosCSV;


public class Paciente implements Comparable<Paciente> {
    // representa un paciente cargado desde el csv
    // guarda id nombre y edad
    // se compara por id para integrarse con los algoritmos de ordenacion

    public String id;
    public String apellido;
    public int prioridad;

    public Paciente(String id, String apellido, int prioridad) {
        this.id = id;
        this.apellido = apellido;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Paciente o) {
        return this.apellido.compareTo(o.apellido);
    }

    @Override
    public String toString() {
        return id + " - " + apellido + " - prioridad:" + prioridad;
    }
}
