package ru.anmokretsov.calculite.common

/**
 * Created by Андрей on 25.03.2018.
 */
abstract class BasePresenter(val view: BaseView) {

    abstract fun doOperation(operation: String)

    abstract fun deleteLastOperation()
}