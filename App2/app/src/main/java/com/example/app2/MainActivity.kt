package com.example.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import kotlin.math.round
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private var dataModel: ArrayList<ShopItem>? = null
    private lateinit var adapter: CustomAdapter
    private var totalPrice: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<View>(R.id.itemsList) as ListView

        var items = arrayOf(
            ShopItem("Arroz 5kg", 36.30, false),
            ShopItem("Leite longa vida", 8.75, false),
            ShopItem("Carne Picanha", 76.78, false),
            ShopItem("Feijão carioquinha", 9.38, false),
            ShopItem("Refrigerante coca-cola", 12.00, false),
        )

        dataModel = ArrayList<ShopItem>()

        for (item in items) {
            dataModel!!.add(item)
        }

        adapter = CustomAdapter(dataModel!!, applicationContext)
        listView.adapter = adapter



        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            var dataModel: ShopItem = dataModel!![position] as ShopItem
            dataModel.checked = !dataModel.checked


            if (dataModel.checked) {
                totalPrice += dataModel.value
            } else {
                totalPrice -= dataModel.value
            }

            var totalPriceView = findViewById<TextView>(R.id.totalPriceView)
            totalPriceView.text = "Total Price: ${String.format("%.2f", totalPrice)}"

            adapter.notifyDataSetChanged()
        }

}
}