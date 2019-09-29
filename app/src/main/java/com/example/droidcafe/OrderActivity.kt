package com.example.droidcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
        val message: String = adapterView?.getItemAtPosition(i).toString()
        displayToast(message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val order = findViewById<TextView>(R.id.text_order)
        val banya = intent.getIntExtra("banyak",0)
        var temp = intent.getStringExtra("order")
        order.setText(temp)
        if (label_spinner != null){
            label_spinner.onItemSelectedListener = this
        }
        //Membuat arrayadapter menggunakan array string dan layout spinner standar
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.labels_array,android.R.layout.simple_spinner_item)
        //Tentukan layout yang digunakan ketika list tampil
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (label_spinner != null){
            label_spinner.adapter = adapter
        }

    }
    fun onRadioButtonClicked (view: View){
        when(view.id){
            R.id.sameday -> if(sameday.isChecked)
                displayToast(getString(R.string.sameday_message))
            R.id.nextday -> if(nextday.isChecked)
                displayToast(getString(R.string.nextday_message))
            R.id.pickup -> if(pickup.isChecked)
                displayToast(getString(R.string.pickup_message))
        }
    }
    fun halamanlain (view: View) {
        val inten = Intent (this, halaman_profil::class.java)
        startActivity(inten)
    }
    private fun displayToast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_LONG).show()
    }
}
