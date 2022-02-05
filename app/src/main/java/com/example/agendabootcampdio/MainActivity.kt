package com.example.agendabootcampdio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.* // importando todos os eventos do CALENDAR CONTRACTS
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetEvent = findViewById(R.id.set_event) as Button
        val btnContact = findViewById(R.id.contact) as Button
        val btnFotos = findViewById(R.id.fotos) as Button
        btnSetEvent.setOnClickListener {

            val intent = Intent(Intent.ACTION_INSERT)
                .setData(CONTENT_URI) // Primeiro item do nosso calendario
                .putExtra(TITLE, "Bootcamp everis")
                .putExtra(EVENT_LOCATION, "on line")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, System.currentTimeMillis() + (60*60*1000))
            startActivity(intent)

        }

        btnContact.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        btnFotos.setOnClickListener {
            val intent = Intent(this, FotosActivity::class.java)
            startActivity(intent)
        }

    }
}