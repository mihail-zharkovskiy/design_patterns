package behavior_patterns

import kotlin.random.Random

interface Strategy {
    fun use()
}

class Operation(private val strategy: Strategy) {
    fun useStrategy() = strategy.use()
}

class FirstStrategy() : Strategy {
    override fun use() = println("применяем FirstStrategy")
}

class SecondStrategy() : Strategy {
    override fun use() = println("применяем SecondStrategy")
}

fun main() {
    val random = Random.nextInt(0, 10)
    val strategy = if (random % 2 == 0) FirstStrategy() else SecondStrategy()

    Operation(strategy).useStrategy()
}