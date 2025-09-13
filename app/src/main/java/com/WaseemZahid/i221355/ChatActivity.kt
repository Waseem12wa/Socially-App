package com.WaseemZahid.i221355

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            enableEdgeToEdge()
            setContentView(R.layout.activity_chat)

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
            val backButton = findViewById<ImageView>(R.id.backButton)
            val videoCallIcon = findViewById<ImageView>(R.id.videoCallIcon)
            val infoIcon = findViewById<ImageView>(R.id.infoIcon)
            val messageInput = findViewById<EditText>(R.id.messageInput)
            val cameraIcon = findViewById<ImageView>(R.id.cameraIcon)
            val microphoneIcon = findViewById<ImageView>(R.id.microphoneIcon)
            val galleryIcon = findViewById<ImageView>(R.id.galleryIcon)
            val emojiIcon = findViewById<ImageView>(R.id.emojiIcon)

            // Back button click listener
            try {
                backButton?.setOnClickListener {
                    finish()
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Video call icon click listener
            try {
                videoCallIcon?.setOnClickListener {
                    val intent = Intent(this, VoiceCallActivity::class.java)
                    startActivity(intent)
                }
            } catch (e: Exception) {
                // Handle error silently
                Toast.makeText(this, "Error opening voice call: ${e.message}", Toast.LENGTH_SHORT).show()
            }

            // Info icon click listener
            try {
                infoIcon?.setOnClickListener {
                    Toast.makeText(this, "Chat info functionality would be implemented here", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Camera icon click listener
            try {
                cameraIcon?.setOnClickListener {
                    Toast.makeText(this, "Camera functionality would be implemented here", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Microphone icon click listener
            try {
                microphoneIcon?.setOnClickListener {
                    Toast.makeText(this, "Voice message functionality would be implemented here", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Gallery icon click listener
            try {
                galleryIcon?.setOnClickListener {
                    Toast.makeText(this, "Opening gallery to attach image...", Toast.LENGTH_SHORT).show()
                    // In a real app, this would open the gallery picker
                    // Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    // startActivityForResult(intent, PICK_IMAGE_REQUEST);
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Emoji icon click listener
            try {
                emojiIcon?.setOnClickListener {
                    Toast.makeText(this, "Emoji picker functionality would be implemented here", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Handle error silently
            }

            // Message input handling
            messageInput?.setOnEditorActionListener { _, actionId, _ ->
                val message = messageInput.text.toString().trim()
                if (message.isNotEmpty()) {
                    // Handle sending message
                    Toast.makeText(this, "Message sent: $message", Toast.LENGTH_SHORT).show()
                    messageInput.text.clear()
                }
                true
            }

            // Add send button functionality
            try {
                val sendButton = findViewById<android.widget.ImageView>(R.id.emojiIcon)
                sendButton?.setOnClickListener {
                    val message = messageInput?.text?.toString()?.trim() ?: ""
                    if (message.isNotEmpty()) {
                        Toast.makeText(this, "Message sent: $message", Toast.LENGTH_SHORT).show()
                        messageInput?.text?.clear()
                    } else {
                        Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                // Handle error silently
            }

        } catch (e: Exception) {
            // If there's any error, show a simple message and finish
            Toast.makeText(this, "Error loading chat: ${e.message}", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
