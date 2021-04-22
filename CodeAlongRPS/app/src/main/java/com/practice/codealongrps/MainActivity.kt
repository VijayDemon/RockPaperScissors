package com.practice.codealongrps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.practice.codealongrps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private  enum class  option (selected :Int){
        ROCK(1),
        PAPER(2),
        SCISSORS(3)
    }
    private  var yourSelection = option.ROCK
    private var computerSelection =option.ROCK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_main)

        // Impelement Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //        Steps to follow
        // 1 . get user input
        // 2. change the image to user select
        // 3.  get random class
        // 4 . get computer input , show the computer randomly generated
        // 5. result


        //  Step -1 and Step -2
        binding.rockButton.setOnClickListener {
            Log.v("Click","Rock")
            binding.playerSelection.setImageDrawable(getDrawable(R.drawable.sheriffrock))
            yourSelection = option.ROCK
            randamizer()
            compare()
        }
        binding.paperButton.setOnClickListener {
            Log.v("Click","Paper")
            binding.playerSelection.setImageDrawable(getDrawable(R.drawable.sheriffpaper))
            yourSelection =option.PAPER
            randamizer()
            compare()
         }
        binding.scissorButton.setOnClickListener {
            Log.v("Click","Scissor")
            binding.playerSelection.setImageDrawable(getDrawable(R.drawable.sheriffscissors))
            yourSelection =option.SCISSORS
            randamizer()
            compare()
        }


    }
    // Step -4 and Step -5
    private fun compare() :Int{
        if ( yourSelection  ==  computerSelection){
            binding .textView.text ="Draw"
            return 1
        }  else if (yourSelection == option.ROCK){
            if(computerSelection  ==  option.PAPER){
                binding.textView.text="Computer Win"
                return 1
            }
        } else if (yourSelection == option.PAPER){
            if(computerSelection == option.SCISSORS){
                 binding.textView.text="Computer Win"
                return 1
            }
        } else if (yourSelection == option.SCISSORS) {
            if (computerSelection == option.ROCK) {
                binding.textView.text = "Computer Win"
                return 1
            }
        }
        binding.textView.text = "YouWin"
        return 1
    }


    // Step -3
    private  fun  randamizer(){

        when ((1..3).shuffled().last()){
            1 ->
            {
                computerSelection = option.ROCK
                binding.computerSeletion.setImageDrawable(getDrawable(R.drawable.outlawrock))
            }
            2->
            {
                computerSelection = option.PAPER
                binding.computerSeletion.setImageDrawable(getDrawable(R.drawable.outlawpaper))
            }
            else ->{
                computerSelection =option.SCISSORS
                binding.computerSeletion.setImageDrawable(getDrawable(R.drawable.outlawscissors))

            }
        }
    }

    }
