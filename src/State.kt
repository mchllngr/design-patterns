/* Description
 *
 * The state pattern is used to alter
 * the behaviour of an object as its
 * internal state changes. The pattern
 * allows the class for an object to
 * apparently change at run-time.
 */

/* Context */
class AlarmContext {

    private var state: AlarmState = SoundAlarm

    fun setState(state: AlarmState) {
        this.state = state
    }

    fun alert() {
        state.alert(this)
    }
}

/* State */
sealed class AlarmState {

    abstract fun alert(context: AlarmContext)
}

/* ConcreteStateA */
object SoundAlarm : AlarmState() {

    override fun alert(context: AlarmContext) {
        println("Alerting with sound")
    }
}

/* ConcreteStateB */
object VibrationAlarm : AlarmState() {

    override fun alert(context: AlarmContext) {
        println("Alerting with vibration")
    }
}

/* ConcreteStateC */
object SilentAlarm : AlarmState() {

    override fun alert(context: AlarmContext) {
        println("Alerting silent")
    }
}

/* Usage */
fun main() {
    val context = AlarmContext()
    context.alert()

    context.setState(VibrationAlarm)
    context.alert()

    context.setState(SilentAlarm)
    context.alert()

    context.setState(SoundAlarm)
    context.alert()
}

/* Output
 *
 * Alerting with sound
 * Alerting with vibration
 * Alerting silent
 * Alerting with sound
 */
