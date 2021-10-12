package com.bellacorp.licenseapplication.job.model;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "item")
public class JobItem {
    @PropertyElement(name = "udeptcd") public String udeptcd;
    @PropertyElement(name = "udeptmdobligcd") public String udeptmdobligcd;
    @PropertyElement(name = "udeptmdoblignm") public String udeptmdoblignm;
    @PropertyElement(name = "udeptnm") public String udeptnm;
    @PropertyElement(name = "udeptobligcd") public int udeptobligcd;
    @PropertyElement(name = "udeptoblignm") public String udeptoblignm;

    public String getUdeptmdobligcd() {
        return udeptmdobligcd;
    }

    public String getUdeptmdoblignm() {
        return udeptmdoblignm;
    }
}
