package Evolucion;

public class GlovitoFitness implements Funcion<Glovito> {
    int[] ambiente;

    public GlovitoFitness( int[] ambiente ){
        this.ambiente = ambiente;
    }

    @Override
    public double aplicar( Glovito x ) {
        int[] salida = x.simular( this.ambiente );
        int cant = 0;

        for( int i = 0; i < salida.length-1; i++ ){
            if( salida[ i ] == ambiente[ i+1 ] ){
                cant++;
            }
        }
        return cant;
    }
}
