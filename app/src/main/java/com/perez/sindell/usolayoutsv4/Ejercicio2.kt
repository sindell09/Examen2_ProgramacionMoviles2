package com.perez.sindell.usolayoutsv4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.perez.sindell.usolayoutsv4.databinding.ActivityEjercicio2Binding
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.widget.Toast

class Ejercicio2 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        observeComponents()
    }

    private fun observeComponents() {
        binding.btnSave.setOnClickListener {
            if (isEmptyInputs()) {
                Toast.makeText(this, "Hay algún campo vacío", Toast.LENGTH_SHORT).show()
            } else {
                goDetailActivity()
            }
        }
    }

    private fun goDetailActivity() {
        val fullName = binding.edtFullName.text.toString()
        val phoneNumber = binding.edtPhoneNumber.text.toString()
        val product = binding.edtProduct.text.toString()
        val city = binding.edtCity.text.toString()
        val address = binding.edtAddress.text.toString()

        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("FULL_NAME", fullName)
        intent.putExtra("PHONE_NUMBER", phoneNumber)
        intent.putExtra("PRODUCT", product)
        intent.putExtra("CITY", city)
        intent.putExtra("ADDRESS", address)
        startActivity(intent)
    }

    private fun isEmptyInputs(): Boolean {
        return binding.edtFullName.text.isEmpty() ||
                binding.edtPhoneNumber.text.isEmpty() ||
                binding.edtProduct.text.isEmpty() ||
                binding.edtCity.text.isEmpty() ||
                binding.edtAddress.text.isEmpty()
    }
}
