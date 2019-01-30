package Evolucion;

public class Elitismo implements Seleccion{
    int tope;
    int fondo;

    public Elitismo(int tope, int fondo){
        this.tope = tope;
        this.fondo = fondo;
    }

    @Override
    public int[] aplicar(int cantidad, double[] fitness) {
        int[] indices = new int[fitness.length];
        fitness = fitness.clone();

        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        for (int i = 0; i < fitness.length-1; i++) {
            for (int j = i+1; j < fitness.length; j++) {
                if(fitness[i]<fitness[j]){
                    double f = fitness[i];
                    fitness[i] = fitness[j];
                    fitness[j] = f;
                    int t = indices[i];
                    indices[i] = indices[j];
                    indices[j] = t;
                }
            }
        }

        int[] selec = new int[cantidad];
        int n = fitness.length * tope / 100;

        for (int i = 0; i < cantidad; i++) {
            selec[i] = indices[(int)(Math.random() * n)];
        }

        return selec;
    }


}
