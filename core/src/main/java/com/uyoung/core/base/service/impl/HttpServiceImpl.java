package com.uyoung.core.base.service.impl;

import com.uyoung.core.base.service.HttpService;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Desc:
 * <p/>Date: 2015-10-15
 * <br/>Time: 14:03
 * <br/>User: ylzhu
 */
@Service("httpService")
public class HttpServiceImpl implements HttpService {

    private final RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(15000)
            .setConnectTimeout(15000)
            .setConnectionRequestTimeout(15000)
            .build();


    public String sendGetRequest(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);
        return sendGetRequest(httpGet);
    }

    /**
     * 发送 post请求
     *
     * @param httpUrl 地址
     * @param params  参数(格式:key1=value1&key2=value2)
     */
    public String sendPostRequest(String httpUrl, String params) {
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
        try {
            //设置参数
            StringEntity stringEntity = new StringEntity(params, "UTF-8");
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(stringEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendRequest(httpPost);
    }

    @Override
    public String sendPostRequest(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        if (url.contains("\\?")) {
            String[] urls = url.split("\\?");
            return sendPostRequest(urls[0], urls[1]);
        } else {
            return sendPostRequest(url, null);
        }
    }

    /**
     * 发送Get请求
     *
     * @param httpGet
     * @return
     */
    private String sendGetRequest(HttpGet httpGet) {
        return sendRequest(httpGet);
    }


    private String sendRequest(HttpRequestBase requestBase) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            requestBase.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(requestBase);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
}
