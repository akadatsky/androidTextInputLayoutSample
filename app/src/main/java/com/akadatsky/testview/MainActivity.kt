package com.akadatsky.testview

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<TextInputLayout>(R.id.loginLayout)
        val password = findViewById<TextInputLayout>(R.id.passwordLayout)

        fun validate() {
            login.error = if (login.editText?.text.toString().length < 5) {
                "Login should be >= 5 chars"
            } else {
                null
            }
            password.error = if (password.editText?.text.toString().length < 6) {
                "Password should be >= 6 chars"
            } else {
                null
            }
        }

        password.editText?.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    validate()
                    true
                }
                else -> false
            }
        }

    }
}