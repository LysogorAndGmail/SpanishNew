package com.example.spanishnew

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        
        // Включаем кнопку "Назад" в тулбаре
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Получаем номер урока из Intent
        val lessonNumber = intent.getIntExtra("LESSON_NUMBER", 0)
        
        // Устанавливаем заголовок
        binding.contentLesson.lessonTitle.text = "Lección $lessonNumber"

        setupRecyclerView()
        loadWords(lessonNumber)
    }

    private fun setupRecyclerView() {
        adapter = WordsAdapter(emptyList())
        binding.contentLesson.wordsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.contentLesson.wordsRecyclerView.adapter = adapter
    }

    private fun loadWords(lessonNumber: Int) {
        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(applicationContext)
            val words = db.wordDao().getWordsForLesson(lessonNumber)
            
            withContext(Dispatchers.Main) {
                adapter.updateWords(words)
            }
        }
    }
}
