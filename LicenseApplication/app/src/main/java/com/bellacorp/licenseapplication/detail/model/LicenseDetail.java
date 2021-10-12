package com.bellacorp.licenseapplication.detail.model;

import com.bellacorp.licenseapplication.main.model.Header;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "response")
public class LicenseDetail {
    @Element
    public Header header;
    @Element
    public LicenseDetailBody body;
}
