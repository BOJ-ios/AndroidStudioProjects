package com.cookandroid.ch06_2023_practice_old_4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cookandroid.ch06_2023_practice_old_4_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "애완 동물 사진 보기"

        // 시작함 체크박스의 체크가 변경되면
        binding.ChkAgree.setOnCheckedChangeListener { compoundButton, b ->
            // 체크되면 모두 보이도록 설정
            if (binding.ChkAgree.isChecked == true) {
                binding.Text2.visibility = android.view.View.VISIBLE
                binding.Rgroup1.visibility = android.view.View.VISIBLE
                binding.BtnOK.visibility = android.view.View.VISIBLE
                binding.ImgPet.visibility = android.view.View.VISIBLE
            } else {
                binding.Text2.visibility = android.view.View.INVISIBLE
                binding.Rgroup1.visibility = android.view.View.INVISIBLE
                binding.BtnOK.visibility = android.view.View.INVISIBLE
                binding.ImgPet.visibility = android.view.View.INVISIBLE
            }
        }

        // 선택 완료 버튼을 클릭하면
        binding.BtnOK.setOnClickListener {
            when (binding.Rgroup1.checkedRadioButtonId) {
                R.id.RdoDog -> binding.ImgPet.setImageResource(R.drawable.dog)
                R.id.RdoCat -> binding.ImgPet.setImageResource(R.drawable.cat)
                R.id.RdoRabbit -> binding.ImgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext, "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}