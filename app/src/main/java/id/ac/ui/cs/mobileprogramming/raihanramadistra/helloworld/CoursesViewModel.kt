package id.ac.ui.cs.mobileprogramming.raihanramadistra.helloworld

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoursesViewModel : ViewModel() {
    val course = MutableLiveData<Course>()

    fun toggleEnrollment() {
        course.value?.let {
            it.enrolled = !it.enrolled
        }
        course.value = course.value
    }
}