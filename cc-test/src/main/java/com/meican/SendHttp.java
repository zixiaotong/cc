package com.meican;

import org.springframework.util.StreamUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @author shanglei
 * @date 2017/8/25.
 */
public class SendHttp {

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        InputStream in = null;
        String result;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "application/json, text/plain, */*");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("Cookie", "Hm_lvt_d63dbf1497d491c4e3cf91f6efab2555=1548390323; machineId=40cfb2b7-2c19-42ff-9a0d-4ef3e478b324; guestId=e84a8b5c-7d0e-4e7f-82b1-849c90b0f698; __utma=1.605528390.1548390324.1548390324.1548390324.1; __utmc=1; __utmz=1.1548390324.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); remember=36d11ca8b857ceeaa1b9434c8e0fae6522c2eeb1-1220397; Hm_lpvt_d63dbf1497d491c4e3cf91f6efab2555=1548395482");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = conn.getInputStream();
            result = StreamUtils.copyToString(in, Charset.forName("utf-8"));
        } catch (Exception var17) {
            throw new RuntimeException(url + "发送 POST 请求出现异常！", var17);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException var16) {
                var16.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "application/json, text/plain, */*");
            connection.setRequestProperty("connection", "keep-alive");
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestProperty("Cookie", "Hm_lvt_d63dbf1497d491c4e3cf91f6efab2555=1548390323; machineId=40cfb2b7-2c19-42ff-9a0d-4ef3e478b324; guestId=e84a8b5c-7d0e-4e7f-82b1-849c90b0f698; __utma=1.605528390.1548390324.1548390324.1548390324.1; __utmc=1; __utmz=1.1548390324.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); remember=36d11ca8b857ceeaa1b9434c8e0fae6522c2eeb1-1220397; Hm_lpvt_d63dbf1497d491c4e3cf91f6efab2555=1548395482");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
