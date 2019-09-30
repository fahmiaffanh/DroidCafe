package com.example.droidcafe

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pesan:String =""
    var jumlah = Array(3){0}
    var mess = arrayOf("","","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            val intent = Intent (this, OrderActivity::class.java)
            for (i in 0..2){
                if (jumlah[i]>0){
                    pesan += mess[i]+" x ${jumlah[i]}\n"
                }
            }
            intent.putExtra("order",pesan)
            intent.putExtra("banyak",jumlah[0])
            startActivity(intent)
        }
    }




    private fun displayToast (message: String,n: Int){

        if (jumlah[n]==0){
            mess[n]+=message
        }
        jumlah[n]+=1
        Toast.makeText(applicationContext,message+"x ${jumlah[n]}", Toast.LENGTH_LONG).show()
    }
    fun showdonutmess(view: View){
        displayToast(getString(R.string.donut_order_message),0)
    }
    fun showfroyomess(view: View){
        displayToast(getString(R.string.froyo_order_message),1)
    }
    fun showicecreammess(view: View){
        displayToast(getString(R.string.ice_cream_order_message),2)
    }
    fun halamanalert (view: View){
        val intent_alert = Intent (this, Alert::class.java)

        startActivity(intent_alert)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_order -> {
                startActivity(Intent(this,OrderActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
