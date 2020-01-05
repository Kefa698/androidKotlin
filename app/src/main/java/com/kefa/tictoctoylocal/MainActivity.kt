package com.kefa.tictoctoylocal

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buclick(view: View) {
        val buSelected = view as Button
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
        //  Toast.makeText(this, "ID:" + cellId, Toast.LENGTH_SHORT).show()
        PlayGame(cellId, buSelected)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var Activeplayer=1

    fun PlayGame(cellId:Int,buselected: Button){

         if (Activeplayer==1){
            buselected.text = "X"
             buselected.setBackgroundResource(R.color.deep_pink)
             player1.add(cellId)
             Activeplayer=2
             Autoplay()
        }else{
             buselected.text = "0"
             buselected.setBackgroundResource(R.color.goldenrod)
             player2.add(cellId)
             Activeplayer=1
         }

        buselected.isEnabled=false
        CheckWinner()

    }

    fun CheckWinner() {
        var Winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            Winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            Winner = 2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            Winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            Winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            Winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            Winner = 2
        }
        //col
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            Winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            Winner = 2
        }
        //col2
        //row 1
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            Winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            Winner = 2
        }
        //col3
        //row 1
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            Winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            Winner = 2
        }
        if (Winner != -1) {
            if (Winner == 1) {
                Toast.makeText(this, "Player1 won the game", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Player2 won the game", Toast.LENGTH_SHORT).show()
            }

        }

    }

    //to play automatically
    fun Autoplay() {
        var emptyCell = ArrayList<Int>()
        //using for loop
        for (cellID in 1..9) {
            if (!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCell.add(cellID)
            }
        }
        val r = java.util.Random()
        val randIndex = r.nextInt(emptyCell.size - 0) + 0
        val cellId = emptyCell.get(randIndex)
        var buselect: Button?
        when (cellId) {
            1 -> buselect = bu1
            2 -> buselect = bu2
            3 -> buselect = bu3
            4 -> buselect = bu4
            5 -> buselect = bu5
            6 -> buselect = bu6
            7 -> buselect = bu7
            8 -> buselect = bu8
            9 -> buselect = bu9
            else -> {
                buselect = bu1
            }


        }
        PlayGame(cellId, buselect)

    }
}
