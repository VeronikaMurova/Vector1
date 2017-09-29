/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;


/**
 *
 * @author Вероника
 */
public class Vector {


    private final int n;         // length of the vector
    private final double[] data;       // array of vector' components

    // create the zero vector of length n
    public Vector(int n) {
        this.n = n;
        this.data = new double[n];
    }

    // create a vector from an array
    public Vector(double[] data) {
        n = data.length;
        this.data = new double[n];
        for (int i = 0; i < n; i++)
            this.data[i] = data[i];
    }
//length
    public int length() {
        return n;
    }

// return the Euclidean norm of this Vector
    public double Euclideannorm() {
        return Math.sqrt(this.dot(this));
    }
//scale
public  Vector scale(double factor) {
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = factor * data[i];
        return c;
    }
 // return this + that
    public Vector plus(Vector that) {
        if (this.length() != that.length())
            throw new IllegalArgumentException("dimensions disagree");
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    }
// return the inner product of this Vector a and b
    public double dot(Vector that) {
        if (this.length() != that.length())
            throw new IllegalArgumentException("dimensions disagree");
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    }



    /**
     * @param args the command line arguments
     */
    // test client

    public static void main(String[] args) {
       
        double[] xdata = { 1, 2, 3, 4 };
        double[] ydata = { 5, 2, 4, 1 };

        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);
        System.out.println("x        =  " + x);
        System.out.println("y        =  " + y);
        System.out.println("Xlength        =  " + x.length());
        System.out.println("Ylength        =  " + y.length());
        System.out.println("x + y    =  " + x.plus(y));
        System.out.println("10x      =  " + x.scale(10.0));
        System.out.println("|x|      =  " + x.Euclideannorm());
        System.out.println("<x, y>   =  " + x.dot(y));


        // TODO code application logic here
    }
    
}
