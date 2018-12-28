package c.offwhite.sampledi.application

import c.offwhite.novel.domain.NovelIntroduction
import c.offwhite.novel.domain.WebSite
import c.offwhite.novel.external.api.NarouOpenApi
import c.offwhite.novel.infra.NarouRepository

/**
 * 小説のリストを取得する
 */
class ShowNovelListUseCase {

    fun getNovelList(word: String): List<NovelIntroduction> {
        val webSite = WebSite("https://api.syosetu.com/", NarouRepository(NarouOpenApi()))
        return webSite.search(word)
    }
}