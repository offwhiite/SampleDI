package c.offwhite.novel.infra

import c.offwhite.novel.domain.Contents
import c.offwhite.novel.domain.IGetPageRepository
import c.offwhite.novel.infra.api.INarouPageApi
import io.reactivex.Single

/**
 * なろうの目次情報を取得する
 */
class NarouHtmlRepository(val narouPageApi : INarouPageApi):IGetPageRepository {
    override fun getIndex(id: String): Single<Contents> {
        return narouPageApi.getIndex(id)
    }
}