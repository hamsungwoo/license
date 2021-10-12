package com.bellacorp.licenseapplication.main.model;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "item")
public class LicenseItem {
    // 종목코드
    @PropertyElement(name = "jmcd") public String jmcd;
    // 종목명
    @PropertyElement(name = "jmfldnm") public String jmfldnm;
    // 자격구분
    @PropertyElement(name = "qualgbcd") public String qualgbcd;
    // 자격구분명
    @PropertyElement(name = "qualgbnm") public String qualgbnm;
    // 계열코드
    @PropertyElement(name = "seriescd") public String seriescd;
    // 계열명
    @PropertyElement(name = "seriesnm") public String seriesnm;
    // 대직무분야코드
    @PropertyElement(name = "obligfldcd") public int obligfldcd;
    // 대직무분야명
    @PropertyElement(name = "obligfldnm") public String obligfldnm;
    // 중직무분야코드
    @PropertyElement(name = "mdobligfldcd") public int mdobligfldcd;
    // 중직무분야명
    @PropertyElement(name = "mdobligfldnm") public String mdobligfldnm;
}
