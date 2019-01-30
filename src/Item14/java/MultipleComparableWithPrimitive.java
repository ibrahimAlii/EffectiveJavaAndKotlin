package Item14.java;

import Item10.java.PhoneNumber;

/**
 * An example of Multiple fields Comparable with primitive fields
 */
public class MultipleComparableWithPrimitive {

    public int compareTo(PhoneNumber pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix);
            if (result == 0)
                result = Short.compare(lineNum, pn.lineNum);
        }

        return result;
    }
}
