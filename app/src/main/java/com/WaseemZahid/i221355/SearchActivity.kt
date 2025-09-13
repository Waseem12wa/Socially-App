package com.WaseemZahid.i221355

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        // Handle system bars for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Search Bar click listener
        findViewById<LinearLayout>(R.id.searchBar).setOnClickListener {
            // Navigate to SearchResultsActivity
            val intent = android.content.Intent(this, SearchResultsActivity::class.java)
            startActivity(intent)
        }

        // Bottom Navigation Icons
        findViewById<ImageView>(R.id.homeIcon).setOnClickListener {
            // Navigate to FeedActivity
            val intent = android.content.Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }
        
        findViewById<ImageView>(R.id.searchIcon).setOnClickListener {
            // Already on search page
            Toast.makeText(this, "Already on search page", Toast.LENGTH_SHORT).show()
        }
        
        findViewById<ImageView>(R.id.addPostIcon).setOnClickListener {
            Toast.makeText(this, "Add Post clicked", Toast.LENGTH_SHORT).show()
        }
        
        findViewById<ImageView>(R.id.notificationsIcon).setOnClickListener {
            Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show()
        }
        
        findViewById<CardView>(R.id.profileIconCard).setOnClickListener {
            // Navigate to MessagesActivity
            val intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
        }
    }
}
