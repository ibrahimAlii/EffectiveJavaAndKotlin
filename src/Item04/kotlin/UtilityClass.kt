package Item04.kotlin

interface CarFactory {
    val prize: Int
    fun makeCar(): Car
}

object Fiat126PFactory: CarFactory {
    override val prize: Int = 500
    override fun makeCar(): Car = TODO()
}

object OpelAstraFactory: CarFactory {
    override val prize: Int = 2_500
    override fun makeCar(): Car = TODO()
}

object FerrariFactory: CarFactory {
    override val prize: Int = 500_000
    override fun makeCar(): Car = TODO()
}

val factories = listOf(
        Fiat126PFactory,
        OpelAstraFactory,
        FerrariFactory
)
val cheapestCar = factories.minBy { it.prize }?.makeCar()
