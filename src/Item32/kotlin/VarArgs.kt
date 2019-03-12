package Item32.kotlin

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}


/*
  allowing a variable number of arguments to be passed to the function:
 */

val list = asList(1, 2, 3)

/*
  Inside a function a vararg-parameter of type T is visible as an array of T, i.e. the ts variable in the example above has type Array<out T>.

  Only one parameter may be marked as vararg.
   If a vararg parameter is not the last one in the list, values for the following parameters can be passed using the named argument syntax,
    or, if the parameter has a function type, by passing a lambda outside parentheses.

  When we call a vararg-function, we can pass arguments one-by-one, e.g. asList(1, 2, 3), or,
  if we already have an array and want to pass its contents to the function, we use the spread operator (prefix the array with *):

*/

val a = arrayOf(1, 2, 3)
val list = asList(-1, 0, *a, 4)
val a = arrayOf(1, 2, 3)
val list = asList(-1, 0, *a, 4)