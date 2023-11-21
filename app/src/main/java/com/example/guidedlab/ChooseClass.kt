package com.example.guidedlab

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class ChooseClass : AppCompatActivity() {

    private var firstName: String? = ""
    private var lastName: String? = ""
    private var phone: String? = ""
    private var birthDate: String? = ""
    private var isDegreeCert: String? = ""
    private var degreeCertification: String? = ""

    private var ctv1: CheckedTextView? = null
    private var ctv2: CheckedTextView? = null
    private var ctv3: CheckedTextView? = null
    private var ctv4: CheckedTextView? = null

    private var rb1: RadioButton? = null
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var rb4: RadioButton? = null
    private var rb5: RadioButton? = null
    private var rb6: RadioButton? = null
    private var rb7: RadioButton? = null
    private var rb8: RadioButton? = null

    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var rg3: RadioGroup? = null
    private var rg4: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_class)


        ctv1 = findViewById(R.id.idctv)
        ctv2 = findViewById(R.id.idctv2)
        ctv3 = findViewById(R.id.idctv3)
        ctv4 = findViewById(R.id.idctv4)

        rb1 = findViewById(R.id.idRB1)
        rb2 = findViewById(R.id.idRB2)
        rb3 = findViewById(R.id.idRB3)
        rb4 = findViewById(R.id.idRB4)
        rb5 = findViewById(R.id.idRB5)
        rb6 = findViewById(R.id.idRB6)
        rb7 = findViewById(R.id.idRB7)
        rb8 = findViewById(R.id.idRB8)

        val btnNext = findViewById<Button>(R.id.idBtnNext2)
        val extras = intent.extras
        if (extras != null) {
            firstName = extras.getString("FirstName")
            lastName = extras.getString("LastName")
            phone = extras.getString("Phone")
            birthDate = extras.getString("BirthDate")
            isDegreeCert = extras.getString("isDegreeCert")
            degreeCertification = extras.getString("degreeCert")
        }

        btnNext.setOnClickListener {
            var radioButton: RadioButton
            var ctv1Text = ""
            var ctv2Text = ""
            var ctv3Text = ""
            var ctv4Text = ""

            var radio1Txt = ""
            var radio2Txt = ""
            var radio3Txt = ""
            var radio4Txt = ""

            rg1 = findViewById(R.id.radioGroup)
            rg2 = findViewById(R.id.radioGroup2)
            rg3 = findViewById(R.id.radioGroup3)
            rg4 = findViewById(R.id.radioGroup4)

            var selectedTime1 = 0
            var selectedTime2 = 0
            var selectedTime3 = 0
            var selectedTime4 = 0

            if (ctv1!!.isChecked) {
                ctv1Text = ctv1!!.text.toString()
                selectedTime1 = rg1!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime1)
                radio1Txt = radioButton.text.toString()
            }
            if (ctv2!!.isChecked) {
                ctv2Text = ctv2!!.text.toString()
                selectedTime2 = rg2!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime2)
                radio2Txt = radioButton.text.toString()
            }
            if (ctv3!!.isChecked) {
                ctv3Text = ctv3!!.text.toString()
                selectedTime3 = rg3!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime3)
                radio3Txt = radioButton.text.toString()
            }
            if (ctv4!!.isChecked) {
                ctv4Text = ctv4!!.text.toString()
                selectedTime4 = rg4!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime4)
                radio4Txt = radioButton.text.toString()
            }

            if (radioCheck(selectedTime1, selectedTime2, selectedTime3, selectedTime4)) {
                val nextScren2 = Intent(this@ChooseClass, Summary::class.java).apply {
                    putExtra("FirstName", firstName)
                    putExtra("LastName", lastName)
                    putExtra("Phone", phone)
                    putExtra("BirthDate", birthDate)
                    putExtra("isDegreeCert", isDegreeCert)
                    putExtra("degreeCert", degreeCertification)
                    putExtra("Class1", ctv1Text)
                    putExtra("Selected1", radio1Txt)
                    putExtra("Class2", ctv2Text)
                    putExtra("Selected2", radio2Txt)
                    putExtra("Class3", ctv3Text)
                    putExtra("Selected3", radio3Txt)
                    putExtra("Class4", ctv4Text)
                    putExtra("Selected4", radio4Txt)
                }

                startActivity(nextScren2)

            } else {
                Toast.makeText(applicationContext, "Time Slot Conflict", Toast.LENGTH_LONG).show()
            }
        }
        rb1!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb2!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb3!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb4!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb5!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb6!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb7!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb8!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        ctv1!!.setOnClickListener{
            if (ctv1!!.isChecked)
                enableDisable(ctv1, rb1, rb2, Color.WHITE, false)
            else {
                enableDisable(ctv1, rb1, rb2, Color.GRAY, true)
                rb1!!.isChecked = true
            }
        }
        ctv2!!.setOnClickListener{
            if (ctv2!!.isChecked)
                enableDisable(ctv2, rb3, rb4, Color.WHITE, false)
            else {
                enableDisable(ctv2, rb3, rb4, Color.GRAY, true)
                rb3!!.isChecked = true
            }
        }
        ctv3!!.setOnClickListener{
            if (ctv3!!.isChecked)
                enableDisable(ctv3, rb5, rb6, Color.WHITE, false)
            else {
                enableDisable(ctv3, rb5, rb6, Color.GRAY, true)
                rb5!!.isChecked = true
            }
        }
        ctv4!!.setOnClickListener{
            if (ctv4!!.isChecked)
                enableDisable(ctv4, rb7, rb8, Color.WHITE, false)
            else {
                enableDisable(ctv4, rb7, rb8, Color.GRAY, true)
                rb7!!.isChecked = true
            }
        }

    }

    fun enableDisable(ctv: CheckedTextView?, rb1: RadioButton?, rb2: RadioButton?, bgcolor: Int?, state: Boolean?) {
        ctv!!.isChecked = state!!
        ctv.setBackgroundColor(bgcolor!!)
        rb1!!.isEnabled = state
        rb2!!.isEnabled = state

        rb2.isChecked = state

        if (!state) {
            rb1.isChecked = state
            rb2.isChecked = state
        }

    }

    fun radioCheck(selectedTime1: Int, selectedTime2: Int, selectedTime3: Int, selectedTime4: Int): Boolean {
        if (selectedTime1 == R.id.idRB2 && selectedTime4 == R.id.idRB7) {
            rb2!!.error = "Time Slot Conflict"
            rb7!!.error = "Time Slot Conflict"
            return false
        }
        if (selectedTime1 == R.id.idRB1 && selectedTime2 == R.id.idRB3) {
            rb1!!.error = "Time Slot Conflict"
            rb3!!.error = "Time Slot Conflict"
            return false
        }
        if (selectedTime3 == R.id.idRB5 && selectedTime4 == R.id.idRB8) {
            rb5!!.error = "Time Slot Conflict"
            rb8!!.error = "Time Slot Conflict"
            return false
        }


        return true
    }

}