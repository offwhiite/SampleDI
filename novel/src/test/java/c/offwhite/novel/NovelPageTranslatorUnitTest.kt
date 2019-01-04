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
    @Test
    fun htmlOnlyDevClass() {

        val inputStream = javaClass.classLoader?.getResourceAsStream("index.html")
        val bs = BufferedReader(InputStreamReader(inputStream))
        var htmlString = ""
        var str = bs.readLine()
        while (str != null) {
            htmlString = htmlString.plus(str).plus("¥n")
            str = bs.readLine()
        }

        val contents = NovelPageTranslator().translateResponseToText(htmlString)
        Assert.assertNotNull(contents)
    }
}