package ge.example.finaluri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecycleViewPersonAdapter(private val list: List<Person>) :
    RecyclerView.Adapter<RecycleViewPersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView
        val textView: TextView
        val textView2: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView)
            textView2 = itemView.findViewById(R.id.textView2)

            itemView.setOnClickListener{
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,"კარგი არჩევანია# ${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }

        fun setData(person: Person) {
            Glide.with(itemView)
                .load(person.imageUrl)
                .into(imageView)

            textView.text = person.title
            textView2.text = person.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): PersonViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, ) {
        val person = list[position]
        holder.setData(person)
    }

    override fun getItemCount() = list.size




}