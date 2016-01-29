package com.oneler.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAjax {
    
    @ResponseBody
    @RequestMapping("/test")
    public String testAjax(String name) {
        JSONObject jsonObject = new JSONObject();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<100;i++) {
            list.add(i);
        }
        jsonObject.put("key", list);
        return jsonObject.toString();        
    }
    
    @RequestMapping("/test1")
    public void testRes(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello,World");
    }
}
