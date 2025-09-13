package com.WaseemZahid.i221355

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_form)
        
        // Handle system bars for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Initialize views
        val backButton = findViewById<android.widget.ImageView>(R.id.backButton)
        val loginButton = findViewById<CardView>(R.id.loginButton)
        val forgotPasswordLink = findViewById<android.widget.TextView>(R.id.forgotPasswordLink)
        val signupLink = findViewById<android.widget.TextView>(R.id.signupLink)
        val usernameField = findViewById<android.widget.EditText>(R.id.usernameField)
        val passwordField = findViewById<android.widget.EditText>(R.id.passwordField)
        
        // Back button click listener
        backButton.setOnClickListener {
            finish() // Go back to previous activity
        }
        
        // Login button click listener
        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()
            
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Navigate to FeedActivity
                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish() // Close login form
            }
        }
        
        // Forgot password link click listener
        forgotPasswordLink.setOnClickListener {
            // Handle forgot password functionality
            Toast.makeText(this, "Forgot password functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        // Sign up link click listener
        signupLink.setOnClickListener {
            // Navigate to SignUpActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
