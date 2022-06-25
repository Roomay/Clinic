package com.dzqc.cloud.controller;
import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.service.PatientService;
import com.google.code.kaptcha.Producer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;


@RestController
public class PatientController implements Message{

    @Autowired
    private PatientService patientService;

    @Autowired
    private Producer kaptchaProducer;

    @Value("${server.servlet.context-path}")
    private String contextPath;


//    @RequestMapping(path = "/register", method = RequestMethod.GET)
//    public String getRegisterPage() {
//        return "/finalpro/register";
//    }
//
//    @RequestMapping(path = "/login", method = RequestMethod.GET)
//    public String getLoginPage() {
//        return "/finalpro/login";
//    }

    /**
     * register
     *
    */

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResultObject register(PatientInfo patient) throws IllegalAccessException {
        try {
            Map<String, Object> map = patientService.register(patient);
            if (map == null || map.isEmpty()) {
                return ResultObject.success("注册成功");
            } else {
                if(map.containsKey("usernameMsg")) {
                    return ResultObject.error((String) map.get("usernameMsg"));
                } else if(map.containsKey("passwordMsg")) {
                    return ResultObject.error((String) map.get("usernameMsg"));
                } else if(map.containsKey("cidMsg")) {
                    return ResultObject.error((String) map.get("cidMsg"));
                } else { //(map.containsKey("phoneMsg"))
                    return ResultObject.error((String) map.get("phoneMsg"));
                }
            }
        } catch (Exception e) {
            return ResultObject.error(SERVER_ERROR);
        }

    }


    /**
     * 使用kaptcha来使用验证码
     * */
    public void getKaptcha(HttpServletResponse response, HttpSession session) {
        //生成验证码
        String text = kaptchaProducer.createText(); //4位随机字符串
        BufferedImage image = kaptchaProducer.createImage(text); //生成随机图片

        //将验证码存入session
        session.setAttribute("kaptcha", text);

        //图片输出给浏览器
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            e.getMessage();
        }
    }


    /**
     * login
     * @return
     */
//    @RequestMapping( "/user/selectByUsernme")
//    public ResultObject selectByUsername(String username,String password) {
//        try {
//            PatientInfo patientInfo = this.patientService.login(username);
//            //
//            if (patientInfo==null) {
//                return ResultObject.error("未注册");
//            }
//            else if (patientInfo.getPassword().equals(password)) {
//                return ResultObject.success(patientInfo);
//            }
//            else if (!patientInfo.getPassword().equals(password)){
//                return ResultObject.error("密码错"+patientInfo.getPassword());
//            }
//        } catch (Exception e) {
//            return ResultObject.error(Message.SERVER_ERROR);
//        }
//        return null;
//    }
//
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResultObject login(String username, String password, String code, boolean rememberMe,
                              HttpSession session, HttpServletResponse response) {
        try {
            //检查验证码
            String kaptcha = (String) session.getAttribute("kaptcha");
            if (StringUtils.isBlank(kaptcha) || StringUtils.isBlank(code) || !kaptcha.equalsIgnoreCase(code)) {
                return ResultObject.error("验证码不正确");
            }

            //检查账号，密码
            int expiredSeconds = rememberMe ? REMEMBER_EXPIRED_SECONDS : DEFAULT_EXPIRED_SECONDS;
            Map<String, Object> map = patientService.login(username, password, expiredSeconds);
            if(map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("contextPath");
                cookie.setMaxAge(expiredSeconds);
                response.addCookie(cookie);
                return ResultObject.success("登录成功");
            } else {
                if(map.containsKey("usernameMsg")) {
                    return ResultObject.error((String) map.get("usernameMsg"));
                } else {
                    return ResultObject.error((String) map.get("passwordMsg"));
                }
            }
        } catch (Exception e){
            return ResultObject.error(SERVER_ERROR);
        }
    }


    /**
     * 退出
     * @param
     * @returnd
     */
//    @RequestMapping("/shiro/logout")
//    public ResultObject logout(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        session.removeAttribute("userinfo");
//        return ResultObject.success("成功注销");
//    }
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public ResultObject logout(@CookieValue("ticket") String ticket) {
        try {
            patientService.logout(ticket);
            return ResultObject.success("成功退出登录");
        } catch (Exception e) {
            return ResultObject.success(SERVER_ERROR);
        }
    }

}