package Item11.java;

public class TypicalHashCodeMethod {


    /**
     *  The value 31 was chosen because it is an odd prime. if it were even and the multiplication overflowed,
     *  information would be lost, because multiplication by 2 is equivalent to shifting.
     * @return result
     */
    @Override
    public int hashCode() {
        int result = Short.hashCode(someVal);
        result = 31 * result + Short.hashCode(someOtherVal);
        result = 31 * result + Short.hashCode(someThing);

        return result;
    }
}
