package c.offwhite.novel.domain

/**
 * 小説紹介
 */
class NovelIntroduction(val title: String,
                        val ncode: String,
                        val userid: String,
                        val writer: String,
                        val story: String,
                        val biggenre: Int,
                        val genre: Int,
                        val gennsaku: String,
                        val keyword: String,
                        val general_firstup: String,
                        val general_lastup: String,
                        val novel_type: Int,
                        val end: Int,
                        val general_all_no: Int,
                        val length: Int,
                        val time: Int,
                        val isstop: Int,
                        val isbl: Int,
                        val isgl: Int,
                        val iszankoku: Int,
                        val istensei: Int,
                        val pc_or_k: Int,
                        val global_point: Int,
                        val fav_novel_cnt: Int,
                        val review_cnt: Int,
                        val all_point: Int,
                        val all_hyoka_cnt: Int,
                        val sasie_cnt: Int,
                        val kaiwaritu: Int,
                        val novelupdated_at: String,
                        val updated_at: String) {

    private val GENRE_ISEKAI = mapOf(101 to "異世界（恋愛）")
    private val GENRE_GENZITU = mapOf(102 to "現実世界（恋愛）")

    private val GENRE_HIGH_FANTAGY = mapOf(201 to "ハイファンタジー（ファンタジー）")
    private val GENRE_LOW_FANTAGY = mapOf(202 to "ローファンタジー（ファンタジー）")

    private val GENRE_JUNBUNGAKU = mapOf(301 to "純文学（文芸）")
    private val GENRE_HUMANDORAMA = mapOf(302 to "ヒューマンドラマ（文芸）")
    private val GENRE_HISTORY = mapOf(303 to "歴史（文芸）")
    private val GENRE_SUIRI = mapOf(304 to "推理（文芸）")
    private val GENRE_HORROR = mapOf(305 to "ホラー（文芸）")
    private val GENRE_ACTION = mapOf(306 to "アクション（文芸）")
    private val GENRE_COMEDY = mapOf(306 to "コメディ（文芸）")

    private val GENRE_VRGAME = mapOf(401 to "VRゲーム（SF）")
    private val GENRE_SPACE = mapOf(402 to "宇宙（SF）")
    private val GENRE_SF = mapOf(403 to "空想科学（SF）")
    private val GENRE_PANIC = mapOf(404 to "パニック（SF）")

    private val GENRE_FAIRYTAIE = mapOf(9901 to "童話（その他）")
    private val GENRE_POETRY = mapOf(9902 to "詩（その他）")
    private val GENRE_ESSAY = mapOf(9903 to "エッセイ（その他）")
    private val GENRE_REPLAY = mapOf(9904 to "リプレイ（その他）")
    private val GENRE_OTHER = mapOf(9999 to "その他（その他）")
    private val GENRE_NONGENRE = mapOf(9801 to "ノンジャンル（その他）")

    /**
     * ジャンル名を表示する
     */
    fun getGenreName() {

    }
}