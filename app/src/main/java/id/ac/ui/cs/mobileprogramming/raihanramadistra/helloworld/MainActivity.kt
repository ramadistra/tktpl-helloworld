package id.ac.ui.cs.mobileprogramming.raihanramadistra.helloworld

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private val model: CoursesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, CourseListFragment()).commit()

        model.course.observe(this, Observer<Course?>{ course ->
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment,
                    if (course == null) CourseListFragment() else CourseDetailFragment())
                .commit()
        })
    }

    override fun onBackPressed() {
        if (model.course.value == null) {
            super.onBackPressed()
        } else {
            model.course.value = null
        }
    }
}