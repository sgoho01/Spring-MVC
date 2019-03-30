# 2. Servlet
  
## 1. 서블릿 소개  
  
### 서블릿 애플리케이션
- 요청 당 쓰레드(만들거나 풀에서 가져와서 사용)를 사용
- 그중 가장 중요한 클래스 중 하나가 HttpServlet

### 서블릿 엔진 또는 서블릿 컨테이너
- 세션관리
- 네트워크 서비스
- MIME 기반 메시지 인코딩 디코딩
- 서블릿 생명주기 관리
- ..

### 서블릿 생명주기
- 서블릿 컨테이너가 서블릿 인스턴스의 init() 메소드를 호출하여 초기화 한다.
  - 최초 요청을 받았을 때 한번 초기화 하고 나면 그 다음 요청부터는 이 과정을 생략한다.
  ```
  public class ServletTest extends HttpServlet{
    public void init() throws ServletException {
        System.out.println("init");
    }
  }
  ```

- 서블릿이 초기화 된 다음부터 클라이언트의 요청을 처리할 수 있다. 각 요청은 별도의 쓰레드로 처리하고 이때 서블릿 인스턴스의 service() 메소드를 호출한다.
  - 이 안에서 HTTP 요청을 받고 클라이언트로 보낼 HTTP 응답을 만든다.
  - service()는 보통 HTTP Method에 따라 doGet(), doPost() 등으로 처리를 위임한다.
  - 따라서 보통 doGet() 또는 doPost()를 구현한다.
  ```
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        System.out.println("doGet or doPost");
    } 
  ```
- 서블릿 컨테이너 판단에 따라 해당 서블릿을 메모리에서 내려야 할 시점에 destory()를 호출한다.
  ```
    public void destory() {
        System.out.println("destory");
    }
  ```
  
## 2. 서블릿 애플리케이션

### 메이븐 프로젝트
- 메이븐 프로젝트로 프로젝트 생성 시에는 web.xml에 서블릿을 정의하고 연결해서 해당 서블릿을 호출하여 사용한다
    ```
    <web-app>
        <servlet>
            <servlet-name>test</servlet-name>
            <servlet-class>com.ghsong.springmvc.ServletTest</servlet-class>
        </servlet>
        
        <servlet>
            <servlet-name>hello</servlet-name>
            <url-pattern>/hello</url-pattern>
        </servlet>
    < /web-app>
    ```

    - localhost:port/hello 로 접속하여 화면 테스트

     
### 서블릿 리스너 & 서블릿 필터

#### 서블릿 리스너
- 웹 애플리케이션에서 발생하는 주요 이벤트를 감지하고 각 이벤트에 특별한 작업이 필요한 경우에 사용할 수 있다.
    - 서블릿 컨텍스트 수준의 이벤트
        - 컨텍스트 라이프사이클 이벤트
        - 컨텍스트 에트리뷰트 변경 이벤트
    - 세션 수준의 이벤트
        - 세션 라이프사이클 이벤트
        - 세션 에트리뷰트 변경 이벤트
        
- web.xml에서 리스너 등록
```
web.xml)
    <web-app>
        <listener>
            <listener-class>com.ghsong.springmvc.MyListener</listener-class>
        </listener>
        
        ...
    </web-app>
```
        
- 서블릿에서 리스너 사용
    - 서블릿 클래스에서 사용 : getServletContext().getAttribute("name")
        
#### 서블릿 필터
- 들어온 요청을 서블릿으로 보내고, 또 서블릿이 작성한 응답을 클라이언트로 보내기 전에 특별한 처리가 필요한 경우에 사용할 수 있다.
- 체인 형태의 구조
    
    Servlet Container  
(request)▽    △(response)  
        Filter A  
(request)▽    △(response)  
        Filter B         
(request)▽    △(response)  
        Servlet  
        
- web.xml에서 필터 등록
```
web.xml)
    <web-app>
        <filter>
            <filter-name>myFilter</filter-name>
            <filter-class>com.ghsong.springmvc.MyFilter</filter-class>
        </filter>
        
        <filter-mapping>
            <filter-name>myFilter</filter-name>
            <servlet-name>hello</servlet-name>
                or
            <url-pattern></url-pattern>
        </filter-mapping>
        
        ...
    </web-app>
```

## 3. DispatcherServlet

### 3.1 DispatcherServlet Info

- 스프링 MVC의 핵심
- Front Controller의 역할

- web.xml에서 리스너 의존성 등록

```
web.xml)
    < web-app>
        
        <context-param>
            <param-name>contextClass</param-name>
            <param-value>org.springFramework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
        </context-param>
    
        <context-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>com.ghsong.springmvc.AppConfig</param-value>
        </context-param>
    
        <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>
        
        <servlet>
            <servlet-name>app</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                <param-name>contextClass</param-name>
                <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
            </init-param>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>com.ghsong.springmvc.WebConfig</param-value>
            </init-param>
        </servlet>
        
        <sevlet-mapping>
            <servlet-name>app</servlet-name>
            <url-ppattern>/app/*</url-ppattern>
        </sevlet=mapping>
        
    </web-app>
```
- service, repositories 를 생성해주는 RootContext와   
    Web관련 context를 생성해주는 WebApplicationContext 를 계층 구조로 생성  
    - 해당 Context에서 생성해주는게 다르므로 init-param으로 등록한 Config 파일에서 ComponentScan의 필터를 적용한다.  
    (RootConext를 따로 생성하지 않고 DispatcherServlet에서 전부 등록해도 상관없다)  
    
### 3.2 DispatcherServlet 초기화  

- 다음의 특별한 타입의 빈들을 찾거나, 기본 전력에 해당하는 빈들을 등록한다.
- HandlerMapping : 핸들러를 찾아주는 인터페이스
- HandlerAdapter : 핸들러를 실행하는 인터페이스
- HandlerExceptionResolver
- View Resolver

### 3.3 DispatcherServlet 동작 원리

- ViewResolver
    - InternalResourceViewResolver
    
- InternalResourceViewResolver
    - Prefix 
    - Suffix
    
    -> WebConfig에 ViewResolver의 Prefix, Suffix를 설정.
    
    