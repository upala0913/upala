package com.upala.wong.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @version 2019/5/7 16:52
 *  @package com.upala.wong.utils
 *  @project document
 *  @describe
 *****************************/
public class FileTypeUtils
{

    public static int setFileType (String code)
    {
        Map<String, Integer> res = new HashMap<>();
        res.put("doc", 1);
        res.put("docx", 2);
        res.put("pdf", 3);
        res.put("xls", 4);
        res.put("xlsx", 5);

        return res.get(code);
    }

}
