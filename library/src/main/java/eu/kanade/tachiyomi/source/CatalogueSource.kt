package eu.kanade.tachiyomi.source

import eu.kanade.tachiyomi.source.model.FilterList
import eu.kanade.tachiyomi.source.model.MangasPage
import eu.kanade.tachiyomi.source.model.SManga

@Suppress("unused")
interface CatalogueSource : Source {

    /**
     * An ISO 639-1 compliant language code (two letters in lower case).
     */
    val lang: String

    /**
     * Whether the source has support for latest updates.
     */
    val supportsLatest: Boolean

    /**
     * Get a page with a list of manga.
     *
     * @since extensions-lib 1.5
     * @param page the page number to retrieve.
     */
    suspend fun getPopularManga(page: Int): MangasPage

    /**
     * Get a page with a list of manga.
     *
     * @since extensions-lib 1.5
     * @param page the page number to retrieve.
     * @param query the search query.
     * @param filters the list of filters to apply.
     */
    suspend fun getSearchManga(page: Int, query: String, filters: FilterList): MangasPage

    /**
     * Get a page with a list of latest manga updates.
     *
     * @since extensions-lib 1.5
     * @param page the page number to retrieve.
     */
    suspend fun getLatestUpdates(page: Int): MangasPage

    /**
     * Returns the list of filters for the source.
     */
    fun getFilterList(): FilterList

    // KMK -->
    /**
     * Whether parsing related mangas in manga page or extension provide custom related mangas request.
     * @default false
     * @since komikku/extensions-lib 1.6
     */
    val supportsRelatedMangas: Boolean get() = false

    /**
     * Extensions doesn't want to use App's [getRelatedMangaListBySearch].
     * @default false
     * @since komikku/extensions-lib 1.6
     */
    val disableRelatedMangasBySearch: Boolean get() = false

    /**
     * Disable showing any related titles.
     * @default false
     * @since komikku/extensions-lib 1.6
     */
    val disableRelatedMangas: Boolean get() = false

    /**
     * Get all the available related mangas for a manga.
     * Normally it's not needed to override this method.
     *
     * @since komikku/extensions-lib 1.6
     * @param manga the current manga to get related mangas.
     * @return a list of <keyword, related mangas>
     * @throws UnsupportedOperationException if a source doesn't support related mangas.
     */
    override suspend fun getRelatedMangaList(
        manga: SManga,
        exceptionHandler: (Throwable) -> Unit,
        pushResults: suspend (relatedManga: Pair<String, List<SManga>>, completed: Boolean) -> Unit,
    ) {
        throw Exception("Stub!")
    }

    /**
     * Get related mangas provided by extension
     *
     * @return a list of <keyword, related mangas>
     * @since komikku/extensions-lib 1.6
     */
    suspend fun getRelatedMangaListByExtension(
        manga: SManga,
        pushResults: suspend (relatedManga: Pair<String, List<SManga>>, completed: Boolean) -> Unit,
    ) {
        throw Exception("Stub!")
    }

    /**
     * Fetch related mangas for a manga from source/site.
     *
     * @since komikku/extensions-lib 1.6
     * @param manga the current manga to get related mangas.
     * @return the related mangas for the current manga.
     * @throws UnsupportedOperationException if a source doesn't support related mangas.
     */
    suspend fun fetchRelatedMangaList(manga: SManga): List<SManga> = throw UnsupportedOperationException("Unsupported!")

    /**
     * Slit & strip manga's title into separate searchable keywords.
     * Used for searching related mangas.
     *
     * @since komikku/extensions-lib 1.6
     * @return List of keywords.
     */
    fun String.stripKeywordForRelatedMangas(): List<String> {
        throw Exception("Stub!")
    }

    /**
     * Get related mangas by searching for each keywords from manga's title.
     *
     * @return a list of <keyword, related mangas>
     * @since komikku/extensions-lib 1.6
     */
    suspend fun getRelatedMangaListBySearch(
        manga: SManga,
        pushResults: suspend (relatedManga: Pair<String, List<SManga>>, completed: Boolean) -> Unit,
    ) {
        throw Exception("Stub!")
    }
    // KMK <--
}