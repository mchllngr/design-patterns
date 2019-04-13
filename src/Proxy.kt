/* Description
 *
 * The proxy pattern is used to provide a surrogate
 * or placeholder object, which references an
 * underlying object. The proxy provides the same
 * public interface as the underlying subject class,
 * adding a level of indirection by accepting requests
 * from a client object and passing these to the real
 * subject object as necessary.
 */

/* Subject */
interface ExpensiveObject {
    fun process()
}

/* RealSubject */
class ExpensiveObjectImpl : ExpensiveObject {

    init {
        println("Created ExpensiveObjectImpl")
    }

    override fun process() {
        println("Finished processing")
    }
}

/* Proxy */
class ExpensiveObjectProxy : ExpensiveObject {

    private val expensiveObject by lazy { ExpensiveObjectImpl() }

    override fun process() {
        expensiveObject.process()
    }
}

/* Usage */
fun main() {
    val expensiveObjectProxy = ExpensiveObjectProxy()
    expensiveObjectProxy.process()
    expensiveObjectProxy.process()
}

/* Output
 *
 * Created ExpensiveObjectImpl
 * Finished processing
 * Finished processing
 */
