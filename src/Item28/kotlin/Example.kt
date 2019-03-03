package Item28.kotlin


/*
  In Java, arrays are covariant meaning that where Sub is a subtype of Super an array of type Sub[] is a subtype of Super[]
  which can lead to an ArrayStoreException at runtime if you store a different subtype of Super in an array:
 */

// runtime exception
/*
  Object[] objectArray = new Long[1];
  objectArray[0] = "Compiles but throws an ArrayStoreException";
  Arrays in Kotlin as with Java generics are invariant so you cannot perform the same cast as you can in Java — Array<Type1>
  is neither a subtype nor a supertype of Array<Type2> for two distinct types. Kotlin’s arrays allow the use of generics which Java doesn’t.
  Of course, you can perform an unchecked, and not safe, cast with an Array such that the following code compiles
  in Kotlin where it wouldn’t in Java because of this use of generics:

 */

/*
  val stringLists = Array<List<String>>(1) { emptyList() }
  val objects = stringLists as Array<List<Any>> // unchecked cast
  objects[0] = listOf(42)
  val s = stringLists[0][0] // runtime exception here
*/

/*
  However, the only guaranteed valid cast with an Array is to a star-projection which will cast the get return values to Any.

  Lists have two class hierarchies in Kotlin, List and MutableList where MutableList like Array is also invariant.
   Consider that if you could cast a MutableList<Int> to MutableList<Number>,
    then you would introduce the same issue shown above for Java’s arrays of allowing the insertion of invalid data at compile time.
    Likewise, if you cast to a more specific implementation of Int then although setting values would work, getting them would fall into the same trap.

  List however in Kotlin is covariant where it was invariant in Java,
  that is you can cast a List<Int> to List<Number> which makes sense when you consider that as an immutable class
   you can only get values out and not set any in and as such an Int return value can definitely be cast to a Number.

  With Array, List and MutableList you get compile-time type safety that wasn’t achievable in the same way with Java.
   On the surface, there is little difference between Array and MutableList,
    but Array uses generics in Kotlin so cannot store primitives and is fixed in size. For primitive arrays see IntArray, DoubleArray, etc.

  You should still prefer MutableList over Array with Kotlin but, as you aim to minimise immutability (item 17), List should be your first choice.

 */