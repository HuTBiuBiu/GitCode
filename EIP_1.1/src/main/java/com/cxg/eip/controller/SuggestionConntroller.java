package com.cxg.eip.controller;

import com.cxg.eip.model.pojo.Suggestion;
import com.cxg.eip.model.pojo.SuggestionList;
import com.cxg.eip.model.pojo.User;
import com.cxg.eip.model.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class SuggestionConntroller {
    @Autowired
    private SuggestionService suggestionService;
    //新增建议
    @RequestMapping(value = "/suggNew",method = RequestMethod.GET)
    public String suggNew(){
        return "suggestionNew";
    }
    //新增建议
    @RequestMapping(value = "/addSugg",method = RequestMethod.POST)
    public String addSugg(String head){
        Date date = new Date();
        suggestionService.newSuggestion(head,date.toString());
        return "suggestionNew";
    }
    //发表合理化建议
    @RequestMapping("/suggestion/{id}")
    public String getSuggest(@PathVariable("id") int id, Model model,HttpSession session){
        Suggestion suggestion = suggestionService.getById(id);
        User user = (User) session.getAttribute("user");
        String head = suggestion.getHead();
        String name = user.getName();
        SuggestionList suggestionList = suggestionService.getByHeadAndName(head, name);
        if (suggestionList!=null)
        {
            return "index";
        }
        model.addAttribute("suggestion",suggestion);
        return "suggestion";
    }
    @RequestMapping(value = "/sgg/{sHead}",method = RequestMethod.POST)
    public String addSuggest(HttpSession session,
                             @PathVariable("sHead") String sHead,String suggestContent,
                             String deficiency,String effect){
        User user = (User)session.getAttribute("user");
        suggestionService.addSuggestion(suggestContent,deficiency,effect,user.getName(),sHead);
        return "index";
    }
    //建议详情
    @RequestMapping("/suggestionList/{head}")
    public String getSuggestList(Model model, @PathVariable("head") String head){
        List<SuggestionList> suggestionList = suggestionService.getSuggestionList(head);
        model.addAttribute("suggestionList",suggestionList);
        return "suggestionList";
    }
    //点赞功能---未做
    @RequestMapping("/addCount")
    public String addCount(){
        return "";
    }
}
