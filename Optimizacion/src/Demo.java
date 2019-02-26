public class Demo implements Function<double[]> {
    public Demo(){}

    @Override
    public double evaluate(double[] arr) {
        return arr[0]*arr[0] - 2*arr[1] + (arr[1]-3)*(arr[1]-3) - arr[0];
    }

    public void print( double[] x ){
        int n=x.length;
        System.out.println(this.evaluate(x));
    }

}