package com.upala.wong.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/*****************************
 *  @author 王鹏
 *  @version 2019/4/8 21:01
 *  @package com.upala.wong.utils
 *  @project document
 *  @describe
 *****************************/

public class CheckUtils
{

    /**
     * 检测字符串
     * @param filename 文件名称
     * @return 返回值 boolean
     */
    public static boolean checkFileLast (String filename)
    {
        boolean flag = false;
        String[] fileNames = filename.split("\\.");
        String[] fileFormat = {"doc", "docx", "pdf"};
        String lastFileName = fileNames[1];
        for (String last : fileFormat)
        {
            flag = lastFileName.equals(last);
            if (flag) // 如果为真，不用遍历比较
                break;
        }
        return flag;
    }

    /**
     * 获取字符串
     * @return 返回值String
     */
    public static String getUUID ()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 检测字符串
     * @param param 参数
     * @return 返回值boolean
     */
    public boolean checkString (String param)
    {
        return StringUtils.isEmpty(param);
    }
}
