package com.sqldoc.soft.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class AbstractBaseVO implements Cloneable, Serializable {
    private String id;
    private Date createdDate;
    private Date lastModifiedDate;
    private String createdBy;
    private String lastModifiedBy;
}
