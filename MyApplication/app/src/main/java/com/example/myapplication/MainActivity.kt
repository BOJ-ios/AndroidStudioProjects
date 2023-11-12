package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
<<<<<<< Updated upstream
import android.view.KeyEvent
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.TestBinding
=======
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
>>>>>>> Stashed changes
import com.example.myapplication.databinding.CheckboxBinding
import com.example.myapplication.databinding.RelativeBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        callbackMethod(paramFunc = {Log.d("myTag", "asd")})
        super.onCreate(savedInstanceState)
        // * Bindings
        val binding1 = ActivityMainBinding.inflate(layoutInflater)
        val binding2 = CheckboxBinding.inflate(layoutInflater)
<<<<<<< Updated upstream
        val binding3 = TestBinding.inflate(layoutInflater)
=======
>>>>>>> Stashed changes
        val binding4 = RelativeBinding.inflate(layoutInflater)
        setContentView(binding1.root)


        /* ! Binding2
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
        */

        /* ! Binding4
        binding4.image22.setOnClickListener{
            binding4.image22.visibility = View.GONE
            binding4.btn22.visibility = View.VISIBLE
        }
        binding4.btn22.setOnClickListener{
            binding4.image22.visibility = View.VISIBLE
            binding4.btn22.visibility = View.GONE
        }
        fun allVisible() {
            binding4.image22.visibility = View.VISIBLE
            binding4.btn22.visibility = View.VISIBLE
        }
        binding4.image22.setOnLongClickListener {
            allVisible()
            true // Return true to indicate that the callback consumed the long click
        }
        binding4.btn22.setOnLongClickListener {
            allVisible()
            true // Return true to indicate that the callback consumed the long click
        }
        */
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("kkang", "onKeyDown")
        return super.onKeyDown(keyCode, event)
    }
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("kkang", "onKeyUp")
        return super.onKeyUp(keyCode, event)
    }
    private fun callbackMethod( paramFunc : ()-> Unit){
        Log.d("myTag","MainActivity called this func")
        Handler(Looper.getMainLooper()).postDelayed({
            paramFunc()
        }, 1000L)
    }
}