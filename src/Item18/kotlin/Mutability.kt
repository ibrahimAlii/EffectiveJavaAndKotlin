package Item18.kotlin

/*
  Kotlin fortunately saves us from this boiler-plate code through it’s implementation by delegation
  https://kotlinlang.org/docs/reference/delegation.html#implementation-by-delegation and means we can generate
   the books example ForwardingSet in one line:
 */

open class ForwardingSet<E>(s: MutableSet<E>) : MutableSet<E> by s

class InstrumentedSet<E>(s: MutableSet<E>) : ForwardingSet<E>(s) {
    var addCount: Int = 0

    override fun add(element: E): Boolean {
        addCount++
        return super.add(element)
    }

    override fun addAll(elements: Collection<E>): Boolean {
        addCount += elements.size
        return super.addAll(elements)
    }
}

/*
The delegation can also be applied directly to the InstrumentedSet without the need for an additional ForwardingSet but
 the delegate then must be turned into a property in order to call it in any overridden methods rather than using super.
 */

class InstrumentedSet<E>(private val s: MutableSet<E>) :
        MutableSet<E> by s {
    //...

    override fun add(element: E): Boolean {
        addCount++
        return s.add(element)
    }

    //...
}

//Extension functions can also be used to provide a more functional style, for example to add logging:

fun <E> MutableSet<E>.addLogging(): MutableSet<E> = object : MutableSet<E> by this {
    override fun add(element: E): Boolean {
        println("add called with $element")
        return this@addLogging.add(element)
    }

    override fun addAll(elements: Collection<E>): Boolean {
        println("addAll called with $elements")
        return this@addLogging.addAll(elements)
    }
}
// Will print "add called with 5"
val set = mutableSetOf<Int>().addLogging()
    set.add(5)

//As a side note it is possible in Kotlin to delegate to multiple objects in a class. Zhang QiChuan shows an example of
// this in his article https://proandroiddev.com/composition-over-inheritance-in-kotlin-way-fe341159bf1c on Composition over inheritance in Kotlin way.