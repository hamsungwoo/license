package com.bellacorp.licenseapplication.main.model;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "header")
public class Header {
    @PropertyElement
    public int resultCode;
    @PropertyElement
    public String resultMsg;
}

