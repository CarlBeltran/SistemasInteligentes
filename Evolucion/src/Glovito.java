public class Glovito {
    int[][] estados;
    int[][] salida;

    public Glovito(int[][] estados, int[][] salida){
        this.estados = estados;
        this.salida = salida;
    }

    public Glovito(int[] adn){
        int cantEstados = 4; //  adn.length/6
        int cantSimbolos = 2;
        estados = new int[ cantEstados ][ cantSimbolos ];
        salida  = new int[ cantEstados ][ cantSimbolos ];

        int k = 0;
        for( int i = 0; i < cantEstados ; i++ ){
            for( int j = 0; j < cantSimbolos ; j++ ){
                estados[ i ][ j ] = adn[ k ]*2 + adn[ k+1 ];
                salida[ i ][ j ] = adn[ k+2 ];
                k += 3;
            }
        }

    }

    public int[] codifica(){
        int[] adn = new int[ 24 ];

        int cantEstados = 4; //  adn.length/6
        int cantSimbolos = 2;

        int k = 0;
        for( int i = 0; i < cantEstados ; i++ ){
            for( int j = 0; j < cantSimbolos ; j++ ){
                adn[ k ]   = estados[ i ][ j ]/2;
                adn[ k+1 ] = estados[ i ][ j ]%2;
                adn[ k+2 ] = salida[ i ][ j ];
                k += 3;
            }
        }
        return adn;
    }

    public int[] simular( int[] entrada ){
        int[] escribe = new int[ entrada.length ];

        int estado = 0;
        for ( int i = 0; i < entrada.length ; i++ ) {
            escribe[ i ] = salida[ estado ][ entrada[ i ] ];
            estado = estados[ estado ][ entrada[ i ] ];
        }

        return escribe;
    }
}
