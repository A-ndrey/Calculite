package ru.anmokretsov.calculite

import ru.anmokretsov.calculite.tokens.Number
import ru.anmokretsov.calculite.tokens.Token
import ru.anmokretsov.calculite.utils.calculate
import ru.anmokretsov.calculite.utils.toExpression
import ru.anmokretsov.calculite.utils.tokenize

class CalculatorModel {

    var result: String = ""
    var expression: String = ""

    private var tokens: MutableList<Token> = ArrayList()

    fun addElement(element: String){
        tokens.tokenize(element)
        update()
    }

    fun deleteLastToken(){
        if (tokens.isEmpty()) return
        if(tokens.last() is Number && tokens.last().value.length > 1)
            tokens.last().value = tokens.last().value.dropLast(1)
        else tokens.dropLast(1)

        update()
     }

    fun clear(){
        tokens = ArrayList()
        update()
    }



    private fun update(){
        expression = tokens.toExpression()
        result = tokens.calculate()?.toString() ?: ""
    }
}