/* Description
 *
 * The iterator pattern is used to provide
 * a standard interface for traversing a
 * collection of items in an aggregate
 * object without the need to understand
 * its underlying structure.
 */

typealias Word = String

class Sentence(vararg val words: Word)

operator fun Sentence.iterator() = words.iterator()

/* Usage */
fun main() {
    val sentence = Sentence("I", "am", "a", "sentence")

    for (word in sentence) {
        println("Word: $word")
    }
}

/* Output
 *
 * Word: I
 * Word: am
 * Word: a
 * Word: sentence
 */
