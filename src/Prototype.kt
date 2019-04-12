/* Description
 *
 * The prototype pattern is used to instantiate
 * a new object by copying all of the properties
 * of an existing object, creating an independent
 * clone. This practise is particularly useful
 * when the construction of a new object is inefficient.
 */

data class Message(val recipient: String, val message: String)

/* Usage */
fun main() {
    val message = Message("John", "Have you heard about this thing?")
    val messageCopy = message.copy(recipient = "Maria")

    println("message goes to ${message.recipient} with the message '${message.message}'")
    println("messageCopy goes to ${messageCopy.recipient} with the message '${messageCopy.message}'")
}

/* Output
 *
 * message goes to John with the message 'Have you heard about this thing?'
 * messageCopy goes to Maria with the message 'Have you heard about this thing?'
 */
