package ru.anmokretsov.calculite

import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class PadAdapter(private val titlesForButton: Array<String>) : RecyclerView.Adapter<PadAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.pad_button, parent, false) as AppCompatButton)
    }

    override fun getItemCount(): Int {
        return titlesForButton.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.button?.text = titlesForButton[position]
    }

    class ViewHolder(val button: AppCompatButton) : RecyclerView.ViewHolder(button){}

}