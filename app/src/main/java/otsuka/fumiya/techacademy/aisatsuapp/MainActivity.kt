package otsuka.fumiya.techacademy.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタン押下時の処理をセット
        aisatsuButton.setOnClickListener{
            //タイマーを表示する
            showTimePickerDialog()
        }
    }

    //タイマー表示メソッド
    private fun showTimePickerDialog(){

        //現在時刻の取得 ※9時間ずれるからなし
//        var calendar = Calendar.getInstance()
//        val nowHour = calendar.get(Calendar.HOUR_OF_DAY)
//        val nowMinute = calendar.get(Calendar.MINUTE)
//        Log.d("UI_PARTS","$nowHour:$nowMinute")

        //タイマーの表示
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                aisatsuSet(hour)
                Log.d("UI_PARTS","$hour:$minute")
            },0,0,true
        )
        timePickerDialog.show()
    }

    private fun aisatsuSet(hour:Int) {
        if (2 <= hour && hour < 10) {
            aisatsuTxt.text = "おはよう"
            Log.d("UI_PARTS", "おはよう")

        }else if (10 <= hour && hour < 18) {
            aisatsuTxt.text = "こんちには"
            Log.d("UI_PARTS", "こんにちは")

        }else if ( (18<= hour && hour <= 23) || (0<= hour && hour <2) ){
            aisatsuTxt.text = "こんばんは"
            Log.d("UI_PARTS", "こんばんは")

        }else{
            aisatsuTxt.text = "もう一度選択してください"
            Log.d("UI_PARTS", "エラー")
        }

    }

}
