package jaefact.branchtest.global.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig<T>{

    //@Value("${external.api.url}")
    private String baseUrl = "http://10.0.2.104:57509";

    private Gson gson = new GsonBuilder().setLenient().create();

    private final OkHttpClient httpClient = OkHttpClients.getUnsafeOkHttpClient();

    private retrofit2.Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build();

    public <T> T create(Class<T> sClass){
        return retrofit.create(sClass);
    }


}
