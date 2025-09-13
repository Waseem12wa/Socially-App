package com.WaseemZahid.i221355

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MessagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            enableEdgeToEdge()
            setContentView(R.layout.activity_messages)

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

            // Header back arrow click listener
            try {
                val headerBar = findViewById<LinearLayout>(R.id.headerBar)
                headerBar?.setOnClickListener {
                    finish()
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Search bar click listener
            try {
                val searchBar = findViewById<LinearLayout>(R.id.searchBar)
                searchBar?.setOnClickListener {
                    Toast.makeText(this, "Search messages", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Camera button click listener
            try {
                val cameraButton = findViewById<LinearLayout>(R.id.cameraButton)
                cameraButton?.setOnClickListener {
                    Toast.makeText(this, "Open camera", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Message icon click listener
            try {
                val messageIcon = findViewById<android.widget.ImageView>(R.id.messageIcon)
                messageIcon?.setOnClickListener {
                    try {
                        Toast.makeText(this, "Opening new chat...", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, ChatActivity::class.java)
                        startActivity(intent)
                    } catch (e: Exception) {
                        Toast.makeText(this, "Error opening chat: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error setting up message icon: ${e.message}", Toast.LENGTH_SHORT).show()
            }

            // Message item click listeners - navigate to chat
            try {
                // Add click listeners for each message item
                val messageItems = listOf(
                    R.id.message1, R.id.message2, R.id.message3, 
                    R.id.message4, R.id.message5, R.id.message6
                )
                
                messageItems.forEach { messageId ->
                    try {
                        val messageItem = findViewById<LinearLayout>(messageId)
                        if (messageItem != null) {
                            messageItem.setOnClickListener {
                                try {
                                    Toast.makeText(this, "Opening chat...", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this, ChatActivity::class.java)
                                    startActivity(intent)
                                } catch (e: Exception) {
                                    Toast.makeText(this, "Error opening chat: ${e.message}", Toast.LENGTH_SHORT).show()
                                }
                            }
                        } else {
                            Toast.makeText(this, "Message item not found: $messageId", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(this, "Error setting click listener: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error setting up message listeners: ${e.message}", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            // If there's any error, show a simple message and finish
            Toast.makeText(this, "Error loading messages: ${e.message}", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}