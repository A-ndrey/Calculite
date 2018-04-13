package ru.anmokretsov.calculite

import ru.anmokretsov.calculite.common.BasePresenter
import ru.anmokretsov.calculite.common.BaseView

class MainPresenter(view: BaseView) : BasePresenter(view) {

    private val calculatorModel = CalculatorModel()

    override fun doOperation(operation: String) {
        calculatorModel.addElement(operation)
        updateDispaly()
    }

    override fun deleteLastOperation(){
        calculatorModel.deleteLastToken()
        updateDispaly()
    }

    override fun clearAll() : Boolean{
        calculatorModel.clear()
        updateDispaly()
        return true
    }

    private fun updateDispaly(){
        view.setExpression(calculatorModel.expression)
        view.setResult(calculatorModel.result)
    }

}