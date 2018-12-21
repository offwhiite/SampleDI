package com.white.off.hotblood.repository

import c.offwhite.sampledi.domain.ISearchRepository
import c.offwhite.sampledi.domain.NovelIntroduction
import c.offwhite.sampledi.external.NovelIntroductionTranslator
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

/**
 * 小説家になろうオープンAPI
 */
class NarouRepository : ISearchRepository {

    // Contextをどこまで引っ張ってくるか問題。個人的に環境やUIに左右されない固定値はresourceに定義するべきではないと思う。
    // 検証環境等環境別にURLがあるならresource定義でもよいかも
    private val NAROU_BASE_URL = "https://api.syosetu.com/novelapi/api/"

    // API
    private val searchService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
        .baseUrl(NAROU_BASE_URL)
        .build()
        .create(INarouAPI::class.java)

    /**
     * 小説情報一覧を取得する
     */
    override fun search(word : String) : List<NovelIntroduction> {
        return searchService.getNovelList(word).mapNotNull{response -> NovelIntroductionTranslator().toNovelIntroduction(response)}
    }
}







