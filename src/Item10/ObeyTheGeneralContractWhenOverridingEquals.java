package Item10;


/*
  Override the equals when:

   1- Each instance of the class is inherently unique.
   2- There is no need for the class to provide a "logical equality" test.
   3- A superclass has already overridden equals, and the superclass behavior is appropriate for this class.
   4- The class is private or package-private, and you are certain that it's equals method will never be invoked.

   @Override public boolean equals(Object o) {
       throw new AssertionError(); // Method is never called
    }
 */


/*
  After finish writing equals method, ask yourself three questions:

    - Is it symmetric?
    - Is it transitive?
    - Is it consistent?
 */

/*
   Few final caveats

   - Always override hashCode when you override equals
   - Don't try to be too clever
   - Don't substitute another type for Object in the equals declaration.
 */
public class ObeyTheGeneralContractWhenOverridingEquals {
}
