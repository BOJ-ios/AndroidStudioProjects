package com.cookandroid.ch09_2023_resource_01_2_string_style

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.cookandroid.ch09_2023_resource_01_2_string_style.databinding.ActivityMainBinding

// XML에 색상 리소스 적용, dimen으로 폰트 크기 설정, XML에서 색상과 크기 사용, Stirng 값 적용,
// 코드에서 리소스 적용법 포함 ppt 6 ~ 7
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //코드에서 색상, 크기 리소스를 사용함 - XML 내용을 덮어씀
        /*
        binding.textView.text = getString(R.string.txt_data2)
        binding.textView.setTextColor(ResourcesCompat.getColor(resources, R.color.txt_color, null))
        binding.textView.textSize = resources.getDimension(R.dimen.txt_size)
        */
    }
}