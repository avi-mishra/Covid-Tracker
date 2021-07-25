package android.example.covidtracker

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofit {
   private val gson=GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

   private val retro=Retrofit.Builder().baseUrl("https://api.covid19india.org")
        .addConverterFactory(GsonConverterFactory.create(gson)).build()

    val api= retro.create(StateInterface::class.java)

}