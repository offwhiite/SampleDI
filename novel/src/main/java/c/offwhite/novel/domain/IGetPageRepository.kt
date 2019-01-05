package c.offwhite.novel.domain

import io.reactivex.Single

/**
 * ページ取得のリポジトリ
 */
interface IGetPageRepository {
    fun getIndex(id: String): Single<Contents>
}