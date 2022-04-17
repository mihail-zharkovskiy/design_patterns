package behavior_patterns

class User(
    private val chat: GeneralChat,
    private val name: String
) {
    fun send(msg: String) {
        println("$name: отправка - $msg")
        chat.sendMessage(msg, this)
    }

    fun receive(msg: String) {
        println("$name: прием сообщения - $msg")
    }
}

//GeneralChat - выструпет в роли mediator
class GeneralChat {
    private val users: MutableList<User> = ArrayList()

    fun sendMessage(msg: String, user: User) {
        users.filter { it != user }.forEach { it.receive(msg) }
    }

    fun addUserToChat(user: User): GeneralChat = apply { users.add(user) }

}

fun main() {
    val mediator = GeneralChat()
    val saha = User(mediator, "Саша")
    val masha = User(mediator, "Маша")
    val pasha = User(mediator, "Паша")

    mediator
        .addUserToChat(pasha)
        .addUserToChat(masha)
        .addUserToChat(saha)
    saha.send("Привет от Саши!")
}