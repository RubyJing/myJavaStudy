package functionalModule.search_engine_crawls_web_pages;

/**
 * 网页文档
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/2 14:28
 */
public class Document {
    private Html html;
    private String url;

    //-------------- 优化前 ---------------
//    public Document(String url) {
//        this.url = url;
//        HtmlDownloader downloader = new HtmlDownloader();
//        this.html = downloader.downloadHtml(url);
//    }

    //-------------- 优化后 ---------------

    public Document(Html html, String url) {
        this.html = html;
        this.url = url;
    }
}
