package polen.com.myapplication.network.apis

import polen.com.myapplication.domain.Movie
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path

/**
 * Created by polen on 4/20/15.
 */
public trait MovieApis {
    GET("/movie/{id}")
    public fun getMovie(Path("id") id:Long,callBack: Callback<Movie>)
}