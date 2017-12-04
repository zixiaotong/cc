package com.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.springframework.util.StreamUtils;

/**
 * @author shanglei
 * @date 2017/8/25.
 */
public class SendPost {

    public static String sendPost(String url, String param, String contentType, String cookies) {
        PrintWriter out = null;
        InputStream in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if (contentType != null && !contentType.isEmpty()) {
                conn.setRequestProperty("Content-Type", contentType);
            }
            if (cookies != null && !cookies.isEmpty()) {
                conn.setRequestProperty("Cookie", cookies);
            }
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
}
