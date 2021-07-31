package com.yls.app.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * @author yunglee on 2021/07/25
 * @package com.yls.demo.pojo
 */
public class Parameter {
    @SerializedName("parameterName")
    private String name;
    @SerializedName("parameterValue")
    private String value;
}
