package com.anlyn.di.data

import com.anlyn.data.Mapper.DataEntityMapper
import com.anlyn.data.RemoteDataSource
import com.anlyn.data.remote.RemoteRepository
import com.anlyn.data.remote.api.TDMBApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class DataModule {
    @Provides
    fun provideTDMBApi() : TDMBApi {
        //GsonConverterFactory.create(gson) create diff
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(TDMBApi.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
             .create(TDMBApi::class.java)
    }

    @Provides
    fun provideRemoteRepository(dataSource: RemoteDataSource):RemoteRepository =
        RemoteRepository(dataSource)

    @Provides
    fun provideRemoteDataSource(tdmbApi: TDMBApi, mapper: DataEntityMapper):RemoteDataSource{
        return RemoteDataSource(tdmpApi = tdmbApi, mapper = mapper)
    }

    @Provides
    fun provideDataEntityMapper():DataEntityMapper = DataEntityMapper()


}