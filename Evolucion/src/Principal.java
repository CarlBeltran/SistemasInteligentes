public class Principal {

    public static Glovito[] iniciar( int cant ){
        Glovito[] poblacion = new Glovito[ cant ];

        for( int i = 0; i < cant ; i++ ) {
            poblacion[i] =  new Glovito( Util.binario( 24 ) );
        }

        return poblacion;
    }

    public static void main( String[] args ){
        int cant = 100;
        int[] ambiente = new int[]{ 1, 1, 0 , 0, 1 , 1, 0 , 0, 0, 1 , 1 };

        Genetico<Glovito> genetico =
                new Genetico<Glovito>( iniciar( cant ),
                        new GlovitoFitness( ambiente ),
                        new Elitismo( 10, 20 ),
                        new GlovitoCrecer() );
        genetico.aplicar( 240 );

    }
}
