package ru.anmokretsov.calculite.utils

import android.util.Log
import ru.anmokretsov.calculite.NamesHelper
import ru.anmokretsov.calculite.NamesHelper.OP_DIV
import ru.anmokretsov.calculite.tokens.Function
import ru.anmokretsov.calculite.tokens.Number
import ru.anmokretsov.calculite.tokens.Operator
import ru.anmokretsov.calculite.tokens.Parentheses
import ru.anmokretsov.calculite.tokens.Token
import java.util.*

fun List<Token>.toExpression() : String{
    if (this.none()) return ""
    val builder = StringBuilder()
    for (token in this){
        builder.append(token)
    }
    return builder.toString()
}

fun MutableList<Token>.calculate() : Double?{
    if (this.none()) return null

    return .0
}

fun MutableList<Token>.toRPN() : LinkedList<Token>{

    val stackOperations = LinkedList<Token>()
    val outQueue = LinkedList<Token>()

    for (token in this){
        when(token){
            is Number -> outQueue += token
            is Function -> stackOperations += token
            is Operator -> {
                while (stackOperations.peek() is Operator && stackOperations.peek() as Operator >= token) {
                    outQueue += stackOperations.pop()
                }
                stackOperations += token
            }
            is Parentheses ->
                if ((token).isLeft) stackOperations += token
                else {
                    while (stackOperations.peek() is Operator) {
                        outQueue += stackOperations.pop()
                    }
                    if (stackOperations.peek() is Parentheses) stackOperations.pop()
                    else if (stackOperations.peek() is Function) outQueue += stackOperations.pop()
                    else {//TODO expected left parentheses, but was null
                    }
                }
        }
    }

    while (!stackOperations.none()){
        if(stackOperations.peek() is Parentheses){} //TODO was left parentheses
        else outQueue += stackOperations.pop()
    }

    return outQueue
}

fun MutableList<Token>.tokenize(name: String) {

    when (name) {
        NamesHelper.L_PAREN -> this += Parentheses(name, true)
        NamesHelper.R_PAREN -> this += Parentheses(name, false)

        in NamesHelper.NUMBERS, NamesHelper.DIVIDER -> if (!this.isEmpty() && this.last() is Number && !(this.last() as Number).isConst)
            this.last().value += name else this += Number(name)

        NamesHelper.OP_FAC, NamesHelper.OP_PERC -> this += Operator(name, 5)
        NamesHelper.OP_SQRT, NamesHelper.OP_POW -> this += Operator(name, 4)
        NamesHelper.OP_DIV, NamesHelper.OP_MUL -> this += Operator(name, 3)
        NamesHelper.OP_MOD -> this += Operator(name, 2)
        NamesHelper.OP_SUB, NamesHelper.OP_ADD -> this += Operator(name, 1)

        NamesHelper.CONST_E, NamesHelper.CONST_PI -> this += Number(name, true)

        NamesHelper.FUN_COS, NamesHelper.FUN_DEG, NamesHelper.FUN_LN, NamesHelper.FUN_LOG,
        NamesHelper.FUN_RAD, NamesHelper.FUN_SIN, NamesHelper.FUN_TAN -> this += Function(name)
    }
}