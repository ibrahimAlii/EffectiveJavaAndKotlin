package Item27.kotlin


/*
   Kotlin already helps by reducing the potential number of warnings we get, for example,
   with its use of smart casts and star-projections instead of raw types.
 */

/*
if (obj is String) {
    println(obj.length) // Smart-cast to a String automatically
}
*/

/*
   Where you cannot remove a warning but know it to be type-safe then in Java you would annotate the class with
   @SuppressWarnings(“unchecked”), the Kotlin equivalent being @Suppress(“UNCHECKED_CAST”), and of course document why it is type-safe.
 */

/*
  One of the other tools up Kotlin’s sleeve is inline functions with reified type parameters which allow you to perform
   is T checks for the type parameter along with access to T::class.java. The following example is from Android KTX:
 */

inline fun <reified T> Context.systemService() =
        getSystemService(T::class.java)
// somewhere  in your code
val connectivityManager = systemService<ConnectivityManager>()


/*
  Inline functions with reified types cannot be called from Java whereas standard inline functions can of course
  so if interoperability is a concern then it is vital to provide a Java-compatible version of your function too.
 */