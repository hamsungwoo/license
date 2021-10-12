package com.bellacorp.licenseapplication.job.model;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml(name = "items")
public class JobList {
    @Element
    public List<JobItem> item;
}
