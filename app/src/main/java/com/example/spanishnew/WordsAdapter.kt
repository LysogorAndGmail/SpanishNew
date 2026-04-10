package com.example.spanishnew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(private var words: List<Word>) : RecyclerView.Adapter<WordsAdapter.WordViewHolder>() {

    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val originalText: TextView = view.findViewById(R.id.original_text)
        val translationRuText: TextView = view.findViewById(R.id.translation_ru_text)
        val translationUkText: TextView = view.findViewById(R.id.translation_uk_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        // Исправлено: макет должен быть R.layout.item_word
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words[position]
        holder.originalText.text = word.original
        holder.translationRuText.text = word.translationRu
        holder.translationUkText.text = word.translationUk ?: ""
        holder.translationUkText.visibility = if (word.translationUk.isNullOrEmpty()) View.GONE else View.VISIBLE
    }

    override fun getItemCount() = words.size

    fun updateWords(newWords: List<Word>) {
        words = newWords
        notifyDataSetChanged()
    }
}
