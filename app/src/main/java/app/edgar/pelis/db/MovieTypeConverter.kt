package app.edgar.pelis.db

import androidx.room.TypeConverter
import app.edgar.pelis.model.MovieType

class MovieTypeConverter {
    @TypeConverter
    fun toMovieType(value: Int) = MovieType.get(value)

    @TypeConverter
    fun toInt(movieType: MovieType) = movieType.type
}