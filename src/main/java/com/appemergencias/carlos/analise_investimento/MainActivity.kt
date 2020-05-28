package com.appemergencias.carlos.analise_investimento

import android.content.Intent
import android.graphics.Rect
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)

    lateinit var listinv: List<List_adapter>
    var posic: Int = 0
    private lateinit var adapter: ck_adapter


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL)
        recyclerv.layoutManager = layoutManager

        adapter = ck_adapter(notes(), { partItem: List_adapter -> partItemClicked(partItem) })
        recyclerv.adapter = adapter

    }

    private fun partItemClicked(partItem: List_adapter) {

        // Launch second activity, pass roi paramater
        val newact = Intent(this, ck_Result::class.java)
        newact.putExtra("roi", partItem.roi)
        startActivity(newact)
    }

    fun notes(): List<List_adapter> {

        //function exetend list
        return listOf(

                List_adapter("My Investiments",
                        "Royal Bank of Canada", "60032346.70", "13.2"),
                List_adapter("My Investiments",
                        "Offshore - Cayman Islands", "232393256.23", "8.2"),
                List_adapter("My Investiments",
                        "Berkshire", "344643632.12", "-4.2"),
                List_adapter("My Investiments",
                        "Real Estate Holdings", "678643632.98", "-7.6"),

                List_adapter("My Investiments",
                        "Gold Bars", "219893632.76", "19.2"),
                List_adapter("My Investiments",
                        "Venture Capital Investments", "42730992.45", "16.2"),
                List_adapter("My Investiments",
                        "Stuffed Under Mattress", "509442.45", "0"),
                List_adapter("My Investiments",
                        "Mining Companies", "14502094.69", "4.1"),
                List_adapter("My Investiments",
                        "Antiquities", "254302094.69", "6.7"))

    }

}

