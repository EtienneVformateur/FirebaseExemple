package re.etienne.firebaseexemple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        val bt = findViewById<Button>(R.id.button)
        val user = findViewById<EditText>(R.id.user)
        val pwd = findViewById<EditText>(R.id.pwd)

        bt.text = "S'inscrire"
        bt.setOnClickListener {
            val email = user.text.toString()
            val password = pwd.text.toString()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "Enregistrement Ok.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            baseContext, "Erreur.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        }
    }
}