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

            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY, name VARCHAR, age INT)")

            //myDataBase.execSQL("INSERT INTO musicians (name, age) VALUES('Jamie',50)")
            //myDataBase.execSQL("INSERT INTO musicians (name, age) VALUES('Lars',65)")
            //myDataBase.execSQL("INSERT INTO musicians (name, age) VALUES('Kirk',35)")

            //val cursor = myDataBase.rawQuery("SELECT * FROM musicians WHERE id = 3 ",null)
            val cursor = myDataBase.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s' ",null)

            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")
            val idIx = cursor.getColumnIndex("id")

            while (cursor.moveToNext()){
                println("Id: ${cursor.getString(idIx)}")
                println("Name: ${cursor.getString(nameIx)}")
                println("Age: ${cursor.getString(ageIx)}")
            }

            cursor.close()

        }catch (e: Exception){
            e.printStackTrace()
        }

    }
}