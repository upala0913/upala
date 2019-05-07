package com.upala.wong.utils;

import java.util.ResourceBundle;

/*****************************
 *  @author 王鹏
 *  @version 2019/4/13 11:07
 *  @package com.upala.wong.utils
 *  @project document
 *  @describe
 *****************************/
public class PathConf
{

    private static final String PATH;

    static
    {
        ResourceBundle rb=  ResourceBundle.getBundle("pathConf");
        PATH = rb.getString("file_path");
    }

    /**
     * 获取文件路径
     * @return 返回值
     */
    public static String getFilePath ()
    {
        String[] split = PATH.split(":");
        return "file:"+split[1];
    }

}
