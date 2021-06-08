package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(note : Note)

    @Delete
   suspend fun delete(note : Note)

                              //these functions are IO function witch takes more time to be done
                              // we need to run them in background by using coroutine
                              //suspend is a coroutine
                               //suspend fun called only with another suspend fun or background thread


    @Query( "Select * from notes_table order by ID ASC")
    fun getAllNotes() : LiveData<List<Note>>

                                               // live data is use for updating all changes , lifecycle aware,
                                               // can observe from anywhere

}