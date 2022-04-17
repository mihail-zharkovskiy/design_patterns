package behavior_patterns.state

/**
 * здесь получилась смесь двух паттернов: State и Builder.
 * очень удобный вариант для реализации состояния данных в android
 * **/

data class State<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T) = State(Status.SUCCESS, data, null)

        fun <T> loading() = State<T>(Status.LOADING, null, null)

        fun <T> empty() = State<T>(Status.EMPTY, null, null)

        fun <T> error(message: String) = State<T>(Status.ERROR, null, message)
    }
}

enum class Status {
    SUCCESS,
    LOADING,
    EMPTY,
    ERROR
}

fun main() {
    val states = mutableListOf(
        State.success(2),
        State.empty(),
        State.loading(),
        State.error("Error")
    )

    fun downloadingData(): State<Int> {
        return states.random()
    }

    val state = downloadingData()

    when (state.status) {
        Status.SUCCESS -> {
            println("состояние загрузки \"Выполнено\" $state")
        }
        Status.LOADING -> {
            println("состояние загрузки \"Загрузка\" $state")
        }
        Status.EMPTY -> {
            println("состояние загрузки \"Пусто\" $state")
        }
        Status.ERROR -> {
            println("состояние загрузки \"Ошибка\" $state")
        }
    }
}