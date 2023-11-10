package com.example.guidedlab

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView

class MainClassList : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)

        val swDegreeCert = findViewById(R.id.idSwitchDegreeCert) as Switch
        val spnDegree = findViewById(R.id.idMajorSpinner) as Spinner
        val spnCertificate = findViewById(R.id.idCertSpinner) as Spinner
        val txtCertificate = findViewById(R.id.idTxtCert) as TextView
        val txtDegree = findViewById(R.id.idTxtMajor) as TextView
        val btnNext = findViewById(R.id.idBtnNext) as Button

        val firstName = findViewById(R.id.idFirNameEntry) as EditText
        val lastName = findViewById(R.id.idLastNameEntry) as EditText
        val phone = findViewById(R.id.idPhoneNumEntry) as EditText

        val spMonth = findViewById(R.id.idSpinnerMonth) as Spinner
        val txtDay = findViewById(R.id.idDayEntry) as EditText
        val txtYear = findViewById(R.id.idYearEntry) as EditText

        firstName.requestFocus()

        swDegreeCert.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                spnDegree.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE
                spnCertificate.visibility = View.GONE
                txtCertificate.visibility = View.GONE
            } else {
                spnDegree.visibility = View.GONE
                txtDegree.visibility = View.GONE
                spnCertificate.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE
            }
        }

        btnNext.setOnClickListener {
            if (checkData()) {
                var doBirth = ""
                doBirth =
                    spMonth.selectedItem.toString() + "/" + txtDay.text.toString() + "/" + txtYear.text.toString()
                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("BirthDate", doBirth)

                if (spnDegree.visibility == View.VISIBLE) {
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", spnDegree.selectedItem.toString())
                } else {
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", spnCertificate.selectedItem.toString())
                }
                startActivity(nextScreen)
            }
        }
    }
            private fun checkData(): Boolean {
                val firstName = findViewById(R.id.idFirNameEntry) as EditText
                val lastName = findViewById(R.id.idLastNameEntry) as EditText
                val phone = findViewById(R.id.idPhoneNumEntry) as EditText
                val txtDay = findViewById(R.id.idDayEntry) as EditText
                val txtYear = findViewById(R.id.idYearEntry) as EditText

                if (firstName.text.toString().isEmpty()) {
                    firstName.error = "Invalid First Name"
                    firstName.requestFocus()
                    return false
                }

                if (lastName.text.toString().isEmpty()) {
                    lastName.error = "Invalid Last Name"
                    lastName.requestFocus()
                    return false
                }

                if (phone.text.toString().isEmpty()) {
                    phone.error = "Invalid Phone Number"
                    phone.requestFocus()
                    return false
                }

                if (txtDay.text.toString().isEmpty()) {
                    txtDay.error = "Invalid Date Selection"
                    txtDay.requestFocus()
                    return false
                }

                if (txtYear.text.toString().isEmpty()) {
                    txtYear.error = "Invalid Date Selection"
                    txtYear.requestFocus()
                    return false
                }

                return true
            }
}