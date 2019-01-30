package Item14.java;


import Item10.java.PhoneNumber;

import java.util.Comparator;

/**
 * This an example of Comparable with Comparator construction method
 */
public class ComparableWithCompratorConstruction {

    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);

    public int compareTo(PhoneNumber pn){
        return COMPARATOR.compare(this /* this should be a phone number instance*/, pn);
    }
}
