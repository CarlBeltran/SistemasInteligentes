public class Cruce {

    int[][] aplicar( int[] adn1, int[] adn2 ){
        int[] clon1 = adn1.clone();
        int[] clon2 = adn2.clone();

        int puntoCruce = 1+(int)( Math.random()*( adn1.length - 2 ) );

        System.arraycopy( adn2, puntoCruce, clon1, puntoCruce, adn1.length - puntoCruce );
        System.arraycopy( adn1, puntoCruce, clon2, puntoCruce, adn2.length - puntoCruce );

        return new int[][]{ clon1, clon2 };
    }

}