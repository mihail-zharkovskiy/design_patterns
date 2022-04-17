package creational_patterns.factory_method


data class Human private constructor(
    val age: Int,
    val name: String,
) {
    companion object {
        //factory method
        fun newHuman(name: String): Human {
            return Human(17, name = name)
        }
    }
}

fun main() {
    val newHuman = Human.newHuman("Иван")
    println(newHuman)
}