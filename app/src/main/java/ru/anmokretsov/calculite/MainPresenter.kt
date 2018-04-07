package ru.anmokretsov.calculite

import ru.anmokretsov.calculite.common.BasePresenter
import ru.anmokretsov.calculite.common.BaseView

class MainPresenter(view: BaseView) : BasePresenter(view) {

    override fun doOperation(operation: String) {
        view.setExpression(operation)
    }

    override fun deleteLastOperation(){
        view.setExpression("")
    }

}