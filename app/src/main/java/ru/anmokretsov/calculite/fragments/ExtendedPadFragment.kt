package ru.anmokretsov.calculite.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.anmokretsov.calculite.common.BasePresenter
import ru.anmokretsov.calculite.common.BaseView
import ru.anmokretsov.calculite.R

class ExtendedPadFragment : Fragment(), BaseView {

    override lateinit var presenter: BasePresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_extended_pad, container, false)
    }

    fun onClick(view: View){
        val button = view as AppCompatButton

    }
}