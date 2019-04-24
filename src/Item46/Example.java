package Item46;

import Item42.java.Operation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static Item15.java.PublicStaticFinalArrayField.values;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Example {


    static String[] words = new String[5];
    public static void main(String[] args){

        // groupingBy
        Map<String, Long> freq = Arrays.stream(words).collect(groupingBy(String::toLowerCase, counting()));


        // Using a toMap collector to make a map from string to enum
        Map<String, Operation> stringToEnum = Stream.of(values()).collect(toMap(Object::toString, e -> e));


        // Pipeline to get a top-ten list of word from a frequency table
        List<String> topTen = freq.keySet().stream().sorted(comparing(freq::get).reversed()).limit(10).collect(toList());


    }
}
