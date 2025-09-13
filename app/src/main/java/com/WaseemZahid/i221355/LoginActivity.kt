package com.WaseemZahid.i221355

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        
        // Handle system bars for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Initialize views
        val loginButton = findViewById<CardView>(R.id.loginButton)
        val switchAccountsLink = findViewById<android.widget.TextView>(R.id.switchAccountsLink)
        val signupLink = findViewById<android.widget.TextView>(R.id.signupLink)
        val profilePictureCard = findViewById<CardView>(R.id.profilePictureCard)
        
        // Login button click listener
        loginButton.setOnClickListener {
            // Navigate to LoginFormActivity
            val intent = Intent(this, LoginFormActivity::class.java)
            startActivity(intent)
        }
        
        // Switch accounts link click listener
        switchAccountsLink.setOnClickListener {
            // Handle switch accounts functionality
            Toast.makeText(this, "Switch accounts functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        // Sign up link click listener
        signupLink.setOnClickListener {
            // Navigate to SignUpActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        
        // Profile picture click listener
        profilePictureCard.setOnClickListener {
            // Handle profile picture selection
            Toast.makeText(this, "Profile picture selection would be implemented here", Toast.LENGTH_SHORT).show()
        }
    }
}
