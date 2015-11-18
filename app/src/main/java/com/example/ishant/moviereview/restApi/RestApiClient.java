package com.example.ishant.moviereview.restApi;

import com.example.ishant.moviereview.constants.URIConstants;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by arpitjain on 16/10/15.
 */
public class RestApiClient {


    private static RestApiService restApiService;

    private RestApiClient(){

    }

    public static RestApiService setUpService(){
        if(restApiService==null){
            Retrofit retrofit  = setUpRetrofit();
            restApiService = retrofit.create(RestApiService.class);
        }
        return restApiService;
    }

    public static Retrofit setUpRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(URIConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
