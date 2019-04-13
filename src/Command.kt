/* Description
 *
 * The command pattern is used to express a request, including
 * the call to be made and all of its required parameters,
 * in a command object. The command may then be executed
 * immediately or held for later use.
 */

/* Command */
interface OrderCommand {
    fun execute()
}

/* ConcreteCommandA */
class AddOrderCommand(val id: Long) : OrderCommand {

    override fun execute() {
        println("Adding order '$id'")
    }
}

/* ConcreteCommandB */
class PayOrderCommand(val id: Long) : OrderCommand {

    override fun execute() {
        println("Paying order '$id'")
    }
}

/* Invoker */
class OrderCommandInvoker {

    private val queue = arrayListOf<OrderCommand>()

    fun addToQueue(orderCommand: OrderCommand) = apply {
        queue.add(orderCommand)
    }

    fun executeQueue() = apply {
        queue.forEach { it.execute() }
        queue.clear()
    }
}

/* Usage */
fun main() {
    OrderCommandInvoker()
        .addToQueue(AddOrderCommand(1L))
        .addToQueue(AddOrderCommand(2L))
        .addToQueue(PayOrderCommand(2L))
        .addToQueue(PayOrderCommand(1L))
        .executeQueue()
}

/* Output
 *
 * Adding order '1'
 * Adding order '2'
 * Paying order '2'
 * Paying order '1'
 */
