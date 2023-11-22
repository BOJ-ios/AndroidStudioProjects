package com.cookandroid.ch13_2023_intent_01_basic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.cookandroid.ch13_2023_intent_01_basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("yang","MainActivity..onCreate..........")

        val activityLauncher= openActivityResultLauncher()

        binding.button1.setOnClickListener {
            val intent: Intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data1", "hello") //인텐트에 부가 정보를 담는 함수
            intent.putExtra("data2", 10)
            //startActivity(intent)// 결과를 받아올 것이 없는 경우는 그대로 사용하면 됨
            //startActivityForResult(intent, 10) //디테일 액티비티에서 받아올 것이 있는 경우, 다른 액티비티를 실행, 또한 callback 등록 역할도 수행
            activityLauncher.launch(intent)

        } //리스너 닫기기
    }

    //registerForActivityResult(ActivityResultContract<I, O>, ActivityResultCallback<O>) → ActivityResultLauncher<I>
    private fun openActivityResultLauncher(): ActivityResultLauncher<Intent> {
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            //콜백을 등록, { } 내부가 콜백이며, 이것을 등록함
            //registerForActivityResult는 Contract와 콜백 등록만 수행, 다른 액티비티를 실행하거나 결과를 요청하지 않음
            result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "수신 성공", Toast.LENGTH_SHORT).show()
                val data1 = result.data?.getStringExtra("data1")
                Log.d("yang","$data1")
            }
            else {
                Toast.makeText(this, "수신 실패", Toast.LENGTH_SHORT).show()
            }
        }
        return resultLauncher
    }








    /* 이전 버전 코딩 방법: 콜백을 처리하는 코드 작성
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("resultData")
        }
    }
    */
}