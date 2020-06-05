package com.havelisolutions.genericapplication.repo

import android.content.Context
import com.havelisolutions.genericapplication.endpoints.GenericApi
import com.havelisolutions.genericapplication.generics.SafeApiRequest
import com.havelisolutions.genericapplication.generics.SafeApiResponse
import com.havelisolutions.genericapplication.models.Post
import com.havelisolutions.genericapplication.models.User
import javax.inject.Inject

class RepositoryClass @Inject constructor(
    private val genericApi: GenericApi
): SafeApiRequest() {
//    private val totalStatsLiveData:MutableLiveData<SafeApiResponse<List<TotalStats>>>()
    //private val createdDestination=MutableLiveData<Destination>()

    companion object {
        @Volatile
        private var INSTANCE: RepositoryClass? = null

        fun getInstance(context: Context, genericService: GenericApi) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: RepositoryClass(genericService).also {
                    INSTANCE = it
                }
            }
    }

    //Susped function can suspend and resume any time its is for running in the coroutines so the view will not freeze
    suspend fun getPosts(): SafeApiResponse<List<Post>> {
        //apiSafeRequest is the wrapping of response
        //arrow showing on left is mean it is suspended function or its is coroutine
        return apiSafeRequest{genericApi.getPosts()}
    }
    suspend fun getUser(id:Int):SafeApiResponse<User>{
        return apiSafeRequest{genericApi.getUser(id)}
    }
    //   fun getDestinationsList():MutableLiveData<List<Destination>>{
//        destinationService.getDestinations().enqueue(object : Callback<List<Destination>> {
//            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
//                Toast.makeText(context,t.message,Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(
//                call: Call<List<Destination>>,
//                response: Response<List<Destination>>
//            ) {
//                if(response.isSuccessful)
//                destinationList.postValue(response.body()!!)
//            }
//
//        })
//        return destinationList
//    }
//    suspend fun getTotalStatsList():SafeApiResponse<TotalStats> {
//       return apiSafeRequest{covidService.getTotalStats()}
//    }
//    suspend fun getGlobalList(): SafeApiResponse<GlobalStats> {
//        return apiSafeRequest{covidService.getGlobalStats()}
//    }
//    suspend fun getHistoricalData(countryName: String?,filter:HashMap<String,String>):SafeApiResponse<HistoricalCountryData> {
//        return apiSafeRequest{covidService.getHistoricalCountryData(countryName,filter)}
//    }

}