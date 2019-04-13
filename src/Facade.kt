/* Description
 *
 * The facade pattern is used to define a
 * simplified interface to a more complex subsystem.
 */

/* Subsystem classes */
data class User(val name: String)

class ComplexSystemStore(private val filePath: String) {

    private val cache: HashMap<String, String> = HashMap()

    init {
        println("Reading data from '$filePath'")
    }

    fun store(key: String, value: String) {
        cache[key] = value
    }

    fun read(key: String) = cache[key] ?: ""

    fun commit() = println("Storing data $cache in '$filePath'")
}

/* Facade */
class UserRepository {

    private val systemStore = ComplexSystemStore("/data/users.txt")

    fun save(user: User) {
        systemStore.store("KEY_USER", user.name)
        systemStore.commit()
    }

    fun findFirst() = User(systemStore.read("KEY_USER"))
}

/* Usage */
fun main() {
    val userRepository = UserRepository()
    userRepository.save(User("John"))
    println("First User: ${userRepository.findFirst()}")
}

/* Output
 *
 * Reading data from '/data/users.txt'
 * Storing data {KEY_USER=John} in '/data/users.txt'
 * First User: User(name=John)
 */
