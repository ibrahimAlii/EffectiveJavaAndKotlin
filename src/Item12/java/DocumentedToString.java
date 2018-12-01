package Item12.java;

public class DocumentedToString {


    /**
     *
     * @return the string representation of phone number.
     * The string consist of twelve characters whose format is "XXX-YYY-ZZZZ", where XXX is the area code, YYY is the
     * prefix, and ZZZZ is the line number. Each of the capital letters represents a single decimal digit.
     *
     * If any of the three parts of this phone number is to small to fill up field is padded with leading zeros.
     * For example, if the value of the line number is 123, the last four characters of the string representation wil be "0123".
     */
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }
}
