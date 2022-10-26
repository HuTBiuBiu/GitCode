package com.cxg.eip.model.service;

import com.cxg.eip.model.pojo.Suggestion;
import com.cxg.eip.model.pojo.SuggestionList;

import java.util.List;

public interface SuggestionService {

    List<Suggestion> getSuggestions();

    Suggestion getById(Integer id);

    void addSuggestion(String suggestContent, String deficiency, String effect, String userName, String sHead);

    SuggestionList getByHeadAndName(String head, String name);

    List<SuggestionList> getSuggestionList(String head);

    void newSuggestion(String head, String date);
}
