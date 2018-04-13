package ru.anmokretsov.calculite.tokens

class Function(value: String) : Token(value) {

    override fun toString(): String  = "$value("
}