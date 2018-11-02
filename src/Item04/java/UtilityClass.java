package Item04.java;

// Noninstantiable utility class
public class UtilityClass {
    // Supress default constructor for noninstantiability
    private UtilityClass(){
        throw new AssertionError();
    }

    //...... Remainder omitted
}
