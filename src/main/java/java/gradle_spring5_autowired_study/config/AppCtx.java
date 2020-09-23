package java.gradle_spring5_autowired_study.config;

import java.gradle_spring5_autowired_study.spring.ChangePasswordService;
import java.gradle_spring5_autowired_study.spring.MemberDao;
import java.gradle_spring5_autowired_study.spring.MemberInfoPrinter;
import java.gradle_spring5_autowired_study.spring.MemberListPrinter;
import java.gradle_spring5_autowired_study.spring.MemberPrinter;
import java.gradle_spring5_autowired_study.spring.MemberRegisterService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
        return pwdSvc;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter());
    }
    
    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDao());
        infoPrinter.setPrinter(memberPrinter());
        return infoPrinter;
    }

}
