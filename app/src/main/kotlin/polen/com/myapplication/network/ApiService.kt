package polen.com.myapplication.network

import polen.com.myapplication.domain.Movie
import polen.com.myapplication.domain.MovieList
import polen.com.myapplication.network.apis.MovieApis
import retrofit.Callback
import retrofit.RequestInterceptor
import retrofit.RestAdapter
import kotlin.properties.Delegates

/**
 * Created by polen on 4/21/15.
 */
public class ApiService {
    companion object {
        val ENDPOINT_URL = "http://api.themoviedb.org/3"
        val API_KEY = "api_key"
        val API_KEY_VALUE = "eb86fe8282128fcba22fe0672c4fb5b9"
    }

    val api : MovieApis by Delegates.lazy {
        RestAdapter.Builder()
                .setEndpoint(ENDPOINT_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(object: RequestInterceptor {
                    override fun intercept(request: RequestInterceptor.RequestFacade?) {
                        request?.addQueryParam(API_KEY,API_KEY_VALUE)
                    }

                })
                .build()
                .create(javaClass<MovieApis>())
    }

    public fun getMovie(id: Long, callback: Callback<Movie>) {
        api.getMovie(id,callback)
    }

    public fun getUpComingMovies(callback: Callback<MovieList>) {
        api.getUpComingMovies(callback)
    }
}