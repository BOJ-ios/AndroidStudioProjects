package com.cookandroid.ch10_2023_dialog_data_time_02

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import com.cookandroid.ch10_2023_dialog_data_time_02.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    Log.d("yang", "year : $p1, month : ${p2+1}, dayOfMonth : $p3")
                }
            }, 2023, 11, 30).show()
        }
        binding.button2.setOnClickListener {
            TimePickerDialog(this, object: TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Log.d("yang", "time : $p1, minute : $p2")
                }
            }, 15, 0, true).show()
        }
    }
}