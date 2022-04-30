package jp.techacademy.toduka.atsushi.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("UI_PARTS", "$hour:$minute")

                    var greet: String = ""

                    if (hour in 2..9) {
                        greet = "おはよう"
                    } else if (hour in 10..17) {
                        greet = "こんにちは"
                    } else if (hour in 18..23 || hour in 0..1) {
                        greet = "こんばんは"
                    }


                    textView.text = greet
                },
                13, 0, true)
        timePickerDialog.show()
    }
}