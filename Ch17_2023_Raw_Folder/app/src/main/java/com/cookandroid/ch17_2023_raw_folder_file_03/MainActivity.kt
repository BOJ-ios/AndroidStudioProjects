package com.cookandroid.ch17_2023_raw_folder_file_03

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.cookandroid.ch17_2023_raw_folder_file_03.databinding.ActivityMainBinding
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE) //권한 관련

        binding.btnRead.setOnClickListener {
            var inputS = resources.openRawResource(R.raw.raw_test) //raw 폴더에서 파일 읽어 오기
            var txt = ByteArray(inputS.available())
            inputS.read(txt)
            binding.edtSD.setText(txt.toString(Charsets.UTF_8))
            inputS.close()
        }
    }
}