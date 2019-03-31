# 06.HandlerInterceptor

## Interceptor
- 핸들러 맵핑에 설정할 수 있는 인터셉터
- 핸들러를 실행하기 전, 후(아직 랜더링 전) 그리고 완료(랜더링 끝난 이후) 시점에 부가 작업을 하고 싶은 경우 사용 할 수 있다.
    - preHandle
    - postHandle
    - afterHandle
- 여러 핸들러에서 반복적으로 사용하는 코드를 줄이고 싶을 때 사용 할 수 있다.
    - 로깅, 인증 체크, Locale 변경 등...
    
### preHandle
- boolean preHandle(request, response, handler)
    - 핸들러 실행하기 전에 호출됨
    - '핸들러'에 대한 정보를 사용할 수 있기 때문에 서블릿 필터에 비해 보다 세밀한 로직을 구현 할 수 있다.
    - 리턴값으로 계속 다음 인터셉터 또는 핸들러로 요청, 응답을 전달할지(true) 응답 처리가 이곳에서 끝난는지(false)를 알려준다.
    
### postHandle
- boolean postHandle(request, response, modelAndView)
    - 핸들러 실행이 끝나고 아직 뷰를 랜더링 하기 이전에 호출됨
    - '뷰'에 전달할 추가적이거나 여러 핸들러에 공통적인 모델 정보를 담는데 사용한다.
    - 이 메소드는 인터셉터 역순으로 호출된다.
        - preHandler 1, preHandler 2 -> postHandler 2, postHandler 1
    - 비동기적인 요청 처리 시에는 호출되지 않는다.

### afterHandle
- boolean afterHandle(request, response, handler, ex)
    - 요청 처리가 완전히 끝난 뒤(뷰 랜러딩이 끝난 후)에 호출됨
    - preHandler가 true를 리턴한 경우에만 실행됨
    - 이 메소드는 인터셉터 역순으로 호출된다.
        - preHandler 1, preHandler 2 -> postHandler 2, postHandler 1 -> afterHandler 2, afterHandler 1
    - 비동기적인 요청 처리 시에는 호출되지 않는다.
    
    
## Interceptor 생성 및 등록
- HandlerInterceptor를 구현한 Interceptor 생성(GreetingInterceptor, AnotherInterceptor)
- WebConfig에서 Interceptor 등록
    - Interceptor의 실행 순서를 지정하고 싶은 경우 order를 지정하여 사용
        - order의 순서는 숫자가 작을수록 빨리 실행된다.
    - 특정 URL에만 Interceptor를 적용하고 싶은 경우 addPathPatterns를 사용하여 패턴을 추가한다.