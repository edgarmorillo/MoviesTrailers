package app.edgar.pelis.ui.home

import android.app.ActivityOptions
import android.os.Bundle
import android.util.Pair as UtilPair // Rename the Pair class from the Android framework to avoid a name clash
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import app.edgar.pelis.R
import app.edgar.pelis.adapter.HomeAdapter
import app.edgar.pelis.model.MovieType
import app.edgar.pelis.utils.NavigationManager
import app.edgar.pelis.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.tmdb_toolbar.*
import kotlinx.android.synthetic.main.tmdb_fragment_home_slide.*

class HomeFragmentSlide(private val movieType: MovieType) : Fragment() {
    lateinit var adapter: HomeAdapter

    constructor() : this(MovieType.POPULAR)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.tmdb_fragment_home_slide, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        recyclerView.layoutManager = GridLayoutManager(context, GRID_COLUMNS)
        adapter = HomeAdapter(requireContext()) { movie, view ->
            val options = ActivityOptions.makeSceneTransitionAnimation(
                activity,
                UtilPair.create(view, "hero"),
                UtilPair.create(activity?.toolbar as? View, "toolbar")
            )
            NavigationManager.handle(activity, movie, options)
        }

        val viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.getMovieList(movieType).observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
        recyclerView.adapter = adapter
    }

    fun getTitle(): String {
        return when(movieType){
            MovieType.POPULAR -> "Popular"
            MovieType.TOP_RATED -> "Top Rated"

        }
    }

    fun getIcon(): Int {
        return when(movieType){
            MovieType.POPULAR -> R.drawable.tmdb_ic_star_accent_24dp
            MovieType.TOP_RATED -> R.drawable.tmdb_ic_event_accent_24dp

        }
    }

    companion object {
        const val GRID_COLUMNS = 3
    }
}