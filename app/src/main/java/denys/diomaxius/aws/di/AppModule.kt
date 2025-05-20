package denys.diomaxius.aws.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denys.diomaxius.aws.data.network.ApiModule
import denys.diomaxius.aws.data.network.SoilApiService
import denys.diomaxius.aws.data.repository.SoilRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSoilApiService(): SoilApiService = ApiModule.retrofitService

    @Provides
    @Singleton
    fun provideSoilRepository(api: SoilApiService): SoilRepository = SoilRepository(api)
}