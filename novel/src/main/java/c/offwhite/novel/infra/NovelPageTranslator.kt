package c.offwhite.novel.infra

import c.offwhite.novel.domain.Chapter
import c.offwhite.novel.domain.Contents
import c.offwhite.novel.domain.PageInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

/**
 * なろうの目次HTMLをパースし、ドメインに変換する
 */
class NovelPageTranslator {

    // divChapterのタグ
    private val divChapter = "<div class=\"chapter_title\">"

    /**
     * htmlをパースする
     */
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

        val count = document.getElementsByClass("chapter_title")

        // チャプターありの場合
        if (count.size > 0) {
            val chapterList = chapterListElements.html()
                .split(Regex(divChapter))
                .drop(1)// splitで分けているので、配列要素１は必ず不要な情報となる。そのため削除。
                .map { divChapter.plus(it) }
                .map { Jsoup.parse(it) }
                .map { createChapter(it.body()) }

            return Contents(summary, chapterList)
        }
        // チャプターなしの場合
        else {

            val chapterListHtml = chapterListElements.html()
            val chapterListElement = Jsoup.parse(chapterListHtml).body()
            val chapterList = createChapter(chapterListElement)

            return Contents(summary, arrayListOf(chapterList))
        }
    }


    /**
     * PageInfoを作成する
     */
    private fun createPageInfo(element: Element): PageInfo {
        val pageTitle = element.getElementsByClass("subtitle").text()
        val updateDate = element.getElementsByClass("long_update").first().ownText()
        return PageInfo(pageTitle, updateDate)
    }

    /**
     * チャプターを生成する
     */
    private fun createChapter(element: Element): Chapter {

        // chapter title elementsを取得する
        val chapterTitle = element.getElementsByClass("chapter_title")

        // チャプターがない場合はchapterTitle.hasText()が空になる。その場合は""とする
        val chapterTitleString = if(chapterTitle.hasText()) element.getElementsByClass("chapter_title").first().ownText() else ""

        // pageInfoを取得する
        val list = element.getElementsByClass("novel_sublist2")
            .map { subListElement -> createPageInfo(subListElement) }

        // Chapterを返却をする
        return Chapter(chapterTitleString, list)
    }
}

