package com.oneler.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.RequestEntity.HeadersBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oneler.mybatis.models.User;
@Controller
public class JsonTest {
    
    @ResponseBody
    @RequestMapping(value = "/index", headers="accept/*")
    public String returnIndex(@RequestBody String body) {
       /* List<User> users = new ArrayList<>();
        for (int i = 0; i<100; i++) {
            users.add(new User(i,"liming"+i,i));
        }*/
        System.out.println(body);
        return "ddd";
    }
    
    @ResponseBody
    @RequestMapping("/down")
    public ResponseEntity<byte[]> testRepsonseEntity(HttpSession httpsession) {
        
        byte[] bytes =null;
        
        ServletContext servletContext = httpsession.getServletContext();
        InputStream inputStream =servletContext.getResourceAsStream("files/a.xlsx");
        try {
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=abc.xlsl");
        HttpStatus httpStatus = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, httpStatus);
        return responseEntity;
        
    }
    
}
