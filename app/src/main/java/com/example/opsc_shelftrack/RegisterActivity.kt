package com.example.opsc_shelftrack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.opsc_shelftrack.Models.User
import com.example.opsc_shelftrack.repository.Repository
import okhttp3.*
import okio.IOException
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull

class RegisterActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    private val gson = Gson()

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        //API Implementation
        val repository = Repository()
        /*val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getUser()
        // Get user from JSON
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.firstName.toString())
            Log.d("Response", response.lastName.toString())
            Log.d("Response", response.emailAddress.toString())
        })*/

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the button and set click listener
        val buttonRegister = findViewById<Button>(R.id.button_register)

        // When register button is clicked
        buttonRegister.setOnClickListener {
            registerUser()


        }
    }

    private fun registerUser() {
        // Retrieve user input from EditText fields
        val firstName = findViewById<EditText>(R.id.editText_firstName).text.toString()
        val lastName = findViewById<EditText>(R.id.editText_lastName).text.toString()
        val emailAddress = findViewById<EditText>(R.id.editText_email).text.toString()
        val companyName = findViewById<EditText>(R.id.editText_companyName).text.toString()
        val vatNumber = findViewById<EditText>(R.id.editText_vatNumber).text.toString()
        val password = findViewById<EditText>(R.id.editText_password).text.toString()

        // Check if any field is empty
        if (firstName.isBlank() || lastName.isBlank() || emailAddress.isBlank() ||
            companyName.isBlank() || vatNumber.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            return // Exit the method if validation fails
        }

        // Create the user object
        val user = User(firstName, lastName, emailAddress, password)

        // Show a toast message
        Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()

        // Navigate to the next activity
        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
        startActivity(intent)




    }
}
