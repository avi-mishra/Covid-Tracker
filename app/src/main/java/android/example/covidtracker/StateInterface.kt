package android.example.covidtracker

import retrofit2.Response
import retrofit2.http.GET

interface StateInterface {
    @GET("data.json")
    suspend fun getAll() : Response<Statewise>
}