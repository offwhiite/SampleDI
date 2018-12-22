package com.white.off.hotblood.repository

import c.offwhite.sampledi.domain.ISearchRepository
import c.offwhite.sampledi.domain.NovelIntroduction
import c.offwhite.sampledi.external.NovelIntroductionTranslator
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
     * - 取得に失敗した場合はサイズ0の配列を返す。
     */
    override fun search(word: String): List<NovelIntroduction> {
        val response = searchService.getNovelList(word).execute()

        if (response.isSuccessful) {
            val body = response.body()
            if (body!= null) return body.mapNotNull { r -> NovelIntroductionTranslator().toNovelIntroduction(r) }
        }

        // 空配列を返す
        return emptyList()
    }
}







