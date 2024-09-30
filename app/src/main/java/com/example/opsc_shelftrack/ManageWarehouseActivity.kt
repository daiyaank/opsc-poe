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

class ManageWarehouseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_manage_warehouse)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the button and set click listener
        val buttonHome = findViewById<Button>(R.id.buttonHome)
        // When register button is clicked
        buttonHome.setOnClickListener {
            val intent = Intent(this@ManageWarehouseActivity, MainPageActivity::class.java)
            startActivity(intent)
        }

        // Find the button and set click listener
        val button_add = findViewById<Button>(R.id.button_add)
        // When button is clicked
        button_add.setOnClickListener {

            val warehouseName1 = findViewById<EditText>(R.id.editText_warehouseName1).text.toString()
            val address1 = findViewById<EditText>(R.id.editText_address1).text.toString()
            val editText_size = findViewById<EditText>(R.id.editText_size).text.toString()

            if (warehouseName1.isBlank() || address1.isBlank() || editText_size.isBlank()  ){
                Toast.makeText(this, "Please fill out all Add Warehouse fields", Toast.LENGTH_SHORT).show()
            }

            // Show a toast message
            Toast.makeText(this, "Warehouse added Successfully", Toast.LENGTH_SHORT).show()

            // Navigate to the next activity
            val intent = Intent(this@ManageWarehouseActivity, MainPageActivity::class.java)
            startActivity(intent)
        }

        // Find the button and set click listener
        val button_send = findViewById<Button>(R.id.button_send)
        // When button is clicked
        button_send.setOnClickListener {

            val editText_warehouseName2 = findViewById<EditText>(R.id.editText_warehouseName2).text.toString()
            val editText_address2 = findViewById<EditText>(R.id.editText_address2).text.toString()
            val editText_itemName = findViewById<EditText>(R.id.editText_itemName).text.toString()
            val editText_sku = findViewById<EditText>(R.id.editText_sku).text.toString()
            val editText_quantity = findViewById<EditText>(R.id.editText_quantity).text.toString()

            if (editText_warehouseName2.isBlank() || editText_address2.isBlank() || editText_itemName.isBlank() || editText_itemName.isBlank() || editText_quantity.isBlank() || editText_sku.isBlank()){
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }

            // Show a toast message
            Toast.makeText(this, "Warehouse item sent Successfully", Toast.LENGTH_SHORT).show()

            // Navigate to the next activity
            val intent = Intent(this@ManageWarehouseActivity, MainPageActivity::class.java)
            startActivity(intent)
        }




    }
}