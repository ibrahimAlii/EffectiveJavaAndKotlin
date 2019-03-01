package Item23.kotlin

class Circle(private val radius: Double) : Figure() {

    override fun area(): Int {
        return (Math.PI * (radius * radius)).toInt()
    }
}