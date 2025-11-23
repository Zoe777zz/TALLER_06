package ArchivosCSV;



public class Inventario implements Comparable<Inventario> {

    // representa un item de inventario proveniente del archivo csv
    // contiene id nombre y cantidad
    // la comparacion por id permite que los algoritmos ordenen estos objetos


    public String id;
    public String insumo;
    public int stock;

    public Inventario(String id, String insumo, int stock) {
        this.id = id;
        this.insumo = insumo;
        this.stock = stock;
    }

    @Override
    public int compareTo(Inventario o) {
        return Integer.compare(this.stock, o.stock);
    }

    @Override
    public String toString() {
        return id + " - " + insumo + " - stock:" + stock;
    }
}
