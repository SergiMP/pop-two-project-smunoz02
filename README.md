# pop-two-project-smunoz02
Student =  Sergio Munoz Paino.
Birkbeck ID = 13152383

Implementation of the Java Fraction class as per CW instructions.

The project was started on the 31st March, and was finished on the 4th of April.

The main issues I had was with the toString() method, which only returned a single String a for fractions of the type a/1, thus when I splitted the String, there wasn't any denominator.

To fix this problem I created a method called checkString(), which returns a String[] object with a default value of 1 at index 1 for the denominator.

Once I managed to solve this most methods were pretty straightforward, although I had to check Google since I didn't remember very well how to operate with fractions :).

The other point that wasn't particularly clear was how to perform testing on main(), as discussed with other students I implemented a series of simple test, to check if the methods returned the expected result, and wrapped it into a Boolean variable, which then I printed.


