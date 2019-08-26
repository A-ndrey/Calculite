package ru.anmokretsov.calculite.tokens

import java.util.*

class Operator(value: String, var priorityWeight: Int, exec: (LinkedList<Number>) -> Unit) : Operation(value, exec) {

    operator fun compareTo(other: Operator) = this.priorityWeight.compareTo(other.priorityWeight)
}