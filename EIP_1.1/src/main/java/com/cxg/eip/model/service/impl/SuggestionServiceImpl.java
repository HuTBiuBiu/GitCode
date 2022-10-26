package com.cxg.eip.model.service.impl;

import com.cxg.eip.model.mapper.SuggestionMapper;
import com.cxg.eip.model.pojo.Suggestion;
import com.cxg.eip.model.pojo.SuggestionList;
import com.cxg.eip.model.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionMapper suggestionMapper;
    @Override
    public List<Suggestion> getSuggestions() {
        List<Suggestion> suggestions = suggestionMapper.getSuggestions();
        return suggestions;
    }
    @Override
    public Suggestion getById(Integer id) {
        Suggestion suggestion = suggestionMapper.getById(id);
        return suggestion;
    }

    @Override
    public void addSuggestion(String suggestContent, String deficiency, String effect, String userName, String sHead) {
        suggestionMapper.addSuggestion(suggestContent,deficiency,effect,userName,sHead);
    }

    @Override
    public SuggestionList getByHeadAndName(String head, String name) {
        return  suggestionMapper.getByHeadAndName(head,name);
    }

    @Override
    public List<SuggestionList> getSuggestionList(String head) {
        return suggestionMapper.getSuggestionList(head);
    }

    @Override
    public void newSuggestion(String head, String date) {
        suggestionMapper.newSuggestion(head,date);
    }
}
