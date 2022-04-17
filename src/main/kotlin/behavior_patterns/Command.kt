package behavior_patterns

import kotlin.random.Random

abstract class Command(val action: Action) {
    abstract fun execute()
}

class DrawLineCommand(action: Action) : Command(action) {
    override fun execute() = action.drawLine()
}

class DrawOvalCommand(action: Action) : Command(action) {
    override fun execute() = action.drawOval()
}

class Action {
    fun drawLine() = println("рисум линию")
    fun drawOval() = println("рисум овал")
}

class CommandExecutor {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun action() {
        command?.execute()
    }
}

fun main() {
    val executor = CommandExecutor()
    val action = Action()
    val randomInt = Random.nextInt(0, 10)

    if (randomInt % 2 == 0) {
        executor.setCommand(DrawLineCommand(action))
    } else {
        executor.setCommand(DrawOvalCommand(action))
    }
    executor.action()
}