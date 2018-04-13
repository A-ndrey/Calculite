package ru.anmokretsov.calculite

import ru.anmokretsov.calculite.common.BasePresenter
import ru.anmokretsov.calculite.common.BaseView

class MainPresenter(view: BaseView) : BasePresenter(view) {

    val calculatorModel = CalculatorModel()

    override fun doOperation(operation: String) {
        calculatorModel.addElement(operation) {view.setExpression(it)}
    }

    override fun deleteLastOperation(){
        view.setExpression("")
    }

}