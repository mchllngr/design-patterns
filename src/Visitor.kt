/* Description
 *
 * The visitor pattern is used to separate a
 * relatively complex set of structured data
 * classes from the functionality that may
 * be performed upon the data that they hold.
 */

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

/* Visitor */
interface Visitor {

    fun visit(water: Water): Double

    fun visit(book: Book): Double

    fun visit(cigarette: Cigarette): Double
}

/* ConcreteVisitor */
class TaxVisitor : Visitor {

    private val format = DecimalFormat("#.##", DecimalFormatSymbols(Locale.ENGLISH))

    private fun format(price: Double) = format.format(price).toDouble()

    override fun visit(water: Water) = format(water.price * 1.18)

    override fun visit(book: Book) = format(book.price * 1.09)

    override fun visit(cigarette: Cigarette) = format(cigarette.price * 1.75)
}

/* Element */
interface Element {
    fun accept(visitor: Visitor): Double
}

/* ConcreteElementA */
class Water(val price: Double) : Element {

    override fun accept(visitor: Visitor) = visitor.visit(this)
}

/* ConcreteElementB */
class Book(val price: Double) : Element {

    override fun accept(visitor: Visitor) = visitor.visit(this)
}

/* ConcreteElementC */
class Cigarette(val price: Double) : Element {

    override fun accept(visitor: Visitor) = visitor.visit(this)
}

/* Usage */
fun main() {
    val taxVisitor = TaxVisitor()

    val water = Water(0.99)
    val book = Book(9.99)
    val cigarette = Cigarette(5.00)

    println("Price water: ${water.accept(taxVisitor)}")
    println("Price book: ${book.accept(taxVisitor)}")
    println("Price cigarette: ${cigarette.accept(taxVisitor)}")
}

/* Output
 *
 * Price water: 1.17
 * Price book: 10.89
 * Price cigarette: 8.75
 */
