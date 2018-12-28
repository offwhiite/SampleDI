package c.offwhite.novel.domain

interface ISearchRepository {
    fun search(word : String) : List<NovelIntroduction>
}