package Item21.kotlin

/*
  The book gives a real-world example of the addition of removeIf where particular Collection implementations will fail at runtime.

  With Kotlin we are no more protected from the same risks highlighted, but additionally,
   we also need to consider Java interoperability. As presented in item 20,
   Kotlin’s default implementations by design are not based on Java 8’s default methods unless you enable the @JvmDefault annotation.
   As the documentation states though, methods with the annotation are “excluded from interface delegation” making composition harder (item 18).
   Effectively there is a trade-off with Java 8 integration whatever you choose.
 */


