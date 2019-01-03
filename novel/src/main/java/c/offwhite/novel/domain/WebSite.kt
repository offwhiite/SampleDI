package c.offwhite.novel.domain

import c.offwhite.novel.di.DaggerRepositoryComponent
import javax.inject.Inject

/**
 * WebSiteクラス
 */
class WebSite (val domain: String) {

    @Inject lateinit var searchRepository: ISearchRepository

    fun search(word: String): List<NovelIntroduction> {
        searchRepository = DaggerRepositoryComponent.create().inject()
        return searchRepository.search(word)
    }
}