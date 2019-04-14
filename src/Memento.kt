/* Description
 *
 * The memento pattern is used to capture the current
 * state of an object and store it in such a manner
 * that it can be restored at a later time without
 * breaking the rules of encapsulation.
 */

class Originator {

    var data: String? = null

    fun save(): Memento = MementoImpl(data)

    fun restore(memento: Memento) {
        memento as MementoImpl
        data = memento.data
    }

    // This abstraction is used so that outside classes
    // can't see the state inside the Memento
    abstract class Memento

    private data class MementoImpl(val data: String?) : Memento()
}

class CareTaker {

    private val mementoList = mutableListOf<Originator.Memento>()

    fun saveMemento(memento: Originator.Memento) {
        mementoList.add(memento)
    }

    fun restoreMemento(index: Int) = mementoList[index]
}

/* Usage */
fun main() {
    val originator = Originator()
    val careTaker = CareTaker()

    originator.data = "initial state"
    careTaker.saveMemento(originator.save())

    originator.data = "state 2"
    originator.data = "state 3"
    careTaker.saveMemento(originator.save())

    originator.data = "state 4"
    println("Current state: ${originator.data}")

    originator.restore(careTaker.restoreMemento(1))
    println("Current state: ${originator.data}")

    originator.restore(careTaker.restoreMemento(0))
    println("Current state: ${originator.data}")
}

/* Output
 *
 * Current state: state 4
 * Current state: state 3
 * Current state: initial state
 */
