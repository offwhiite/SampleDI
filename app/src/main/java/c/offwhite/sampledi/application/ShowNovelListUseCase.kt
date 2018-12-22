package c.offwhite.sampledi.application

import c.offwhite.sampledi.domain.NovelIntroduction
import c.offwhite.sampledi.domain.WebSite
import com.white.off.hotblood.repository.NarouRepository

/**
 * 小説のリストを取得する
 */
class ShowNovelListUseCase {

    suspend fun getNovelList(word : String):List<NovelIntroduction> {
        val webSite = WebSite("https://api.syosetu.com/", NarouRepository())
        return webSite.search(word)
    }
}