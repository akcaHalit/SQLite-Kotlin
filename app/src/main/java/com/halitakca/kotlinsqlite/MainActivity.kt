package com.halitakca.kotlinsqlite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try{

            val myDataBase = this.openOrCreateDatabase("Musicians",Context.MODE_PRIVATE,null)

            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS musicians(name VARCHAR, age INT)")


        }catch (e: Exception){
            e.printStackTrace()
        }

    }
}