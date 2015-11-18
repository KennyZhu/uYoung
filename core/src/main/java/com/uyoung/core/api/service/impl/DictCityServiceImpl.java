package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.service.DictCityService;
import com.uyoung.core.base.service.HttpService;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Desc:
 * <p/>Date: 2015-11-18
 * <br/>Time: 12:02
 * <br/>User: ylzhu
 */
@Service
public class DictCityServiceImpl implements DictCityService {

    private static final String BASE_URL = "http://flash.weather.com.cn/wmaps/xml/china.xml";
    private static final String BEIJING_URL = "http://flash.weather.com.cn/wmaps/xml/beijing.xml";
    private static final String url = "http://dict.58.com/api/local/getLocalList/?pid=0&qq-pf-to=pcqq.c2c";
    private static final String FILE_NAME = "city_new.xml";

    @Autowired
    private HttpService httpService;


    @Override
    public void buildBaseData() {
        String chinaXml = httpService.sendGetRequest(BASE_URL);
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            String filePath = this.getClass().getClassLoader().getResource("/").getPath();
            InputStream inputStream = new FileInputStream(new File(filePath + FILE_NAME));
            InputSource inputSource = new InputSource(inputStream);
            Document cityDocument = saxBuilder.build(inputSource);
            List<Element> elementList = cityDocument.getRootElement().getChild("province").getChildren();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
