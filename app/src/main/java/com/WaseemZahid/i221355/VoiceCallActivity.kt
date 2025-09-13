package com.WaseemZahid.i221355

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.TimeUnit

class VoiceCallActivity : AppCompatActivity() {
    
    private var callDuration = 0 // in seconds
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var durationTextView: TextView
    private lateinit var endCallButton: ImageView
    private lateinit var menuButton: ImageView
    private lateinit var speakerButton: ImageView
    
    private val durationRunnable = object : Runnable {
        override fun run() {
            callDuration++
            updateDurationDisplay()
            handler.postDelayed(this, 1000) // Update every second
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            enableEdgeToEdge()
            setContentView(R.layout.activity_voice_call)

            // Handle system bars for edge-to-edge display
            try {
                val mainView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
                if (mainView != null) {
                    ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                        insets
                    }
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Initialize views
            durationTextView = findViewById(R.id.callDuration)
            endCallButton = findViewById(R.id.endCallButton)
            menuButton = findViewById(R.id.menuButton)
            speakerButton = findViewById(R.id.speakerButton)

            // Set initial duration
            callDuration = 192 // 3 minutes 12 seconds (03:12)
            updateDurationDisplay()

            // Start duration timer
            handler.post(durationRunnable)

            // End call button click listener
            endCallButton.setOnClickListener {
                try {
                    handler.removeCallbacks(durationRunnable)
                    Toast.makeText(this, "Call ended", Toast.LENGTH_SHORT).show()
                    finish()
                } catch (e: Exception) {
                    finish()
                }
            }

            // Menu button click listener
            menuButton.setOnClickListener {
                Toast.makeText(this, "Call menu functionality would be implemented here", Toast.LENGTH_SHORT).show()
            }

            // Speaker button click listener
            speakerButton.setOnClickListener {
                Toast.makeText(this, "Speaker toggle functionality would be implemented here", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            // If there's any error, show a simple message and finish
            Toast.makeText(this, "Error loading voice call: ${e.message}", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun updateDurationDisplay() {
        val minutes = TimeUnit.SECONDS.toMinutes(callDuration.toLong())
        val seconds = callDuration % 60
        val durationText = String.format("%02d:%02d", minutes, seconds)
        durationTextView.text = durationText
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(durationRunnable)
    }
}
