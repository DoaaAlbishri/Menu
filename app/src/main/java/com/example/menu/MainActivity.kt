package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
lateinit var ETname : EditText
lateinit var ETlocation : EditText
lateinit var ETmobile : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnToast = findViewById<Button>(R.id.button)
        var btnTv = findViewById<Button>(R.id.button2)

        ETname = findViewById<EditText>(R.id.name)
        ETlocation = findViewById<EditText>(R.id.location)
        ETmobile = findViewById<EditText>(R.id.mobile)

        var Tv = findViewById<TextView>(R.id.textView)

        btnToast.setOnClickListener {
            var name = ETname.text.toString()
            var location = ETlocation.text.toString()
            var mobile = ETmobile.text.toString()
            val toast = Toast.makeText(applicationContext, "name:${name}\nlocation:${location} \nmobile:${mobile}", Toast.LENGTH_LONG)
            toast.show()
        }

        btnTv.setOnClickListener {
            var name = ETname.text.toString()
            var location = ETlocation.text.toString()
            var mobile = ETmobile.text.toString()
            Tv.setText("name:${name}\nlocation:${location}\nmobile:${mobile}")
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        val item1: MenuItem = menu!!.getItem(0)
        item1.setVisible(false)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m2 -> {
                val intent = Intent(this, MainActivity2::class.java)
                val name = ETname.text.toString()
                val location = ETlocation.text.toString()
                val mobile = ETmobile.text.toString()
                intent.putExtra("Name", name)
                intent.putExtra("Location", location)
                intent.putExtra("Mobile", mobile)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

