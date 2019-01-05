package c.offwhite.novel.domain

import io.reactivex.Single
import javax.inject.Inject

/**
 * WebSiteクラス
 */
class WebSite @Inject constructor(
    val domain: String,
    private val searchRepository: ISearchRepository,
    private val getPageRepository: IGetPageRepository
) {

    fun search(word: String): List<NovelIntroduction> {
        return searchRepository.search(word)
    }

    fun getIndex(ncode: String): Single<Contents> {
        return getPageRepository.getIndex(ncode)
    }
}