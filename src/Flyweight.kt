/* Description
 *
 * The flyweight pattern is used to reduce
 * the memory and resource usage for complex
 * models containing many hundreds, thousands
 * or hundreds of thousands of similar objects.
 */

/* Flyweight */
interface BankNote {
    val value: Int
}

/* ConcreteFlyweight */
class BankNoteImpl(override val value: Int) : BankNote {

    init {
        println("Creating BankNote with value $value")
    }
}

/* FlyweightFactory */
class BankNoteFactory {

    private val bankNotes = HashMap<Int, BankNote>()

    fun getBankNote(value: Int): BankNote {
        val bankNote = bankNotes[value]
        if (bankNote != null) return bankNote
        return BankNoteImpl(value).apply { bankNotes[value] = this }
    }
}

/* Usage */
fun main() {
    val bankNoteFactory = BankNoteFactory()
    println("bankNote 5: ${bankNoteFactory.getBankNote(5)}")
    println("bankNote 10: ${bankNoteFactory.getBankNote(10)}")
    println("bankNote 5: ${bankNoteFactory.getBankNote(5)}")
    println("bankNote 20: ${bankNoteFactory.getBankNote(20)}")
    println("bankNote 10: ${bankNoteFactory.getBankNote(10)}")
}

/* Output
 *
 * Creating BankNote with value 5
 * bankNote 5: BankNoteImpl@7ea987ac
 * Creating BankNote with value 10
 * bankNote 10: BankNoteImpl@12a3a380
 * bankNote 5: BankNoteImpl@7ea987ac
 * Creating BankNote with value 20
 * bankNote 20: BankNoteImpl@29453f44
 * bankNote 10: BankNoteImpl@12a3a380
 */
