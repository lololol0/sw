package com.example.sw

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.net.URI

class ListAdapter(private val list: List<Movie>)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {

    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null
    private var mImageView: ImageView? = null

    init {
        mTitleView = itemView.findViewById(R.id.list_title)
        mYearView = itemView.findViewById(R.id.list_year)
        mImageView = itemView.findViewById(R.id.simple_img)
    }

    fun bind(movie: Movie) {
//        val uri: Uri = Uri.parse("@drawable/jd")
        mTitleView?.text = movie.title
        mYearView?.text = movie.year.toString()
//        mImageView?.setImageURI(null)
//        mImageView?.setImageURI(uri)
    }

}

