package app.edgar.pelis.model

enum class MovieType(val type: Int) {
    POPULAR(1),
    TOP_RATED(2);


    companion object {
        fun get(value: Int) = values().find { it.type == value }
    }
}