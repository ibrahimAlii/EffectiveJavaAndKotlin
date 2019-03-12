package Item32.java;

import java.util.List;
import java.util.Random;

public class TypeSafeGenerics {

    static <T> List<T> pickTwo(T a, T b, T c){
        switch (new Random().nextInt(3)){
            case 0: return List.of(a, b);
            case 1: return List.of(a, c);
            case 2: return List.of(b, c);
        }
        throw new AssertionError();
    }
}
