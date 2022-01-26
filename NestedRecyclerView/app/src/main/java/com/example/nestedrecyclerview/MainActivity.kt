package com.example.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview.databinding.ActivityMainBinding
import my.project.nestedmycinema.GenreAdapter
import my.project.nestedmycinema.GenreModel
import my.project.nestedmycinema.MovieModel

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null
    private var genreAdapter:GenreAdapter? = null

    private var genres:ArrayList<GenreModel>? = null
    private var actionMovies:ArrayList<MovieModel>? = null
    private var fantasticMovies:ArrayList<MovieModel>? = null
    private var adventureMovies:ArrayList<MovieModel>? = null
    private var thrillerMovies:ArrayList<MovieModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        genres = ArrayList<GenreModel>()
        actionMovies = ArrayList<MovieModel>()
        fantasticMovies = ArrayList<MovieModel>()
        adventureMovies = ArrayList<MovieModel>()
        thrillerMovies = ArrayList<MovieModel>()


        genres?.add(GenreModel(getString(R.string.actionMovies), actionMovies!!))
        genres?.add(
            GenreModel(getString(R.string.fantasticMovies), fantasticMovies!!)
        )

        genres?.add(
            GenreModel(getString(R.string.adventureMovies), adventureMovies!!)
        )

        genres?.add(
            GenreModel(getString(R.string.thrillerMovies), thrillerMovies!!)
        )


        actionMovies?.add(MovieModel(R.drawable.bad_boys, getString(R.string.badBoys), getString(R.string.badBoysLong),
            getString(R.string.badBoysActors), getString(R.string.badBoysRating)))
        adventureMovies?.add(
            MovieModel(R.drawable.avengers, getString(R.string.avengers), getString(R.string.avengersLong),
                getString(R.string.avengersActors), getString(R.string.avengersRating))
        )
        actionMovies?.add(
            MovieModel(R.drawable.transformers, getString(R.string.transformers), getString(R.string.transformersLong),
                getString(R.string.transformersActors), getString(R.string.transformersRating))
        )
        adventureMovies?.add(
            MovieModel(R.drawable.fast, getString(R.string.fast), getString(R.string.fastLong),
                getString(R.string.fastActors), getString(R.string.fastRating))
        )
        actionMovies?.add(
            MovieModel(R.drawable.mk, getString(R.string.mk), getString(R.string.mkLong),
                getString(R.string.mkActors), getString(R.string.mkRating))
        )
        adventureMovies?.add(
            MovieModel(R.drawable.underworld, getString(R.string.underworld), getString(R.string.underworldLong),
                getString(R.string.underworldActors), getString(R.string.underworldRating))
        )


        fantasticMovies?.add(
            MovieModel(R.drawable.avengers, getString(R.string.avengers), getString(R.string.avengersLong),
                getString(R.string.avengersActors), getString(R.string.avengersRating))
        )
        fantasticMovies?.add(
            MovieModel(R.drawable.transformers, getString(R.string.transformers), getString(R.string.transformersLong),
                getString(R.string.transformersActors), getString(R.string.transformersRating))
        )
        fantasticMovies?.add(
            MovieModel(R.drawable.mk, getString(R.string.mk), getString(R.string.mkLong),
                getString(R.string.mkActors), getString(R.string.mkRating))
        )
        fantasticMovies?.add(
            MovieModel(R.drawable.underworld, getString(R.string.underworld), getString(R.string.underworldLong),
                getString(R.string.underworldActors), getString(R.string.underworldRating))
        )

        adventureMovies?.add(
            MovieModel(R.drawable.pirates, getString(R.string.pirates), getString(R.string.piratesLong),
                getString(R.string.piratesActors), getString(R.string.piratesRating))
        )
        adventureMovies?.add(
            MovieModel(R.drawable.future, getString(R.string.future), getString(R.string.futureLong),
                getString(R.string.futureActors), getString(R.string.futureRating))
        )

        thrillerMovies?.add(MovieModel(R.drawable.underworld, getString(R.string.underworld), getString(R.string.underworldLong),
            getString(R.string.underworldActors), getString(R.string.underworldRating)))

        binding?.genresMovies?.layoutManager = LinearLayoutManager(this)
        genreAdapter = GenreAdapter(this, genres!!)
        binding?.genresMovies?.adapter = genreAdapter
    }
}