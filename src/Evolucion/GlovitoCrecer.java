package Evolucion;

public class GlovitoCrecer implements Crecer<Glovito>{
    @Override
    public int[] codifica( Glovito obj ) {
        return obj.codifica();
    }

    @Override
    public Glovito crecer( int[] arr ) {
        return new Glovito(arr);
    }
}
