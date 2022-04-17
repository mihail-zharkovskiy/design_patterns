package structural_patterns

/**
 * более понятный пример фафсада это стандартный репозиторий
 * **/

class FacadeCar {
    private val wheels = Wheels()
    private val engine = Engine()
    private val transmission = Transmission()
    private val car = CarFactory(wheels, engine, transmission).buildCar()

    fun useCar() = car.driveCar()
}

class Car {
    fun driveCar() = println("машина поехала")
}

class CarFactory(
    private val wheels: Wheels,
    private val engine: Engine,
    private val transmission: Transmission
) {
    fun buildCar(): Car {
        wheels.buildWheels()
        engine.buildEngine()
        transmission.buildTransmission()
        return Car()
    }
}

class Wheels {
    fun buildWheels() = println("создал колеса")
}

class Engine {
    fun buildEngine() = println("создал двигатель")
}

class Transmission {
    fun buildTransmission() = println("создал коробку передач")
}

fun main() {
    FacadeCar().useCar()
}

