package denys.diomaxius.aws.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {
    private const val BASE_URL = "https://bpubt8r80a.execute-api.ap-southeast-2.amazonaws.com/"

    val retrofitService: SoilApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SoilApiService::class.java)
    }
}
