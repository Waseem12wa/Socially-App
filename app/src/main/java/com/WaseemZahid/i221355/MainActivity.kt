package com.WaseemZahid.i221355

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        // Handle system bars for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Splash screen delay - show for 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                // Navigate to LoginActivity
                val intent = android.content.Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Close splash screen
            } catch (e: Exception) {
                // If there's an error, show a toast and keep the splash screen
                android.widget.Toast.makeText(this, "Error navigating to login page: ${e.message}", android.widget.Toast.LENGTH_LONG).show()
            }
        }, 3000)
    }
}