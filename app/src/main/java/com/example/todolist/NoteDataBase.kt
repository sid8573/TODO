package com.example.todolist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//abstract class object note create ,its child object create
//Single tern database can note access together by two process use companion object
@Database(entities = arrayOf(Note::class),version = 1,exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {

       abstract fun getNoteDao() : NoteDao

    companion object {

        @Volatile
        private var INSTANCE: NoteDataBase? = null

        fun getDatabase(context: Context): NoteDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDataBase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }





}