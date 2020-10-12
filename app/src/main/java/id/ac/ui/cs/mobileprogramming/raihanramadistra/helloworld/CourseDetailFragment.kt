package id.ac.ui.cs.mobileprogramming.raihanramadistra.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.course_detail_fragment.view.*

class CourseDetailFragment : Fragment() {
    private val model: CoursesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.course_detail_fragment, container, false)

        model.course.observe(viewLifecycleOwner, Observer<Course?> {
            it?.let {
                view.courseName.text = it.name
                view.lecturer.text = "Lecturer: ${it.lecturer}"
                view.semester.text = "Semester: ${it.semester}"
                view.enrollButton.text = if (it.enrolled) "Drop" else "Enroll"
            }
        })

        view.enrollButton.setOnClickListener { model.toggleEnrollment() }

        return view
    }
}