package app.edgar.pelis.db

import androidx.paging.DataSource
import androidx.room.*
import app.edgar.pelis.model.Movie
import app.edgar.pelis.model.MovieType

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies WHERE type =:movieType ORDER BY page ASC")
    fun loadMovies(movieType: MovieType): DataSource.Factory<Int, Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<Movie>)

    @Insert
    fun insertMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

    @Update
    fun updateMovie(movie: Movie)
}