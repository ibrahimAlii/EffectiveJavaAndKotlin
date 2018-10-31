package Item01;

 /* http://www.informit.com/articles/article.aspx?p=1216151 */

public class ConsideringStaticFactoryMethodInsteadOfConstructors {

     // Advantages

    /**
     *  @Adavantage of static factory method is that, unlike constructors they have names.
     *  {e.g: BigInteger(int, int, Random) which returns a BigInteger that is probably prime}
     *  would have been better expressed as a static factory method named #BigInteger.probablePrime#
     *
     *
     *  @Adavantage of static factory method is that, unlike constructors, they are not required to create a new object
     *  each time they're invoked.
     *  {e.g: Boolean.valueOf(boolean) method illustrates this technique: it never creates an object}
     *  This technique is similar to the Flyweight pattern [Gamma95].
     *
     *
     *  @Adavantage of static factory method is that, unlike constructors, they can return an object of any subtype of
     *  their return type.
     *  {e.g: *interface-based frameworks, where interface provide natural return types for static factory methods.}.
     *  java.util.Collections Framework API is much smaller than it would have been exported forty-five separate public
     *  classes, one for each convenience implementation.
     *
     * @Advantage of static factories is that the class of the returned object can vary from call to call as a function
     * of the input parameters.
     * {e.g: #EnumSet class, has no public constructors, only static factories}
     *
     *
     * @Advantage of static factories is that the class of the returned object not exist when the class containing the
     * method is written.
     *
     */



    // Limitations

    /**
     *  @Main limitation of providing only static factory methods is that classes without public or protected constructor
     *  cannot be subclassed.
     *  {e.g: It's impossible to subclass any of the convenience implementation classes in the Collections Framework}
     *
     *  @Second shortcoming of static factory methods is that they hard for programmer's to find.
     *  see CommonNamingConventions.class
     */
}
