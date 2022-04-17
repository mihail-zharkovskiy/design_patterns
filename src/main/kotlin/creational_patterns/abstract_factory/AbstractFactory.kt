package creational_patterns.abstract_factory

interface Chat {
    fun getMassages(): List<Message>
}

data class Message(val data: String)

class FakeChat : Chat {
    override fun getMassages(): List<Message> {
        return listOf(
            Message("Fake Message - 1"),
            Message("Fake Message - 2"),
            Message("Fake Message - 3")
        )
    }
}

class RealChat : Chat {
    override fun getMassages(): List<Message> {
        return listOf(
            Message("Real Message - 1"),
            Message("Real Message - 2"),
            Message("Real Message - 3")
        )
    }
}

abstract class ChatFactory {

    abstract fun getChat(): Chat

    //OR
    companion object {
        inline fun <reified T : Chat> create(): Chat {
            return when (T::class) {
                FakeChat::class -> FakeChat()
                RealChat::class -> RealChat()
                else -> throw Exception("неизвестны тип чата")
            }
        }
    }
}

class FakeChatFactory : ChatFactory() {
    override fun getChat(): Chat = FakeChat()
}

class RealChatFactory : ChatFactory() {
    override fun getChat(): Chat = RealChat()
}

fun main() {
    val fakeChat = ChatFactory.create<FakeChat>()
    val fakeMessage = fakeChat.getMassages()
    println(fakeMessage.toString())

    val realChat = ChatFactory.create<RealChat>()
    val realMessage = realChat.getMassages()
    println(realMessage.toString())
    //OR
    val fake = FakeChatFactory().getChat().getMassages()
    println(fake.toString())
    val real = RealChatFactory().getChat().getMassages()
    println(real.toString())
}
