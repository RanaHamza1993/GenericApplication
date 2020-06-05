package com.havelisolutions.genericapplication.generics

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    public const val BASE_URL="https://jsonplaceholder.typicode.com/"

    //HttpInteceptor
   // private val logger: HttpLoggingInterceptor =HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //create OKhttp Client
    private  val okhttpBuilder: OkHttpClient.Builder =OkHttpClient.Builder()
//    private  val okhttpBuilder: OkHttpClient.Builder =OkHttpClient.Builder().addInterceptor(
//        logger
//    )



    //Create Retrofit Builder

    private val builder: Retrofit.Builder =Retrofit.Builder().
                        baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                        .client(okhttpBuilder.build())

    private val retrofit: Retrofit = builder.build()

    operator fun<T> invoke(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }
}