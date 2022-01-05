package com.caglageller.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import com.caglageller.lesson2.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hesaplaButton.setOnClickListener {
            bahsisHesapla()
        }

    }
    fun bahsisHesapla(){

        val hizmetBedeliString= binding.hizmetBedeliEditText.text.toString()
        val tutar=hizmetBedeliString.toDoubleOrNull()
        if(tutar==null){
            binding.bahsisTutariTextView.text=""
            return
        }

        val secilenRadioButton=binding.bahsisSecenekleriRadioGrup.checkedRadioButtonId
        val bahsisYuzdesi=when(secilenRadioButton) {
            R.id.yuzde_yirmi_radio_button->0.20
            R.id.yuzde_onsekiz_radio_button->0.18
            else->0.15
        }
        var bahsis=bahsisYuzdesi*tutar

        val yukariYuvarla=binding.bahsisYukariYuvarlaSwitch.isChecked

        if (yukariYuvarla){
            bahsis=kotlin.math.ceil(bahsis)
        }

        binding.bahsisTutariTextView.text="Bahşiş Tutarı: $bahsis ₺"
    }

}