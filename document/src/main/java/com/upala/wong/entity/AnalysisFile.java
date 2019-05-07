package com.upala.wong.entity;

import lombok.Data;

import java.util.Date;

/*****************************
 *  @author 王鹏
 *  @version 2019/5/7 15:54
 *  @package com.upala.wong
 *  @project document
 *  @describe
 *****************************/

@Data
public class AnalysisFile
{

    private int id;
    private String fileUUID;
    private String fileType;
    private int fileTypeCode;
    private Date fileUploadDate;
    private String fileUploadName;

}
