package com.example.spanishnew

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.spanishnew.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setupLanguageButtons()

        binding.fab.setOnClickListener { view ->
            lifecycleScope.launch(Dispatchers.IO) {
                val db = AppDatabase.getDatabase(applicationContext)
                db.clearAllTables()
                db.wordDao().insertWords(TestData.words)
                
                withContext(Dispatchers.Main) {
                    getSharedPreferences("AppPrefs", MODE_PRIVATE).edit().putInt("MAX_UNLOCKED_LESSON", 1).apply()
                    Snackbar.make(view, "Database refreshed and progress reset", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show()
                    
                    updateStats()
                    setupLessonButtons()
                }
            }
        }
    }

    private fun setupLanguageButtons() {
        val sharedPrefs = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        
        binding.contentMain.btnLangRu.setOnClickListener {
            sharedPrefs.edit().putString("SELECTED_LANG", "ru").apply()
            Snackbar.make(binding.root, "Язык изменен на Русский", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.contentMain.btnLangUa.setOnClickListener {
            sharedPrefs.edit().putString("SELECTED_LANG", "ua").apply()
            Snackbar.make(binding.root, "Мову змінено на Українську", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        updateStats()
        setupLessonButtons()
    }

    private fun updateStats() {
        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(applicationContext)
            val totalWords = db.wordDao().getTotalWordCount()
            val totalLessons = db.wordDao().getTotalLessonCount()

            withContext(Dispatchers.Main) {
                binding.contentMain.totalWordsText.text = "Total words: $totalWords"
                binding.contentMain.totalLessonsText.text = "Total lessons: $totalLessons"
            }
        }
    }

    private fun setupLessonButtons() {
        binding.contentMain.buttonGrid.removeAllViews()
        
        val sharedPrefs = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val maxUnlocked = sharedPrefs.getInt("MAX_UNLOCKED_LESSON", 1)

        val activeColor = ContextCompat.getColor(this, R.color.button_blue)
        val lockedColor = ColorStateList.valueOf(ContextCompat.getColor(this, android.R.color.darker_gray))

        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(applicationContext)
            val totalLessons = db.wordDao().getTotalLessonCount()
            
            withContext(Dispatchers.Main) {
                // Если уроков в базе больше чем 9, отобразим все
                val countToShow = if (totalLessons > 0) totalLessons else 9

                for (i in 1..countToShow) {
                    val isLocked = i > maxUnlocked
                    
                    val button = MaterialButton(this@MainActivity).apply {
                        text = if (isLocked) "Lesson $i \uD83D\uDD12" else "Lesson $i"
                        setTextColor(ContextCompat.getColor(context, R.color.white))
                        isEnabled = !isLocked
                        
                        cornerRadius = (8 * resources.displayMetrics.density).toInt()
                        backgroundTintList = if (isLocked) lockedColor else ColorStateList.valueOf(activeColor)
                        
                        elevation = if (isLocked) 0f else 6 * resources.displayMetrics.density
                        
                        layoutParams = GridLayout.LayoutParams().apply {
                            width = 0
                            height = ViewGroup.LayoutParams.WRAP_CONTENT
                            columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                            setMargins(16, 16, 16, 16)
                        }

                        setOnClickListener {
                            val intent = Intent(this@MainActivity, ShowLessonActivity::class.java)
                            intent.putExtra("LESSON_NUMBER", i)
                            startActivity(intent)
                        }
                    }
                    binding.contentMain.buttonGrid.addView(button)
                }
            }
        }
    }
}
