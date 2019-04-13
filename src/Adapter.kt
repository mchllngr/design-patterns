/* Description
 *
 * The adapter pattern is used to provide a
 * link between two otherwise incompatible
 * types by wrapping the "adaptee" with a
 * class that supports the interface
 * required by the client.
 */

/* ITarget */
interface Movable {
    fun move()
}

class Person : Movable {

    override fun move() {
        println("Person moving forward")
    }
}

/* Adaptee */
class Car {

    fun drive() {
        println("Car driving forward")
    }
}

/* Adapter */
class CarAdapter(private val car: Car) : Movable {

    override fun move() {
        car.drive()
    }
}

/* Usage */
fun main() {
    val person = Person()
    val car = Car()

    person.move()
    car.drive()

    val carAdapter = CarAdapter(car)

    carAdapter.move()
}

/* Output
 *
 * Person moving forward
 * Car driving forward
 * Car driving forward
 */
