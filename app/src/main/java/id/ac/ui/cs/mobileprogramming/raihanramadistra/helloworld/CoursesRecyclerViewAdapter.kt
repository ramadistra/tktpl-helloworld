package id.ac.ui.cs.mobileprogramming.raihanramadistra.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.course_list_item.view.*


class CoursesRecyclerViewAdapter(private val courses: List<Course>, val coursesViewModel: CoursesViewModel) :
    RecyclerView.Adapter<CoursesRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CoursesRecyclerViewAdapter.ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.courseName.text = courses[position].name
        holder.view.setOnClickListener {
            coursesViewModel.course.value = courses[position]
        }
    }

    override fun getItemCount() = courses.size
}
