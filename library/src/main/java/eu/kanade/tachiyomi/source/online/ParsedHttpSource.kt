package eu.kanade.tachiyomi.source.online

import eu.kanade.tachiyomi.source.model.MangasPage
import eu.kanade.tachiyomi.source.model.Page
import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga
import okhttp3.Response
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

/**
 * A simple implementation for sources from a website using Jsoup, an HTML parser.
 */
@Suppress("unused")
abstract class ParsedHttpSource : HttpSource() {

    /**
     * Parses the response from the site and returns a [MangasPage] object.
     * Normally it's not needed to override this method.
     *
     * @param response the response from the site.
     */
    override fun popularMangaParse(response: Response): MangasPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each manga.
     */
    protected abstract fun popularMangaSelector(): String

    /**
     * Returns a manga from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [popularMangaSelector].
     */
    protected abstract fun popularMangaFromElement(element: Element): SManga

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    protected abstract fun popularMangaNextPageSelector(): String?

    /**
     * Parses the response from the site and returns a [MangasPage] object.
     * Normally it's not needed to override this method.
     *
     * @param response the response from the site.
     */
    override fun searchMangaParse(response: Response): MangasPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each manga.
     */
    protected abstract fun searchMangaSelector(): String

    /**
     * Returns a manga from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [searchMangaSelector].
     */
    protected abstract fun searchMangaFromElement(element: Element): SManga

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    protected abstract fun searchMangaNextPageSelector(): String?

    /**
     * Parses the response from the site and returns a [MangasPage] object.
     * Normally it's not needed to override this method.
     *
     * @param response the response from the site.
     */
    override fun latestUpdatesParse(response: Response): MangasPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each manga.
     */
    protected abstract fun latestUpdatesSelector(): String

    /**
     * Returns a manga from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [latestUpdatesSelector].
     */
    protected abstract fun latestUpdatesFromElement(element: Element): SManga

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    protected abstract fun latestUpdatesNextPageSelector(): String?

    /**
     * Parses the response from the site and returns the details of a manga.
     * Normally it's not needed to override this method.
     *
     * @param response the response from the site.
     */
    override fun mangaDetailsParse(response: Response): SManga {
        throw Exception("Stub!")
    }

    /**
     * Returns the details of the manga from the given [document].
     *
     * @param document the parsed document.
     */
    protected abstract fun mangaDetailsParse(document: Document): SManga

    // KMK -->
    /**
     * Parses the response from the site and returns a list of related mangas.
     * Normally it's not needed to override this method.
     *
     * @since komikku/extensions-lib 1.6
     * @param response the response from the site.
     */
    override fun relatedMangaListParse(response: Response): List<SManga> {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each related mangas.
     *
     * @since komikku/extensions-lib 1.6
     */
    protected open fun relatedMangaListSelector(): String = throw Exception("Stub!")

    /**
     * Returns a manga from the given element.
     *
     * @since komikku/extensions-lib 1.6
     * @param element an element obtained from [relatedMangaListSelector].
     */
    protected open fun relatedMangaFromElement(element: Element): SManga = throw Exception("Stub!")
    // KMK <--

    /**
     * Parses the response from the site and returns a list of chapters.
     * Normally it's not needed to override this method.
     *
     * @param response the response from the site.
     */
    override fun chapterListParse(response: Response): List<SChapter> {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each chapter.
     */
    protected abstract fun chapterListSelector(): String

    /**
     * Returns a chapter from the given element.
     *
     * @param element an element obtained from [chapterListSelector].
     */
    protected abstract fun chapterFromElement(element: Element): SChapter

    /**
     * Parses the response from the site and returns the page list.
     * Normally it's not needed to override this method.
     *
     * @param response the response from the site.
     */
    override fun pageListParse(response: Response): List<Page> {
        throw Exception("Stub!")
    }

    /**
     * Returns a page list from the given document.
     *
     * @param document the parsed document.
     */
    protected abstract fun pageListParse(document: Document): List<Page>

    /**
     * Parse the response from the site and returns the absolute url to the source image.
     * Normally it's not needed to override this method.
     *
     * @param response the response from the site.
     */
    override fun imageUrlParse(response: Response): String {
        throw Exception("Stub!")
    }

    /**
     * Returns the absolute url to the source image from the document.
     *
     * @param document the parsed document.
     */
    protected abstract fun imageUrlParse(document: Document): String
}
