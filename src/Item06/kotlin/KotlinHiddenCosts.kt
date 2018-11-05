package Item06.kotlin

// https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-1-fbb9935d9b62#3a31

/*
 If you use Nullable types such as Int?,
 then this will always compile as Integer as there’s no way for a primitive reference to hold null.
 When developing with Kotlin ask yourself, “does this need to be null?”
 */

/*
 The issue with generics is the type argument must be a reference type.
 Usually, the use of generics will be apparent, but one hidden case is in the use of lambda functions. Consider the following code:
*/
fun awesomeAlgorithm(factor: Int): (Int, Int) -> Int {
    return { a, b -> a + b * factor }
}
/*
  This generates byte-code where the lambda’s input and output will be boxed just to be unboxed again,
  not what you would call efficient. Function2 is the interface used for functions with two input parameters,
  Kotlin defines these interfaces from 0 to 22.
 */