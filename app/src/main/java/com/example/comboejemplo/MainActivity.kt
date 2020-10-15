package com.example.comboejemplo

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    var opciones = arrayOf("Negritas","Cursivas", "Negrita/cursiva")

    lateinit var spinnerOpciones: Spinner
    lateinit var txtSaludoCodigo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerOpciones = this.spinner
        txtSaludoCodigo = this.txtSaludo

        val adaptador = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,opciones)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOpciones.adapter = adaptador
        spinnerOpciones.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(position){
            1->txtSaludoCodigo.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
            2->txtSaludoCodigo.typeface = Typeface.defaultFromStyle(Typeface.ITALIC)
            3->txtSaludoCodigo.typeface = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}




