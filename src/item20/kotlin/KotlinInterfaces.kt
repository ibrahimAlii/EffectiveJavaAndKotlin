package Item19.kotlin

/*
   Kotlin’s interfaces are very similar to those in Java 8, allowing the declaration of abstract methods,
   method implementations, abstract properties and property accessor implementations.
   Interfaces cannot store state and as such any properties defined don’t have backing fields and their definitions overridden by an implementation
   so should be used with caution. The code below demonstrates the main features of an interface:
 */

interface AnInterface {
    val abstractProperty: Boolean

    var propertyAccessorImplementations: Boolean
        get() = true
        set(value) {
            if (value) {
                // do something
            }
        }

    fun abstractMethod()

    fun methodImplementation() {
        // do something
    }
}
/*
   It is important to note however that Kotlin’s method implementations are synthetic and don’t compile down to Java 8’s default methods.
    As such implementing the above, AnInterface, in Java may result in a compile error as you need to implement AnInterface::methodImplementation.


 */

/*
  The latest versions of Kotlin introduce the experimental @JvmDefault annotation to support generating default interface
    methods for JVM 1.8+ to help alleviate the problem discussed above. The feature is disabled by default, as discussed in issue KT-4779, with a compiler flag to enable it:

    compileKotlin {
    kotlinOptions {
        freeCompilerArgs = ['-Xjvm-default=enable']
    }
}
To summarise, as with Java 8, prefer interfaces over abstract classes paying close attention to Java interoperability.


 */

