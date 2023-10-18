package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.RadioButton
//import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.CheckboxBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        callbackMethod(paramFunc = {Log.d("myTag", "asd")})
        super.onCreate(savedInstanceState)
        //val binding1 = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding1.root)
        val binding2 = CheckboxBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        binding2.visibleCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding2.letsGo.visibility = View.VISIBLE // radioSelect가 binding2에 있는 뷰의 id라고 가정합니다.
            } else {
                binding2.letsGo.visibility = View.GONE
            }
        }
        // RadioGroup에 리스너를 설정
        binding2.radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            binding2.choice.text = radio.text  // choice는 TextView의 ID
        }
    }

    private fun callbackMethod( paramFunc : ()-> Unit){
        Log.d("myTag","MainActivity called this func")
        Handler(Looper.getMainLooper()).postDelayed({
            paramFunc()
        }, 1000L)
    }
}
//    override fun onCreate(savedInstanceState: Bundle?) {
//        callbackMethod(paramFunc= {it:String ->
//            Log.d("myTag", it)
//        })
//        callbackMethod { it: String ->
//            Log.d("myTag", it)
//        }
//        callbackMethod(testFun)
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//    private fun callbackMethod( paramFunc : (String)-> Unit){
//        Log.d("myTag","MainActivity called this func")
//        Handler(Looper.getMainLooper()).postDelayed({
//            paramFunc("ㅋㅋㅋㅋㅋ")
//        }, 1000L)
//    }
//    private val testFun: (String) -> Unit = { it ->
//        Log.d("my tag", it)
//    }