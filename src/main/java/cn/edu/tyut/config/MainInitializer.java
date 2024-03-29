package cn.edu.tyut.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author 羊羊
 * @ClassName MainInitializer
 * @SubmitTime 周四
 * @DATE 2023/12/7
 * @Time 14:28
 * @Package_Name cn.edu.tyut.config
 */
@Configuration
public class MainInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 基本的Spring配置类，一般用于业务层配置，其中WebConfiguration为Spring的配置文件，可以加载多个配置文件
     * 相当于使用配置文件配置时的在resources文件夹下的spring-mvc.xml配置文件
     * 将配置spring的任务交给WebConfiguration配置文件来进行
     *
     * @return 数组是什么？？？：Spring的配置文件吗？
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfiguration.class};
    }

    /**
     * 配置DispatcherServlet的配置类类似于使用配置文件配置中的web.xml文件，主要用于Controller等配置
     * 将配置DispatcherServlet的任务交给下面给出的配置文件来进行
     *
     * @return 数组是什么？？
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    /**
     * 与web.xml配置中的
     * <servlet-mapping>
     * <servlet-name>DispatcherServlet</servlet-name>
     * <url-pattern>/</url-pattern>
     * </servlet-mapping>
     * 含义相同，指定DispatcherServlet要拦截的请求的路径
     * 返回的是DispatcherServlet的映射路径
     *
     * @return DispatcherServlet（前端控制器）要拦截的请求路径
     */
    @Override
    protected String @NotNull [] getServletMappings() {
        return new String[]{"/"};
    }
}