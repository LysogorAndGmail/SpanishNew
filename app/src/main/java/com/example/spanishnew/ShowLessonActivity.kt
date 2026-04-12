package com.example.spanishnew

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spanishnew.databinding.ActivitySecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowLessonActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var adapter: WordsAdapter

    // Переменная для хранения списка слов в памяти (если понадобится потом)
    private var wordsList: List<Word> = emptyList()

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

        setupRecyclerView()

        // Запускаем загрузку и перемешивание
        loadAndShowRandomWords(lessonNumber)
    }

    private fun setupRecyclerView() {
        adapter = WordsAdapter(emptyList())
        binding.contentLesson.wordsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.contentLesson.wordsRecyclerView.adapter = adapter
    }

    private fun loadAndShowRandomWords(lessonNumber: Int) {
        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(applicationContext)
            // 1. Получаем все слова из БД
            val allWords = db.wordDao().getWordsForLesson(lessonNumber)

            // 2. Перемешиваем их случайным образом
            // Метод .shuffled() возвращает новый список в случайном порядке
            val shuffledWords = allWords.shuffled()

            // Сохраняем в переменную класса (если захотите использовать позже)
            wordsList = shuffledWords

            Log.d("SpanishApp", "Loaded ${allWords.size} words, showing in random order new new")

            // 3. Выводим в интерфейс
            withContext(Dispatchers.Main) {
                adapter.updateWords(shuffledWords)
            }
        }
    }
}