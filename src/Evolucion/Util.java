package Evolucion;

public class Util {

    public static String toString(int[] arr){
        StringBuilder sb = new StringBuilder();

        sb.append('[');

        if(arr.length>0)
            sb.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            sb.append(',');
            sb.append(arr[i]);
        }

        sb.append(']');

        return sb.toString();
    }

    public static int indiceMax (double[] x ){
        int indice = 0;
        for ( int i = 1; i < x.length; i++ ){
            if( x[ i ] > x[ indice ] )
                indice = i;
        }
        return indice;
    }

    public static double max( double[] x ){
        return x[ indiceMax( x ) ];
    }

    public static int[] binario( int n ){
        int[] bin = new int[ n ];

        for ( int i = 0; i <n; i++ ) {
            bin[ i ] = ( Math.random()<0.5 )? 0 : 1;
        }

        return bin;
    }

    public static double average(  double[] x  ){
        double suma = 0;
        for (int i = 0; i < x.length  ; i++)
            suma+= x[i];

        return suma/x.length;
    }

}