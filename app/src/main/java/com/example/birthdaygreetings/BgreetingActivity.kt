package com.example.birthdaygreetings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bgreeting.*

class BgreetingActivity : AppCompatActivity() {

    companion object{
        const val NAME_EXTRA= "name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bgreeting)

        val name= intent.getStringExtra(NAME_EXTRA)

        birthdayGreeting.text= "Happy Birthday \n$name !"
    }
}