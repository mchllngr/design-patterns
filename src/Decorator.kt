/* Description
 *
 * The decorator pattern is used to extend
 * or alter the functionality of objects at
 * run-time by wrapping them in an object
 * of a decorator class. This provides a
 * flexible alternative to using inheritance
 * to modify behaviour.
 */

/* Component */
interface Text {
    fun get(): String
}

/* ConcreteComponent */
class DefaultText(private val string: String) : Text {

    override fun get() = string
}

/* ConcreteDecorators4 */
class UnderlineText(private val text: Text) : Text {

    override fun get() = "<u>${text.get()}</u>"
}

class BoldText(private val text: Text) : Text {

    override fun get() = "<b>${text.get()}</b>"
}

/* Usage */
fun main() {
    val defaultText = DefaultText("default")
    println(defaultText.get())
    val underlineText = UnderlineText(defaultText)
    println(underlineText.get())
    val boldText = BoldText(defaultText)
    println(boldText.get())
    val boldUnderlineText = BoldText(underlineText)
    println(boldUnderlineText.get())
}

/* Output
 *
 * default
 * <u>default</u>
 * <b>default</b>
 * <b><u>default</u></b>
 */
