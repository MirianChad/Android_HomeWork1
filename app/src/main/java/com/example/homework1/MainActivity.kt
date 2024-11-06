package com.example.homework1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework1.databinding.ActivityMainBinding
import com.example.homework1.ResultActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val numberRegex = "^[0-9]".toRegex()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendMessage.setOnClickListener {
            if (binding.etNumber.text?.isBlank() == true || binding.etMessage.text?.isBlank() == true) {
                Toast.makeText(this, "Fill out all fields!", Toast.LENGTH_SHORT).show()
            } else if (binding.etNumber.text?.matches(numberRegex) == false) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            } else if (binding.etMessage.length() > 250) {
                Toast.makeText(this, "Message text is too long!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java).putExtras(
                    Bundle().apply {
                        putString(NUMBER_ARG, binding.etNumber.text.toString())
                        putString(MESSAGE_ARG, binding.etMessage.text.toString())
                    }
                )
                startActivity(intent)
            }
        }
    }

    companion object {
        const val NUMBER_ARG = "number_arg"
        const val MESSAGE_ARG = "message_arg"
    }
}