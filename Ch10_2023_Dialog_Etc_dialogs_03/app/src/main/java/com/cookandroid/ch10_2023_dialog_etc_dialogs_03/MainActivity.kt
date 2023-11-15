package com.cookandroid.ch10_2023_dialog_etc_dialogs_03

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cookandroid.ch10_2023_dialog_etc_dialogs_03.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val eventHandler = object : DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {
            if (p1 == DialogInterface.BUTTON_POSITIVE) {
                Log.d("yang", "positive button click")
            } else if (p1 == DialogInterface.BUTTON_NEGATIVE) {
                Log.d("yang", "negative button click")

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("test dialog")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("OK", eventHandler)
                setNegativeButton("Cancel", eventHandler)
                show()
            }
        }

        binding.button2.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(
                    items,
                    object : DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            Log.d(
                                "yang",
                                "선택한 과일 : ${items[p1]}"
                            )
                        }
                    })
                setCancelable(false) // 뒤로 가기 버튼에 반응하지 않도록 설정
                setPositiveButton("닫기", null)
                show()
            }.setCanceledOnTouchOutside(false) // 영역 바깥에 터치해도 반응 없도록 설정
        }
        binding.button3.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true, false, true, false),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int, p2: Boolean) {
                            Log.d(
                                "yang",
                                "${items[p1]} 이 ${if (p2) "선택되었습니다." else "선택 해제되었습니다."}"
                            )
                        }
                    })
                setPositiveButton("닫기", null)
                show()
            }
        }
        binding.button4.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)
                setSingleChoiceItems(
                    items,
                    2,
                    object : DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            Log.d(
                                "yang",
                                "${items[p1]} 이 선택되었습니다."
                            )
                        }
                    })
                setPositiveButton("닫기", null)
                show()
            }
        }
    }
}