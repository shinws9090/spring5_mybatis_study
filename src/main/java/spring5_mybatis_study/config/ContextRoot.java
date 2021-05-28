package spring5_mybatis_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@Import({ContextDataSource.class,ContextSqlSession.class})
@ComponentScan(basePackages = {"spring5_mybatis_study.mapper","spring5_mybatis_study.service"})
public class ContextRoot {

}
