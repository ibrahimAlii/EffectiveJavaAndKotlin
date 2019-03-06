package Item30.java;

import Item13.kotlin.Object;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.empty;

public class GenericMethods {


    // Returns max value in a collection - uses recursive type bound
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            return new Optional<E>.of(c);

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }



}
