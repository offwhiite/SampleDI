package c.offwhite.novel.infra

import c.offwhite.novel.domain.Novel
import c.offwhite.novel.domain.NovelIntroduction
import java.io.Serializable

data class NarouNovelIntroductionResponse(var allcount: Int?,
                                          var title: String?,
                                          var ncode: String?,
                                          var userid: String?,
                                          var writer: String?,
                                          var story: String?,
                                          var biggenre: Int?,
                                          var genre: Int?,
                                          var gennsaku: String?,
                                          var keyword: String?,
                                          var general_firstup: String?,
                                          var general_lastup: String?,
                                          var novel_type: Int?,
                                          var end: Int?,
                                          var general_all_no: Int?,
                                          var length: Int?,
                                          var time: Int?,
                                          var isstop: Int?,
                                          var isbl: Int?,
                                          var isgl: Int?,
                                          var iszankoku: Int?,
                                          var istensei: Int?,
                                          var pc_or_k: Int?,
                                          var global_point: Int?,
                                          var fav_novel_cnt: Int?,
                                          var review_cnt: Int?,
                                          var all_point: Int?,
                                          var all_hyoka_cnt: Int?,
                                          var sasie_cnt: Int?,
                                          var kaiwaritu: Int?,
                                          var novelupdated_at: String?,
                                          var updated_at: String?): Serializable {

}
