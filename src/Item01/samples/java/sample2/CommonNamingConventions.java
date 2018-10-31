package Item01.samples.java.sample2;

import java.math.BigInteger;
import java.util.Date;

/**
 * We can reduce naming problem by drawing attention to static factories in class or interface documentation and by
 * adhering to common naming conventions.
 */
public class CommonNamingConventions {

    /* Here are some common names for static factories methods. */


    // #Obj.from
    Date data = Date.from(null);


    // #Obj.of
    // --> Set<String> set = EnumSet.of(/* SomeEnums*/)


    // #Obj.valueOf
    BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);




}
