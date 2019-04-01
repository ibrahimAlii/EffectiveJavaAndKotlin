package Item42.kotlin

import java.util.function.DoubleBinaryOperator

enum class Operation private constructor(private val symbol: String, private val op: DoubleBinaryOperator) {
    // Shortcut for Operation in Item 38
    PLUS("+", DoubleBinaryOperator{ x, y -> x + y }),
    MINUS("-", DoubleBinaryOperator{ x, y -> x - y }),
    TIMES("*", DoubleBinaryOperator{ x, y -> x * y }),
    DIVIDE("/", DoubleBinaryOperator{ x, y -> x / y });

    override fun toString(): String {
        return symbol
    }

    fun apply(x: Double, y: Double): Double {
        return op.applyAsDouble(x, y)
    }
}
