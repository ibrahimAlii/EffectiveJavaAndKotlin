package Item13.kotlin

/*when you create a data class. copy creates a new instance with the default constructor, avoiding a lot of the complexities
of clone while additionally allowing overriding of any of its properties.

It is essential to understand how copy works, with reference types it is merely copying the reference to the object and
 not copying the content. Consider the following code:
*/

data class Object(val list: List<Int>)

val list = mutableListOf(1)
val alex = Object(list)

val bob = alex.copy()

list.add(2)

println(alex.list)
println(bob.list)
/*
Although the class of list may look immutable, you can, of course, provide any type including mutable lists.
 Given that copy copies the reference when the mutable list changes we will see that both objects now contain [1, 2].

As with clone, be careful when dealing with mutable classes such as lists, and builders. Copy only works well on entirely immutable objects.
        */