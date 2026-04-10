package com.example.spanishnew

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.spanishnew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Цикл для создания 9 кнопок
        for (i in 1..9) {
            val button = Button(this).apply {
                text = "Кнопка $i"
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(8, 8, 8, 8)
                }
                setOnClickListener {
                    Snackbar.make(this, "Нажата кнопка $i", Snackbar.LENGTH_SHORT).show()
                }
            }
            binding.contentMain.buttonGrid.addView(button)
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }
}
