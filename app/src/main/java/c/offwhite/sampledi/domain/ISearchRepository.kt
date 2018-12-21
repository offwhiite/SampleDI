package c.offwhite.sampledi.domain

import com.white.off.hotblood.repository.NarouNovelIntroductionResponse

interface ISearchRepository {
    fun search(word : String) : List<NarouNovelIntroductionResponse>
}