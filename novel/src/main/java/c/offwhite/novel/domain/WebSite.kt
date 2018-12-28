package c.offwhite.novel.domain

/**
 * WebSiteクラス
 * TODO 3: Dagger2を利用してDIする
 */
class WebSite(val domain : String, val searchRepository : ISearchRepository) {

    fun search(word : String) : List<NovelIntroduction>{
       return searchRepository.search(word)
    }
}