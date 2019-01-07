package c.offwhite.novel.infra.api

import c.offwhite.novel.domain.NovelIntroduction

/**
 * OpenApiのインターフェースクラス。
 * Flavorでスタブと切り替える
 */
interface INarouOpenApi {
    fun search(word: String): List<NovelIntroduction>
}