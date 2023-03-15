package com.example.helloworldplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloworldplus.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val str = intent.getStringExtra("message")
        val shownMessage = binding.finalMessage
        shownMessage.text = str
        val button = binding.buttonBack
        button.setOnClickListener {
            val intent2 = Intent()
            intent2.putExtra("message2", str)
            setResult(RESULT_OK, intent2)
            finish()
        }
    }
}