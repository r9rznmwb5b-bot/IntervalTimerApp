package ru.ansya.intervaltimerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workDurationInput = findViewById<EditText>(R.id.workDurationEditText)
        val restDurationInput = findViewById<EditText>(R.id.restDurationEditText)
        val roundCountInput = findViewById<EditText>(R.id.roundCountEditText)

        findViewById<Button>(R.id.startTimerButton).setOnClickListener {
            val workSeconds = workDurationInput.text.toString().toIntOrNull()
            val restSeconds = restDurationInput.text.toString().toIntOrNull()
            val roundCount = roundCountInput.text.toString().toIntOrNull()

            if (workSeconds !in 1..3600 || restSeconds !in 1..3600 || roundCount !in 1..99) {
                Toast.makeText(this, R.string.invalid_settings, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val timerIntent = Intent(this, TimerActivity::class.java).apply {
                putExtra(TimerActivity.EXTRA_WORK_SECONDS, workSeconds)
                putExtra(TimerActivity.EXTRA_REST_SECONDS, restSeconds)
                putExtra(TimerActivity.EXTRA_ROUND_COUNT, roundCount)
            }
            startActivity(timerIntent)
        }
    }
}
