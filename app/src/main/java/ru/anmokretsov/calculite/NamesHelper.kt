package ru.anmokretsov.calculite

object NamesHelper {

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
    const val OP_SQRT = "√"
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
            L_PAREN, R_PAREN, OP_POW, OP_SQRT,
            CONST_E, CONST_PI, OP_FAC, FUN_LN,
            FUN_LOG, FUN_SIN, FUN_COS, FUN_TAN,
            OP_PERC, OP_MOD, FUN_RAD, FUN_DEG)

}
