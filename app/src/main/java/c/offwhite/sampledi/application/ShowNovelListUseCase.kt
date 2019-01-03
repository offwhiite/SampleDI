package c.offwhite.sampledi.application

import c.offwhite.novel.domain.NovelIntroduction
import c.offwhite.novel.domain.WebSite

/**
 * 小説のリストを取得する
 */
class ShowNovelListUseCase {

    fun getNovelList(word: String): List<NovelIntroduction> {
        val webSite = WebSite("https://api.syosetu.com/")
        return webSite.search(word)
    }

}