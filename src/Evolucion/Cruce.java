package Evolucion;

public class Cruce {
    int[][] aplicar(int[] adn1, int[] adn2){
        int[] clon1 = adn1.clone();
        int[] clon2 = adn2.clone();

        int puntoCruce = 1+(int)(Math.random()* (adn1.length - 2) );

        System.arraycopy(adn2, puntoCruce, clon1, puntoCruce, adn1.length - puntoCruce);
        System.arraycopy(adn1, puntoCruce, clon2, puntoCruce, adn2.length - puntoCruce);

        System.out.println(puntoCruce);
        return new int[][]{clon1, clon2};
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] y = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


        Cruce cruce = new Cruce();
        for (int i = 0; i < 100 ; i++) {
            System.out.println("-----------------------------");
            int[][] res = cruce.aplicar(x, y);
            System.out.println(Util.toString(res[0]));
            System.out.println(Util.toString(res[1]));
        }
    }


}
