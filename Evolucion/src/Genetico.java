public class Genetico<T> {
    T[] poblacion;
    double[] fitness;
    Funcion<T> f;
    Mutacion m = new Mutacion();
    Cruce c = new Cruce();
    Crecer<T> crecer;
    Seleccion s;

    public Genetico( T[] poblacion, Funcion<T> f, Seleccion s, Crecer<T> crecer ){
        this.poblacion = poblacion.clone();
        this.f = f;
        this.s = s;
        this.crecer = crecer;
        this.fitness = new double[poblacion.length];

        for (int i = 0; i < poblacion.length ; i++) {
            this.fitness[i] = f.aplicar(poblacion[i]);
        }
    }

    public void aplicar( int generaciones ){
        imprimir();

        for( int i = 0; i < generaciones ; i++ ){
            int[] padres = s.aplicar( 2, fitness );
            int[][] hijos = c.aplicar( crecer.codifica( poblacion[ padres[0] ] ), crecer.codifica( poblacion[ padres[1] ] ) );
            hijos[0] = m.aplicar( hijos[0] );
            hijos[1] = m.aplicar( hijos[1] );

            int p1 = (int)( Math.random()*poblacion.length );
            int p2 = (int)( Math.random()*poblacion.length );

            T x1 = crecer.crecer( hijos[0] );
            T x2 = crecer.crecer( hijos[1] );
            double f1 = f.aplicar( x1 );
            double f2 = f.aplicar( x2 );

            if( f1 > fitness[p1] ){
                poblacion[p1] = x1;
                fitness[p1] = f1;
            }

            if( f2 > fitness[p2] ){
                poblacion[p2] = x2;
                fitness[p2] = f2;
            }

            imprimir();
        }
    }

    public void imprimir(){
        int mejorIndice = Util.indiceMax( fitness );
        //System.out.println( mejorIndice+" "+fitness[ mejorIndice ] );
        System.out.println( Util.average(fitness) );
    }
}
