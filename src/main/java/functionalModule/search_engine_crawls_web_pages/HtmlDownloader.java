package functionalModule.search_engine_crawls_web_pages;


/**
 * 通过URL获取网页
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/2 14:27
 */
public class HtmlDownloader {
    // 通过构造函数或IOC注入

    private NetworkTransporter transporter;

    public Html downloadHtml(String url){
//        Byte[] rawHtml = transporter.send(new HtmlRequest(url));
//        return new Html(rawHtml);

        HtmlRequest htmlRequest = new HtmlRequest(url);
        Byte[] rawHtml = transporter.send(htmlRequest.getAddress(),
                htmlRequest.getContext().getBytes());
        return new Html(rawHtml);
    }

}
