package com.bellacorp.licenseapplication.main.model;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "body")
public class Body {
    @Element
    public LicenseList licenseList;
}
