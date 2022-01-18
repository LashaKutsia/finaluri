package ge.example.finaluri.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ge.example.finaluri.Person
import ge.example.finaluri.RecycleViewPersonAdapter
import ge.example.finaluri.R

class DashboardFragment: Fragment(R.layout.fragment_dashboard) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recycleViewPersonAdapter: RecycleViewPersonAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recycleViewPersonAdapter = RecycleViewPersonAdapter(getData())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = recycleViewPersonAdapter

    }

    private fun getData(): List<Person> {
        val personList = ArrayList<Person>()
        personList.add(
            Person(
                1,
                "https://images.eurooptic.com/images/products/benelli/8/benelli-828u-sport-12ga-aa-satin-walnut-blue-30-shotgun-10730.jpg",
                "Benelli 828 U Sport",
                "ფასი: 4000$"

            )
        )
        personList.add(
            Person(
                1,
                "https://palmettostatearmory.com/media/catalog/product/b/e/benelli-sbe3-blacksynthetic_3.jpg",
                "Benelli Super Black Eagle 3",
                "ფასი: 4000$"

            )
        )
        personList.add(
            Person(
                1,
                "https://static.my.ge/mymarket/photos/large/1207/18596472_1.jpg?v=0",
                "Browning Maxus Ultimate Ducks",
                "ფასი: 4000$"

            )
        )
        personList.add(
            Person(
                1,
                "https://korgan.kz/uploads/products/f92073.jpg",
                "Sako 85 Carbon Wolf",
                "ფასი: 4000$"

            )
        )
        personList.add(
            Person(
                1,
                "https://static.wikia.nocookie.net/modernwar/images/1/15/SVD.jpg/revision/latest?cb=20100611064936",
                "Snayperskaya Vintovka Dragunova",
                "ფასი: 4000$"

            )
        )
        personList.add(
            Person(
                1,
                "https://ammoterra.com/system/images/images/000/035/662/original/542bb30d8f9cd_5eb42cc1af746.jpg?1615453747",
                "Blaser R93 Attache",
                "ფასი: 4000$"

            )
        )
        personList.add(
            Person(
                1,
                "https://i0.wp.com/www.kellysonline.ca/wp-content/uploads/Class-SL.jpg?fit=800%2C600&ssl=1",
                "Fausti Class SL O/U",
                "ფასი: 4000$"

            )
        )
        personList.add(
            Person(
                1,
                "https://s7d2.scene7.com/is/image/CabelasCA/149428-212081?wid=460&hei=460",
                "Franchi Instict SL-12",
                "ფასი: 4000$"

            )
        )



        return personList
    }
}