package org.sweetrooms.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
         securedEnabled = true,
         jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    /*    http.antMatcher("/**").authorizeRequests()
            .antMatchers("/user").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login();*/
               http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/auth/**").permitAll().and()
                .authorizeRequests().antMatchers("/user/**").permitAll().and()
                .authorizeRequests().antMatchers("/file/downloadFile/**").permitAll().and()
                .authorizeRequests().antMatchers("/user/add-new-user").permitAll().and()
                .authorizeRequests().antMatchers("/user/changePassword").permitAll().and()
                .authorizeRequests().antMatchers("/user/savePassword").permitAll().and()
                .authorizeRequests().antMatchers("/user/resetPassword").permitAll().and()
                .authorizeRequests().antMatchers("/owner").permitAll().and()
                .authorizeRequests().antMatchers("/lodger").permitAll().and()
                .authorizeRequests().antMatchers("/city").permitAll().and()
                .authorizeRequests().antMatchers("/announcement/search").permitAll().and()
                .authorizeRequests().antMatchers("/announcement/details/**").permitAll().and()
                .authorizeRequests().antMatchers("/announcement/last-published").permitAll().and()
                .authorizeRequests().antMatchers("/announcement/search-announcement").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}