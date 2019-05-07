package com.upala.wong.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @version 2019/4/8 21:48
 *  @package com.upala.wong.utils
 *  @project document
 *  @describe 文件进行读取操作
 *****************************/

@Log4j2
public class FileUtils
{

    public static Map<String, String> readFile (InputStream in, String lastFile)
    {
        Map<String, String> res = new HashMap<>();
        String content = null;
        switch (lastFile)
        {
            case "doc":
                try
                {
                    HWPFDocument document = new HWPFDocument(in);
                    Range range = document.getCommentsRange();
                    content = range.text();
                } catch (IOException e)
                {
                    log.error ("获取文件出错！", e);
                }
                res.put("status", content);
                break;
            case "docx":
                try
                {
                    XWPFDocument xwpfDocument = new XWPFDocument(in);
                    XWPFWordExtractor wordExtractor = new XWPFWordExtractor(xwpfDocument);
                    content = wordExtractor.getText();
                } catch (IOException e)
                {
                    log.error("获取文件出错！", e);
                }
                res.put("status", content);
                break;
            case "pdf":
                break;
            default:
                res.put("status", "invalid is param!");
                break;
        }
        return res;
    }

}
