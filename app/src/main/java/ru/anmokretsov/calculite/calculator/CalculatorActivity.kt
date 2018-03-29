package ru.anmokretsov.calculite.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.anmokretsov.calculite.BasePresenter
import ru.anmokretsov.calculite.R

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

        displayPresenter = DisplayPresenter(displayFragment)
    }
}
