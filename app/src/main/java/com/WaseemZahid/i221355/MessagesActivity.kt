package com.WaseemZahid.i221355

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MessagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_messages)

        // Handle system bars for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Header back arrow click listener
        findViewById<ImageView>(R.id.headerBar).setOnClickListener {
            // Navigate back to previous screen
            finish()
        }

        // Search bar click listener
        findViewById<LinearLayout>(R.id.searchBar).setOnClickListener {
            Toast.makeText(this, "Search messages", Toast.LENGTH_SHORT).show()
        }

        // Camera button click listener
        findViewById<LinearLayout>(R.id.cameraButton).setOnClickListener {
            Toast.makeText(this, "Open camera", Toast.LENGTH_SHORT).show()
        }

        // Message item click listeners (for demonstration)
        // In a real app, these would open individual chat conversations
        Toast.makeText(this, "Messages screen loaded", Toast.LENGTH_SHORT).show()
    }
}
