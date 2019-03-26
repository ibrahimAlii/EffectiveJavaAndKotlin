package Item37;

import Item37.java.Planet;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Usage {



    static Planet[] garden = new Planet[0]; // fake
    public static void main(String[] args){


        // Using ordinal() to index into an array - DON"T DO THIS !!!
        Set<Planet>[] planetsByLifeCycle = (Set<Planet>[]) new Set[Planet.LifeCycle.values().length];
        for (int i = 0; i < planetsByLifeCycle.length; i++)
            planetsByLifeCycle[i] = new HashSet<>();

        for (Planet p : garden)
            planetsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        for (int i = 0; i < planetsByLifeCycle.length; i++)
            System.out.printf("%s: %s%n", Planet.LifeCycle.values()[i], planetsByLifeCycle[i]);


        //-----------------------------------------
        //Using EnumMap to associate data with an enum  --1st version--
        Map<Planet.LifeCycle, Set<Planet>> plantsByLifeCycle = new EnumMap<Planet.LifeCycle, Set<Planet>>(Planet.LifeCycle.class);
        for (Planet.LifeCycle pl: Planet.LifeCycle.values())
            plantsByLifeCycle.put(pl, new HashSet<>());
        for (Planet p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);


        //------------------------------------------
        // Using Stream with EnumMap --2nd version--
        System.out.println(Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Planet.LifeCycle.class), toSet())));


    }
}
