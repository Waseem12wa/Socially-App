package com.WaseemZahid.i221355

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feed)
        
        // Handle system bars for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Initialize views
        val cameraIcon = findViewById<android.widget.ImageView>(R.id.cameraIcon)
        val tvIcon = findViewById<android.widget.ImageView>(R.id.tvIcon)
        val filterIcon = findViewById<android.widget.ImageView>(R.id.filterIcon)
        val menuDots = findViewById<android.widget.ImageView>(R.id.menuDots)
        val likeIcon = findViewById<android.widget.ImageView>(R.id.likeIcon)
        val commentIcon = findViewById<android.widget.ImageView>(R.id.commentIcon)
        val shareIcon = findViewById<android.widget.ImageView>(R.id.shareIcon)
        val saveIcon = findViewById<android.widget.ImageView>(R.id.saveIcon)
        val homeIcon = findViewById<android.widget.ImageView>(R.id.homeIcon)
        val searchIcon = findViewById<android.widget.ImageView>(R.id.searchIcon)
        val addPostIcon = findViewById<android.widget.ImageView>(R.id.addPostIcon)
        val notificationsIcon = findViewById<android.widget.ImageView>(R.id.notificationsIcon)
        val messagesIcon = findViewById<android.widget.ImageView>(R.id.messagesIcon)
        
        // Header icons click listeners
        cameraIcon.setOnClickListener {
            Toast.makeText(this, "Camera functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        tvIcon.setOnClickListener {
            Toast.makeText(this, "TV/Reels functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        filterIcon.setOnClickListener {
            Toast.makeText(this, "Filter functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        // Post menu click listener
        menuDots.setOnClickListener {
            Toast.makeText(this, "Post menu functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        // Engagement icons click listeners
        likeIcon.setOnClickListener {
            Toast.makeText(this, "Like functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        commentIcon.setOnClickListener {
            Toast.makeText(this, "Comment functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        shareIcon.setOnClickListener {
            Toast.makeText(this, "Share functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        saveIcon.setOnClickListener {
            Toast.makeText(this, "Save functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        // Bottom navigation click listeners
        homeIcon.setOnClickListener {
            Toast.makeText(this, "Already on Home", Toast.LENGTH_SHORT).show()
        }
        
        searchIcon.setOnClickListener {
            // Navigate to SearchActivity
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        
        addPostIcon.setOnClickListener {
            Toast.makeText(this, "Add Post functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        notificationsIcon.setOnClickListener {
            Toast.makeText(this, "Notifications functionality would be implemented here", Toast.LENGTH_SHORT).show()
        }
        
        messagesIcon.setOnClickListener {
            // Navigate to MessagesActivity
            val intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
        }
    }
}
