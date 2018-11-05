package Item06.java;

import java.util.regex.Pattern;

public class RomanNumerals {
    /*
    Instead of using the famous [String.matches] pattern which will create a Pattern instance each time invoking it.
     */

    // Reusing expensive object for improved performance
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD])");

    static boolean isRomanNumeral(String s){
        return ROMAN.matcher(s).matches();
    }
}
