package app.edgar.pelis.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import app.edgar.pelis.model.Movie
import app.edgar.pelis.model.MovieType
import app.edgar.pelis.repository.TmdbRepository

class MovieViewModel(application: Application): AndroidViewModel(application) {
    private val repository: TmdbRepository = TmdbRepository(application)
    private val moviesPopular: LiveData<PagedList<Movie>>
    private val moviesTopRated: LiveData<PagedList<Movie>>


    init {
        moviesPopular = repository.movieListPopular
        moviesTopRated = repository.movieListTopRated

    }

    fun getMovieList(movieType: MovieType): LiveData<PagedList<Movie>> {
        return when(movieType) {
            MovieType.POPULAR -> moviesPopular
            MovieType.TOP_RATED -> moviesTopRated

        }
    }
}