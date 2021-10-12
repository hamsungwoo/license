package com.bellacorp.licenseapplication.detail.model;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "item")
public class LicenseQualInfoItem {
    // 종목명
    @PropertyElement(name = "jmfldnm") public String jmfldnm;
    // 정보구분
    @PropertyElement(name = "infogb") public String infogb;
    // 내용
    @PropertyElement(name = "contents") public String contents;
    // 대직무분야코드
    @PropertyElement(name = "obligfldcd") public int obligfldcd;
    // 대직무분야명
    @PropertyElement(name = "obligfldnm") public String obligfldnm;
    // 중직무분야코드
    @PropertyElement(name = "mdobligfldcd") public int mdobligfldcd;
    // 중직무분야명
    @PropertyElement(name = "mdobligfldnm") public String mdobligfldnm;
}
