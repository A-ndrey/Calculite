package ru.anmokretsov.calculite

data class Token(var value: String, var type: Type) {

    enum class Type {
        OPERATOR, FUNCTION, NUMBER, PARENTHESES, CONSTANT
    }
}