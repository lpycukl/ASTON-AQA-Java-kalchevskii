package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(factorial(5));
    }

    public static int factorial(int number) {
        if (number==1 || number==0) return 1;
        else return number*factorial(number-1);
    }
}

