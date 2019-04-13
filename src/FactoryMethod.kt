/* Description
 *
 * The factory pattern is used to replace
 * class constructors, abstracting the
 * process of object generation so that
 * the type of the object instantiated
 * can be determined at run-time.
 */

enum class Country { GERMANY, SPAIN, USA }

/* ProductBase */
interface Currency {
    companion object {

        /* Factory Method */
        fun fromCountry(country: Country) = when (country) {
            Country.GERMANY, Country.SPAIN -> Euro()
            Country.USA -> Dollar()
        }
    }
}

/* ConcreteProductA */
class Euro : Currency

/* ConcreteProductB */
class Dollar : Currency

/* Usage */
fun main() {
    println("${Country.GERMANY} has the currency ${Currency.fromCountry(Country.GERMANY)}")
    println("${Country.SPAIN} has the currency ${Currency.fromCountry(Country.SPAIN)}")
    println("${Country.USA} has the currency ${Currency.fromCountry(Country.USA)}")
}

/* Output
 *
 * GERMANY has the currency Euro@5e481248
 * SPAIN has the currency Euro@66d3c617
 * USA has the currency Dollar@63947c6b
 */
