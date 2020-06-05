package com.havelisolutions.genericapplication.di.modules;

import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.havelisolutions.genericapplication.R;
import com.havelisolutions.genericapplication.utils.CustomSharedPreference;

import java.text.DateFormat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.havelisolutions.genericapplication.generics.ServiceBuilder.BASE_URL;

@Module
public class AppModule {

    @Singleton
    @Provides
    static HttpLoggingInterceptor provideHttpLogger()
    {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
    @Singleton
    @Provides
    static OkHttpClient.Builder provideOkhttpBuilder(HttpLoggingInterceptor loggingInterceptor)
    {
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
    }
    @Singleton
    @Provides
    static Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(DateFormat.LONG)
                .create();

    }
    @Singleton
    @Provides
    static CustomSharedPreference providSharedPreferences(Application application) {
        return new CustomSharedPreference(application);

    }


    @Singleton
    @Provides
    static Retrofit.Builder provideRetrofitBuilderInstance(Gson gson, OkHttpClient.Builder builder){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(builder.build());
    }

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(Retrofit.Builder builder){
        return builder.build();
    }

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions(){
        return RequestOptions.
                placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }
    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions){
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }
//    @Singleton
//    @Provides
//    static Drawable provideDrawable(Application application){
//        return ContextCompat.getDrawable(application,R.drawable.logo);
//    }
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

//    @Provides
//    @Singleton
//    NotificationsUtil provideNotificationUtil(Application application){
//        return new Notificatio
//    }
}
