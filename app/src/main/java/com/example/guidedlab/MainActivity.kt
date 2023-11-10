package com.example.guidedlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intVal: Int) {
            login(1),
            password(2),
            success(0)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.idUsernameEntry)
        val txtPassword = findViewById<TextView>(R.id.idPasswordEntry)
        val btnLogin = findViewById<Button>(R.id.idBtn)

        btnLogin.setOnClickListener {
            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())){
                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword), Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }
                else -> {
                    btnLogin.setOnClickListener {
                        val intent = Intent(this,MainClassList::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Kaitlyn"
        val holdPass = "password"

        return if (txtLogin != holdLogin) {
            LoginSuccess.login
        }else if (txtPassword != holdPass) {
            LoginSuccess.password
        }else {
            LoginSuccess.success
        }
    }
}