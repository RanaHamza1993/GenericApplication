package com.havelisolutions.genericapplication.di.modules.main;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

//    @MainScope
//    @Provides
//    static ItemAdapter provideItemAdapter(){
//        return new ItemAdapter();
//    }
//    @MainScope
//    @Provides
//    static CountriesAdapter provideCountriesAdapter(){
//        return new CountriesAdapter();
//    }
//    @MainScope
//    @Provides
//    static NotificationAdapter provideNotificationsAdapter(){
//        return new NotificationAdapter();
//    }
//    @Provides
//    static LinearLayoutManager provideLinearLayoutManager(MainActivity activity){
//        return new LinearLayoutManager(activity, RecyclerView.VERTICAL,false);
//    }
////    @Provides
////    static VerticalSpacingItemDecoration provideVerticalSpacingDecoration(){
////        return new VerticalSpacingItemDecoration(15);
////    }
//
//    @MainScope
//    @Provides
//    static DatabaseReference myDbReference(){
//        return FirebaseDatabase.getInstance().getReference();
//    }
//    @MainScope
//    @Provides
//    static StorageReference myStorageReference(){
//        return FirebaseStorage.getInstance().getReference();
//    }
//    @MainScope
//    @Provides
//    static CovidApi provideMainApi(Retrofit retrofit){
//        return retrofit.create(CovidApi.class);
//    }
}
