package functionalModule.search_engine_crawls_web_pages;

import javax.naming.Context;

/**
 * 发送对象
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/2 14:29
 */
public class HtmlRequest {

    private String address;
    private String url;
    private Context context;

    public HtmlRequest(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Context getContext() {
        return context;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected class Context{
        private Byte[] bytes;

        public Byte[] getBytes() {
            return bytes;
        }

    }
}
