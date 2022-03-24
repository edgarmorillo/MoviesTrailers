package app.edgar.pelis.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import app.edgar.pelis.model.Movie
import app.edgar.pelis.model.Video
import app.edgar.pelis.repository.TmdbRepository

class MovieDetailViewModel(application: Application, movie: Movie) : AndroidViewModel(application){
    private val repository: TmdbRepository = TmdbRepository(application)
    var movieDetail: LiveData<Movie>
    var movieVideos: LiveData<ArrayList<Video>>

    init {
        movieDetail = repository.requestMovieDetail(movie.id)
        movieVideos = repository.requestMovieVideos(movie.id)
    }
}