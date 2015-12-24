package com.uyoung.web.vo;

/**
 * Desc:
 * <p/>Date: 2015-12-24
 * <br/>Time: 10:55
 * <br/>User: ylzhu
 */
public class PhotoInfoUrlVo {
    /**
     * 下载地址
     */
    private String downLoadUrl;

    /**
     * exif地址
     */
    private String exifUrl;

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }

    public String getExifUrl() {
        return exifUrl;
    }

    public void setExifUrl(String exifUrl) {
        this.exifUrl = exifUrl;
    }

    @Override
    public String toString() {
        return "PhotoInfoUrlVo{" +
                "downLoadUrl='" + downLoadUrl + '\'' +
                ", exifUrl='" + exifUrl + '\'' +
                '}';
    }
}
