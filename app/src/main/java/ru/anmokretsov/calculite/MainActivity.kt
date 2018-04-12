package ru.anmokretsov.calculite

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.ScrollView
import kotlinx.android.synthetic.main.activity_calculator.*
import ru.anmokretsov.calculite.Helper.dataForExtendedPad
import ru.anmokretsov.calculite.Helper.dataForMainPad
import ru.anmokretsov.calculite.common.BasePresenter
import ru.anmokretsov.calculite.common.BaseView

class MainActivity : AppCompatActivity(), BaseView, PadAdapter.Listener{

    lateinit var presenter: BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        BottomSheetBehavior.from(main_pad_recycler).state = BottomSheetBehavior.STATE_EXPANDED

        main_pad_recycler.setHasFixedSize(true)
        main_pad_recycler.layoutManager = GridLayoutManager(this, 4)
        var padAdapter = PadAdapter(dataForMainPad)
        padAdapter.listener = this
        main_pad_recycler.adapter = padAdapter

        extended_pad_recycler.setHasFixedSize(true)
        extended_pad_recycler.layoutManager = GridLayoutManager(this, 4)
        padAdapter = PadAdapter(dataForExtendedPad)
        padAdapter.listener = this
        extended_pad_recycler.adapter = padAdapter

        delete_button.setOnClickListener{ presenter.deleteLastOperation()}

         presenter = MainPresenter(this)
    }

    override fun onClick(operation: String) {
        presenter.doOperation(operation)
    }

    override fun setResult(result: String) {
        result_text_view.text = result
    }

    override fun setExpression(expression: String) {
        expression_text_view.append(expression)
    }

}
