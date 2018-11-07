package Item07.java;

import java.util.EmptyStackException;

public class EliminateObbseleteObjects {

    public Object pop(){
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }
}
