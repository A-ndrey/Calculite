package ru.anmokretsov.calculite

import ru.anmokretsov.calculite.common.BasePresenter
import ru.anmokretsov.calculite.common.BaseView

class MainPresenter(view: BaseView) : BasePresenter(view) {

    private val calculatorModel = CalculatorModel()

    override fun doOperation(operation: String) {
        calculatorModel.addElement(operation)
        updateDisplay()
        if (operation == NamesHelper.EQUAL) view.setResult(calculatorModel.result)
    }

    override fun deleteLastOperation(){
        calculatorModel.deleteLastToken()
        updateDisplay()
    }

    override fun clearAll() : Boolean{
        calculatorModel.clear()
        updateDisplay()
        return true
    }

    private fun updateDisplay(){
        view.setExpression(calculatorModel.expression)
        //view.setResult(calculatorModel.result)
    }

}