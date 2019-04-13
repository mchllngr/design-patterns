/* Description
 *
 * The strategy pattern is used to create
 * an interchangeable family of algorithms
 * from which the required process is chosen
 * at run-time.
 */

/* StrategyBase */
typealias Discount = (Double) -> Double

/* ConcreteStrategy */
val familyDiscount = { raw: Double -> raw / 2 }
val noDiscount = { raw: Double -> raw }

/* Client */
class Customer(val name: String, val rawPrice: Double, val discount: Discount) {

    val price: Double
        get() {
            return discount(rawPrice)
        }
}

/* Usage */
fun main() {
    val john = Customer("John", 10.0, familyDiscount)
    val mike = Customer("Mike", 10.0, noDiscount)

    println("${john.name} pays %.2f".format(john.price))
    println("${mike.name} pays %.2f".format(mike.price))
}

/* Output
 *
 * John pays 5,00
 * Mike pays 10,00
 */
