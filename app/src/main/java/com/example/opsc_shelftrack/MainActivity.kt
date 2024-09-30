package com.example.opsc_shelftrack

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Login page
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Find the button and set click listener
        val ButtonSSO = findViewById<Button>(R.id.buttonSSO)

        ButtonSSO.setOnClickListener {
            // Create a ProgressDialog to show the circular indicator
            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Verifying Account SSO...")
            progressDialog.setCancelable(false) // Disallow canceling the dialog by tapping outside of it
            progressDialog.show()

            // Simulate a delay using Handler
            Handler(Looper.getMainLooper()).postDelayed({
                // Dismiss the progress dialog after the delay
                progressDialog.dismiss()

                // Show a toast message
                Toast.makeText(this, "SSO Verified", Toast.LENGTH_SHORT).show()

                // Navigate to the next activity
                val intent = Intent(this@MainActivity, MainPageActivity::class.java)
                startActivity(intent)
            }, 3000) // 3000 milliseconds delay (3 seconds)
        }



        // Find the button and set click listener
        val buttonLogin = findViewById<Button>(R.id.button_login)
        // When register button is clicked
        buttonLogin.setOnClickListener {

            val emailAddress = findViewById<EditText>(R.id.editText_email).text.toString()
            val password = findViewById<EditText>(R.id.editText_password).text.toString()

            if (emailAddress.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }

            // Navigate to the next activity
            val intent = Intent(this@MainActivity, MainPageActivity::class.java)
            startActivity(intent)
        }

    }
}