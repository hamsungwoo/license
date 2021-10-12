package com.bellacorp.licenseapplication.job.model;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "body")
public class JobBody {
    @Element
    public JobList items;
    @PropertyElement(name = "numOfRows") public int numOfRows;
    @PropertyElement(name = "pageNo") public int pageNo;
    @PropertyElement(name = "totalCount") public int totalCount;
}
