package com.example.spanishnew

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.spanishnew.databinding.ActivitySecondBinding
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowLessonActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var wordsList: List<Word> = emptyList()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val lessonNumber = intent.getIntExtra("LESSON_NUMBER", 0)
        binding.contentLesson.lessonTitle.text = "Lesson $lessonNumber"

        loadAndShowRandomWords(lessonNumber)
    }

    private fun loadAndShowRandomWords(lessonNumber: Int) {
        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(applicationContext)
            val allWords = db.wordDao().getWordsForLesson(lessonNumber)

            if (allWords.isEmpty()) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ShowLessonActivity, "No words in this lesson", Toast.LENGTH_SHORT).show()
                }
                return@launch
            }

            wordsList = allWords.shuffled()
            currentIndex = 0

            withContext(Dispatchers.Main) {
                binding.contentLesson.lessonProgressBar.max = wordsList.size
                showNextQuestion()
            }
        }
    }

    private fun showNextQuestion() {
        if (currentIndex >= wordsList.size) {
            val lessonNumber = intent.getIntExtra("LESSON_NUMBER", 0)
            saveProgress(lessonNumber)
            Toast.makeText(this, "Lesson completed!", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        // Update progress
        binding.contentLesson.lessonProgressBar.progress = currentIndex + 1
        binding.contentLesson.progressText.text = "${currentIndex + 1} / ${wordsList.size}"

        val correctWord = wordsList[currentIndex]
        binding.contentLesson.targetWord.text = correctWord.original

        // Генерируем варианты ответов
        val options = mutableListOf<Word>()
        options.add(correctWord)

        // Добавляем 3 случайных неправильных ответа из этого же урока (если возможно)
        val otherWords = wordsList.filter { it.id != correctWord.id }.shuffled()
        options.addAll(otherWords.take(3))
        
        val shuffledOptions = options.shuffled()

        val buttons = listOf(
            binding.contentLesson.btnOption1,
            binding.contentLesson.btnOption2,
            binding.contentLesson.btnOption3,
            binding.contentLesson.btnOption4
        )

        buttons.forEachIndexed { index, button ->
            if (index < shuffledOptions.size) {
                val optionWord = shuffledOptions[index]
                button.text = optionWord.translationRu
                button.visibility = android.view.View.VISIBLE
                button.setOnClickListener {
                    checkAnswer(optionWord, correctWord, button)
                }
                // Сброс цвета (на случай если мы его меняли)
                button.setBackgroundColor(Color.parseColor("#5C6BC0"))
            } else {
                button.visibility = android.view.View.GONE
            }
        }
    }

    private fun saveProgress(completedLesson: Int) {
        val sharedPrefs = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val currentMax = sharedPrefs.getInt("MAX_UNLOCKED_LESSON", 1)
        if (completedLesson >= currentMax) {
            sharedPrefs.edit().putInt("MAX_UNLOCKED_LESSON", completedLesson + 1).apply()
        }
    }

    private fun checkAnswer(selected: Word, correct: Word, button: MaterialButton) {
        if (selected.id == correct.id) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            currentIndex++
            showNextQuestion()
        } else {
            button.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong! Progress reset.", Toast.LENGTH_SHORT).show()
            
            // Сбрасываем прогресс и перемешиваем список заново
            currentIndex = 0
            wordsList = wordsList.shuffled()
            
            // Небольшая задержка, чтобы пользователь увидел красный цвет (опционально)
            // Но для простоты вызовем сразу, так как цвета кнопок сбросятся в showNextQuestion
            showNextQuestion()
        }
    }
}