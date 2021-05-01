//명현 firebase 실험
package org.tensorflow.lite.examples.posenet

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.tensorflow.lite.examples.posenet.Extensions.toast
import org.tensorflow.lite.examples.posenet.FirebaseUtils.firebaseAuth


class LoginActivity : AppCompatActivity() {
    lateinit var signInEmail: String
    lateinit var signInPassword: String
    lateinit var signInInputsArray: Array<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signInInputsArray = arrayOf(etSignInEmail, etSignInPassword)
        btnCreateAccount2.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        btnSignIn.setOnClickListener {
            signInUser()
        }
    }

    private fun notEmpty(): Boolean = signInEmail.isNotEmpty() && signInPassword.isNotEmpty()

    private fun signInUser() {
        signInEmail = etSignInEmail.text.toString().trim()
        signInPassword = etSignInPassword.text.toString().trim()

        if (notEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(signInEmail, signInPassword)
                .addOnCompleteListener { login ->
                    if (login.isSuccessful) {
                        startActivity(Intent(this, LogoutActivity::class.java))
                        toast("로그인 성공")
                        finish()
                    } else {
                        toast("로그인 실패")
                    }
                }
        } else {
            signInInputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} 이(가) 필요합니다."
                }
            }
        }
    }
}