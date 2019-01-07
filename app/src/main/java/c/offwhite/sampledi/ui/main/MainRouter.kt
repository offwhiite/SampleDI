package c.offwhite.sampledi.ui.main

import android.content.Context
import android.content.Intent
import c.off.white.viewer.ScrollingActivity

/**
 * メイン画面の画面遷移管理クラス
 */
class MainRouter(val context: Context) {

    // intent用のパラメータ
    val NCODE = "ncode"

    fun translateViewer(ncode: String) {

        val intent = Intent(context, ScrollingActivity::class.java)
        intent.putExtra(NCODE, ncode)
        context.startActivity(intent)
    }
}