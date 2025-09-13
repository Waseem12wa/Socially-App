package com.WaseemZahid.i221355

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NotificationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            enableEdgeToEdge()
            setContentView(R.layout.activity_notifications)

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
            val followingTab = findViewById<TextView>(R.id.followingTab)
            val youTab = findViewById<TextView>(R.id.youTab)
            val homeIcon = findViewById<ImageView>(R.id.homeIcon)
            val searchIcon = findViewById<ImageView>(R.id.searchIcon)
            val addPostIcon = findViewById<ImageView>(R.id.addPostIcon)
            val heartIcon = findViewById<ImageView>(R.id.heartIcon)
            val profileIconCard = findViewById<androidx.cardview.widget.CardView>(R.id.profileIconCard)

            // Back button click listener
            backButton?.setOnClickListener {
                try {
                    finish()
                } catch (e: Exception) {
                    finish()
                }
            }

            // Tab navigation click listeners
            followingTab?.setOnClickListener {
                try {
                    followingTab.setTextColor(resources.getColor(R.color.brown_primary, theme))
                    followingTab.setTypeface(null, android.graphics.Typeface.BOLD)
                    youTab?.setTextColor(resources.getColor(android.R.color.darker_gray, theme))
                    youTab?.setTypeface(null, android.graphics.Typeface.NORMAL)
                    Toast.makeText(this, "Following tab selected", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error switching tabs", Toast.LENGTH_SHORT).show()
                }
            }

            youTab?.setOnClickListener {
                try {
                    youTab.setTextColor(resources.getColor(R.color.brown_primary, theme))
                    youTab.setTypeface(null, android.graphics.Typeface.BOLD)
                    followingTab?.setTextColor(resources.getColor(android.R.color.darker_gray, theme))
                    followingTab?.setTypeface(null, android.graphics.Typeface.NORMAL)
                    Toast.makeText(this, "You tab selected", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error switching tabs", Toast.LENGTH_SHORT).show()
                }
            }

            // Bottom navigation click listeners
            homeIcon?.setOnClickListener {
                try {
                    val intent = Intent(this, FeedActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error navigating to feed: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            searchIcon?.setOnClickListener {
                try {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error navigating to search: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            addPostIcon?.setOnClickListener {
                Toast.makeText(this, "Add Post functionality would be implemented here", Toast.LENGTH_SHORT).show()
            }

            heartIcon?.setOnClickListener {
                // Already on notifications page
                Toast.makeText(this, "Already on notifications page", Toast.LENGTH_SHORT).show()
            }

            profileIconCard?.setOnClickListener {
                try {
                    val intent = Intent(this, MessagesActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error navigating to messages: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            // Apply light gray color to timestamp text (3h) in all activity items
            applyTimestampColor()

        } catch (e: Exception) {
            // If there's any error, show a simple message and finish
            Toast.makeText(this, "Error loading notifications: ${e.message}", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun applyTimestampColor() {
        try {
            // Find all TextViews that contain "3h" and apply light gray color to the timestamp
            val scrollView = findViewById<android.widget.ScrollView>(R.id.activityScrollView)
            scrollView?.let { scroll ->
                val linearLayout = scroll.getChildAt(0) as? LinearLayout
                linearLayout?.let { mainLayout ->
                    for (i in 0 until mainLayout.childCount) {
                        val child = mainLayout.getChildAt(i)
                        if (child is LinearLayout) {
                            // Look for TextView in each activity item
                            for (j in 0 until child.childCount) {
                                val textView = child.getChildAt(j)
                                if (textView is TextView) {
                                    val text = textView.text.toString()
                                    if (text.contains("3h")) {
                                        // Create SpannableString to apply different colors
                                        val spannable = android.text.SpannableString(text)
                                        val mainColor = Color.parseColor("#000000") // Black for main text
                                        val timeColor = Color.parseColor("#999999") // Light gray for timestamp
                                        
                                        // Find the position of "3h"
                                        val timeIndex = text.indexOf("3h")
                                        
                                        // Apply black color to main text
                                        spannable.setSpan(
                                            android.text.style.ForegroundColorSpan(mainColor),
                                            0,
                                            timeIndex,
                                            android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                        )
                                        
                                        // Apply light gray color to timestamp
                                        spannable.setSpan(
                                            android.text.style.ForegroundColorSpan(timeColor),
                                            timeIndex,
                                            text.length,
                                            android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                        )
                                        
                                        textView.text = spannable
                                    }
                                }
                                
                                // Also check nested LinearLayouts for TextViews
                                if (textView is LinearLayout) {
                                    for (k in 0 until textView.childCount) {
                                        val nestedTextView = textView.getChildAt(k)
                                        if (nestedTextView is TextView) {
                                            val text = nestedTextView.text.toString()
                                            if (text.contains("3h")) {
                                                val spannable = android.text.SpannableString(text)
                                                val mainColor = Color.parseColor("#000000")
                                                val timeColor = Color.parseColor("#999999")
                                                
                                                val timeIndex = text.indexOf("3h")
                                                
                                                spannable.setSpan(
                                                    android.text.style.ForegroundColorSpan(mainColor),
                                                    0,
                                                    timeIndex,
                                                    android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )
                                                
                                                spannable.setSpan(
                                                    android.text.style.ForegroundColorSpan(timeColor),
                                                    timeIndex,
                                                    text.length,
                                                    android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )
                                                
                                                nestedTextView.text = spannable
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            // Handle error silently
        }
    }
}
