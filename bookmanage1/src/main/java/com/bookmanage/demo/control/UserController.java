package com.bookmanage.demo.control;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bookmanage.demo.Repository.UserRepository;
import com.bookmanage.demo.dao.User;
import com.bookmanage.demo.service.FaceService;
import com.bookmanage.demo.service.UserService;
import com.bookmanage.demo.unity.FaceDetectUnity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@EnableAutoConfiguration
public class UserController {
    private FaceService faceService = new FaceService();
    private FaceDetectUnity faceDetectUnity = new FaceDetectUnity();

    @Autowired(required=true)
    private UserService userService;
    @Autowired(required = true)
    private UserRepository userRepository;

    @RequestMapping("/")
    String welcome(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/notVerify")
    @ResponseBody
    String notVerify() {
        return "username or password NOT correct";
    }

    @RequestMapping("/login")
    String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/register")
    String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

     /*
       人脸开始
      */
     @RequestMapping("/face")
     String face(Model model) {
         model.addAttribute("user", new User());
         return "face";
     }
    @RequestMapping("/facer")
    String facer(Model model) {
        model.addAttribute("user", new User());
        return "facer";
    }




    @RequestMapping(value = "/faceLogin",method = RequestMethod.POST)
    @ResponseBody
    String faceLogin(Model model,HttpSession session,@RequestParam("snapData") String str)throws Exception {

        String img_data = str.substring(22, str.length());
        //faceService.useradd(img_data);
        // faceService.userDetect(img_data);
        String result = faceService.useSearch(img_data);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String msg = jsonObject.getString("error_msg");
        System.out.println(msg);

        if (msg.equals("SUCCESS") ) {
            User user = new User();
            JSONObject jsonObjectl = jsonObject.getJSONObject("result");
             JSONArray  user_list = jsonObjectl.getJSONArray("user_list");
            JSONObject  user_lists = (JSONObject )user_list.get(0);
             String user_info = user_lists.getString("user_info");
             String error_code = jsonObject.getString("error_code");
             String scor = user_lists.getString("score");
             Float score =Float.parseFloat(scor); //相似度

            String account =user_info;
            System.out.println("人脸登录"+account);
            user = userService.selectUserByAccount(account);
            System.out.println(user.toString());
            if (user != null) {

                session.setAttribute("name", user.getName());
                session.setAttribute("account", user.getAccount());
                return error_code;
            }
            // return "redirect:/welcome";
            //return "face";
        }
        else {
            model.addAttribute("mes", "请整理妆容重新认证");
            return result;
        }
        return result;
        // return "redirect:/welcome";

    }

//"0884673bc6da8d2b8cc7365fa7b3f827



    /**
     *
     *
     *
     */
    @RequestMapping(value = "/faceResign",method = RequestMethod.POST)
    @ResponseBody
    String faceResign(Model model,HttpSession session,@RequestParam("snapData") String str)throws Exception {

        String img_data = str.substring(22, str.length());
        String account = (String) session.getAttribute("account");
        String result = faceService.useradd(img_data,account);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String msg = jsonObject.getString("error_msg");
        String error_code = jsonObject.getString("error_code");
        if (msg.equals("SUCCESS")){

            return error_code;
        }
        else {
            model.addAttribute("mes","请整理妆容重新认证");
            return "meserror";
        }
        // faceService.userDetect(img_data);
        //faceService.useSearch(img_data);
        //System.out.println(img_data);
        //"0884673bc6da8d2b8cc7365fa7b3f827

    }

    /*
     结束
     */

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ResponseBody
    String registerUser(User user, Model model) {
        System.out.println(user.toString());
        //return "redirect:/register";
        userService.registerUser(user);
        model.addAttribute("mes","恭喜您账号注册成功 ");
        return "success";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    String userLogin(User user, Model model, HttpSession session) {
        System.out.println(user.toString());
        boolean verify = userService.verifyUser(user);
        if (verify) {
            user = userService.selectUserByAccount(user.getAccount());
            System.out.println(user.toString()+"验证密码");

           // model.addAttribute("name", user.getName());
            //model.addAttribute("password", user.getPassWord());
            session.setAttribute("name",user.getName());
            session.setAttribute("account",user.getAccount());
            return "redirect:/welcome";
        } else {
            return "redirect:/notVerify";
        }

    }
    @RequestMapping("/signOut")
    String signOut(Model model, HttpSession session) {
         session.removeAttribute("name");
         session.removeAttribute("account");
         session.invalidate();
         return "signOut";
    }

    /**
     *
     * 用户管理
     * @param model
     * @return
     */
    @RequestMapping("/usemanage")
    String usemanage(Model model) {
        List users = new ArrayList();
        for ( User user : userRepository.findAll()){
            users.add(user);
          //  System.out.println(user.toString());
        }
        model.addAttribute("users",users);
        return "usemanage";
    }
    /**
     * delet user
     */
    @RequestMapping(value = "/deletuse",method = RequestMethod.POST)
    String deletuse(Model model, @RequestBody JSONObject params) {
        String account = params.getString("account");
        User user =  userRepository.findByAccount(account);
       // System.out.println(user.toString());
        userRepository.delete(user);
        return "redirect:/usemanage";
    }
}
