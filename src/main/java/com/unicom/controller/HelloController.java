package com.unicom.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.unicom.domain.User;
import com.unicom.exception.SysException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.time.temporal.ValueRange;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author hanbing
 * @create 2019-09-06 14:47
 */

@Controller
@RequestMapping("/user")
//@SessionAttributes(names = {"one", "two"})
public class HelloController {

    @ModelAttribute("user")
    public User test(){
        User user = new User();
        user.setUsername("woshini");
        return user;
    }

    @RequestMapping(value = "/interceptor")
    public String interceptor(){
        System.out.println("方法执行。。。");
        return "success";
    }

    @RequestMapping(value = "/exception")
    public String exception() throws Exception {
//        try {
//            int i = 1/0;
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new SysException("系统错误...");
//        }
        int i =1/0;
        return "success";
    }

    @RequestMapping(value = "/upload")
    public String user(MultipartFile upload) throws Exception {
        String path = "http://localhost:9090/uploadServer/uploads/";

        String filename = upload.getOriginalFilename();
        String replace = UUID.randomUUID().toString().replace("-", "");
        filename =replace + filename;
        String encode = URLEncoder.encode(filename, "utf-8");

        Client client = Client.create();
        WebResource resource = client.resource(path + encode);
        resource.put(upload.getBytes());
        return "success";
    }

    @RequestMapping(value = "/user")
    public String user( User user) throws Exception {
        System.out.println(user);

        return "success";

    }

    @RequestMapping(value = "/modelAndView")
    public ModelAndView modelAndView() throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setPassword("654321");
        user.setUsername("猪八戒");
        user.setMoney(180000.0);
        mv.addObject("one", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping(value = "/response")
    public void response(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        response.sendRedirect(request.getContextPath() + "/response.jsp");
//        System.out.println(request.getContextPath());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("你好啊");
    }

    @RequestMapping(value = "/sessionAttribute")
    public String sessionAttribute(Map<String,Object> mapp){
        User user = (User) mapp.get("one");
        System.out.println(user);
//        return "success";
//        return "forword:/WEB-INF/pages/success.jsp";
        return "redirect:/response.jsp";
    }

    @RequestMapping(value = "/DELsessionAttribute")
    public String DELsessionAttribute(SessionStatus status){
        status.setComplete();
        return "success";
    }


//    @ModelAttribute
//    public void modelAttribute(String username, Map<String,Object> mapp){
//        User one = new User();
//        one.setUsername(username + "one");
//        one.setMoney(123.0);
//        one.setPassword("123");
//        mapp.put("one", one);
//
//    }

    @RequestMapping(value = "/modelAttribute")
    public String testModelAttribute(User user, Map<String, Object> mapp){
        user.setUsername(user.getUsername() + "one");
        user.setPassword("654321");
        System.out.println("testModelAttribute...");
        System.out.println(user);
        mapp.put("one", user);
        return "success";
    }

    @RequestMapping(value = "/cookievalue")
    public String testCookievalue(@CookieValue("JSESSIONID") String id){
        System.out.println("cookievalue...");
        System.out.println(id);
        return "success";
    }

    @RequestMapping(value = "/requestheader")
    public String testRequestHeader(@RequestHeader("Accept") String accept){
        System.out.println("requestheader...");
        System.out.println(accept);
        return "success";
    }

    @RequestMapping(value = "/helloWorld/{sid}")
    public String helloworld(String id){
        System.out.println("helloworld...");
        System.out.println(id);
        return "success";
    }

    @RequestMapping(value = "/usertest")
    public String usertest(@RequestBody String body){
        System.out.println(body);
        String decode = null;
        try {
            decode = URLDecoder.decode(body, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(decode);
        return "success";
    }
}
