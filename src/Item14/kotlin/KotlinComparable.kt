package Item14.kotlin

/*
   With Kotlin we should implement kotlin.Comparable rather than java.util.Comparable.
   Both require the implementation of a compareTo function, but, using Kotlin’s version gives access to some extension functions.
    The below code shows an example compareTo function using Java 8’s comparingInt, available since Android API 24.
 */

class Date(val year: Int, val month: Int, val day: Int) :
        Comparable<Date> {

    override fun compareTo(other: Date): Int {
        return COMPARATOR.compare(this, other)
    }

    companion object {
        private val COMPARATOR =
                Comparator.comparingInt<Date> { it.year }
                        .thenComparingInt { it.month }
                        .thenComparingInt { it.day }
    }
}

/*
  ---------------------------------------------------------------------------------------------------------------------
 */


/*
   Kotlin’s extension functions allow you to use the rangeTo operator, .. to create ranges as well as coerce values within particular bounds.
 */
fun Date.isInTwentyEighteen(): Boolean {
    return this in Date(2018, 1, 1)..Date(2018, 12, 31)
}




/*
   To make your ranges even more powerful define an iterator operator.
    This allows you to do for (i in Date(2017, 2, 20)..Date(2017, 3, 3)) as well as call iterator().asSequence()
     to be able to filter your range for example.
 */

operator fun ClosedRange<Date>.iterator() =
        object : Iterator<Date> {
            var curr: Date = start

            override fun hasNext() = curr <= endInclusive
            override fun next() = curr++
        }
/*
   For the above to work with the Date class example you would also need to add in an operator fun Date.inc(): Date.
 */