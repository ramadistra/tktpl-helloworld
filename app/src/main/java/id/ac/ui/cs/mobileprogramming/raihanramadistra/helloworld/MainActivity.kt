package id.ac.ui.cs.mobileprogramming.raihanramadistra.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val counter = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count.text = counter.value.toString()

        plusButton.setOnClickListener {
            counter.increment()
            count.text = counter.value.toString()
        }

        minusButton.setOnClickListener {
            counter.decrement()
            count.text = counter.value.toString()
        }
    }
}