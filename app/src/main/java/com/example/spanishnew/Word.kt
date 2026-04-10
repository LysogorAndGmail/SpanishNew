package com.example.spanishnew

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val original: String,     // Испанское слово
    val translationRu: String, // Перевод на русский
    val translationUk: String? = null, // Перевод на украинский (опционально)
    val lessonNumber: Int
)
