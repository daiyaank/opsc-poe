package com.example.opsc_shelftrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ManageItems : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_manage_items)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the button and set click listener
        val buttonHome = findViewById<Button>(R.id.buttonHome)
        // When register button is clicked
        buttonHome.setOnClickListener {
            val intent = Intent(this@ManageItems, MainPageActivity::class.java)
            startActivity(intent)
        }

        // Find the button and set click listener
        val button_add = findViewById<Button>(R.id.button_add)
        // When button is clicked
        button_add.setOnClickListener {

            val editText_name = findViewById<EditText>(R.id.editText_name).text.toString()
            val editText_description = findViewById<EditText>(R.id.editText_description).text.toString()
            val editText_category = findViewById<EditText>(R.id.editText_category).text.toString()
            val editText_quantity = findViewById<EditText>(R.id.editText_quantity).text.toString()
            val editText_costPrice = findViewById<EditText>(R.id.editText_costPrice).text.toString()
            val editText_saleprice = findViewById<EditText>(R.id.editText_saleprice).text.toString()

            if (
                editText_name.isBlank()
                || editText_description.isBlank() 
                || editText_category.isBlank()
                || editText_quantity.isBlank()
                || editText_costPrice.isBlank()
                || editText_saleprice.isBlank()


                ){
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }

            // Show a toast message
            Toast.makeText(this, "Item added Successfully", Toast.LENGTH_SHORT).show()

            // Navigate to the next activity
            val intent = Intent(this@ManageItems, MainPageActivity::class.java)
            startActivity(intent)
        }

    }
}