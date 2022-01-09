package com.example.teacherassistant.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teacherassistant.data.assignment.AssignmentDao
import com.example.teacherassistant.data.mark.Mark
import com.example.teacherassistant.data.mark.MarkDao
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.student.StudentDao
import com.example.teacherassistant.data.subject.Subject
import com.example.teacherassistant.data.subject.SubjectDao

@Database(entities = [Student::class, Subject::class, Mark::class], version = 1, exportSchema = false)
abstract class TeacherDatabase: RoomDatabase() {

    abstract val studentDao: StudentDao
    abstract val subjectDao: SubjectDao
    abstract val markDao: MarkDao
    abstract val assignmentDao: AssignmentDao

    companion object{
        @Volatile
        private var INSTANCE: TeacherDatabase? = null

        fun getInstance(context: Context): TeacherDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TeacherDatabase::class.java,
                        "teacher_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}