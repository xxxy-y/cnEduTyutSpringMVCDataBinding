package cn.edu.tyut.controller;

import cn.edu.tyut.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 羊羊
 * @ClassName UserController
 * @SubmitTime 周四
 * @DATE 2023/12/7
 * @Time 14:26
 * @Package_Name cn.edu.tyut.controller
 */
@Controller
public class UserController {
    /**
     * 请求中userId参数的信息封装到getUserId()方法的httpServletRequest形参中，默认的HttpServletRequest参数类型完成了数据绑定
     *
     * @param httpServletRequest 默认的HttpServletRequest参数类型完成了数据绑定
     */
    @GetMapping("/getUserId")
    public void getUserId(@NotNull HttpServletRequest httpServletRequest) {
        String userId = httpServletRequest.getParameter("userId");
        System.out.println("userId = " + userId);
    }

    /**
     * 在课本上说在处理器形参上的名称与客户端请求参数的名称一致，请求参数就会自动映射并匹配到处理器的形参完成数据绑定
     * 但是现在必须在处理器的形参上加上@RequestParam注解来定义参数的名称才能实现将请求参数匹配到处理器的形参
     *
     * @param username 传入的username参数
     * @param id       出入的id参数
     */
    @GetMapping("/getUserNameAndId")
    public void getUserNameAndId(@RequestParam("username") String username, @RequestParam("id") Integer id) {
        System.out.println("username = " + username + "    id = " + id);
    }

    /**
     * 使用@RequestParam注解来定义处理器参数的别名，完成请求参数名称和处理器的形参名称不一致时的数据绑定。
     * <br/>
     * value
     * <br/>
     * name
     * <br/>
     * required              用于指定参数是否必须，默认为true，表示请求中必须有对应的参数
     * <br/>
     * defaultValue          处理器形参的默认值，表示如果请求中没有同名参数时的默认值。
     *
     * @param username username
     * @param id       id
     */
    @RequestMapping("/requestParamGetUserNameAndId")
    public void requestParamGetUserNameAndId(@RequestParam("name") String username, @RequestParam(value = "userId", required = false, defaultValue = "3") Integer id) {
        System.out.println(username + "   " + id);
    }

    /**
     * 当请求的映射方式是REST风格时，需要使用@PathVariable注解将URL中占位符参数绑定到处理器的形参中
     * value            用于指定URL中的占位符名称
     * required         是否必须提供占位符，默认值为true
     * 以下为通过@PathVariable注解的value属性将占位符参数"name"和处理方法的参数"username"进行绑定
     * 必须使用该注解进行绑定，即使名称相同
     * @param username 处理器参数
     */
    @RequestMapping("/restPathVariableGetUserName/{name}")
    public void restPathVariableGetUserName(@PathVariable("name") String username) {
        System.out.println("username = " + username);
    }

    /**
     * 请求参数会通过Spring的依赖注入自动封装为实体类，请求参数名与实体类中的属性名一一对应，或者使用注解来指定绑定的名称
     * 当处理器方法的参数中包含Model类型的参数时，这个Model参数其实是用来向视图传递数据的，而不是从请求参数中获取数据。 在Spring MVC中，Model是一个接口，用于存储和传递数据给视图。它允许在处理器方法中设置属性，并将这些属性传递给视图进行渲染。
     * 当处理器方法的参数中包含Model类型的参数时，Spring会自动创建一个Model对象，并将其传递给处理器方法。我们可以在处理器方法中通过操作Model对象来设置属性，这些属性的值会被传递给视图。
     * @param user 实体类
     */
    @RequestMapping("/registerUser")
    public String registerUser(@NotNull User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("username = " + username + "         password = " + password);
        return "register";
    }
}