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
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("yang","MainActivity..onCreate..........")
        binding.detailResultView1.text = "data1: 받아올 데이터1"
        binding.detailResultView3.text = "data3: 받아올 데이터3"
        binding.detailResultView2.text = "data2: 받아올 데이터2"
        val activityLauncher= openActivityResultLauncher()
        binding.button1.setOnClickListener {
            val intent: Intent = Intent(this, DetailActivity::class.java)
            // !인텐트에 부가 정보를 담는 함수 putExtra()
            intent.putExtra("data1", "Hello")
            intent.putExtra("data2", 2023)
            //startActivity(intent)// 결과를 받아올 것이 없는 경우는 그대로 사용하면 됨
            //startActivityForResult(intent, 10) //디테일 액티비티에서 받아올 것이 있는 경우, 다른 액티비티를 실행, 또한 callback 등록 역할도 수행
            //ActivityResultLauncher<I>는 ActivityResultContract<I> 타입과 일치하는 입력을 가져온다.
            //launch() 함수를 호출하면 결과를 생성하는 프로세스가 시작된다.
            //사용자가 후속 활동을 완료하고 반환하면 ActivityResultCallback의 onActivityResult() 함수(코드에서는 익명 함수로 전달됨)가 실행된다.
            activityLauncher.launch(intent)
        } //리스너 닫기기
    }
    /* 추상 클래스: ActivityResultLauncher<I>	ActivityResultContract 실행 프로세스를 시작하기 위한 실행기와 같은 역할
       I : 실행에 필요한 입력 타입

       함수원형(메서드): registerForActivityResult(ActivityResultContract<I, O>, ActivityResultCallback<O>) → ActivityResultLauncher<I>
       1. registerForActivityResult() 함수의 매개변수로 ActivityResultcontract, ActivityResultCallback을 전달
       2. 함수 호출 결과로 ActivityResultLauncher 인스턴스를 얻어낸다.
       3. registerForActivityResult()는 콜백을 등록하는 함수일 뿐, 실제 액티비티 실행이나 결과 요청은 여기서 반환된 ActivityResultLauncher 인스턴스가 담당한다.
          즉, registerForActivityResult는 Contract와 콜백 등록만 수행, 다른 액티비티를 실행하거나 결과를 요청하지 않음

       클래스: ActivityResultContract<I. O> 결과를 생성하는 데 필요한 입력 타입과 결과의 출력 타입을 정의한다. (클래스를 생성할 때 I, O를 제공해야 한다)
       1. 카메라, 권한 요청 등 기본 인텐트 작업의 기본 제약(contract)을 제공한다. I : 입력 타입, O : 출력 타입
       2. createIntent(Context context, I Input) : startActivityForResult() 에 사용할 수 있는 인텐트를 생성한다. (추상 메서드)
      @ abstract class ActivityResultContract<I, O> {
      @   abstract Intent createIntent(@NonNull Context context, I input);
      @   abstract O parseResult(int resultCode, @Nullable Intent intent);
      @ }

       함수: StartActivityForResult(): 인텐트를 발생시키는 함수, contract 객체를 생성함 -> registerForActivityResult()의 첫째 인자를 만드는 역할
       인터페이스: ActivityResultCallback<O>	ActivityResultContract에 정의된 출력 타입의 객체를 가져오는 onActivityResult(O result) 메서드가 포함된 단일 메서드 인터페이스.
       코드에서는 익명 함수 형태로 작성되었음, Activity Result를 이용할 수 있을 때 호출되는 타입 안정성 콜백, O : 반환 타입
   */
    private fun openActivityResultLauncher(): ActivityResultLauncher<Intent> {
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            //$콜백을 등록, { } 내부가 콜백이며, 이것을 등록함
            result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data1 = result.data?.getStringExtra("data1")
                val data3 = result.data?.getStringExtra("data3")
                val data2 = result.data?.getIntExtra("data2",1970)
                this.binding.detailResultView1.text = "data1: $data1"
                this.binding.detailResultView3.text = "data3: $data3"
                this.binding.detailResultView2.text = "data2: $data2"
                this.binding.code.text = "$result.resultCode"
                Log.d("yang","$result.resultCode")
                Toast.makeText(this, "수신 성공 : $data3", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "수신 실패", Toast.LENGTH_SHORT).show()
            }
        }// $ 여기까지 콜백
        return resultLauncher
    }
    /* #이전 버전 코딩 방법: 콜백을 처리하는 코드 작성
    #override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    #    super.onActivityResult(requestCode, resultCode, data)
    #    if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
    #        val result = data?.getStringExtra("resultData")
    #    }
    #}
    #*/
}