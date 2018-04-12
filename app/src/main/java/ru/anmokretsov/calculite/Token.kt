package ru.anmokretsov.calculite

class Token(var value: String, var type: Type) {


    enum class Type {
        OPERATOR, FUNCTION, NUMBER, PARENTHESES, CONSTANT
    }
}