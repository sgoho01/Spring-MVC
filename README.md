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
  <pre><code>
  public class ServletTest extends HttpServlet{
    public void init() throws ServletException {
        System.out.println("init");
    }
  }</code></pre>

- 서블릿이 초기화 된 다음부터 클라이언트의 요청을 처리할 수 있다. 각 요청은 별도의 쓰레드로 처리하고 이때 서블릿 인스턴스의 service() 메소드를 호출한다.
  - 이 안에서 HTTP 요청을 받고 클라이언트로 보낼 HTTP 응답을 만든다.
  - service()는 보통 HTTP Method에 따라 doGet(), doPost() 등으로 처리를 위임한다.
  - 따라서 보통 doGet() 또는 doPost()를 구현한다.
  <pre><code>public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        System.out.println("doGet or doPost");
    } 
  </code></pre>
- 서블릿 컨테이너 판단에 따라 해당 서블릿을 메모리에서 내려야 할 시점에 destory()를 호출한다.
  <pre><code>
  public void destory() {
        System.out.println("destory");
    }
  </code></pre>
  
## 2. 서블릿 애플리케이션

### 메이븐 프로젝트
- 메이븐 프로젝트로 프로젝트 생성 시에는 web.xml에 서블릿을 정의하고 연결해서 해당 서블릿을 호출하여 사용한다
    <pre><code>
    < web-app>
        < servlet>
            < servlet-name>test< /servlet-name>
            < servlet-class>com.ghsong.springmvc.ServletTest< /servlet-class>
        < /servlet>
        
        < servlet>
            < servlet-name>hello< /servlet-name>
            < url-pattern>/hello< /url-pattern>
        < /servlet>
    < /web-app>
    </code></pre>

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
<pre><code>
web.xml)
    < web-app>
        < listener>
            < listener-class>com.ghsong.springmvc.MyListener< /listener-class>
        < /listener>
        
        ...
    < /web-app>
</code></pre>
        
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
<pre><code>
web.xml)
    < web-app>
        < filter>
            < filter-name>myFilter< /filter-name>
            < filter-class>com.ghsong.springmvc.MyFilter< /filter-class>
        < /filter>
        
        < filter-mapping>
            < filter-name>myFilter< /filter-name>
            < servlet-name>hello< /servlet-name>
                or
            < url-pattern>< /url-pattern>
        < /filter-mapping>
        
        ...
    < /web-app>
</code></pre>
