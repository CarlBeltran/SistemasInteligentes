package Optimizacion;

public class HiperCubo implements Espacio<double[]> {
    protected double min;
    protected double max;
    protected double length;
    protected int n;

    public HiperCubo( int n, double min, double max ){
        this.min = min;
        this.max = max;
        length = max-min;
        this.n = n;
    }

    public int dim(){ return n; }

    @Override
    public double[] generar() {
        double[] x = new double[n];
        for (int i = 0; i < n ; i++) {
            x[i] = min + Math.random()*length;
        }
        return x;
    }

    @Override
    public double[] reparar( double[] x ) {
        double[] y = x.clone();
        for( int i=0; i<n; i++ ){
            if( y[i]<min ) y[i] = min;
            else if(y[i]>max) y[i] = max;
        }
        return y;
    }

    public void print( double[] x ){
        System.out.print('[');
        for( int i=0; i<n-1; i++ ){
            System.out.print(x[i]);
            System.out.print(',');
        }
        System.out.print(x[n-1]);
        System.out.print("] ");
    }

}