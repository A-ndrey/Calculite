package ru.anmokretsov.calculite
import java.lang.Math

const val OP_DIV = '÷'
const val OP_MUL = '×'
const val FUN_SQRT = '√'
const val CONST_PI = 'π'
const val DIVIDER = '.'

val dataForMainPad = arrayOf("1", "2", "3", OP_DIV.toString(), "4", "5", "6", OP_MUL.toString(), "7", "8", "9", "-", DIVIDER.toString(), "0", "=", "+")
val dataForExtendedPad = arrayOf("(", ")", "^", FUN_SQRT.toString(), "e", CONST_PI.toString(), "!", "ln", "log", "sin", "cos", "tan", "%", "mod", "rad", "deg")

fun tokenize(expression: String) : List<Token>{

    var tokens: List<Token> = ArrayList()

    for (char in expression){
        when(char){
            '(', ')' -> tokens += Token(char.toString(), Token.Type.PARENTHESES)
            in '0'..'9', DIVIDER -> if (tokens.last().type == Token.Type.NUMBER) tokens.last().value += char else tokens += Token(char.toString(), Token.Type.NUMBER)
            OP_DIV, OP_MUL, '-', '+', '^', '!', '%' -> tokens += Token(char.toString(), Token.Type.OPERATOR)
            'e' -> tokens += Token(Math.E.toString(), Token.Type.CONSTANT)
            CONST_PI -> tokens += Token(Math.PI.toString(), Token.Type.CONSTANT)
            in 'a'..'z', FUN_SQRT -> if (tokens.last().type == Token.Type.FUNCTION) tokens.last().value += char else tokens += Token(char.toString(), Token.Type.FUNCTION)
            ' ' -> if(tokens.last().type == Token.Type.FUNCTION) tokens.last().type = Token.Type.OPERATOR else tokens += Token("", Token.Type.FUNCTION)
        }
    }

    return tokens
}