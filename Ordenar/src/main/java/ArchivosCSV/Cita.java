package ArchivosCSV;

public class Cita implements Comparable<Cita> {

    // representa una cita cargada desde el archivo csv
    // almacena su id fecha y motivo para poder tratarlos como un objeto
    // implementa comparable para permitir que los algoritmos ordenen citas segun su id

    public String id;
    public String apellido;
    public String fechaHora;

    public Cita(String id, String apellido, String fechaHora) {
        this.id = id;
        this.apellido = apellido;
        this.fechaHora = fechaHora;
    }

    @Override
    public int compareTo(Cita other) {
        return this.fechaHora.compareTo(other.fechaHora);
    }

    @Override
    public String toString() {
        return id + " - " + apellido + " - " + fechaHora;
    }
}


