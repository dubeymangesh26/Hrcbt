package hrcbetaversion.com.hrcbt;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {
    public static final String WEB_API_BASE_URL = "http://www.worldindia.in/SamApi/";

    /**
     * Retrofit client to call web service.
     */
    public static Webservice getWebService() {

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(7000, TimeUnit.SECONDS);
        okHttpClient.readTimeout(7000, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(7000, TimeUnit.SECONDS);

        return new retrofit2.Retrofit.Builder()                                   // Retrofit client.
                .baseUrl(WEB_API_BASE_URL)                                       // Base domain URL.
                .addConverterFactory(GsonConverterFactory.create())     // Added converter factory.
                .client(okHttpClient.build())
                .build()                                                // Build client.
                .create(Webservice.class);
    }
}
