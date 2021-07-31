package com.yls.app.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author yunglee on 2021/07/25
 * @package com.yls.demo.pojo
 */
public class Element {
    @SerializedName("elementName")
    private String name;
    private List<TimeRecord> time;
}
