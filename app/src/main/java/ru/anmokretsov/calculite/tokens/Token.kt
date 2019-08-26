package ru.anmokretsov.calculite.tokens

abstract class Token(var value: String) {

    override fun toString(): String = value
}