package ru.anmokretsov.calculite

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    val dataForMainPad = arrayOf("1", "2", "3", "÷", "4", "5", "6", "×", "7", "8", "9", "-", ",", "0", "=", "+")
    val dataForExtendedPad = arrayOf("(", ")", "^", "√", "e", "π", "!", "ln", "log", "sin", "cos", "tan", "%", "mod", "rad", "deg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        BottomSheetBehavior.from(main_pad_recycler).state = BottomSheetBehavior.STATE_EXPANDED

        main_pad_recycler.setHasFixedSize(true)
        main_pad_recycler.layoutManager = GridLayoutManager(this, 4)
        main_pad_recycler.adapter = PadAdapter(dataForMainPad)

        extended_pad_recycler.setHasFixedSize(true)
        extended_pad_recycler.layoutManager = GridLayoutManager(this, 4)
        extended_pad_recycler.adapter = PadAdapter(dataForExtendedPad)
    }

}
