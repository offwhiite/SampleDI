package c.offwhite.novel

import android.util.Log
import c.offwhite.novel.infra.NovelPageTranslator
import com.googlecode.eyesfree.compat.CompatUtils.getClass
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import java.io.BufferedReader
import java.io.InputStreamReader


@RunWith(RobolectricTestRunner::class)
class NovelPageTranslatorUnitTest {


    /**
     * チャプターがある場合の正常系HTMLのパーステスト
     */
    @Test
    fun 正常系チャプターあり() {

        // ファイル取得
        val htmlString = FileManager().openResourcesFile("index.html")

        // コンテンツ取得
        val contents = NovelPageTranslator().translateResponseToText(htmlString)

        if (contents == null) {
            Assert.assertNotNull(contents)
            return
        }

        Assert.assertEquals(contents.chapters.size, 5)
        Assert.assertEquals(contents.chapters[0].chapterTitle, "第一部　幼少期～少年時代")
        Assert.assertEquals(contents.chapters[0].pageInfo.size, 57)
    }

    /**
     * チャプターがない場合の正常系HTMLのパーステスト
     */
    @Test
    fun 正常系チャプターなし() {

        // ファイル取得
        val htmlString = FileManager().openResourcesFile("no_chapter_index.html")

        // コンテンツ取得
        val contents = NovelPageTranslator().translateResponseToText(htmlString)

        if (contents == null) {
            Assert.assertNotNull(contents)
            return
        }

        Assert.assertEquals(contents.chapters.size, 1)
        Assert.assertEquals(contents.chapters[0].chapterTitle, "")
        Assert.assertEquals(contents.chapters[0].pageInfo.size, 13)
    }
}