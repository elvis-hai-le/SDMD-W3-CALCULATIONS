package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val answer = findViewById<TextView>(R.id.answer)

        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener {
            val result = add(number1.text.toString().toInt(), number2.text.toString().toInt())
            // TODO: show result on the screen
            answer.text = result.toString()
        }
    }

    // adds two numbers together
    private fun add(number1: Int, number2: Int) = number1 + number2
}