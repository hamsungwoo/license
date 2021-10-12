package com.bellacorp.licenseapplication.job.model;

import com.bellacorp.licenseapplication.main.model.Header;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "response")
public class JobModel {
    @Element
    public Header header;
    @Element
    public JobBody body;
}
