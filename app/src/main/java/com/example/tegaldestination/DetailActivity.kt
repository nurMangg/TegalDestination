package com.example.tegaldestination

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DESTINATION ="extra_destination"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.title = "Destination Wisata Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvDetailName: TextView = findViewById(R.id.tvDetailName)
        val tvDetailDescription: TextView = findViewById(R.id.tvDetailDescription)
        val ivDetailPhoto: ImageView = findViewById(R.id.ivDetailPhoto)
        val buttonShare : Button = findViewById(R.id.action_share)

        val dataDestination = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Destination>(EXTRA_DESTINATION, Destination::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Destination>(EXTRA_DESTINATION)
        }



        if (dataDestination != null) {
            tvDetailName.text = dataDestination.name
            tvDetailDescription.text = dataDestination.description
            ivDetailPhoto.setImageResource(dataDestination.photo)

            buttonShare.setOnClickListener {
                Toast.makeText(this, "Kamu Membagikan " + dataDestination.name, Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun onSupportNavigateUp(): Boolean {
        @Suppress("DEPRECATION")
        onBackPressed()
        return true
    }
}