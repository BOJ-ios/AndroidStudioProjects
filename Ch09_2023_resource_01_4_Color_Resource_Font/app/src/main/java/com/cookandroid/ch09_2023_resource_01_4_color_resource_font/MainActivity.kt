package com.cookandroid.ch09_2023_resource_01_4_color_resource_font

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// color 디렉토리를 만들어서 하나의 뷰에 대한 색상을 설정 --> 여기서는 버튼에 적용함
// cf) color.xml은 한 가지 색상을 resource에 등록하는 것
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}