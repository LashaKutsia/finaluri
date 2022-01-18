package ge.example.finaluri
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {




    private lateinit var buttonLogout : Button
    private lateinit var buttonPasswordChange : Button
    private lateinit var buttonstart : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        init()

        registrationListeners()


    }

    private fun init(){
        buttonLogout = findViewById(R.id.buttonLogout)
        buttonPasswordChange = findViewById(R.id.buttonPasswordChange)
        buttonstart = findViewById(R.id.buttonstart)
    }


    private fun registrationListeners(){
        buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))


        }
        buttonPasswordChange.setOnClickListener {
            val intent = Intent(this, PasswordResetActivity::class.java)
            startActivity(intent)
        }

        buttonstart.setOnClickListener(){
            startActivity(Intent(this, Navbar::class.java))
            finish()
        }

        buttonLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("გასვლა")
                .setMessage("ნამდვილად გსურთ გასვლა")
                .setPositiveButton("დიახ"){ dialog, i ->
                    Toast.makeText(this, "თქვენ გსურთ გასვლა", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    dialog.dismiss()

                }
                .setNegativeButton("არა") { dialog, i ->
                    Toast.makeText(this, "გსურთ რომ დარჩეთ აქტიური", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .setNeutralButton("მოვიფიქრებ") { dialog, i ->
                    Toast.makeText(this, "მოიფიქრეთ", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .show().setCanceledOnTouchOutside(false)
        }

    }

}