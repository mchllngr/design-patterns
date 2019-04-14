/* Description
 *
 * The template method pattern is used
 * to define the basic steps of an
 * algorithm and allow the implementation
 * of the individual steps to be changed.
 */

import java.lang.Thread.sleep
import kotlin.system.measureTimeMillis

typealias Algorithm = () -> Unit

fun executeWithTimeLogging(algorithm: Algorithm) {
    val measureTimeMillis = measureTimeMillis(algorithm)
    println("Executed in $measureTimeMillis ms")
}

/* Usage */
fun main() {
    executeWithTimeLogging {
        println("Some algorithm")
        sleep(1000)
    }
}

/* Output
 *
 * Some algorithm
 * Executed in 1000 ms
 */
