package com.yls.demo.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author yunglee on 2021/07/25
 * @package com.yls.demo.pojo
 */
public class Location {
    @SerializedName("locationName")
    private String name;
    @SerializedName("weatherElement")
    private List<Element> elements;
}
