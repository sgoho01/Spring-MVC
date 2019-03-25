# 2. Servlet
  
## 서블릿 애플리케이션
- 요청 당 쓰레드(만들거나 풀에서 가져와서 사용)를 사용
- 그중 가장 중요한 클래스 중 하나가 HttpServlet

## 서블릿 엔진 또는 서블릿 컨테이너
- 세션관리
- 네트워크 서비스
- MIME 기반 메시지 인코딩 디코딩
- 서블릿 생명주기 관리
- ..

## 서블릿 생명주기
- 서블릿 컨테이너가 서블릿 인스턴스의 init() 메소드를 호출하여 초기화 한다.
  - 최초 요청을 받았을 때 한번 초기화 하고 나면 그 다음 요청부터는 이 과정을 생략한다.
  <pre><code>public class ServletTest extends HttpServlet{
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
  <pre><code>public void destory() {
        System.out.println("destory");
    }
  </code></pre>

