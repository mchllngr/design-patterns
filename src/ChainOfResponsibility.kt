/* Description
 *
 * The chain of responsibility pattern is used
 * to process varied requests, each of which
 * may be dealt with by a different handler.
 */

/* Handler */
interface RequestChain {

    var successor: RequestChain?

    fun process(input: String): String
}

/* ConcreteHandlerA */
class BodyHandler(private val body: String, override var successor: RequestChain? = null) : RequestChain {

    override fun process(input: String) = "$input\nBody: $body".let { successor?.process(it) ?: it }
}

/* ConcreteHandlerB */
class ContentTypeHandler(private val contentType: String, override var successor: RequestChain? = null) : RequestChain {

    override fun process(input: String) = "$input\nContentType: $contentType".let { successor?.process(it) ?: it }
}

/* ConcreteHandlerC */
class AuthorizationHandler(private val authorization: String, override var successor: RequestChain? = null) : RequestChain {

    override fun process(input: String) = "$input\nAuthorization: $authorization".let { successor?.process(it) ?: it }
}

/* Usage */
fun main() {
    val bodyHandler = BodyHandler("{key:\"value\"}")
    val contentTypeHandler = ContentTypeHandler("application/json")
    val authorizationHandler = AuthorizationHandler("some_authorization_token")

    authorizationHandler.successor = contentTypeHandler
    contentTypeHandler.successor = bodyHandler

    println(authorizationHandler.process("Chain with Authorization:"))
    println(contentTypeHandler.process("Chain without Authorization:"))
}

/* Output
 *
 * Chain with Authorization:
 * Authorization: some_authorization_token
 * ContentType: application/json
 * Body: {key:"value"}
 * Chain without Authorization:
 * ContentType: application/json
 * Body: {key:"value"}
 */
