package com.upala.wong.controller;

import com.upala.wong.utils.CheckUtils;
import com.upala.wong.utils.FileUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @version 2019/4/8 20:47
 *  @package com.upala.wong.controller
 *  @project document
 *  @describe
 *****************************/

@RestController
@Log4j2
@RequestMapping("/upala/file")
public class FileController
{

    /**
     * 上传文件
     * @param file 上传的文件
     * @return 返回值
     */
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public Map<String, String> uploadFile (MultipartFile file)
    {
        Map<String, String> res = new HashMap<>();
        res.put("status", "successful");
        String filename = file.getOriginalFilename();
        String[] split = filename.split("\\.");
        if (file.getSize() <= 0)
        {
            res.put("status", "文件小于0，请重新上传文件！");
            return res;
        }
        boolean flag = CheckUtils.checkFileLast(filename);
        if (!flag)
        {
            res.put("status", "文件格式错误，请上传doc、docx、pdf格式的文件！");
            return res;
        }
        try
        {
            InputStream inputStream = file.getInputStream();
            res = FileUtils.readFile(inputStream, split[1]);
            res.put("title", split[0]);
        } catch (IOException e)
        {
            log.error("获取文件输入流失败！", e);
            res.put("status", "读取文件失败！");
            return res;
        }
        return res;
    }

    /**
     * 保存文件
     * @param content 文件内容
     * @param title 文件标题
     * @return 返回值
     */
    @RequestMapping(value="/saveFile", method=RequestMethod.POST)
    public Map<String, String> saveFile (String content, String title)
    {
        Map<String, String> res = new HashMap<>();
        return res;
    }

}
