package c.offwhite.novel.infra.api

import c.offwhite.novel.domain.Contents
import c.offwhite.novel.infra.INarouNovelAPI
import c.offwhite.novel.infra.NovelPageTranslator
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import javax.inject.Inject

class NarouPageApi @Inject constructor(): INarouPageApi {

    // 小説を読もうURL
    private val BASE_URL = "https://ncode.syosetu.com/"

    // API
    private val searchService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()
        .create(INarouNovelAPI::class.java)

    /**
     * 小説目次を取得する
     * - とりあえずRxを使ってみるが、Kotlin-coroutineの方が良いかも
     */
    override fun getIndex(ncode: String): Single<Contents> {
        return Single.create<Contents> { emitter ->
            val responseBody: Call<ResponseBody> = searchService.getNovelIndex(ncode)

            responseBody.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: retrofit2.Response<ResponseBody>) {

                    val contents = NovelPageTranslator().translateResponseToText(response.body()!!.toString())
                    if (contents == null) {
                        emitter.onError(Throwable())
                    } else {
                        emitter.onSuccess(contents)
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    emitter.onError(t)
                }
            })
        }

    }
}