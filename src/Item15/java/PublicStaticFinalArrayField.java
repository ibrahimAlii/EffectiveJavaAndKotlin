package Item15.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PublicStaticFinalArrayField {

    // Potential security hole! The array elements can be modified.
    public static final Thing[] VALUES = {};

    // Two ways to avoid that

    // 1 -
    private static final Thing[] PRIVATE_VALUES = {};
    public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    // 2-
    private static final Thing[] PRIVATE_VALUES = {};
    public static final Thing[] values(){
        return PRIVATE_VALUES.clone();
    }
}
