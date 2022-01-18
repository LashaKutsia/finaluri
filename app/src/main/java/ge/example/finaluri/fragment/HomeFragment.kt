package ge.example.finaluri.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ge.example.finaluri.R
import ge.example.finaluri.UserInfo


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var imageView: ImageView
    private lateinit var personname: EditText
    private lateinit var url: EditText
    private lateinit var click: Button
    private lateinit var text: TextView

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        imageView = view.findViewById(R.id.photo)
        personname = view.findViewById(R.id.name)
        url =view.findViewById(R.id.url)
        click = view.findViewById(R.id.click)
        text = view.findViewById(R.id.textView)

        click.setOnClickListener{
            val personName = personname.text.toString()
            val imageLink = url.text.toString()
            val infoUser = UserInfo(personName, imageLink)
            db.child(auth.currentUser?.uid!!).setValue(infoUser)
        }

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(UserInfo::class.java) ?: return

                Glide.with(this@HomeFragment)
                    .load(userInfo.url)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageView)
                text.text = userInfo.name
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }










}