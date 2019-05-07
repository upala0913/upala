package com.upala.wong.mapper;

import com.upala.wong.entity.AnalysisFile;
import org.apache.ibatis.annotations.Mapper;

/*****************************
 *  @author 王鹏
 *  @version 2019/5/7 16:01
 *  @package com.upala.wong.mapper
 *  @project document
 *  @describe
 *****************************/

@Mapper
public interface AnalysisFileMapper
{

    public void insertFile(AnalysisFile analysisFile);

}
