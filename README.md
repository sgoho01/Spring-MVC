# 3. SpringBootMVC
  
## 스프링부트의 스프링 MVC
 
### 스프링부트
- 스프링 애플리케이션 안에 스프링 IoC 컨테이너, 임베디드 톰캣(was)를 생성.
- 스프링 애플리케이션 안에 생성된 톰캣에 DispatcherServlet을 등록한다.

#### 스프링부트의 주관이 적용된 자동 설정이 적용된다.
- JSP보다 Thymeleaf 선호
- JSON 지원
- 정적 리소스 지원(+웰컴 페이지, 파비콘 등 지원)

#### 스프링 MVC 커스터마이징
- application.properties
- @Configuration + implements WebMvcConfigurer : 스프링 부트의 스프링 MVC 자동설정
- @Configuration + @EnableWebMvc + implements WebMvcConfigurer : 스프링 부트의 스프링 MVC 자동설정을 이용하지 않음

