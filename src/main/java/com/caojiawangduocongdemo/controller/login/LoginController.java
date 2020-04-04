package com.caojiawangduocongdemo.controller.login;

import com.caojiawangduocongdemo.common.ResultBody;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.entity.Teacher;
import com.caojiawangduocongdemo.entity.User;
import com.caojiawangduocongdemo.service.custom.UserService;
import com.caojiawangduocongdemo.service.student.StudentService;
import com.caojiawangduocongdemo.service.teacher.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caojia
 * @createtime 2019-11-04 15:36
 */
@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * shiro登录认证
     * @param userName
     * @param userPass
     * @param request
     * @return
     */
    @RequestMapping("/main")
    public String shiroLogin(@RequestParam("userName")String userName,
                             @RequestParam("userPass")String userPass,
                             @RequestParam(name = "rememberMe",required = false)boolean rememberMe,HttpServletRequest request,HttpServletResponse response)throws Exception{
        UsernamePasswordToken token = new UsernamePasswordToken(userName,userPass);
        Subject subject = SecurityUtils.getSubject();
        logger.info("对用户[" + userName + "]进行登录验证..验证开始");
        subject.login(token);
        Map<String,String> respMap = new HashMap<>();
        //登录成功
        if(subject.isAuthenticated()){
            logger.info("用户[" + userName + "]登录成功！请继续执行以下操作");
            if(rememberMe){
                token.setRememberMe(true);
            }
            //获取当前登录用户对象
            User user = (User) subject.getPrincipal();
            request.getSession().setAttribute("custom",user);
            //通过identify查询用户信息，将用户信息存放到session中
            //学生编号
            if(user.getIdentify().length()==8){
                Student student = studentService.findByStudentId(user.getIdentify());
                request.getSession().setAttribute("user",student);
            }else if(user.getIdentify().length()==9){
                Teacher teacher = teacherService.findByTeacherId(user.getIdentify());
                request.getSession().setAttribute("user",teacher);
            }
            return "main";
        }else{//登录失败
            token.clear();
            logger.info("用户[" + userName + "]登录失败！重新登录");
            respMap.put("msg","登录失败，请重新登录！");
        }
        if(!CollectionUtils.isEmpty(respMap)){
            response.setContentType("text/html;charset=utf-8");
            String msg = "alert('"+respMap.get("msg")+"'); window.location.href='"+request.getContextPath()+"/login';";
            response.getWriter().write("<script language=\"javascript\">");
            response.getWriter().write(msg+"\n");
            response.getWriter().write("</script>");
            return null;
        }
        return "redirect:/login";
    }

    /*@RequestMapping("/main")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //角色
        String role = request.getParameter("role");
        //用户名
        String username = request.getParameter("username");
        //密码
        String password = request.getParameter("password");
        //用于记录消息
        Map<String,String> respMap = new HashMap<>();
        if("teacher".equals(role)){
            if(teacherService.allowLogin(username,password )){
                //将教师信息存入session
                Teacher teacher = teacherService.findByTeacherId(username);
                request.getSession().setAttribute("user",teacher);
                //重定向到教师控制层
                return new ModelAndView("redirect:/index");
            }else{
                //教师登录失败
                respMap.put("msg","The teacher login in failed");
            }
        }else if("student".equals(role)){
            if(studentService.allowLogin(username,password )){
                //将学生对象存入session
                Student student = studentService.findByStudentId(username);
                request.getSession().setAttribute("user", student);
                //重定向到学生控制层
                return new ModelAndView("redirect:exam/index");
            }else{
                //学生登录失败
                respMap.put("msg","The student login in failed");
            }
        }else{
            response.setContentType("text/html;charset=utf-8");
            String msg = "alert('教师或学生角色登录失败，请重新登录！'); window.location.href='"+request.getContextPath()+"';";
            response.getWriter().write("<script language=\"javascript\">");
            response.getWriter().write(msg+"\n");
            response.getWriter().write("</script>");
            return null;
        }
        if(!CollectionUtils.isEmpty(respMap)){
            response.setContentType("text/html;charset=utf-8");
            String msg = "alert('"+respMap.get("msg")+"'); window.location.href='"+request.getContextPath()+"/login';";
            response.getWriter().write("<script language=\"javascript\">");
            response.getWriter().write(msg+"\n");
            response.getWriter().write("</script>");
            return null;
        }
        return new ModelAndView("redirect:/login");
    }*/

    @RequestMapping("/index")
    public String main(){
        return "main";
    }

    /**
     * shiro退出登录
     * @return
     */
    @RequestMapping("/loginOut")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }
    /*@RequestMapping("/loginOut")
    public ModelAndView loginOut(HttpServletRequest request){
        ResultBody rb = new ResultBody();
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            request.getSession().removeAttribute("user");
        }
        rb.setMessage("success");
        return new ModelAndView("redirect:/login");
    }*/
}
