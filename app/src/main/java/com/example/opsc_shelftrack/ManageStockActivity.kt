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

class ManageStockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_manage_stock)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the button and set click listener
        val buttonHome = findViewById<Button>(R.id.buttonHome)
        // When register button is clicked
        buttonHome.setOnClickListener {
            val intent = Intent(this@ManageStockActivity, MainPageActivity::class.java)
            startActivity(intent)
        }

        val button_add = findViewById<Button>(R.id.button_add)
        // When button is clicked
        button_add.setOnClickListener {

            val editText_name1 = findViewById<EditText>(R.id.editText_name1).text.toString()
            val editText_amount = findViewById<EditText>(R.id.editText_amount).text.toString()


            if (editText_name1.isBlank() || editText_amount.isBlank() ){
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }

            // Show a toast message
            Toast.makeText(this, "Stock Added", Toast.LENGTH_SHORT).show()

            // Navigate to the next activity
            val intent = Intent(this@ManageStockActivity, MainPageActivity::class.java)
            startActivity(intent)
        }



        val button_add2 = findViewById<Button>(R.id.button_add2)
        // When button is clicked
        button_add2.setOnClickListener {

            val editText_name2 = findViewById<EditText>(R.id.editText_name2).text.toString()
            val editText_number = findViewById<EditText>(R.id.editText_number).text.toString()
            val editText_stock = findViewById<EditText>(R.id.editText_stock).text.toString()


            if (editText_name2.isBlank() || editText_number.isBlank() || editText_stock.isBlank() ){
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }

            // Show a toast message
            Toast.makeText(this, "Inventory Added", Toast.LENGTH_SHORT).show()

            // Navigate to the next activity
            val intent = Intent(this@ManageStockActivity, MainPageActivity::class.java)
            startActivity(intent)
        }




    }
}