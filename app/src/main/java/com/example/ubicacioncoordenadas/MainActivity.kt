package com.example.ubicacioncoordenadas

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ubicacioncoordenadas.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        coordenadas()
    }
    fun coordenadas(){
        binding.botonbusca.setOnClickListener{
            val geocoder = Geocoder(this, Locale.getDefault())
            val addressList = geocoder.getFromLocationName("${binding.cajita.text.toString()}",1)
            if (addressList[0].hasLatitude() && addressList[0].hasLongitude()){
                binding.latitudevar.setText("${addressList[0].latitude}")
                binding.longitudevar.setText("${addressList[0].longitude}")
            }
            binding.ciudadvar.setText("${binding.cajita.text.toString()}")
            binding.cajita.setText("")
        }
    }
}