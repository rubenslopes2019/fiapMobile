package br.com.rubens.pingpong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var homeScore = 0
    private var awayScore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resetGame()
        setUpView()

        if(savedInstanceState != null){
            homeScore = savedInstanceState.getInt("HOME_SCORE")
            awayScore = savedInstanceState.getInt("AWAY_SCORE")
            tvHomeScore.text = homeScore.toString()
            tvAwayName.text = awayScore.toString()

        }
    }

    private fun setUpView() {
        tvHomeName.text = intent.getStringExtra( "HOME_NAME")
        tvHomeName.text = intent.getStringExtra("AWAY_NAME")
        setUpListener()

    }

    private fun setUpListener() {
        btHomeScore.setOnClickListener {
            homeScore++
            tvHomeScore.text = homeScore.toString()
        }


        btAwayScore.setOnClickListener {
            awayScore++
            tvAwayName.text = awayScore.toString()
        }
    }

    private fun resetGame(){
        homeScore = 0
        awayScore = 0
        tvHomeScore.text = homeScore.toString()
        tvAwayName.text = awayScore.toString()


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("HOME_NAME", homeScore)
        outState.putInt("AWAY_NAME", awayScore)

    }
}