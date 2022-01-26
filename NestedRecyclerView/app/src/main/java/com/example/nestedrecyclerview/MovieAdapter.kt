package my.project.nestedmycinema

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.databinding.MoviesItemBinding


class MovieAdapter(var movies: ArrayList<MovieModel>):
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : MoviesItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.movies_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies[position])
    }

}

class MyViewHolder(val binding: MoviesItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(movieModel:MovieModel){

        binding.contentCardMovie.setBackgroundResource(movieModel.banerMovie)
        binding.nameMovie.text = movieModel.nameMovie
        binding.longMovie.text = movieModel.longMovie
        binding.actorsMovie.text = movieModel.actorsMovie
        binding.ratingMovie.text = movieModel.ratingMovie

    }



}