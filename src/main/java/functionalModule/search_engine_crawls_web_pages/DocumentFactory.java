package functionalModule.search_engine_crawls_web_pages;

/**
 * 通过工厂方法来创建Document
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/2 14:49
 */
public class DocumentFactory {

    private HtmlDownloader downloader;

    public DocumentFactory(HtmlDownloader downloader) {
        this.downloader = downloader;
    }

    public Document createDocument(String url) {
        Html html = downloader.downloadHtml(url);
        return new Document(html, url);
    }
}
