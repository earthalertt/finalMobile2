package com.example.finalmobile2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var dbHandler:DatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHandler(this)

        button_save.setOnClickListener(View.OnClickListener {

            if (validaton()){
                val user: Users = Users()
                var success: Boolean = false
                user.firstName = editText_firstName.text.toString()
                user.lastName = editText_lastName.text.toString()

                success = dbHandler!!.addUser(user)

                if (success){
                    val toast = Toast.makeText(this,"Saved Successfully", Toast.LENGTH_LONG).show()
                }
            }
        })


    }
}
