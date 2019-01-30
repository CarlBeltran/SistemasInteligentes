package Evolucion;

public class Uniforme implements Seleccion{
    @Override
    public int[] aplicar(int cantidad, double[] fitness) {
        int[] selec = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            selec[i] = (int)(Math.random()*fitness.length);
        }
        return selec;
    }
}