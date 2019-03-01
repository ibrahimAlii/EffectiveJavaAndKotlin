package Item24.java;

import java.util.AbstractSet;
import java.util.Iterator;

public class NonStaticMemberClass<E> extends AbstractSet<E> {

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    private class MyIterator<S> implements Iterator<S>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public S next() {
            return null;
        }
    }
    @Override
    public int size() {
        return 0;
    }
}
