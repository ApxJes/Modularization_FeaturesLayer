package com.example.news_presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news_domain.model.Article
import com.example.news_presentation.databinding.NewsLayoutBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    private val differCallBack = object: DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
        val binding = NewsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) {
        val newsArticle = differ.currentList[position]

        holder.binding.apply {
            txvNewsTitle.text = newsArticle.title
            txvNewsDescription.text = newsArticle.description
            txvNewsPublishDate.text = newsArticle.publishedAt

            Glide.with(imgNewsImage.context)
                .load(newsArticle.urlToImage)
                .into(imgNewsImage)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    inner class NewsViewHolder(val binding: NewsLayoutBinding): RecyclerView.ViewHolder(binding.root)
}