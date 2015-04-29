package polen.com.myapplication

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import kotlinx.android.anko.*
import polen.com.myapplication.domain.Movie
import polen.com.myapplication.domain.MovieList
import polen.com.myapplication.network.ApiService
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import kotlin.properties.Delegates

/**
 * Created by polen on 4/13/15.
 */
public class AnkoActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        var listView: ListView
        verticalLayout {
            padding = dip(30)
            listView = listView {  }
        }

        val apiService: ApiService = ApiService()
        apiService.getUpComingMovies(object: Callback<MovieList>{
            override fun failure(error: RetrofitError?) {
                throw UnsupportedOperationException()
            }

            override fun success(t: MovieList?, response: Response?) {
                listView.setAdapter(object: BaseAdapter(){
                    override fun getCount(): Int {
                        return t!!.results!!.size()
                    }

                    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
                        var view = convertView
                        if (view == null) {
                            view = with(parent.getContext()) {
                                linearLayout {
                                    orientation = LinearLayout.HORIZONTAL
                                    imageView {
                                        id = R.id.image
                                    }.layoutParams(height = matchParent)
                                    verticalLayout {
                                        val title = textView {
                                            id = R.id.title
                                            text = t?.results?.get(position)?.title
                                        }
                                        val overview = textView {
                                            id = R.id.withText
                                            text = t?.results?.get(position)?.overview
                                        }
                                    }.layoutParams(weight = 1f)
                                }
                            }
                        } else {
                            (view?.findViewById(R.id.title) as? TextView)?.setText(t?.results?.get(position)?.title)
                            (view?.findViewById(R.id.withText) as? TextView)?.setText(t?.results?.get(position)?.overview)
                            (view?.findViewById(R.id.image) as? ImageView)?.setImageUrl("https://image.tmdb.org/t/p/w500/${t?.results?.get(position)?.backdrop_path}")
                        }
                        return view
                    }

                    override fun getItem(position: Int): Any? {
                        throw UnsupportedOperationException()
                    }

                    override fun getItemId(position: Int): Long {
                        throw UnsupportedOperationException()
                    }

                })
            }

            fun ImageView.setImageUrl(url: String) {
                Glide.with(getContext()).load(url).into(this)
            }

        })
    }
}