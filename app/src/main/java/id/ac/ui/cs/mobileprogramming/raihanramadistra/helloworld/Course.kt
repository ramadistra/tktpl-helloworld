package id.ac.ui.cs.mobileprogramming.raihanramadistra.helloworld

data class Course(val name: String, val lecturer: String, val semester: Int, var enrolled: Boolean = false)

val courses = listOf(
    Course("DDP 1", "Lecturer 1", 1),
    Course("DDP 2", "Lecturer 1", 2)
)