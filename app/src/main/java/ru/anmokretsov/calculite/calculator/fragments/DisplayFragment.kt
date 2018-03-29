package ru.anmokretsov.calculite.calculator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.anmokretsov.calculite.BasePresenter
import ru.anmokretsov.calculite.BaseView
import ru.anmokretsov.calculite.R

/**
 * Created by Андрей on 25.03.2018.
 */
class DisplayFragment : Fragment(), BaseView {

    override lateinit var presenter: BasePresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_dispaly, container, false)
    }
}