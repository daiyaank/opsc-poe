package com.example.opsc_shelftrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the button and set click listener
        val buttonSettings = findViewById<Button>(R.id.buttonSettings)
        // When settings button is clicked
        buttonSettings.setOnClickListener {
            val intent = Intent(this@MainPageActivity, MainActivity::class.java)
            startActivity(intent)
        }

        // Find the button and set click listener
        val buttonManageItems = findViewById<Button>(R.id.buttonManageItems)
        // When manage inventory button is clicked
        buttonManageItems.setOnClickListener {
            val intent = Intent(this@MainPageActivity, ManageItems::class.java)
            startActivity(intent)
        }

        // Find the button and set click listener
        val buttonManageStock = findViewById<Button>(R.id.buttonManageStock)
        // When register button is clicked
        buttonManageStock.setOnClickListener {
            val intent = Intent(this@MainPageActivity, ManageStockActivity::class.java)
            startActivity(intent)
        }

        // Find the button and set click listener
        val buttonManageWarehouse = findViewById<Button>(R.id.buttonManageWarehouse)
        // When register button is clicked
        buttonManageWarehouse.setOnClickListener {
            val intent = Intent(this@MainPageActivity, ManageWarehouseActivity::class.java)
            startActivity(intent)
        }


    }
}