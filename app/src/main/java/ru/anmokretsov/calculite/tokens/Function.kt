package ru.anmokretsov.calculite.tokens

import java.util.*

class Function(value: String, exec: (LinkedList<Number>) -> Unit) : Operation(value, exec) {

    override fun toString(): String  = "$value("
}