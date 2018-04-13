package ru.anmokretsov.calculite.tokens

class Operator(value: String, var priorityWeight: Int) : Token(value) {

    operator fun compareTo(other: Operator) = this.priorityWeight.compareTo(other.priorityWeight)
}