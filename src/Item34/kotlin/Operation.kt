package Item34.kotlin

enum class Operation(val symbol: String) {
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

    abstract fun apply(x: Double, y: Double): Double
}