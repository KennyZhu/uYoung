package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.constant.CommonConstant;
import com.uyoung.core.api.dao.DictCityDao;
import com.uyoung.core.api.model.DictCity;
import com.uyoung.core.api.service.DictCityService;
import com.uyoung.core.base.service.HttpService;
import org.apache.commons.collections.CollectionUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.*;

/**
 * Desc:
 * <p/>Date: 2015-11-18
 * <br/>Time: 12:02
 * <br/>User: ylzhu
 */
@Service
public class DictCityServiceImpl implements DictCityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DictCityServiceImpl.class);
    private static final String BASE_URL = "http://flash.weather.com.cn/wmaps/xml/";
    private static final String URL_58 = "http://dict.58.com/api/local/getLocalList/?pid=0&qq-pf-to=pcqq.c2c";

    @Autowired
    private HttpService httpService;

    @Autowired
    private DictCityDao dictCityDao;


    @Override
    public void buildBaseData() {
        buildProvinceData("china");
    }

    @Override
    public List<DictCity> getDictCityListByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return dictCityDao.getListByIds(ids);
    }

    @Override
    public List<DictCity> getDefaultCityList() {
        List<Integer> provinceIdList = Arrays.asList(CommonConstant.CITIES);
        List<DictCity> allCityList = dictCityDao.getListByIds(provinceIdList);
        List<DictCity> provinceList = new ArrayList<>();
        Map<Integer, List<DictCity>> cityMap = new HashMap<>();
        for (DictCity city : allCityList) {
            if (provinceIdList.contains(city.getId())) {
                provinceList.add(city);
            } else if (provinceIdList.contains(city.getPid())) {
                List<DictCity> subCityList = cityMap.get(city.getPid());
                if (CollectionUtils.isEmpty(subCityList)) {
                    subCityList = new ArrayList<>();
                    subCityList.add(city);
                    cityMap.put(city.getPid(), subCityList);
                } else {
                    subCityList.add(city);
                }
            }
        }

        for (DictCity province : provinceList) {
            List<DictCity> subCityList = cityMap.get(province.getId());
            if (CollectionUtils.isNotEmpty(subCityList)) {
                province.setSubDictCityList(subCityList);
            } else {
                DictCity provinceSelf = province.clone();
                province.setSubDictCityList(Arrays.asList(provinceSelf));
            }
        }
        return provinceList;
    }

    private void buildProvinceData(String cityEnName) {
        String url = BASE_URL + cityEnName + ".xml";
        LOGGER.info("#Begin to get dataXml enName is " + cityEnName);
        try {
            String dataXml = httpService.sendGetRequest(url);
            LOGGER.info("#Begin to get enName is " + cityEnName + " dataXml is " + dataXml);
            StringReader read = new StringReader(dataXml);
            InputSource source = new InputSource(read);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document cityDocument = saxBuilder.build(source);
            List<Element> cityElementList = cityDocument.getRootElement().getChildren();
            for (Element element : cityElementList) {
                String cnName = element.getAttributeValue("quName");
                String enName = element.getAttributeValue("pyName");
                DictCity province = new DictCity(cnName, enName, 0);
                dictCityDao.insert(province);
                buildCityData(enName, cnName);
            }
        } catch (Exception e) {
            LOGGER.error("#Update EnName error.enName is " + cityEnName + "Cause:", e);

        }
    }

    private void buildCityData(String cityEnName, String provinceCnName) {
        String url = BASE_URL + cityEnName + ".xml";
        LOGGER.info("#Begin to get dataXml enName is " + cityEnName);
        try {
            String dataXml = httpService.sendGetRequest(url);
            LOGGER.info("#Begin to get enName is " + cityEnName + " dataXml is " + dataXml);
            StringReader read = new StringReader(dataXml);
            InputSource source = new InputSource(read);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document cityDocument = saxBuilder.build(source);
            List<Element> cityElementList = cityDocument.getRootElement().getChildren();
            for (Element element : cityElementList) {
                String cnName = element.getAttributeValue("cityname");
                String enName = element.getAttributeValue("pyName");
                DictCity province = dictCityDao.getByCnName(provinceCnName);
                if (province != null) {
                    DictCity city = new DictCity(cnName, enName, province.getId());
                    dictCityDao.insert(city);
                }
            }
        } catch (Exception e) {
            LOGGER.error("#Update EnName error.enName is " + cityEnName + "Cause:", e);
            e.printStackTrace();
        }
    }

    private void buildLonLat() {
//        try {
//            String jsonData = httpService.sendGetRequest(URL_58);
//        } catch (Exception e) {
//            LOGGER.error("#Update EnName error.enName is " + cityEnName + "Cause:", e);
//            e.printStackTrace();
//        }

    }
}
