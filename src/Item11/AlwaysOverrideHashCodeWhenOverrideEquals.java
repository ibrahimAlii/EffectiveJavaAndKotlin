package Item11;

/*
 ** Equal objects must have equal hash codes **
 */
public class AlwaysOverrideHashCodeWhenOverrideEquals {


    /**
     * The worst possible legal hashCode implementation - [[never use]]!
     */

    @Override
    public int hashCode() {
        return 42;
    }
}




