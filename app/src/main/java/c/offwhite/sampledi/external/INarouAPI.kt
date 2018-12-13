package com.white.off.hotblood.repository

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface INarouAPI {

    @GET("?out=json")
    fun getNovelList(@Query("word") word : String) : List<NarouNovelIntroductionResponse>
}