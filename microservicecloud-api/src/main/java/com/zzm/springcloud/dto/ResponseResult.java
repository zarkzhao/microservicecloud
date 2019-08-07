package com.zzm.springcloud.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ResponseResult implements Serializable {
    private Integer code;
    private String data;
    private String message;
}
