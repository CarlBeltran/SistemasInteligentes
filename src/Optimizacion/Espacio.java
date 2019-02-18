package Optimizacion;

public interface Espacio<T> {
    public T generar();
    public T reparar( T x );
    public void print( T x );
}