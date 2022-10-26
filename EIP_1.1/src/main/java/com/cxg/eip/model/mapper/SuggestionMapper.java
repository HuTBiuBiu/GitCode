package com.cxg.eip.model.mapper;

import com.cxg.eip.model.pojo.Suggestion;
import com.cxg.eip.model.pojo.SuggestionList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestionMapper {
    //查询所有建议
    public List<Suggestion> getSuggestions();
    //根据id查询建议
    public Suggestion getById(Integer id);
    //添加一个建议
    public boolean addSuggestion(@Param("suggestContent") String suggestContent,
                                 @Param("deficiency") String deficiency,
                                 @Param("effect") String effect,
                                 @Param("userName") String userName,
                                 @Param("sHead") String sHead);
    SuggestionList getByHeadAndName(@Param("head") String head, @Param("name") String name);
    //根据标题查询所有建议
    List<SuggestionList> getSuggestionList(@Param("sHead") String head);

    void newSuggestion(@Param("head")String head, @Param("date")String date);
}
