package c.offwhite.sampledi.application

import c.offwhite.novel.di.DaggerDomainComponent
import c.offwhite.novel.domain.NovelIntroduction

/**
 * 小説のリストを取得する
 */
class ShowNovelListUseCase {

    fun getNovelList(word: String): List<NovelIntroduction> {
        val webSite = DaggerDomainComponent.builder()
            .domain("https://api.syosetu.com/") // 生成時にドメインを指定する
            .build() // DomainComponentを生成する
            .inject() // inject実施。repositoryを注入する。

        return webSite.search(word)
    }

}