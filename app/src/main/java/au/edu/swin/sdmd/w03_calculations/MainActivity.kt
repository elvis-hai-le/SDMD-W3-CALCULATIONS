package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var calculation: Int = 0
    var operator = "plus"

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle","onDestroy")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle","onCreate")
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val answer = findViewById<TextView>(R.id.answer)

        savedInstanceState?.let {
            calculation = it.getInt("answer")
            answer.text = calculation.toString()
        }

        val equals = findViewById<Button>(R.id.equals)

        equals.setOnClickListener {
            calculation = when(operator) {
                "plus" -> add(number1.text.toString(), number2.text.toString())
                "sub" -> sub(number1.text.toString(), number2.text.toString())
                 else -> add(number1.text.toString(), number2.text.toString())
            }
            answer.text = calculation.toString()
        }
    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked


            when (view.getId()) {
                R.id.radioPlus ->
                    if (checked) {
                        operator = "plus"
                    }

                R.id.radioMinus ->
                    if (checked) {
                        operator = "sub"
                    }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("answer", calculation)
        Log.i("Lifecycle","saveInstanceState $calculation")
    }

    // adds two numbers together
    private fun add(number1: String, number2: String) = number1.toInt() + number2.toInt()
    private fun sub(number1: String, number2: String) = number1.toInt() - number2.toInt()


}