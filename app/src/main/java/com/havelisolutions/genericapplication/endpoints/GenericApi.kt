package com.havelisolutions.genericapplication.endpoints

import com.havelisolutions.genericapplication.models.Post
import com.havelisolutions.genericapplication.models.User
import retrofit2.Response
import retrofit2.http.*

interface GenericApi {
    //    @GET("summary")
    //   suspend fun getTotalStats(): Response<TotalStats>
//    @GET("v2/all")
//    suspend fun getGlobalStats(): Response<GlobalStats>

    //Susped function can suspend and resume any time its is for running in the coroutines so the view will not freeze
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("users/{id}")
    suspend fun getUser(
        @Path("id") id: Int
    ): Response<User>

//    @GET("v2/countries/{name}")
//    suspend fun getCountriesStats(@Path("name") countryName: String?): Response<CountryStats>
//
//    @GET("v2/countries")
//    suspend fun getAllCountries(): Response<List<CountryStats>>
//
//    @GET("v2/historical/all")
//    suspend fun getHistoricalGlobalData(@QueryMap filter: HashMap<String, String>): Response<TimelineData>
//
//    @GET("v2/historical/{countryname}")
//    suspend fun getHistoricalCountryData(
//        @Path("countryname") countryName: String?,
//        @QueryMap filter: HashMap<String, String>
//    ): Response<HistoricalCountryData>
    //
    //    @GET("destination")
    //    suspend fun getDestinations(@QueryMap filter:HashMap<String,String>?): Response<List<Destination>>
    //    @GET("destination/{id}")
    //    suspend fun getDestination(@Path("id")id:Int):Response<Destination>
    //
    //    @POST("destination")
    //    suspend fun addDestination(@Body destination: Destination):Response<Destination>
    //    @PUT("destination/{id}")
    //    suspend fun updateDestination(@Path("id")id:Int,@Body destination: Destination):Response<Destination>
    //    @DELETE("destination/{id}")
    //    suspend fun deleteDestination(@Path("id")id:Int):Response<String>

}