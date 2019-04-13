/* Description
 *
 * The bridge pattern is used to separate the abstract
 * elements of a class from the implementation details,
 * providing the means to replace the implementation
 * details without modifying the abstraction.
 */

/* ImplementationBase */
interface Appliance {
    fun run()
}

/* ConcreteImplementation */
class TV : Appliance {

    override fun run() {
        println("TV turned on")
    }
}

class DvdPlayer : Appliance {

    override fun run() {
        println("DvdPlayer turned on")
    }
}

/* Abstraction */
interface Switch {

    val appliance: Appliance

    fun turnOn()
}

/* RefinedAbstraction */
class RemoteControl(override val appliance: Appliance) : Switch {

    override fun turnOn() {
        appliance.run()
    }
}

/* Usage */
fun main() {
    val tvRemoteControl = RemoteControl(TV())
    tvRemoteControl.turnOn()

    val dvdPlayerRemoteControl = RemoteControl(DvdPlayer())
    dvdPlayerRemoteControl.turnOn()
}

/* Output
 *
 * TV turned on
 * DvdPlayer turned on
 */
