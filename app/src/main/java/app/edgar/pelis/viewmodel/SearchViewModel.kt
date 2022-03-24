package app.edgar.pelis.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import app.edgar.pelis.model.Movie
import app.edgar.pelis.repository.TmdbRepository

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TmdbRepository = TmdbRepository(application)
    val searchResults: LiveData<ArrayList<Movie>>

    init {
        searchResults = repository.searchResults
    }

    fun search(query: String, page: Int = 1) {
        repository.searchMovie(query, page)
    }
}