package ru.anmokretsov.calculite.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayout
import android.view.View
import ru.anmokretsov.calculite.BasePresenter
import ru.anmokretsov.calculite.R
import ru.anmokretsov.calculite.calculator.fragments.DisplayFragment
import ru.anmokretsov.calculite.calculator.fragments.ExtendedPadFragment
import ru.anmokretsov.calculite.calculator.fragments.MainPadFragment
import ru.anmokretsov.calculite.calculator.presenters.DisplayPresenter
import ru.anmokretsov.calculite.calculator.presenters.ExtendedPadPresenter
import ru.anmokretsov.calculite.calculator.presenters.MainPadPresenter

class CalculatorActivity : AppCompatActivity() {

    private lateinit var displayPresenter: BasePresenter
    private lateinit var extPadPresenter: BasePresenter
    private lateinit var mainPadPresenter: BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val displayFragment = supportFragmentManager.findFragmentById(R.id.display_frame)
                as DisplayFragment? ?: DisplayFragment().also {
                    supportFragmentManager.beginTransaction().replace(R.id.display_frame, it).commit();
        }

        val extendedPadFragment = supportFragmentManager.findFragmentById(R.id.extended_pad_frame)
                as ExtendedPadFragment? ?: ExtendedPadFragment().also {
                    supportFragmentManager.beginTransaction().replace(R.id.extended_pad_frame, it).commit();
        }

        val mainPadFragment = supportFragmentManager.findFragmentById(R.id.main_pad_frame)
                as MainPadFragment? ?: MainPadFragment().also {
                    supportFragmentManager.beginTransaction().replace(R.id.main_pad_frame, it).commit()
        }

        displayPresenter = DisplayPresenter(displayFragment)
        extPadPresenter = ExtendedPadPresenter(extendedPadFragment)
        mainPadPresenter = MainPadPresenter(mainPadFragment)
    }

    fun clickButton(view: View){
        when((view.parent as GridLayout).id){
            R.id.main_pad -> (mainPadPresenter.view as MainPadFragment).onClick(view)
            R.id.extended_pad -> (extPadPresenter.view as ExtendedPadFragment).onClick(view)
        }
    }
}
