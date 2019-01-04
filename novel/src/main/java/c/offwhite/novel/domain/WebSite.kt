package c.offwhite.novel.domain

import javax.inject.Inject

/**
 * WebSiteクラス
 */
class WebSite @Inject constructor(val domain: String, private val searchRepository: ISearchRepository) {

    fun search(word: String): List<NovelIntroduction> {
        return searchRepository.search(word)
    }
}