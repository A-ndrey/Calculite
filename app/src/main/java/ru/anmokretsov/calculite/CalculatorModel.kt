package ru.anmokretsov.calculite

import android.provider.SyncStateContract.Helpers.update
import android.support.design.widget.Snackbar
import android.util.Log

class CalculatorModel {

    var result: String = ""
    var expression: String = ""

    private var tokens: List<Token> = ArrayList()

    fun addElement(element: String){
        tokenize(element)

        update()
    }

    fun deleteLastToken(){
        if (tokens.isEmpty()) return
        if(tokens.last().type == Token.Type.NUMBER && tokens.last().value.length > 1)
            tokens.last().value = tokens.last().value.dropLast(1)
        else tokens = tokens.dropLast(1)

        update()
     }

    fun clear(){
        tokens = ArrayList()

        update()
    }

    private fun tokenize(name: String) {

        when (name) {
            Helper.L_PAREN, Helper.R_PAREN -> tokens += Token(name, Token.Type.PARENTHESES)

            in Helper.NUMBERS, Helper.DIVIDER -> if (!tokens.isEmpty() && tokens.last().type == Token.Type.NUMBER)
                tokens.last().value += name else tokens += Token(name, Token.Type.NUMBER)

            Helper.OP_DIV, Helper.OP_MUL, Helper.OP_SUB, Helper.OP_ADD, Helper.OP_SQRT,
            Helper.OP_POW, Helper.OP_FAC, Helper.OP_PERC, Helper.OP_MOD -> tokens += Token(name, Token.Type.OPERATOR)

            Helper.CONST_E, Helper.CONST_PI -> tokens += Token(name, Token.Type.CONSTANT)

            Helper.FUN_COS, Helper.FUN_DEG, Helper.FUN_LN, Helper.FUN_LOG,
            Helper.FUN_RAD, Helper.FUN_SIN, Helper.FUN_TAN -> tokens += Token(name, Token.Type.FUNCTION)
        }
    }

    private fun tokensToString() : String{
        val builder = StringBuilder()
        for (token in tokens){
            builder.append(token.value)
            if (token.type == Token.Type.FUNCTION)
                builder.append("(")
        }
        return builder.toString()
    }

    private fun update(){
        expression = tokensToString()
    }
}