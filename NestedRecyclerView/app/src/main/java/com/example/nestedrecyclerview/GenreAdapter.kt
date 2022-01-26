package my.project.nestedmycinema

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.databinding.GenresItemBinding


class GenreAdapter(val context: Context, var genres: ArrayList<GenreModel>): RecyclerView.Adapter<GenreHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : GenresItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.genres_item,parent,false)
        return GenreHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {

        holder.binding.nameGenres.text = genres[position].nameGenre
        loadMovies(holder.binding.catalogWithMovies, genres[position].catalogWithMovies)

    }

    override fun getItemCount(): Int {
        return genres.size
    }

    private fun loadMovies(recyclerView:RecyclerView, movies: ArrayList<MovieModel>) {

        val movieAdapter = MovieAdapter(movies)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = movieAdapter

    }
}


class GenreHolder(val binding: GenresItemBinding): RecyclerView.ViewHolder(binding.root){

}