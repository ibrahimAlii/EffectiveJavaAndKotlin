package Item38.kotlin

import Item38.java.Operation

enum class ExtendedOperation private constructor(private val symbol: String) : Operation {

    EXP("^") {
        override fun apply(x: Double, y: Double): Double {
            return Math.pow(x, y)
        }
    },
    REMINDER("%") {
        override fun apply(x: Double, y: Double): Double {
            return x % y
        }
    };

    override fun toString(): String {
        return symbol
    }
}