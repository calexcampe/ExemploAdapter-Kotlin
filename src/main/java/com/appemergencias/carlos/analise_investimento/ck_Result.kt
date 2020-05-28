package com.appemergencias.carlos.analise_investimento

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import com.appemergencias.carlos.analise_investimento.R.color.error_color_material
import com.appemergencias.carlos.analise_investimento.R.color.notification_icon_bg_color
import kotlinx.android.synthetic.main.ck_result.*

class ck_Result : AppCompatActivity() {


    private lateinit var returninvestment :String
    private var returndouble : Double = 0.0

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ResourceAsColor", "PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ck_result)

        returninvestment = intent.getStringExtra("roi");
        returndouble = returninvestment.toDouble()
        txt_return.text =(returninvestment.toString())

        if (returndouble < 0)
        {
            txt_return.setBackgroundResource(error_color_material)
        }

    }
}