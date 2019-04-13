/* Description
 *
 * The abstract factory pattern is used to provide a client with a set
 * of related or dependant objects. The "family" of objects created
 * by the factory are determined at run-time.
 */

/* AbstractProduct */
interface OperationSystem

/* ConcreteProduct */
class Windows : OperationSystem

class Linux : OperationSystem

/* Abstract Factory */
abstract class OperationSystemFactory<T : OperationSystem> {

    companion object {

        inline fun <reified T : OperationSystem> createFactory() = when (T::class) {
            Windows::class -> WindowsFactory()
            Linux::class -> LinuxFactory()
            else -> throw IllegalArgumentException()
        }
    }

    abstract fun create(): T
}

/* Concrete Factories */
class WindowsFactory : OperationSystemFactory<Windows>() {
    override fun create() = Windows()
}

class LinuxFactory : OperationSystemFactory<Linux>() {
    override fun create() = Linux()
}

/* Usage */
fun main() {
    val windowsFactory = OperationSystemFactory.createFactory<Windows>()
    println("Windows: ${windowsFactory.create()}")

    val linuxFactory = OperationSystemFactory.createFactory<Linux>()
    println("Linux: ${linuxFactory.create()}")
}

/* Output
 *
 * Windows: Windows@723279cf
 * Linux: Linux@10f87f48
 */
