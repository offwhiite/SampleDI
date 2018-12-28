package c.offwhite.novel.external.api

import c.offwhite.novel.domain.NovelIntroduction
import c.offwhite.novel.infra.NovelIntroductionTranslator
import com.google.gson.GsonBuilder
import c.offwhite.novel.infra.INarouAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NarouOpenApi {

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
    fun search(word: String): List<NovelIntroduction> {
        val response = searchService.getNovelList(word).execute()

        if (response.isSuccessful) {
            val body = response.body()
            if (body!= null) return body.mapNotNull { r -> NovelIntroductionTranslator().toNovelIntroduction(r) }
        }

        // 空配列を返す
        return emptyList()
    }
}