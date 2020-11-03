package functionalModule.search_engine_crawls_web_pages;

/**
 * 底层网络通信
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/2 14:27
 */
public class NetworkTransporter {

    //============== 优化前 ==============
//    public Byte[] send(HtmlRequest htmlRequest){
//        //..
//        return new Byte[]{};
//    }

    //作为一个底层网络通信类，我们希望它的功能尽可能通用，而不只是服务于下载 HTML，
    // 所以，我们不应该直接依赖太具体的发送对象 HtmlRequest。

    //=========== 优化后 ====================

    public Byte[] send(String address,Byte[] data){
        //..
        return new Byte[]{};
    }

}
