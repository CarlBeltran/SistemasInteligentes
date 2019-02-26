import java.util.Random;

public class Gaussiana implements Mutacion<double[]> {
    protected HiperCubo espacio;
    protected double sigma;

    public Gaussiana( HiperCubo espacio, double sigma ){
        this.espacio = espacio;
        this.sigma = sigma;
    }

    public double[] gauss() {
        Random r = new Random();
        double[] x = new double[espacio.dim()];
        for( int i=0; i<x.length; i++ ){
            x[i] = sigma*r.nextGaussian();
        }
        return x;
    }

    @Override
    public double[] aplicar(double[] x) {
        double[] y = x.clone();
        double[] z = gauss();
        for( int i=0; i<y.length; i++ ) y[i] += z[i];
        return espacio.reparar(y);
    }
}