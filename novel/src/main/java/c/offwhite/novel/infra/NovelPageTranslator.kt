package c.offwhite.novel.infra

import c.offwhite.novel.domain.Chapter
import c.offwhite.novel.domain.Contents
import c.offwhite.novel.domain.PageInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class NovelPageTranslator {

    private val divChapter = "<div class=\"chapter_title\">"
    fun translateResponseToText(html: String): Contents? {
        if (html.isNullOrEmpty()) {
            return null
        }

        val document = Jsoup.parse(html)

        // あらすじ取得
        val summary = document.select("div#novel_ex").first().ownText()

        // 章取得
        // なぜかわからないが章ごとにdivでグループ分けされておらず、このままelementsから章タイトルを取ろうとしても
        // どこまでが章内のタイトルなのかわからない。
        // そこで、まずdiv class=chapter_titleごとにhtmlを分割し、
        // それをさらにparseする作戦とする。
        val chapterListElements = document.getElementsByClass("index_box")
        val chapterList = chapterListElements.html()
            .split(Regex(divChapter))
            .drop(1)// splitで分けているので、配列要素１は必ず不要な情報となる。そのため削除。
            .map { divChapter.plus(it) }
            .map { Jsoup.parse(it)}
            .map { createChapter(it.body())}

        return Contents(summary, chapterList)
//
//        // 本文取得
//        val element = document.getElementById("novel_honbun")
//
//        // 整形
//        var body = element.html()
//        val kaigyo = System.getProperty("line.separator")
//        body = body.replace(kaigyo.toRegex(), "")
//        body = body
//            .replace("<ruby>".toRegex(), "")
//            .replace("</ruby>".toRegex(), "")
//            .replace("<rb>".toRegex(), "")
//            .replace("</rb>".toRegex(), "")
//            .replace("<rt>".toRegex(), "")
//            .replace("</rt>".toRegex(), "")
//            .replace("<rp>".toRegex(), "")
//            .replace("</rp>".toRegex(), "")
//        body = body.replace("<br>".toRegex(), kaigyo)
    }

    private fun createPageInfo(element: Element): PageInfo {
        val pageTitle = element.getElementsByClass("subtitle").text()
        val updateDate = element.getElementsByClass("long_update").first().ownText()
        return PageInfo(pageTitle, updateDate)
    }

    private fun createChapter(element: Element): Chapter {
        val chapterTitle = element.getElementsByClass("chapter_title").first().ownText()
        val list = element.getElementsByClass("novel_sublist2").map { subListElement -> createPageInfo(subListElement) }
        return Chapter(chapterTitle, list)
    }
}

