package polen.com.myapplication

import android.app.Activity
import android.os.Bundle
import kotlinx.android.anko.*
import polen.com.myapplication.domain.Movie
import polen.com.myapplication.network.ApiService
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

/**
 * Created by polen on 4/13/15.
 */
public class AnkoActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(30)
            val title = textView {
                text = "Title"
            }
            val overview = textView {
                text = "Overview"
            }
            val apiService: ApiService = ApiService()
            apiService.getMovie(3,object: Callback<Movie> {
                override fun success(t: Movie?, response: Response?) {
                    title.setText(t?.title)
                    overview.setText(t?.overview)
                }

                override fun failure(error: RetrofitError?) {
                }
            })
        }
    }
}
