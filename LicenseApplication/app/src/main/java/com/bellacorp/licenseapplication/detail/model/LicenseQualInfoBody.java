package com.bellacorp.licenseapplication.detail.model;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "body")
public class LicenseQualInfoBody {
    @Element
    public LicenseQualInfoList items;
}
