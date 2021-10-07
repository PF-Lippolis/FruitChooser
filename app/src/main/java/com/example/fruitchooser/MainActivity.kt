package com.example.fruitchooser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.fruitchooser.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val fruitArray = listOf(
        R.drawable.apple,
        R.drawable.bananas,
        R.drawable.cherries,
        R.drawable.grapes,
        R.drawable.orange,
        R.drawable.strawberry,
        R.drawable.watermelon)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButton()
    }

    private fun setupButton() {
        binding.button.setOnClickListener {
            val fruitSelection = Random.nextInt(fruitArray.size)
            binding.image.visibility = View.INVISIBLE
            binding.progressCircle.visibility = View.VISIBLE
            binding.description.text = getString(R.string.loading_string)
            binding.image.setImageResource(fruitArray[fruitSelection])
            Handler(Looper.getMainLooper()).postDelayed({
                binding.progressCircle.visibility = View.GONE
                binding.image.visibility = View.VISIBLE
                binding.description.text = getString(R.string.inviting_message)
            }, 3000)
        }
    }
}