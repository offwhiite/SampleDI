package c.offwhite.novel.external.api

/**
 * OpenApiのインターフェースクラス。
 * Flavorでスタブと切り替える
 */
interface INarouOpenApi {
    abstract fun search(word: String)
}