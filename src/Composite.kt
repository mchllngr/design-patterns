/* Description
 *
 * The composite pattern is used to create hierarchical,
 * recursive tree structures of related objects where
 * any element of the structure may be accessed and
 * utilised in a standard manner.
 */

/* Component */
abstract class Part {
    abstract val name: String
    abstract val price: Int
}

/* Leafs */
class Motherboard : Part() {
    override val name = "Motherboard"
    override val price = 100
}

class CPU : Part() {
    override val name = "CPU"
    override val price = 200
}

class HardDrive : Part() {
    override val name = "HardDrive"
    override val price = 50
}

/* Composite */
open class Computer : Part() {

    private val parts = mutableListOf<Part>()

    override val name: String
        get() = "Computer"
    override val price: Int
        get() = parts.map { it.price }.sum()

    fun add(part: Part) {
        parts.add(part)
    }

    fun remove(part: Part) {
        parts.remove(part)
    }
}

/* Usage */
fun main() {
    val computer = Computer()
    computer.add(Motherboard())
    computer.add(CPU())
    val hardDrive = HardDrive()
    computer.add(hardDrive)

    println("name: ${computer.name}, price: ${computer.price}")

    computer.remove(hardDrive)

    println("name: ${computer.name}, price: ${computer.price}")
}

/* Output
 *
 * name: Computer, price: 350
 * name: Computer, price: 300
 */
