public class AscensoColina {
    public void aplicar() {
        Demo d = new Demo();
        HiperCubo espacio = new HiperCubo(2, -10,10 );
        Gaussiana mutacion = new Gaussiana(espacio, 0.2);
        int k=0;
        double [] x = espacio.generar();
        System.out.print(k+' '); espacio.print(x);
        System.out.println();
        for( k=1; k<=10000; k++ ){
            double[] y = mutacion.aplicar(x);
            if(d.evaluate(x)>=d.evaluate(y)) x = y;
            System.out.print(k+" "); espacio.print(x);
            System.out.println();
        }
    }

    public static void main( String[] args ){
        AscensoColina ac = new AscensoColina();
        ac.aplicar();
    }
}
