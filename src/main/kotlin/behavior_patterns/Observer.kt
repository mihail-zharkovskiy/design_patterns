package behavior_patterns

interface Observer {
    fun onEvent()
}

class FirstObserver : Observer {
    override fun onEvent() = println("FirstObserver пронаблюдал данные")
}

class SecondObserver : Observer {
    override fun onEvent() = println("SecondObserver пронаблюдал данные")
}

class EventOwner {
    private val observers = mutableListOf<Observer>()

    fun addObserver(vararg observer: Observer) = observers.addAll(observer)

    fun removeObserver(observer: Observer) = observers.remove(observer)

    fun emitEvent() = observers.forEach { observer -> observer.onEvent() }
}

fun main() {
    val eventOwner = EventOwner()
    val firstObserver = FirstObserver()
    val secondObserver = SecondObserver()

    eventOwner.addObserver(firstObserver, secondObserver)
    eventOwner.emitEvent()
}