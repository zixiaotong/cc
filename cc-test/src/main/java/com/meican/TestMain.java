package com.meican;


/**
 * @author shanglei
 * @date 2017/8/25.
 */
public class TestMain {
    // 此接口可以查看今天定了什么餐。
    private static String url = "https://meican.com/preorder/api/v2.1/calendaritems/list?withOrderDetail=false&beginDate=2019-01-25&endDate=2019-01-25";
    // 此接口可以查看今天有哪些吃的？猜得，待更正
    private static String url1 = "https://meican.com/preorder/api/v2.1/orders/unpaidList";
    // 配送地点名称和id
    private static String url2 = "https://meican.com/preorder/api/v2.1/accounts/entrance";
    // 此接口get请求
    private static String url3 = "https://meican.com/preorder/api/v2.1/specialaccount/related";
    // 配送地址
    private static String url4 = "https://meican.com/preorder/api/v2.1/corps/show?namespace=416046";
    private static String url5 = "https://meican.com/preorder/api/v2.1/favourite/all";
    private static String url6 = "https://meican.com/preorder/api/v2.1/corpNotice/list";
    private static String url7 = "https://meican.com/preorder/api/v2.1/orders/show";
    private static String url8 = "https://meican.com/preorder/api/v2.1/corpaddresses/getmulticorpaddress?namespace=416046";

    private static String url9 = "https://meican.com/preorder/api/v2.1/recommendations/dishes";

    public static void main(String[] args) {
//        String s = SendHttp.sendPost(url, "");
//        System.out.println(s);

//param = "CorpID=" + CorpID + "&LoginName=" + LoginName
        System.out.println(SendHttp.sendPost(url9,
                "tabUniqueId=dee31017-9592-4c80-900d-c162eed0a31d&targetTime=2019-01-28%2011%3A00"));
//                "tabUniqueId=" + "dee31017-9592-4c80-900d-c162eed0a31d" + "&targetTime=" + "2019-01-28 11:00"));
//                "tabUniqueId:dee31017-9592-4c80-900d-c162eed0a31d;targetTime:2019-01-28 11:00"));


//        String s1 = SendHttp.sendGet(url5, "");
//        String s1 = SendHttp.sendGet(url7, "");
//        System.out.println(s1);
    }

}
