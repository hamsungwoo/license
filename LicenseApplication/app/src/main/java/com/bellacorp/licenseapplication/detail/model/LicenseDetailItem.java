package com.bellacorp.licenseapplication.detail.model;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "item")
public class LicenseDetailItem {
    // 진로
    @PropertyElement(name = "Career") public String Career;
    // 자격영문명
    @PropertyElement(name = "engJmNm") public String engJmNm;
    // 변천과정
    @PropertyElement(name = "hist") public String hist;
    // 시행기관
    @PropertyElement(name = "implNm") public String implNm;
    // 관련 부처
    @PropertyElement(name = "instiNm") public String instiNm;
    // 자격명
    @PropertyElement(name = "jmNm") public String jmNm;
    // 수행직무
    @PropertyElement(name = "job") public String job;
    // 직종
    @PropertyElement(name = "mdobligFldNm") public String mdobligFldNm;
    // 자격등급
    @PropertyElement(name = "seriesNm") public String seriesNm;
    // 개요
    @PropertyElement(name = "summary") public String summary;
    // 출제경향
    @PropertyElement(name = "trend") public String trend;
}
