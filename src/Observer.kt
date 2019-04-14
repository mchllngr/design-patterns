import kotlin.properties.Delegates

/* Description
 *
 * The observer pattern is used to allow
 * an object to publish changes to its state.
 * Other objects subscribe to be immediately
 * notified of any changes.
 */

/* ConcreteObserver */
typealias Observer = (String) -> Unit

/* ConcreteSubject */
class Subject {

    private val observerList = mutableListOf<Observer>()

    var value by Delegates.observable("empty") { _, old, new ->
        println("old value is '$old'")
        observerList.forEach { it(new) }
    }

    fun addObserver(observer: Observer) {
        observerList.add(observer)
    }
}

/* Usage */
fun main() {
    val subject = Subject()
    subject.addObserver { new -> println("new value is '$new'") }

    subject.value = "value 1"
    subject.value = "value 2"
}

/* Output
 *
 * old value is 'empty'
 * new value is 'value 1'
 * old value is 'value 1'
 * new value is 'value 2'
 */
