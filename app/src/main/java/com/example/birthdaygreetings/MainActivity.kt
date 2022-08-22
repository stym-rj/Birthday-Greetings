package com.example.birthdaygreetings

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val imageView:ImageView by lazy{
        findViewById(R.id.chosenImgPreview)
    }

    private val selectPictureLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){
        imageView.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);         //this line is to disable dark mode.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.chooseImageBtn).setOnClickListener {


            selectPictureLauncher.launch("image/*")
        }

    }



    fun createBirthdayCard(view: View) {

        val name = nameInput.editableText.toString()
        Toast.makeText(this, "Creating Card for $name", Toast.LENGTH_LONG).show()

        val intent= Intent(this, BgreetingActivity::class.java)
        intent.putExtra(BgreetingActivity.NAME_EXTRA, name)
        startActivity(intent)
    }
}