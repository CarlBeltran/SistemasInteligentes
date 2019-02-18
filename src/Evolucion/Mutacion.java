package Evolucion;

public class Mutacion {

    public int[] aplicar( int[] adn ){
        int[] clon = adn.clone();
        double p = 1.0/adn.length;

        for( int i = 0; i < adn.length ; i++ ){
            if( Math.random() < p ){
                clon[ i ] = 1 - clon[ i ];
            }
        }

        return clon;
    }

}
