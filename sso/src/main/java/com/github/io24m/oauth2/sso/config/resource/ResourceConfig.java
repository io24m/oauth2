//package com.github.io24m.oauth2.sso.config.resource;//package com.github.io24m.oauth2.config.resource;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * @author lk1
// * @description
// * @create 2021-03-05 13:59
// */
//@Configuration
//@EnableResourceServer
//public class ResourceConfig extends ResourceServerConfigurerAdapter {
//    //@Autowired
//    //private CustomAuthExceptionHandler customAuthExceptionHandler;
//
////    @Override
////    public void configure(ResourceServerSecurityConfigurer resources) {
////        resources.stateless(false)
////                .accessDeniedHandler(customAuthExceptionHandler)
////                .authenticationEntryPoint(customAuthExceptionHandler);
////    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//        //请求权限配置
//        http.authorizeRequests()
//                //下边的路径放行,不需要经过认证
//                .antMatchers("/oauth/**", "/login").permitAll()
//                //OPTIONS请求不需要鉴权
//                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                //用户的增删改接口只允许管理员访问
//                .antMatchers(HttpMethod.POST, "/auth/user").hasAnyAuthority(Oauth2Constants.ROLE_ADMIN)
//                //其余接口没有角色限制，但需要经过认证，只要携带token就可以放行
//                .anyRequest()
//                .authenticated();
//    }
//}
