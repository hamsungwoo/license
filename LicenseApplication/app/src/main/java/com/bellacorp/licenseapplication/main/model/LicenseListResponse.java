package com.bellacorp.licenseapplication.main.model;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "response")
public class LicenseListResponse {
    @Element
    public Header header;
    @Element
    public Body body;
}