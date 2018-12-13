package c.offwhite.sampledi.domain

/**
 * WebSiteクラス
 * TODO 3: Dagger2を利用してDIする
 */
class WebSite(val domain : String, val searchRepository : ISearchRepository) {

    fun search() {
        // TODO 1: LiveDataを返却するように修正する
    }
}