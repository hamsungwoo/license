package com.bellacorp.licenseapplication.main.model;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "item")
public class ExamScheduleItem {
    // 회차
    @PropertyElement(name = "description") public String description;
    // 필기시험원서접수시작일자
    @PropertyElement(name = "docRegStartDt") public String docRegStartDt;
    // 필기시험원서접수종료일자
    @PropertyElement(name = "docRegEndDt") public String docRegEndDt;
    // 필기시험일자
    @PropertyElement(name = "docExamDt") public String docExamDt;
    // 필기시험 합격(예정)자 발표일자
    @PropertyElement(name = "docPassDt") public String docPassDt;
    // 응시자격 서류제출시작일자
    @PropertyElement(name = "docSubmitStartDt") public String docSubmitStartDt;
    // 응시자격 서류제출종료일자
    @PropertyElement(name = "docSubmitEntDt") public String docSubmitEntDt;
    // 실기시험원서접수시작일자
    @PropertyElement(name = "pracRegStartDt") public String pracRegStartDt;
    // 실기시험원서접수종료일자
    @PropertyElement(name = "pracRegEndDt") public String pracRegEndDt;
    // 실기시험시작일자
    @PropertyElement(name = "pracExamStartDt") public String pracExamStartDt;
    // 실기시험종료일자
    @PropertyElement(name = "pracExamEndDt") public String pracExamEndDt;
    // 합격자발표일자
    @PropertyElement(name = "pracPassDt") public String pracPassDt;
}
