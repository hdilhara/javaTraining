package com.thilina.UIdemoDTO.Controller;


import com.thilina.UIdemoDTO.model.Dummy;
import com.thilina.UIdemoDTO.model.GetDate;
import com.thilina.UIdemoDTO.model.GetDateModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UIcontroller {

    @GetMapping("/")
    public String homePage(Model model){
        String[] choices=new String[]{"FootBall","Carem","Cricket","BaseBall"};
        model.addAttribute("choices",choices);
        return "formInput";
    }
    @ResponseBody
    @GetMapping("/getDate")
    public GetDate getDate(@ModelAttribute GetDate getDate){
        System.out.println(getDate.getTdate());
        System.out.println(getDate.getChoices());
        System.out.println(getDate.getWant());
        return getDate;
    }

//    @RequestMapping("/saveGetDate")
//    public String saveGetDate(@ModelAttribute GetDate getDate){
//        int i=getDate.getWant().length;
//        GetDateModel getDateModel=new GetDateModel();
//        getDateModel.setChoices("fdfdsf");
//        getDateModel.setTdate(LocalDate.now());
////        for(int j=0;j<i;j++){
////            getDateModel.setWant(getDate.getWant()[i]);
////            HttpEntity<GetDateModel> request=new HttpEntity<>(getDateModel);
////            RestTemplate restTemplate=new RestTemplate();
////            restTemplate.postForEntity("http://localhost:8484/getDate",request,String.class);
////        }
//
//        getDateModel.setWant("dsfdsfds5");
//        System.out.println(getDateModel);
//        HttpEntity<GetDateModel> request=new HttpEntity<>(getDateModel);
//        RestTemplate restTemplate=new RestTemplate();
//        restTemplate.exchange("http://localhost:8484/getDate", HttpMethod.POST,request,String.class);
//
//        return "redirect: /getDate";
//    }

    @RequestMapping("/saveGetDate")
    public void saveGetDate(){
        GetDateModel g=new GetDateModel();
        g.setTdate(LocalDate.now());
        g.setChoices("gfdgd");
        g.setWant("dfdf");
        System.out.println(g);

        HttpEntity<GetDateModel> request=new HttpEntity<GetDateModel>(g);
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.exchange("http://localhost:8484/getDate", HttpMethod.POST,request,String.class);

    }
    @RequestMapping("/dummyForm")
    public void saveDummy(@ModelAttribute Dummy dummy)
    {
        HttpEntity<Dummy> request=new HttpEntity<>(dummy);
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.exchange("http://localhost:8484/saveDummy",HttpMethod.POST,request,String.class);
    }
    @RequestMapping("dummy")
    public  String dummyView(Model model){
        String[] cbox=new String[]{"Thilina","Shalitha","Mike","TeachLead"};
        model.addAttribute("cboxVals",cbox);
        return "dummy";
    }
    @RequestMapping("/getDummy")
    public String getAllDummy(Model model){
        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<List<Dummy>> response=restTemplate.exchange("http://localhost:8484/getDummy", HttpMethod.GET, null, new ParameterizedTypeReference<List<Dummy>>() {
        });
        List<Dummy> list=new ArrayList<>();
        //list.add(new Dummy(1,"dsfdf",LocalDate.now()));
        list=response.getBody();
        model.addAttribute("d1",list);
        System.out.println(response);
        return "viewDummy";
    }
}
