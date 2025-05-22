package denys.diomaxius.aws.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {
    private const val DATA_BASE_URL = "https://bpubt8r80a.execute-api.ap-southeast-2.amazonaws.com/"
    private const val TRIGGER_BASE_URL = "https://7v87euq5xe.execute-api.ap-southeast-2.amazonaws.com/"

    val dataApi: SoilApiService by lazy {
        Retrofit.Builder()
            .baseUrl(DATA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SoilApiService::class.java)
    }

    val triggerApi: TriggerApiService by lazy {
        Retrofit.Builder()
            .baseUrl(TRIGGER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TriggerApiService::class.java)
    }
}
