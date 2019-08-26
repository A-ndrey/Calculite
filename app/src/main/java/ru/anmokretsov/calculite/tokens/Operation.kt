package ru.anmokretsov.calculite.tokens

import java.util.*

abstract class Operation(value: String,val exec: (LinkedList<Number>) -> Unit ) : Token(value) {

}