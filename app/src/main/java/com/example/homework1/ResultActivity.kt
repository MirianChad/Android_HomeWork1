package com.example.homework1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework1.databinding.ActivityResultBinding
import com.example.homework1.MainActivity.Companion.MESSAGE_ARG
import com.example.homework1.MainActivity.Companion.NUMBER_ARG

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvEmail.text = intent.extras?.getString(NUMBER_ARG)
        binding.tvMessage.text = intent.extras?.getString(MESSAGE_ARG)

        binding.btnClear.setOnClickListener {
            binding.tvEmail.text = ""
            binding.tvMessage.text = ""
        }
    }
}
