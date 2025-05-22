package denys.diomaxius.aws.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denys.diomaxius.aws.data.network.ApiModule
import denys.diomaxius.aws.data.network.SoilApiService
import denys.diomaxius.aws.data.network.TriggerApiService
import denys.diomaxius.aws.data.repository.SoilRepository

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSoilApiService(): SoilApiService = ApiModule.dataApi

    @Provides
    fun provideTriggerApi(): TriggerApiService = ApiModule.triggerApi

    @Provides
    @Singleton
    fun provideSoilRepository(
        dataApi: SoilApiService,
        triggerApi: TriggerApiService
    ): SoilRepository = SoilRepository(dataApi, triggerApi)
}