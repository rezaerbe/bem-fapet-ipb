package com.app.bemfapetipb.Utils;

import com.app.bemfapetipb.Retrofit.ApiClient;
import com.app.bemfapetipb.Retrofit.ApiInterface;

public class Common {
    private static final String BASE_URL = "http://192.168.43.249/bemfapetipb/";
//    private static final String BASE_URL = "http://femaleinaction.com/bemfapetipb/";

    public static ApiInterface getAPI()
    {
        return ApiClient.getApiClient(BASE_URL).create(ApiInterface.class);
    }
}
