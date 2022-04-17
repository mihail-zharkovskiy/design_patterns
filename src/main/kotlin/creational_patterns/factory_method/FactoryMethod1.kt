package creational_patterns.factory_method

import kotlin.random.Random


interface Task {
    fun execute()
}

class SendMessageTask : Task {
    override fun execute() = println("задача отправить сообщение выполнена")
}

class ReadMessageTask : Task {
    override fun execute() = println("задача прочитать сообщение выполнена")
}

class SendMassageTaskExecutor : Executor() {
    override fun getTask(): Task = SendMessageTask()
}

class ReadMassageTaskExecutor : Executor() {
    override fun getTask(): Task = ReadMessageTask()
}

class RandomMassageTaskExecutor : Executor() {
    override fun getTask(): Task = if (Random.nextBoolean()) SendMessageTask() else ReadMessageTask()
}


abstract class Executor {
    fun executeTaskInBackground() {
        println("выполняется на Background")
        getTask().execute()
    }

    /**factory method**/
    abstract fun getTask(): Task
}

fun main() {
    SendMassageTaskExecutor().executeTaskInBackground()
    ReadMassageTaskExecutor().executeTaskInBackground()
    RandomMassageTaskExecutor().executeTaskInBackground()
}