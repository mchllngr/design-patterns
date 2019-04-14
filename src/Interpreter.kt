/* Description
 *
 * The interpreter pattern is used to
 * define the grammar for instructions
 * that form part of a language or
 * notation, whilst allowing the
 * grammar to be easily extended.
 */

/* Context */
class IntegerContext(private var data: MutableMap<Char, Int> = mutableMapOf()) {

    fun lookup(name: Char) = data[name]!!

    fun assign(expression: IntegerVariableExpression, value: Int) {
        data[expression.name] = value
    }
}

/* AbstractExpression */
interface IntegerExpression {

    fun evaluate(context: IntegerContext): Int
}

/* TerminalExpression */
class IntegerVariableExpression(val name: Char) : IntegerExpression {

    override fun evaluate(context: IntegerContext) = context.lookup(name)
}

/* NonterminalExpressionA */
class AddExpression(private var operand1: IntegerExpression, private var operand2: IntegerExpression) : IntegerExpression {

    override fun evaluate(context: IntegerContext) = operand1.evaluate(context) + operand2.evaluate(context)
}

/* NonterminalExpressionB */
class SubstractExpression(private var operand1: IntegerExpression, private var operand2: IntegerExpression) : IntegerExpression {

    override fun evaluate(context: IntegerContext) = operand1.evaluate(context) - operand2.evaluate(context)
}

/* Kotlin Syntax Sugar - see 'expressionKt' below */
operator fun IntegerExpression.plus(other: IntegerExpression) = AddExpression(this, other)
operator fun IntegerExpression.minus(other: IntegerExpression) = SubstractExpression(this, other)

/* Usage */
fun main() {
    val context = IntegerContext()

    val a = IntegerVariableExpression('a')
    val b = IntegerVariableExpression('b')
    val c = IntegerVariableExpression('c')

    context.assign(a, 15)
    context.assign(b, 5)
    context.assign(c, 10)

    // a + (b - c)
    val expression = AddExpression(a, SubstractExpression(b, c))
    val expressionKt = a + (b - c)

    println("Expression: ${expression.evaluate(context)}")
    println("ExpressionKt: ${expressionKt.evaluate(context)}")
}

/* Output
 *
 * Expression: 10
 * ExpressionKt: 10
 */
