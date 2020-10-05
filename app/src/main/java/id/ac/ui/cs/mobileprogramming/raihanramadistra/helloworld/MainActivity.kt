package id.ac.ui.cs.mobileprogramming.raihanramadistra.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.fixedRateTimer


enum class StopwatchState {
    STOP,
    START,
    PAUSE
}

class MainActivity : AppCompatActivity() {
    var state = StopwatchState.STOP
    var milliseconds = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fixedRateTimer("timer", false, 0L, 100) {
            if (state == StopwatchState.START) {
                milliseconds += 100
            }
            updateUI()
        }

        button1.setOnClickListener {
            when (state) {
                StopwatchState.STOP -> start()
                StopwatchState.PAUSE -> start()
                StopwatchState.START -> pause()
            }
        }

        button2.setOnClickListener {
            stop()
        }
    }

    private fun updateUI() {
        val seconds = milliseconds / 1000
        val h = seconds / 3600
        val m = seconds % 3600 / 60
        val s = seconds % 60

        this@MainActivity.runOnUiThread {
            time.text = String.format(Locale.getDefault(), "%d:%02d:%02d", h, m, s)
        }
    }

    private fun start() {
        button1.text = "PAUSE"
        state = StopwatchState.START
    }

    private fun pause() {
        button1.text = "START"
        state = StopwatchState.PAUSE
    }

    private fun stop() {
        state = StopwatchState.STOP
        button1.text = "START"
        milliseconds = 0
    }

    override fun onBackPressed() {
        when (state) {
            StopwatchState.STOP -> super.onBackPressed()
            StopwatchState.PAUSE -> stop()
            StopwatchState.START -> pause()
        }
    }
}