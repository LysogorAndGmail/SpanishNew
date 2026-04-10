package com.example.spanishnew

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {
    @Query("SELECT * FROM words_table WHERE lessonNumber = :lessonNum")
    suspend fun getWordsForLesson(lessonNum: Int): List<Word>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(words: List<Word>)

    @Query("DELETE FROM words_table")
    suspend fun deleteAll()
}
