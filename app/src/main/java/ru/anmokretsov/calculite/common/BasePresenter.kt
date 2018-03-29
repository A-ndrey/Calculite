package ru.anmokretsov.calculite.common

/**
 * Created by Андрей on 25.03.2018.
 */
abstract class BasePresenter(val view: BaseView) {

    init {
        view.presenter = this
    }

    abstract fun start()

}