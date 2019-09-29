package com.example.droidcafe

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*

class Alert : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
    }
    fun onClickAlert(view: View){
        val alertBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Alert")
        alertBuilder.setMessage("Click Ok to continue, or Cancel to stop")

        alertBuilder.setPositiveButton("Ok"){
                dialogInterface, i ->
            Toast.makeText(applicationContext,"Press Ok", Toast.LENGTH_LONG).show()
        }
        alertBuilder.setNegativeButton("Cancel"){
                dialogInterface, i ->
            Toast.makeText(applicationContext,"Press Cancel", Toast.LENGTH_LONG).show()
        }
        alertBuilder.show()
    }


}
