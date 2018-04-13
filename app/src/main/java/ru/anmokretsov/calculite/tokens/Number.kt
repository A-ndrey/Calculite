package ru.anmokretsov.calculite.tokens

import ru.anmokretsov.calculite.NamesHelper

class Number(value: String, val isConst: Boolean = false) : Token(value) {

    fun toDouble() : Double{
        if (!isConst) return value.toDouble()
        return when(value){
            NamesHelper.CONST_PI -> Math.PI
            NamesHelper.CONST_E -> Math.E
            else -> .0
        }
    }
}