package com.upala.wong.service.impl;

import com.upala.wong.entity.AnalysisFile;
import com.upala.wong.mapper.AnalysisFileMapper;
import com.upala.wong.service.AnalysisFileService;
import com.upala.wong.utils.FileTypeUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/*****************************
 *  @author 王鹏
 *  @version 2019/5/7 16:35
 *  @package com.upala.wong.service.impl
 *  @project document
 *  @describe
 *****************************/

@Log4j2
@Service
public class AnalysisFileServiceImpl implements AnalysisFileService
{

    @Autowired
    private AnalysisFileMapper analysisFileMapper;

    @Override
    public void insertFile(String uuid, String type)
    {
        AnalysisFile analysisFile = new AnalysisFile();
        analysisFile.setFileUUID(uuid);
        analysisFile.setFileType(type);
        analysisFile.setFileTypeCode(FileTypeUtils.setFileType(type));
        analysisFile.setFileUploadDate(new Date());
        analysisFileMapper.insertFile(analysisFile);
    }

}
