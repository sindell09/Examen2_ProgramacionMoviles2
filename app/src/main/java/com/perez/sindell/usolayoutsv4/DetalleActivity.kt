package com.perez.sindell.usolayoutsv4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.net.Uri
import com.perez.sindell.usolayoutsv4.databinding.ActivityDetalleBinding


class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerComponentUi()
        intent.extras?.let {
            showData(it)
        }
    }

    private fun showData(paramExtras: Bundle) {
        val fullName = paramExtras.getString(FULL_NAME_KEY)
        val phoneNumber = paramExtras.getString(PHONE_NUMBER_KEY)
        val product = paramExtras.getString(PRODUCT_KEY)
        val city = paramExtras.getString(CITY_KEY)
        val address = paramExtras.getString(ADDRESS_KEY)

        binding.tvFullName.text = fullName
        binding.tvPhoneNumber.text = phoneNumber
        binding.tvProduct.text = product
        binding.tvAddress.text = address
        binding.tvCity.text = city
    }

    private fun listenerComponentUi() {
        binding.btnllamar.setOnClickListener {
            call()
        }
        binding.btnwsp.setOnClickListener {
            Whatsapp()
        }
        binding.btnmaps.setOnClickListener {
            Maps()
        }
    }

    private fun call() {
        val phoneNumber = binding.tvPhoneNumber.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }

    private fun Whatsapp() {
        val phoneNumber = binding.tvPhoneNumber.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
        startActivity(intent)
    }

    private fun Maps() {
        val city = binding.tvCity.text.toString()
        val address = binding.tvAddress.text.toString()
        val uri = "geo:0,0?q=$address,$city"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

}