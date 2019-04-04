import fraction.Fraction;
import fraction.FractionImpl;


public class Main {

    public static void main(String[] args) {
        /**I wasn't sure on the type of testing we were expected to carry, so checked that the return value of
         * the methods equals the correct value of the operation, which includes the fractions being in their
         * simplified form**/

        // We create Fraction objects covering various cases (other than denominator == 0)
        Fraction completeFraction = new FractionImpl(4,6);
        Fraction completeFraction2= new FractionImpl(15,-35);
        Fraction stringFraction = new FractionImpl("4/3");
        Fraction stringFraction2 = new FractionImpl("5/-2");
        Fraction stringFraction3 = new FractionImpl(" -2 ");
        Fraction onlyNumerator = new FractionImpl(4);
        Fraction onlyNumerator2 = new FractionImpl(-5);

        //We create some variables containing the results of the arithmetic operations.
        Fraction add = ((completeFraction.add(stringFraction3)));
        Fraction add2 = (completeFraction2.add(onlyNumerator));
        Fraction sub = (stringFraction2.subtract(completeFraction));
        Fraction sub2 = (stringFraction.subtract(completeFraction2));
        Fraction mul = (onlyNumerator2.multiply(onlyNumerator2));
        Fraction mul2 = (onlyNumerator.multiply(stringFraction));
        Fraction div = (completeFraction.divide(completeFraction2));
        Fraction div2 = (stringFraction2.divide(stringFraction));

        // We test that they return the correct value, all of them should print "true".

        System.out.println("Test passed = " + add.toString().equals("-4/3"));
        System.out.println("Test passed = " + add2.toString().equals("25/7"));
        System.out.println("Test passed = " + sub.toString().equals("-19/6"));
        System.out.println("Test passed = " + sub2.toString().equals("37/21"));
        System.out.println("Test passed = " + mul.toString().equals("25"));
        System.out.println("Test passed = " + mul2.toString().equals("16/3"));
        System.out.println("Test passed = " + div.toString().equals("-14/9"));
        System.out.println("Test passed = " + div2.toString().equals("-15/8"));


        // We now initialize variables containing the return value for the other methods
        Fraction neg = completeFraction.negate();
        Fraction neg2 = stringFraction3.negate();
        Fraction inv = stringFraction.inverse();
        Fraction inv2 = stringFraction2.inverse();
        Fraction abs = completeFraction.abs();
        Fraction abs2 = completeFraction2.abs();
        Boolean equals = completeFraction.equals(onlyNumerator);
        Boolean equals2 = completeFraction2.equals(completeFraction2);
        int compare = onlyNumerator.compareTo(onlyNumerator);
        int compare2 = onlyNumerator.compareTo(completeFraction);
        int compare3 = stringFraction2.compareTo(stringFraction);

        //We proceed as before,  only "True" should be printed.

        System.out.println("Test passed = " + neg.toString().equals("-2/3"));
        System.out.println("Test passed = " + neg2.toString().equals("2"));
        System.out.println("Test passed = " + inv.toString().equals("3/4"));
        System.out.println("Test passed = " + inv2.toString().equals("-2/5"));
        System.out.println("Test passed = " + abs.toString().equals("2/3"));
        System.out.println("Test passed = " + abs2.toString().equals("3/7"));
        System.out.println("Test passed = " + (equals == false));
        System.out.println("Test passed = " + equals2);
        System.out.println("Test passed = " + (compare == 0));
        System.out.println("Test passed = " +(compare2 == 1));
        System.out.println("Test passed = " +(compare3 == -1));

        // We will test now if the exceptions work as expected

        // Division by zero
        try{
            Fraction test = new FractionImpl(1,0);
        }catch(ArithmeticException e){
            System.out.println("Test passed = Division by zero has been prevented by the constructor.");
        }

        // Using an object other than a Fraction one with compareTo()

        try{
            Fraction test = new FractionImpl("ha");
            completeFraction.compareTo(test);
        }catch(IllegalArgumentException e){
            System.out.println("Test passed = Only Fraction objects are accepted by compareTo().");
        }

    }
}
