package com.bellacorp.licenseapplication.detail.model;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml(name = "items")
public class LicenseDetailList {
    @Element
    public List<LicenseDetailItem> item;
}
