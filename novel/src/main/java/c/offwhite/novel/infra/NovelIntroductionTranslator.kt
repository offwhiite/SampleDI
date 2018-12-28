package c.offwhite.novel.infra

import c.offwhite.novel.domain.NovelIntroduction

class NovelIntroductionTranslator {


    fun toNovelIntroduction(response : NarouNovelIntroductionResponse) : NovelIntroduction? {

        // allcountが含まれている場合はその時点で終了
        if (response.allcount != null) {
            return null
        }

        return NovelIntroduction(
            response.title ?: "",
            response.ncode ?: "",
            response.userid ?: "",
            response.writer ?: "",
            response.story ?: "",
            response.biggenre ?: 0,
            response.genre ?: 0,
            response.gennsaku ?: "",
            response.keyword ?: "",
            response.general_firstup ?: "",
            response.general_lastup ?: "",
            response.novel_type ?: 0,
            response.end ?: 0,
            response.general_all_no ?: 0,
            response.length ?: 0,
            response.time ?: 0,
            response.isstop ?: 0,
            response.isbl ?: 0,
            response.isgl ?: 0,
            response.iszankoku ?: 0,
            response.istensei ?: 0,
            response.pc_or_k ?: 0,
            response.global_point ?: 0,
            response.fav_novel_cnt ?: 0,
            response.review_cnt ?: 0,
            response.all_point ?: 0,
            response.all_hyoka_cnt ?: 0,
            response.sasie_cnt ?: 0,
            response.kaiwaritu ?: 0,
            response.novelupdated_at ?: "",
            response.updated_at ?: ""
        )
    }
}