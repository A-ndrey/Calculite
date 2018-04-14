package ru.anmokretsov.calculite

import android.provider.SyncStateContract.Helpers.update
import ru.anmokretsov.calculite.tokens.Number
import ru.anmokretsov.calculite.tokens.Token
import ru.anmokretsov.calculite.utils.calculate
import ru.anmokretsov.calculite.utils.deleteLast
import ru.anmokretsov.calculite.utils.toExpression
import ru.anmokretsov.calculite.utils.tokenize

class CalculatorModel {

    var result: String = ""
        get() {
            try {
                return tokens.calculate()?.toString() ?: ""
            } catch (e: Exception){
                e.printStackTrace()
                return "Error!"
            }
        }
    var expression: String = ""
        get() = tokens.toExpression()

    private var tokens: MutableList<Token> = ArrayList()

    fun addElement(element: String){
        tokens.tokenize(element)
    }

    fun deleteLastToken(){
        tokens.deleteLast()
     }

    fun clear(){
        tokens = ArrayList()
    }
}