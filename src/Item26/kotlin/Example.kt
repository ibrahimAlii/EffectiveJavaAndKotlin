package Item26.kotlin

/*
   Kotlin, on the other hand, doesn’t have raw types, you always have to specify the type parameter.
   For Java interoperability raw types are converted into star projections where List becomes List<*>!
   which maps to List<out Any?>!. Star projections are a way to say that you know nothing about the type
   argument but remain “safe” — in basic terms get returns Any? and set allows you to set Nothing,
    i.e. you will get a compilation error if you try to use it. Read Mixed-Site Variance for more details about the background behind Kotlin’s implementation.
 */

/*
   Of course under the hood Kotlin’s generics are erased,
   just as with Java’s, meaning you can still get a ClassCastException if you use an unchecked cast to an invalid type.
   As such, in is statements, you can only check the type against a star-projection as that is the most you know:

 */

//when (anyObject) {
//    is MutableList<*> -> doSomething()
//    is List<*> -> doSomethingElse()
//}


/*
   Although there are similarities between Kotlin’s star-projections and Java’s raw types
    we should not be afraid to use them where necessary as star projections are effectively bounded types.
 */