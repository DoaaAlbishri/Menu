package com.example.menu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //get data from intent
        val intent = intent
        val name = intent.getStringExtra("Name")
        val location = intent.getStringExtra("Location")
        val mobile = intent.getStringExtra("Mobile")

        //textview
        val resultTv = findViewById<TextView>(R.id.textView2)
        //setText
        resultTv.text = "Name: "+name+"\nLocation: "+location+"\nMobile: "+mobile

        resultTv.setOnClickListener {
            endAlert()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        val item2: MenuItem = menu!!.getItem(1)
        item2.setVisible(false)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m1 -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun endAlert(){
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // here we set the message of our alert dialog
        dialogBuilder.setMessage("Thank you")
            // negative button text and action
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Text view")
        // show alert dialog
        alert.show()
    }

}