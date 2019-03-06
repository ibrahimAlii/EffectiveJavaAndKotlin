package Item29.kotlin

import java.util.*

class Stack<T : Any>(initialCapacity: Int = 16) {
    @Suppress("UNCHECKED_CAST")
    private var elements = arrayOfNulls<Any?>(initialCapacity) as Array<T?>
    private var size = 0

    val isEmpty = size == 0

    fun push(e: T) {
        ensureCapacity()
        elements[size++] = e
    }

    fun pop(): T {
        if (size == 0) throw EmptyStackException()
        return (elements[--size] as T).also {
            elements[size] = null // Eliminate obsolete reference
        }
    }

    private fun ensureCapacity() {
        if (elements.size == size)
            elements = Arrays.copyOf(elements, 2 * size + 1)
    }
}