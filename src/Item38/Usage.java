package Item38;

import Item38.java.ExtendedOperation;
import Item38.java.Operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Usage {

    public static void main(String[] args) {
        double x = 15456456.5;
        double y = 15456456.5;

        test(ExtendedOperation.class, x, y);

        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet)
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}
