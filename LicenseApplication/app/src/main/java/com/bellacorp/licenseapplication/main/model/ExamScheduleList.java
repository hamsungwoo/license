package com.bellacorp.licenseapplication.main.model;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml(name = "items")
public class ExamScheduleList {
    @Element
    public List<ExamScheduleItem> item;
}
