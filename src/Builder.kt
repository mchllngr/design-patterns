/* Description
 *
 * The builder pattern is used to
 * create complex objects with
 * constituent parts that must be
 * created in the same order or
 * using a specific algorithm.
 * An external class controls
 * the construction algorithm.
 */

/* Product */
class Dialog(
    private val title: String,
    private val message: String
) {

    fun show() {
        println("Showing dialog '$title: $message'")
    }
}

/* Builder / ConcreteBuilder */
class DialogBuilder {

    var title: String = "no title"
    var message: String = "no message"

    fun build() = Dialog(title, message)
}

fun dialog(init: DialogBuilder.() -> Unit) = DialogBuilder().apply(init).build()

/* Usage */
fun main() {
    dialog {
        title = "For John"
        message = "with a message"
    }.show()

    dialog {
        title = "For Mike"
    }.show()
}

/* Output
 *
 * Showing dialog 'For John: with a message'
 * Showing dialog 'For Mike: no message'
 */
