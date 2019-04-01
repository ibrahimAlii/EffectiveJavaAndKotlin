package Item43;

import java.util.HashMap;

public class Usage {

    public static void main(String[] args){

        HashMap<Integer, Integer> map = new HashMap<>();

        // The code snippet is to associate the number 1 with the key if it is not in the map and to increment the associated
        // value if the key is already present


        // 1.st version
        map.merge(1, 1, (count, incr) -> count + incr);


        // 2nd.version using Method references -- shorter, cleaner and more readable
        map.merge(1, 1, Integer::sum);
    }
}
