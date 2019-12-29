package com.kefa.tictoctoylocal

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    protected fun buclick(view: View) {
        val buSelected:Button = view as Button
        var cellId = 0
        when (buSelected.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
        Toast.makeText(this, "ID:" + cellId, Toast.LENGTH_LONG).show()
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var Activeplayer=1

    fun PlayGame(cellId:Int,buselected: Button){

         if (Activeplayer==1){
            buselected.text = "X"
            buselected.setBackgroundColor(Color.GREEN)
             player1.add(cellId)
             Activeplayer=2
        }else{
             buselected.text = "0"
             buselected.setBackgroundColor(Color.BLUE)
             player2.add(cellId)
             Activeplayer=1
         }

        buselected.isEnabled=false
    }
}
