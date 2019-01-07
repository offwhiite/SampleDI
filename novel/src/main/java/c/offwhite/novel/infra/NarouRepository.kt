package c.offwhite.novel.infra

import c.offwhite.novel.domain.ISearchRepository
import c.offwhite.novel.domain.NovelIntroduction
import c.offwhite.novel.infra.api.INarouOpenApi
import javax.inject.Inject

/**
 * 小説家になろうオープンAPI
 */
class NarouRepository @Inject constructor(val api: INarouOpenApi) : ISearchRepository {

    /**
     * 小説情報一覧を取得する
     * - 取得に失敗した場合はサイズ0の配列を返す。
     */
    override fun search(word: String): List<NovelIntroduction> {
        return api.search(word)
    }

}







