package c.offwhite.novel

import java.io.BufferedReader
import java.io.InputStreamReader

class FileManager {

    fun openResourcesFile(fileName : String): String {
        // ファイル取得
        val inputStream = javaClass.classLoader?.getResourceAsStream(fileName)
        val bs = BufferedReader(InputStreamReader(inputStream))
        var htmlString = ""
        var str = bs.readLine()
        while (str != null) {
            htmlString = htmlString.plus(str).plus("¥n")
            str = bs.readLine()
        }
        return htmlString
    }
}