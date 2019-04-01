package Item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Usage {

    static List<String> words = new ArrayList<>();
    public static void main(String[] args){


        // 1st.version Using Anonymous class instance as a function object - obsolete!
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });


        // 2nd.version Using Lambda expression as function object (replaces anonymous class)
        Collections.sort(words, (Comparator<String>) (o1, o2) -> Integer.compare(o1.length(), o2.length()));


        // 3rd.version Using method reference
        Collections.sort(words, Comparator.comparingInt(String::length));


        // 4rd.version Taking the advantage of the sort method was added to List interface in Java 8;
        words.sort(Comparator.comparingInt(String::length));

    }
}
