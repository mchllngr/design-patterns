/* Description
 *
 * The mediator pattern is used to reduce
 * coupling between classes that communicate
 * with each other. Instead of classes
 * communicating directly, and thus requiring
 * knowledge of their implementation, the
 * classes send messages via a mediator object.
 */

/* Mediator */
interface ChatMediator {

    fun addUser(user: ChatUser): ChatMediator

    fun sendMessage(user: ChatUser, message: String)
}

/* ConcreteMediator */
class ChatMediatorImpl : ChatMediator {

    private val users = mutableListOf<ChatUser>()

    override fun addUser(user: ChatUser) = apply {
        users.add(user)
    }

    override fun sendMessage(user: ChatUser, message: String) {
        users.filter { it != user }
            .forEach { it.receive(message) }
    }
}

/* AbstractColleague */
interface Colleague {

    fun send(message: String)

    fun receive(message: String)
}

/* ConcreteColleague */
class ChatUser(private val mediator: ChatMediator, private val name: String) : Colleague {

    override fun send(message: String) {
        println("$name sending message: $message")
        mediator.sendMessage(this, message)
    }

    override fun receive(message: String) {
        println("$name received message: $message")
    }
}

/* Usage */
fun main() {
    val chatMediator = ChatMediatorImpl()
    val mike = ChatUser(chatMediator, "Mike")

    chatMediator
        .addUser(mike)
        .addUser(ChatUser(chatMediator, "John"))
        .addUser(ChatUser(chatMediator, "Alice"))

    mike.send("Hello, World!")
}

/* Output
 *
 * Mike sending message: Hello, World!
 * John received message: Hello, World!
 * Alice received message: Hello, World!
 */
