package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wamiikechukwukanu.quizapp.dailyactivity.DailyActivityViewModel
import com.wamiikechukwukanu.quizapp.dailyactivity.DataModel

class DailyActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DailyActivityViewModel
    var arrayList = ArrayList<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_daily)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        arrayList.add(DataModel(R.drawable.algeria))
        arrayList.add(DataModel(R.drawable.angola))
        arrayList.add(DataModel(R.drawable.benin))
        arrayList.add(DataModel(R.drawable.botswana))
        arrayList.add(DataModel(R.drawable.burkina_faso))
        arrayList.add(DataModel(R.drawable.burundi))
        arrayList.add(DataModel(R.drawable.cameroon))
        arrayList.add(DataModel(R.drawable.cape_verde))
        arrayList.add(DataModel(R.drawable.chad))
        arrayList.add(DataModel(R.drawable.comoros))
        arrayList.add(DataModel(R.drawable.cote_d_ivoire))
        arrayList.add(DataModel(R.drawable.djibouti))
        arrayList.add(DataModel(R.drawable.egypt))
        arrayList.add(DataModel(R.drawable.eritrea))
        arrayList.add(DataModel(R.drawable.eswatini))
        arrayList.add(DataModel(R.drawable.ethiopia))
        arrayList.add(DataModel(R.drawable.gabon))
        arrayList.add(DataModel(R.drawable.gambia))
        arrayList.add(DataModel(R.drawable.ghana))
        arrayList.add(DataModel(R.drawable.guinea))
        arrayList.add(DataModel(R.drawable.guinea_bissau))
        arrayList.add(DataModel(R.drawable.kenya))
        arrayList.add(DataModel(R.drawable.lesotho))
        arrayList.add(DataModel(R.drawable.liberia))
        arrayList.add(DataModel(R.drawable.libya))
        arrayList.add(DataModel(R.drawable.madagascar))
        arrayList.add(DataModel(R.drawable.malawi))
        arrayList.add(DataModel(R.drawable.mali))
        arrayList.add(DataModel(R.drawable.mauritania))
        arrayList.add(DataModel(R.drawable.mauritius))
        arrayList.add(DataModel(R.drawable.morocco))
        arrayList.add(DataModel(R.drawable.mozambique))
        arrayList.add(DataModel(R.drawable.namibia))
        arrayList.add(DataModel(R.drawable.niger))
        arrayList.add(DataModel(R.drawable.nigeria))
        arrayList.add(DataModel(R.drawable.reunion))
        arrayList.add(DataModel(R.drawable.rwanda))
        arrayList.add(DataModel(R.drawable.senegal))
        arrayList.add(DataModel(R.drawable.seychlles))
        arrayList.add(DataModel(R.drawable.sierra_leone))
        arrayList.add(DataModel(R.drawable.somalia))
        arrayList.add(DataModel(R.drawable.south_africa))
        arrayList.add(DataModel(R.drawable.south_sudan))
        arrayList.add(DataModel(R.drawable.sudan))
        arrayList.add(DataModel(R.drawable.tanzania))
        arrayList.add(DataModel(R.drawable.togo))
        arrayList.add(DataModel(R.drawable.tunisia))
        arrayList.add(DataModel(R.drawable.uganda))
        arrayList.add(DataModel(R.drawable.zambia))
        arrayList.add(DataModel(R.drawable.zimbabwe))


        adapter = DailyActivityViewModel(this, arrayList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


    }
}