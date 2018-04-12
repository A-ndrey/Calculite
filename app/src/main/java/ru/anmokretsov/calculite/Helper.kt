package ru.anmokretsov.calculite

import ru.anmokretsov.calculite.Helper.CONST_PI
import ru.anmokretsov.calculite.Helper.DIVIDER
import ru.anmokretsov.calculite.Helper.FUN_SQRT
import ru.anmokretsov.calculite.Helper.OP_DIV
import ru.anmokretsov.calculite.Helper.OP_MUL
import java.lang.Math

object Helper {

    val NUMBERS = Array(10, { it.toString() })
    const val L_PAREN = "("
    const val R_PAREN = ")"
    const val OP_DIV = "÷"
    const val OP_MUL = "×"
    const val OP_SUB = "-"
    const val OP_ADD = "+"
    const val OP_POW = "^"
    const val OP_FAC = "!"
    const val OP_PERC = "%"
    const val OP_MOD = "mod"
    const val FUN_SQRT = "√"
    const val FUN_LN = "ln"
    const val FUN_LOG = "log"
    const val FUN_SIN = "sin"
    const val FUN_COS = "cos"
    const val FUN_TAN = "tan"
    const val FUN_RAD = "rad"
    const val FUN_DEG = "deg"
    const val CONST_PI = "π"
    const val CONST_E = "e"
    const val DIVIDER = "."
    const val EQUAL = "="

    val dataForMainPad = arrayOf(
            NUMBERS[1], NUMBERS[2], NUMBERS[3], OP_DIV,
            NUMBERS[4], NUMBERS[5], NUMBERS[6], OP_MUL,
            NUMBERS[7], NUMBERS[8], NUMBERS[9], OP_SUB,
            DIVIDER, NUMBERS[0], EQUAL, OP_ADD)

    val dataForExtendedPad = arrayOf(
            L_PAREN, R_PAREN, OP_POW, FUN_SQRT,
            CONST_E, CONST_PI, OP_FAC, FUN_LN,
            FUN_LOG, FUN_SIN, FUN_COS, FUN_TAN,
            OP_PERC, OP_MOD, FUN_RAD, FUN_DEG)

    fun tokenize(token: String): List<Token> {

        var tokens: List<Token> = ArrayList()

        when (token) {
            L_PAREN, R_PAREN -> tokens += Token(token, Token.Type.PARENTHESES)
            in NUMBERS, DIVIDER -> if (tokens.last().type == Token.Type.NUMBER) tokens.last().value += token else tokens += Token(token, Token.Type.NUMBER)
            OP_DIV, OP_MUL, OP_SUB, OP_ADD, OP_POW, OP_FAC, OP_PERC, OP_MOD -> tokens += Token(token, Token.Type.OPERATOR)
            CONST_E -> tokens += Token(Math.E.toString(), Token.Type.CONSTANT)
            CONST_PI -> tokens += Token(Math.PI.toString(), Token.Type.CONSTANT)
            FUN_COS, FUN_DEG, FUN_LN, FUN_LOG, FUN_RAD, FUN_SIN, FUN_TAN, FUN_SQRT -> tokens += Token(token, Token.Type.FUNCTION)
        }

        return tokens
    }

}
