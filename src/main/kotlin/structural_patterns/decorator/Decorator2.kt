package structural_patterns.decorator

/**
 * Decorator он же Wrapper
 * **/
class MyMap<K, V>(
    private val map: MutableMap<K, V> = mutableMapOf()
) : MutableMap<K, V> by map {
// чтобы не переоределять все подряд, делегирум выполнение остальных мметодов через by map

    override fun put(key: K, value: V): V? {
        // допустим сюда добавили много много нового функционала
        println("в map добавлен новый элнмен: key-$key value-$value")
        return map.put(key, value)
    }
}

fun main() {
    val map = MyMap<Int, String>()
    map[1] = "иван"
}