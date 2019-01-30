package Evolucion;

public class Mutacion {


    public int[] aplicar( int[] adn ){
        int[] clon = adn.clone();
        double p = 1.0/adn.length;

        for (int i = 0; i < adn.length ; i++) {
            if(Math.random() < p){
                clon[i] = 1 - clon[i];
            }
        }

        return clon;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Mutacion m = new Mutacion();

        for (int i = 0; i < 100 ; i++) {
            System.out.println("-----------------------------");
            int[] res = m.aplicar(x);
            System.out.println(Util.toString(res));
        }
    }
}
