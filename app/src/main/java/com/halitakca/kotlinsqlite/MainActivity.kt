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

            myDataBase.execSQL("INSERT INTO musicians (name, age) VALUES('Jamie',50)")

            val cursor = myDataBase.rawQuery("SELECT * FROM musicians",null)

            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")

            while (cursor.moveToNext()){
                println("Name: ${cursor.getString(nameIx)}")
                println("Age: ${cursor.getString(ageIx)}")
            }

            cursor.close()

        }catch (e: Exception){
            e.printStackTrace()
        }

    }
}