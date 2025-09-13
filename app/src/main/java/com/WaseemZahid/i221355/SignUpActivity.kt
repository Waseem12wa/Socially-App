package com.WaseemZahid.i221355

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        
        // Handle system bars for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Initialize views
        val backButton = findViewById<android.widget.ImageView>(R.id.backButton)
        val createAccountButton = findViewById<CardView>(R.id.createAccountButton)
        val profilePictureCard = findViewById<CardView>(R.id.profilePictureCard)
        
        // Initialize EditText fields
        val usernameField = findViewById<android.widget.EditText>(R.id.usernameField)
        val nameField = findViewById<android.widget.EditText>(R.id.nameField)
        val lastnameField = findViewById<android.widget.EditText>(R.id.lastnameField)
        val dobField = findViewById<android.widget.EditText>(R.id.dobField)
        val emailField = findViewById<android.widget.EditText>(R.id.emailField)
        val passwordField = findViewById<android.widget.EditText>(R.id.passwordField)
        
        // Back button click listener
        backButton.setOnClickListener {
            finish() // Go back to previous activity
        }
        
        // Create account button click listener
        createAccountButton.setOnClickListener {
            // Get form data
            val username = usernameField.text.toString()
            val name = nameField.text.toString()
            val lastname = lastnameField.text.toString()
            val dob = dobField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            
            // Basic validation
            if (username.isEmpty() || name.isEmpty() || lastname.isEmpty() || dob.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Handle account creation
                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Profile picture click listener
        profilePictureCard.setOnClickListener {
            // Handle profile picture selection
            Toast.makeText(this, "Profile picture selection would be implemented here", Toast.LENGTH_SHORT).show()
        }
    }
}
