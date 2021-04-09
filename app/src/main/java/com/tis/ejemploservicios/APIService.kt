package com.tis.ejemploservicios

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getDogsByBreads(@Url url:String):Response<DogsResponse>
}