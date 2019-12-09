package dev.lunarcoffee.orchid.parser.lexer

sealed class OrchidToken(private val repr: String) : Token {
    open class ID(val value: String) : OrchidToken(value)
    class NumberLiteral(val value: Double) : OrchidToken(value.toString())
    class StringLiteral(val value: String) : OrchidToken(value)

    object Colon : OrchidToken(":")
    object Dot : OrchidToken(".")
    object Comma : OrchidToken(",")
    object Equals : OrchidToken("=")
    object Terminator : OrchidToken(";")
    object LBrace : OrchidToken("{")
    object RBrace : OrchidToken("}")
    object LParen : OrchidToken("(")
    object RParen : OrchidToken(")")
    object LBracket : OrchidToken("[")
    object RBracket : OrchidToken("]")
    object LAngle : OrchidToken("<")
    object RAngle : OrchidToken(">")
    object EOF : OrchidToken("<EOF>")

    // [right] determines right-associativity (i.e. exponentiation).
    open class Operator(repr: String, val precedence: Int, val right: Boolean) : OrchidToken(repr)

    object Plus : Operator("+", 6, false)
    object Dash : Operator("-", 6, false)
    object Asterisk : Operator("*", 7, false)
    object Slash : Operator("/", 7, false)
    object Percent : Operator("%", 7, false)
    object DoubleAsterisk : Operator("**", 8, true)
    object Ampersand : Operator("&", 1, false)
    object Caret : Operator("^", 2, false)
    object Pipe : Operator("|", 3, false)
    object DoubleEquals : Operator("==", 4, false)
    object BangEquals : Operator("!=", 4, false)
    object LAngleEquals : Operator("<=", 5, false)
    object RAngleEquals : Operator(">=", 5, false)

    // Exclusively unary operators.
    object Tilde : Operator("~", -1, false)
    object Bang : Operator("!", -1, false)

    object KVar : ID("var")
    object KFunc : ID("func")
    object KReturn : ID("return")
    object KIf : ID("if")
    object KElse : ID("else")
    object KTrue : ID("true")
    object KFalse : ID("false")

    override fun toString() = repr
}
