package ru.anmokretsov.calculite.utils

fun factorial(value: Double) : Double{
    val int: Int = value.toInt()
    if (int.toDouble() == value) return factorial(int).toDouble()
    return Math.exp(Math.log(factorial(int).toDouble()) + (value - int)*Math.log(int.toDouble()+1) )
}

fun factorial(value: Int) : Int{
    var prod = 1
    for (i in 2..value) prod *= i
    return prod
}