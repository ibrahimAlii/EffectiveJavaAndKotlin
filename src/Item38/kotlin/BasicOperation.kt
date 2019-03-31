package Item38.kotlin

import Item38.java.Operation

enum class BasicOperation private constructor(private val symbol: String) : Operation {

    PLUS("+") {
        override fun apply(x: Double, y: Double): Double {
            return x + y
        }
    },
    MINUS("-") {
        override fun apply(x: Double, y: Double): Double {
            return x - y
        }
    },
    TIMES("*") {
        override fun apply(x: Double, y: Double): Double {
            return x * y
        }
    },
    DIVIDE("/") {
        override fun apply(x: Double, y: Double): Double {
            return x / y
        }
    };

    override fun toString(): String {
        return symbol
    }
}