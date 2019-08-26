package ru.anmokretsov.calculite.utils

import ru.anmokretsov.calculite.NamesHelper
import ru.anmokretsov.calculite.tokens.*
import ru.anmokretsov.calculite.tokens.Function
import ru.anmokretsov.calculite.tokens.Number
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

    val operationsStack = LinkedList<Token>()
    val numbersStack = LinkedList<Number>()

    for (token in this){
        when(token){
            is Number -> numbersStack.addFirst(token)
            is Function -> operationsStack.addFirst(token)
            is Operator -> {
                while (operationsStack.peek() is Operator && operationsStack.peek() as Operator >= token) {
                    (operationsStack.pop() as Operation).exec(numbersStack)
                }
                operationsStack.push(token)
            }
            is Parentheses ->
                if ((token).isLeft) operationsStack.push(token)
                else {
                    while (operationsStack.peek() is Operator) {
                        (operationsStack.pop() as Operation).exec(numbersStack)
                    }
                    if (operationsStack.peek() is Parentheses) operationsStack.pop()
                    else if (operationsStack.peek() is Function) (operationsStack.pop() as Operation).exec(numbersStack)
                    else {//TODO expected left parentheses, but was null
                    }
                }
        }
    }

    while (!operationsStack.none()){
        if(operationsStack.peek() is Parentheses){} //TODO was left parentheses
        else (operationsStack.pop() as Operation).exec(numbersStack)
    }

    return numbersStack.pop().toDouble()
}


fun MutableList<Token>.deleteLast(){
    if (this.isEmpty()) return
    if(this.last() is Number && !(this.last() as Number).isConst && this.last().value.length > 1)
        this.last().value = this.last().value.dropLast(1)
    else this.removeAt(this.lastIndex)
}

fun MutableList<Token>.tokenize(name: String) {

    when (name) {
        NamesHelper.L_PAREN -> this += Parentheses(name, true)
        NamesHelper.R_PAREN -> this += Parentheses(name, false)

        in NamesHelper.NUMBERS, NamesHelper.DIVIDER -> if (!this.isEmpty() && this.last() is Number && !(this.last() as Number).isConst)
            this.last().value += name else this += Number(name)
        NamesHelper.CONST_E, NamesHelper.CONST_PI -> this += Number(name, true)

        NamesHelper.OP_FAC -> this += Operator(name, 5,
                {
                    it.push(Number(factorial(it.pop().toDouble()).toString()))
                })
        NamesHelper.OP_PERC -> this += Operator(name, 5,
                {
                    it.push(Number((it.pop().toDouble()*it.peek().toDouble()/100).toString()))
                })
        NamesHelper.OP_SQRT -> this += Operator(name, 4,
                {
                    it.push(Number( (Math.sqrt(it.pop().toDouble())).toString()))
                })
        NamesHelper.OP_POW -> this += Operator(name, 4,
                {
                    val num2 = it.pop().toDouble()
                    val num1 = it.pop().toDouble()
                    it.push( Number( Math.pow(num1, num2).toString()))
                })
        NamesHelper.OP_DIV -> this += Operator(name, 3,
                {
                    val num2 = it.pop().toDouble()
                    val num1 = it.pop().toDouble()
                    //TODO check zero division
                    it.push( Number( (num1 / num2).toString()))
                })
        NamesHelper.OP_MUL -> this += Operator(name, 3,
                {
                    it.push(Number( (it.pop().toDouble() * it.pop().toDouble()).toString()))
                })
        NamesHelper.OP_MOD -> this += Operator(name, 2,
                {
                    val num2 = it.pop().toDouble()
                    val num1 = it.pop().toDouble()
                    //TODO check zero division
                    it.push( Number( (num1 % num2).toString()))
                })
        NamesHelper.OP_SUB -> this += Operator(name, 1,
                {
                    val num2 = it.pop().toDouble()
                    val num1 = it.pop().toDouble()
                    it.push( Number( (num1 - num2).toString()))
                })
        NamesHelper.OP_ADD -> this += Operator(name, 1,
                {
                    it.push(Number( (it.pop().toDouble() + it.pop().toDouble()).toString()))
                })


        NamesHelper.FUN_COS -> this += Function(name,
                {
                    it.push(Number(Math.cos(it.pop().toDouble()).toString()))
                })
        NamesHelper.FUN_SIN -> this += Function(name,
                {
                    it.push(Number(Math.sin(it.pop().toDouble()).toString()))
                })
        NamesHelper.FUN_TAN -> this += Function(name,
                {
                    it.push(Number(Math.tan(it.pop().toDouble()).toString()))
                })
        NamesHelper.FUN_LN -> this += Function(name,
                {
                    it.push(Number(Math.log(it.pop().toDouble()).toString()))
                })
        NamesHelper.FUN_LOG -> this += Function(name,
                {
                    it.push(Number(Math.log10(it.pop().toDouble()).toString()))
                })
        NamesHelper.FUN_DEG, NamesHelper.FUN_RAD -> this += Function(name, {})
    }
}