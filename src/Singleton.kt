/* Description
 *
 * The singleton pattern ensures that only one
 * object of a particular class is ever created.
 * All further references to objects of the
 * singleton class refer to the same underlying
 * instance.
 */

import java.util.UUID

object SingletonUUID {

    val uuid: UUID = UUID.randomUUID()

    init {
        println("Initializing $this")
    }
}

/* Usage */
fun main() {
    println("UUID: ${SingletonUUID.uuid}")
    println("UUID: ${SingletonUUID.uuid}")
}

/* Output
 *
 * Initializing SingletonUUID@7a81197d
 * UUID: 63b69891-4cbc-4ac3-92bd-b13fd598f901
 * UUID: 63b69891-4cbc-4ac3-92bd-b13fd598f901
 */
