package fraction;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;

    /** We have created these two helper methods GDC() and checkString to reduce the amount of code repetition**/
    /** ------------------------------------------------------------------------------------------------------**/


    //Both of this methods are tested indirectly on the main method, given that they are used by all the other methods

    /**Input = two integers
     * Return value = An integer representing the greatest common divisor.
     *      * GDC(2,4) => 2
     *      * GDC(1,7) => 1
     *      * GDC(3/6) => 3
     * Exceptions = None

     Method is private as indicated on the coursework instructions**/

    private int GCD(int a, int b){


        if(b == 0){
            return a;
        }else{
            return GCD(b, a % b);
        }
    }

    /**Method checkString()
     * Input = A string object.
     * Return value = A String[] object containing the String representation of the numerator and denominator.
     * In case the String has a single character, ("1","2","-3"), the method will assign the default value of "1"
     * to the denominator.
     * Given that toString(2/1) would only return 2, we needed to create this method to allow operations of the type
     * FractionInstance.add(new FractionImpl(2))
     * Exceptions = IllegalArgumentException if the object is not an instance of String
     * **/
    private String[] checkString(String fraction){

        String[] elements = fraction.split("/");
        String[] result = new String[2];
        if(elements.length == 1){
            result[0] = elements[0];
            result[1] ="1";
        }else{
            result[0] = elements[0];
            result[1] = elements[1];
        }
        return result;
    }

    /**--------------------------------------------------------------------------------------------------------**/
    /**Constructor
     * Parameter = Two Integers, a and b.
     * Return value = This constructor method initializes the variables numerator y denominator, doesn't return a value
     * Exceptions = None **/
    public FractionImpl(int a, int b) {


        if(b == 0){
            throw new ArithmeticException("Denominator can't be zero");
        }
        if(b < 1){
            a *= -1;
            b *= -1;
        }
        int gdc = GCD(a,b);

        this.numerator = a / gdc;
        this.denominator = b / gdc;
    }

    /**Parameter = A single integer
     * Return value = This constructor method initializes the variables numerator y denominator, doesn't return a value
     * Exceptions = None **/
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /** Constructor
     *  Parameter = a String object.
     *  Return value = This constructor method initializes the variables numerator y denominator, doesn't return a value..
     *  Exceptions = NumberFormatException if the String contains character other than those representing integers,
     *  with the exception of "/" and " " in the beginning or end of the String.
     *  IllegalArgumentException if the String object contains whitespace " " in between the digits.
     **/

    public FractionImpl(String fraction) {
        fraction = fraction.trim();
        int numeratorInt;
        int denominatorInt;

        // If the fraction doesn't have a proper format i.e "4  /5" it will throw an exception.
        if(fraction.contains(" ")){
            throw new IllegalArgumentException("The fraction doesn't have the required format.");
        }else {
            String[] parts = checkString(fraction);
            numeratorInt = Integer.parseInt(parts[0]);
            denominatorInt = Integer.parseInt(parts[1]);
        }

        // We need to check if the denominator is equal to zero in case the object has the form a/b.
        if(denominatorInt == 0){
           throw new ArithmeticException("Denominator can't be zero");
        }

        // We need to swap signs in case the denominator is negative.
        if(denominatorInt < 1){
               numeratorInt *= -1;
               denominatorInt *= -1;
            }

        int gdc = GCD(numeratorInt,denominatorInt);
        this.numerator = numeratorInt / gdc;
        this.denominator = denominatorInt / gdc;

        }

    /** Method add()
     * Input = A Fraction object.
     * Return value =  A Fraction object, in its reduced form, representing the addition of the original fraction
     * and the one passed as argument. Examples:
     1/2 + 1/2 = 1;
     3/5 + 6/7 = 51/35
     *  Exceptions = NumberFormatException if the String passed as argument contains character other than those
     *  representing integers, with the exception of "/" and " " in the beginning or end of the String.
     *  IllegalArgumentException if the String object contains whitespace " " in between the digits.

     **/
    @Override
    public Fraction add(Fraction f) {

        int numeratorF;
        int denominatorF;
        String fraction[] = checkString(f.toString());
        numeratorF = Integer.parseInt(fraction[0]);
        denominatorF = Integer.parseInt(fraction[1]);

        int resultNumerator = numerator * denominatorF + denominator * numeratorF;
        int resultDenominator = denominator * denominatorF;

        FractionImpl result = new FractionImpl(resultNumerator,resultDenominator);
        return result;
    }
    /**Method subtract()
     * Input = A Fraction object.
     * Return value = A Fraction object in its simplified form representing the subtraction of a Fraction object
     * from another and returns a single Fraction object.
     1/2 - 2/2 = -1/2;
     4/5 - 7/3 = -23/15
     *  Exceptions = NumberFormatException if the String passed as argument contains character other than those
     *  representing integers, with the exception of "/" and " " in the beginning or end of the String.
     *  IllegalArgumentException if the String object contains whitespace " " in between the digits.
     **/
    @Override
    public Fraction subtract(Fraction f) {

        int numeratorF;
        int denominatorF;
        String fraction[] = checkString(f.toString());
        numeratorF = Integer.parseInt(fraction[0]);
        denominatorF = Integer.parseInt(fraction[1]);

        int resultNumerator = numerator * denominatorF - denominator * numeratorF;
        int resultDenominator = denominator * denominatorF;

        FractionImpl result = new FractionImpl(resultNumerator,resultDenominator);
        return result;
    }

    /**Method multiply()
     * Input = A Fraction object.
     * Return Value = Multiplies two Fraction objects together and returns a reduced Fraction object representing the
     * result of the multiplication
     4/5 * 5/4 = 1;
     4/6 * 2/3 = 4/
     *  Exceptions = NumberFormatException if the String passed as argument contains character other than those
     *  representing integers, with the exception of "/" and " " in the beginning or end of the String.
     *  IllegalArgumentException if the String object contains whitespace " " in between the digits.
     **/
    @Override
    public Fraction multiply(Fraction f) {

        int numeratorF;
        int denominatorF;
        String fraction[] = checkString(f.toString());
        numeratorF = Integer.parseInt(fraction[0]);
        denominatorF = Integer.parseInt(fraction[1]);

        int resultNumerator = numerator  * numeratorF;
        int resultDenominator = denominator * denominatorF;

        FractionImpl result = new FractionImpl(resultNumerator,resultDenominator);
        return result;
    }


    @Override
    public Fraction divide(Fraction f) {
        /** Multiplies two Fraction objects together and returns a single Fraction object
         4/5 / 3/4 = 16/15;
         1/3  / 2/7 = 7/6**/

        int numeratorF;
        int denominatorF;
        String fraction[] = checkString(f.toString());
        numeratorF = Integer.parseInt(fraction[0]);
        denominatorF = Integer.parseInt(fraction[1]);

        int resultNumerator = numerator  * denominatorF;
        int resultDenominator = denominator * numeratorF;

        FractionImpl result = new FractionImpl(resultNumerator,resultDenominator);
        return result;
    }

    /**Method abs()
     * Arguments = This method doesn't take arguments.
     * Return value = A Fraction object in its absolute value form.
     -4/5 = 4/5;
     4/-5 = 4/5;
     * Exceptions = None.
     **/

    @Override
    public Fraction abs() {


        int resultNumerator = Math.abs(numerator);
        int resultDenominator = Math.abs(denominator);

        FractionImpl result = new FractionImpl(resultNumerator,resultDenominator);
        return result;
    }

    /** Method negate()
     * Arguments = This method doesn't take arguments.
     * Return value = A new fraction object representing the original one with opposite sign.
     *  8/9 = -8/9;
     * -8/9 = 8/9;
     * Exceptions = None
     **/
    @Override
    public Fraction negate() {

        int resultNumerator = -numerator;

        Fraction result = new FractionImpl(resultNumerator,denominator);
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**Method equals()
     * Arguments = Any Object
     * Return value = A Boolean object, true if both objects are equal, false otherwise.
     * Fraction original = new FractionImpl(2/4);
     * Fraction compare = new FractionImpl(3/6);
     * original.equals(compare) ==> true
     * Exceptions = IllegalArgumentException for any object passed as an argument that is not an instance of Fraction.
     * **/

    @Override
    public boolean equals(Object obj) {

        Boolean question = obj instanceof Fraction;
        if(!question){
            throw  new IllegalArgumentException("This method needs a Fraction type of object");
        }

        int numeratorF;
        int denominatorF;
        String fraction[] = checkString(obj.toString());
        numeratorF = Integer.parseInt(fraction[0]);
        denominatorF = Integer.parseInt(fraction[1]);

        int resultNumerator = numerator  * denominatorF;
        int resultDenominator = denominator * numeratorF;

        Boolean result = (resultNumerator/resultDenominator) == 1;
        return result;

    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**Method inverse()
     * Arguments = Doesn't take any argument
     * Return Value = A new fraction object where the numerator and denominator have switched positions.
     * 5/4 => 4/5;
     * -3/6 => -6/3;
     * Exceptions = None
     * **/
    @Override
    public Fraction inverse() {

        int resultNumerator = denominator;
        int resultDenominator = numerator;
        FractionImpl result = new FractionImpl(resultNumerator,resultDenominator);
        return result;
    }

    /**Method compareTo()
     * Arguments = A Fraction object.
     * Return value = Checks if obj is an instance of the class Fraction, compares it with the current Fraction object
     * and returns 3 possible integers:
     * if its value is bigger (1),
     * smaller(-1)
     * or equal than the original fraction (0).
     *
     * Fraction original = new FractionImpl(2/4);
     * Fraction compare = new FractionImpl(3/6);
     * original.compareTo(compare) // 0
     *
     * Exceptions = None (but there will be a runtime error if the object is not an instance of Fraction)
     * **/

    @Override
    public int compareTo(Fraction o) {

        double numeratorF;
        double denominatorF;
        int result ;

        String fraction[] = checkString(o.toString());
        numeratorF = Integer.parseInt(fraction[0]);
        denominatorF = Integer.parseInt(fraction[1]);

        if(numerator/denominator == numeratorF/denominatorF  ){
            result = 0;
        }else if(numerator/denominator < numeratorF/denominatorF ){
            result = -1;
        }else{
            result = 1;
        }
        return result;
    }

    /**Method toString()
     * Arguments =  Doesn't take any argument
     * Return value = A String object representation of a Fraction object by concatenating "/" in between numerator
     * and denominator or just the String representation of an integer "a" if the fraction has the form "a/1"
     * Exceptions = None
    **/


    @Override
    public String toString() {

        int numeratorF ;
        int denominatorF;
        String result = "";

        if(denominator < 0){
            numeratorF = -numerator;
            denominatorF = -denominator;
        }else{
            numeratorF = numerator;
            denominatorF = denominator;
        }

        if(denominator != 1){
            result = numeratorF + "/" + denominatorF;
        }else{
            result = Integer.toString(numeratorF);
        }
        return result;
    }
}