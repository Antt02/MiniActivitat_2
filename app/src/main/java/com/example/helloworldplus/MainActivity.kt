package com.example.helloworldplus

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.helloworldplus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.button
        val byeMessage: EditText = binding.byeMessage
        val repetitions: EditText = binding.repetitions
        byeMessage.setTextIsSelectable(true)
        repetitions.setTextIsSelectable(true)

        val finalText = binding.finalMessage
        val startForResult:ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result:ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    byeMessage.text.clear()
                    repetitions.text.clear()
                    if (intent != null) {
                        finalText.text = intent.getStringExtra("message2")
                    }
                }
            }
        button.setOnClickListener{
            val reps:Int
            val text =  byeMessage.text.toString()
            if (repetitions.text.toString() != ""){
                reps = repetitions.text.toString().toInt()
            }else{
                reps = 1
            }
            var message = ""
            for (i in 1..reps)
                message += text
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("message", message)
            startForResult.launch(intent)
        }
    }
}