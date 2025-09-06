package com.example.dicerollerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dicerollerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val scale = resources.displayMetrics.density
            val desiredPx = (16 * scale + 0.5f).toInt()
            v.setPadding(systemBars.left + desiredPx,
                systemBars.top + desiredPx,
                systemBars.right + desiredPx,
                systemBars.bottom + desiredPx)
            insets
        }

        binding.RollBtn.setOnClickListener {
            rollTwoDices()
        }
    }

    private fun getRandomNumber(): Int = (1..6).random()

    private fun rollDice(@IdRes id : Int){
        val randomNumber = getRandomNumber()
        val randomDice = when(randomNumber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        when(id){
            R.id.image_1_iv -> binding.image1Iv.setImageResource(randomDice)
            else -> binding.image2Iv.setImageResource(randomDice)
        }
    }

    private fun rollTwoDices(){
        rollDice(R.id.image_1_iv)
        rollDice(R.id.image_2_iv)
    }
}