package panjaitan.rizky.app.football

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import panjaitan.rizky.app.football.adapter.RecyclerViewAdapter

private var items: MutableList<Item> = mutableListOf()

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }


    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices){
            items.add(Item(name[i],
                    image.getResourceId(i, 0)))
        }
        image.recycle()
    }

}
