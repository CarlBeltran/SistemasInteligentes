package Evolucion;

public class Elitismo implements Seleccion{
    int tope;
    int fondo;

    public Elitismo( int tope, int fondo ){
        this.tope = tope;
        this.fondo = fondo;
    }

    @Override
    public int[] aplicar( int cantidad, double[] fitness ) {
        int[] indices = new int[ fitness.length ];
        fitness = fitness.clone();

        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        for (int i = 1; i < fitness.length-1; i++) {
            for (int j = 0; j < fitness.length - i ; j++) {
                if(fitness[j] < fitness[j+1]){
                    double f = fitness[j+1];
                    fitness[j+1] = fitness[j];
                    fitness[j] = f;

                    int t = indices[j+1];
                    indices[j+1] = indices[j];
                    indices[j] = t;
                }
            }
        }

        int[] selec = new int[cantidad];
        int n = fitness.length * tope / 100;

        for (int i = 0; i < cantidad; i++) {
            int selected = (int)(Math.random() * n);
            selec[i] = indices[selected];
        }

        return selec;
    }

}
