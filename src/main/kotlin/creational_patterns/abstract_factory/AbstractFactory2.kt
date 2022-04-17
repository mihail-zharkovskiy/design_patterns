package creational_patterns.abstract_factory

interface Fruit

class Orange : Fruit {
    override fun toString(): String = "Orange"
}

class Apple : Fruit {
    override fun toString(): String = "Apple"
}

abstract class FruitFactory {
    abstract fun makePlant(): Fruit

    companion object {
        inline fun <reified T : Fruit> createFactory(): FruitFactory = when (T::class) {
            Orange::class -> OrangeFactory()
            Apple::class -> AppleFactory()
            else -> throw IllegalArgumentException()
        }
    }
}

class AppleFactory : FruitFactory() {
    override fun makePlant(): Fruit = Apple()
}

class OrangeFactory : FruitFactory() {
    override fun makePlant(): Fruit = Orange()
}

fun main() {
    val plantFactory = FruitFactory.createFactory<Orange>()
    val plant = plantFactory.makePlant()
    println("Created Fruit: $plant")
}