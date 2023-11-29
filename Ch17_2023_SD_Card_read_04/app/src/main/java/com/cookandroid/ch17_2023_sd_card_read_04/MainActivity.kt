package com.cookandroid.ch17_2023_sd_card_read_04


import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.cookandroid.ch17_2023_sd_card_read_04.databinding.ActivityMainBinding
import java.io.DataOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

//권한 리스트
var permission_list = arrayOf(
    android.Manifest.permission.READ_EXTERNAL_STORAGE,
    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
)

/*권한 문제로 수정 중, permission.kt 파일 참고, SD 카드는 현재 바로 접근 안됨 */
class MainActivity : AppCompatActivity() {

    //권한 체크
    fun PermissionCheck(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return
        }
        for(permission : String in permission_list){
            var chk = checkCallingOrSelfPermission(permission)
            if(chk == PackageManager.PERMISSION_DENIED){
                requestPermissions(permission_list, 0)
                break
            }
        }
    }

    var path : String? = null  //파일 경로

    var txtFiles: Array<File>? = null
    lateinit var txtFname: String

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE) //권한 관련

        binding.btnRead.setOnClickListener {
            PermissionCheck()

            var inFs = FileInputStream("/storage/emulated/0/doc/sd_test.txt") // SD 카드 경로
            var txt = ByteArray(inFs.available())
            inFs.read(txt)
            binding.edtSD.setText(txt.toString(Charsets.UTF_8))
            inFs.close()
        }
    }
}