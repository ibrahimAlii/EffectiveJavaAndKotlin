package Item30.kotlin


/*
  The implementation in Kotlin is not much different to Java just with the type parameter list specified between fun and the function name.
 */

// Generic method
fun <T> union(vararg sets: Set<T>): Set<T> {
    return sets.flatMap { it }.toSet()
}
val union = union<Number>(setOf<Int>(1, 2), setOf<Double>(3.1, 4.2))
/*
   Introducing generic methods shouldn’t break backwards compatibility in Kotlin unless of course it introduces a new
   generic class as discussed in item 29 so there is little reason to ignore the guidance, avoid the Any object where you can.
 */
