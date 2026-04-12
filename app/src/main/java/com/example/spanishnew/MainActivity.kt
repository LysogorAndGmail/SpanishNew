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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Цвет для кнопок
        val buttonColor = ContextCompat.getColor(this, R.color.button_blue)

        // Цикл для создания 9 кнопок
        for (i in 1..9) {
            val button = MaterialButton(this).apply {
                text = "Lesson $i"
                setTextColor(ContextCompat.getColor(context, R.color.white))
                
                // Настройка внешнего вида (скругление и цвет)
                cornerRadius = (8 * resources.displayMetrics.density).toInt() // ~8dp скругление
                backgroundTintList = ColorStateList.valueOf(buttonColor)
                
                // Тень (elevation)
                elevation = 6 * resources.displayMetrics.density // ~6dp тень
                
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

        binding.fab.setOnClickListener { view ->
            lifecycleScope.launch(Dispatchers.IO) {
                val db = AppDatabase.getDatabase(applicationContext)
                db.clearAllTables()
                db.wordDao().insertWords(TestData.words)
            }
            Snackbar.make(view, "Database refreshed from TestData", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }
}
