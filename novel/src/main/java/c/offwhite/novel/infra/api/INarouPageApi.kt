package c.offwhite.novel.infra.api

import c.offwhite.novel.domain.Contents
import io.reactivex.Single

interface INarouPageApi {
    fun getIndex(ncode: String): Single<Contents>
}