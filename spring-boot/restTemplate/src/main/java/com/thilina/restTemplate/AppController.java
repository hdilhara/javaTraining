package com.thilina.restTemplate;

import com.thilina.restTemplate.dao.Quote;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    public static Quote quoteMsg;
                        /**First call the "/" --to load restTemplate then call "/q"*/
    @RequestMapping("/")
    public String quoteReading(){
        RestTemplate restTemplate=new RestTemplate();
        Quote quote=restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random",Quote.class);
        quoteMsg=quote;
        return quote.toString();
    }

    @RequestMapping("/q")
    public String quoteReadingServe(ModelMap model){
        model.put("quote",quoteMsg);
        // return quoteMsg.toString();
        return "home";
    }

    @RequestMapping("/getData")
    public String getListData(ModelMap model)
    {
        List<Quote> list=new ArrayList<>();
        for(int i=0;i<10;i++) {
            RestTemplate restTemplate = new RestTemplate();
            Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            list.add(quote);
        }
        model.put("quotes",list);
        return "listOfQuotes";
    }

//    @RequestMapping("/exData")
//    public String exDataPage(){
//        String requestURL="https://gturnquist-quoters.cfapps.io/api/random";
//        RestTemplate restTemplate=new RestTemplate();
//        HttpEntity<>
//    }
}
