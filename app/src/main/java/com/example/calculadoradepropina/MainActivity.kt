package com.example.calculadoradepropina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadoradepropina.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    private fun initUI(){
        binding.button15.setOnClickListener {
            interfaceCalculateTip(percentage = .15)
            Toast.makeText(this, "You are tipping 15%", Toast.LENGTH_SHORT).show()
        }
        binding.button20.setOnClickListener {
            interfaceCalculateTip(percentage = .20)
            Toast.makeText(this, "You are tipping 20%", Toast.LENGTH_SHORT).show()
        }
        binding.button35.setOnClickListener {
            interfaceCalculateTip(percentage = .35)
            Toast.makeText(this, "You are tipping 35%", Toast.LENGTH_SHORT).show()
        }
    }

    private fun interfaceCalculateTip(percentage: Double) {
        val amount = binding.editTextNumberDecimal.text.toString()
        val amountValue = amount.toDoubleOrNull()
        if (amountValue == null || amountValue <= 0) {
            Toast.makeText(this, "You must enter a number higher than 0", Toast.LENGTH_SHORT).show()
            binding.textView3.text = "0.0"
            binding.textView4.text = "0.0"
            return
        }
        binding.textView3.text = "${amountValue * percentage}"
        binding.textView4.text = "${amountValue * (1 + percentage)}"

        binding.buttonRound.setOnClickListener {
            binding.textView3.text = "${round(amountValue * percentage)}"
            binding.textView4.text = "${round(amountValue * (1 + percentage))}"
        }
    }
}