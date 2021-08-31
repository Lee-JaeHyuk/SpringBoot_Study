package hello.core;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 예제에서 작성한 우리가 수동으로 작성한 AppConfig를 제외한다.
)
public class AutoAppConfig {

    //수동빈이랑 자동빈이 만약 conflict 를 일으키면 수동빈이 우선권을 갖는다.
    // 근데 이러한 부분이 어려운 버그가 된다.
    // 근데 이제 스프링부트에서 이제 그냥 수동빈이랑 자동빈 충돌나면 버그나게 만들었다.

}
