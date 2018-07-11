package com.minghui.jdbc.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * POJO类，对应数据表crm_user
 * @author minghui.y
 * @create 2018-07-11 16:46
 **/
@Data
@ToString
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer roleId;
    private String status;
    private Date gmtCreated;
    private Date gmtModified;
}
