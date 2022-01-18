package ge.example.finaluri

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var editTextNewPassword: EditText
    private lateinit var buttonChangePassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        init()

        registerListener()
    }
    private fun init() {
        editTextNewPassword = findViewById(R.id.editTextNewPassword)
        buttonChangePassword = findViewById(R.id.buttonChangePassword)
    }
    private fun registerListener(){
        buttonChangePassword.setOnClickListener {
            val newPassword = editTextNewPassword.text.toString()
            if (newPassword.isEmpty() || newPassword.length < 7) {
                Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)?.addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }
}