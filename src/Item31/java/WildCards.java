package Item31.java;

import java.util.List;
import java.util.Set;

public class WildCards {

    public static <T extends Comparable<? super T>> T max(List<? extends T> list){}


    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2){}
 }
