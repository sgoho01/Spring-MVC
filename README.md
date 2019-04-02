# Spring-MVC

## Spring MVC 활용

### 애노테이션 기반의 스프링 MVC
- 요청 맵핑하기
- 핸들러 메소드
- 모델과 뷰
- 데이터 바인더
- 예외 처리
- 글로벌 컨트롤러

### 사용할 기술
- 스프링 부트
- 스프링 프레임워크 웹 MVC
- 타임리프

--------
 - [1.HTTP 요청 맵핑 : 요청 메소드](#1.HTTP-요청-맵핑-:-요청-메소드)
 - [2.HTTP 요청 맵핑 : URI 패턴 맵핑](#2.HTTP-요청-맵핑-:-URI-패턴-맵핑)
 - [3.HTTP 요청 맵핑 : 컨텐츠 타입 맵핑](#3.HTTP-요청-맵핑-:-컨텐츠-타입-맵핑)
 - [4.HTTP 요청 맵핑 : 헤더와 매개변수](#4.HTTP-요청-맵핑-:-헤더와-매개변수)
 - [5.HTTP 요청 맵핑 : HEAD와 OPTIONS](#5.HTTP-요청-맵핑-:-HEAD와-OPTIONS)
 - [6.HTTP 요청 맵핑 : 커스텀 애노테이션](#6.HTTP-요청-맵핑-:-커스텀-애노테이션)
------

### 1.HTTP 요청 맵핑 : 요청 메소드
#### HTTP Method
- GET, POST, PUT, PATCH, DELETE, ...

#### GET 요청
- 클라이언트가 서버의 리소스를 요청할 때 사용한다.
- 캐싱 할 수 있다. (조건적인 GET으로 바뀔 수 있다.)
- 브라우저 기록에 남는다.
- 북마크 할 수 있다.
- 민감한 데이터를 보낼 때 사용하지 말 것. (URL에 다 보이기 때문)
- idempotent(같은 GET 요청은 항상 같은 값 리턴)

#### POST 요청
- 클라이언트가 서버의 리소스를 수정하거나 새로 만들 때 사용한다.
- 서버에 보내는 데이터를 POST 요청 본문에 담는다.
- 캐시할 수 없다.
- 브라우저 기록에 남지 않는다.
- 북마크 할 수 없다.
- 데이터 길이 제한이 없다.

#### PUT 요청
- URI에 해당하는 데이터를 새로 만들거나 수정할 때 사용한다.
- POST와 다른점은 "URI"에 대한 의미가 다르다.
    - POST의 URI는 보내는 데이터를 처리할 리소스를 지칭
    - PUT의 URI는 보내는 데이터에 해당하는 리소스를 지칭
- idempotent

#### PATCH 요청
- PUT과 비슷하지만, 기존 엔티티와 새 데이터의 차이점만 보낸다는 차이가 있다.

#### DELETE 요청
- URI에 해당하는 리소스를 삭제할 때 사용한다.
- idempotent


### 2.HTTP 요청 맵핑 : URI 패턴 맵핑
#### 요청 식별자로 맵핑하기
- @RequestMapping은 다음의 패턴을 지원.
    - ? : 한글자("/author/???" => "/author/123")
    - * : 여러글자("/author/*" => "/author/ghsong")
    - ** : 여러 패스("/author/** => "/author/ghsong/age")
    
- 클래스에 선언한 @RequestMapping과 조합
    - 클래스에 선언한 URI 패턴뒤에 이어 붙여서 맵핑.
    
- 정규 표현식으로 맵핑할 수도 있다.
    - /{name:정규식}
    
- 패턴이 중복되는 경우에는 ?
    - 가장 구제척으로 맵핑되는 핸들러를 선택.
    
- URI 확장자 맵핑 지원
    - 이 기능은 권장하지 않음.(스프링 부트에서는 기본으로 이 기능을 사용하지 않도록 설정 해 줌)
        - 보안 이슈(RFD Attack)
        - URI 변수, Path 매개변수, URI 인코딩을 사용할 때 불명확 함
        
### 3.HTTP 요청 맵핑 : 컨텐츠 타입 맵핑
- 특정한 타입의 데이터를 담고 있는 요청만 처리하는 핸들러
    - @RequestMappint(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    - Content-Type 헤더로 필터링
    - 매치 되지 않는 경우에 415 Not Unsuppoerted MediaType
    
- 특정한 타입의 응답을 만드는 핸들러
    - @RequestMapping(produces="application/json")
    - Accept 헤더로 필터링
    - 매치 되지 않는 경우에 406 Not Acceptable 응답
    
- 문자열을 입력하는 대신 MediaType을 사용하면 상수를 자동 완성으로 사용할 수 있다.

- 클래스에 선언한 @RequestMapping에 사용한 것과 조합이 되지 않고 메소드에 사용한 @RequestMapping의 설정으로 덮어쓴다.

### 4.HTTP 요청 맵핑 : 헤더와 파라미터 맵핑
- 특정한 헤더가 있는 요청을 처리하고 싶은 경우
    - @RequestMapping(headers = "key")
- 특정한 헤더가 없는 요청을 처리하고 싶은 경우
    - @RequestMapping(headers = "!key")
- 특정한 헤더 키/값이 있는 요청을 처리하고 싶은 경우
    - @RequestMapping(headers = "key=value")
- 특정한 요청 매개변수 키를 가지고 있는 요청을 처리하고 싶은 경우
    - @RequestMapping(params = "a")
- 특정한 요청 매개변수가 없는 요청을 처리하고 싶은 경우
    - @RequestMapping(params = "!a")
- 특정한 요청 매개변수 키/값을 가지고 있는 요청을 처리하고 싶은 경우
    - @RequestMapping(params = "a=b")
    
### 5.HTTP 요청 맵핑 : HEAD와 OPTIONS 요청 처리
- 우리가 구현하지 않아도 스프링 웹 MVC에서 자동으로 처리하는 HTTP Method
    - HEAD
    - OPTIONS
- HEAD
    - GET 요청과 동일하지만 응답 본문을 받아오지 않고 응답 헤더만 받아온다.
- OPTIONS
    - 사용할 수 있는 HTTP Method 제공
    - 서버 또는 특정 리소스가 제공하는 기능을 확인할 수 있다.
    - 서버는 Allow 응답 헤더에 사용할 수 있는 HTTP Method 목록을 제공해야 한다.
    
### 6.HTTP 요청 맵핑 : 커스텀 애노테이션
- @RequestMapping 애노테이션을 메타 애노테이션으로 사용하기
    - @GetMapping 같은 커스텀한 애노테이션을 만들 수 있다.
- 메타(Mata) 애노테이션
    - 애노테이션에 사용할 수 있는 애노테이션
    - 스프링이 제공하는 대부분의 애노테이션은 메타 애노테이션을 사용할 수 있다.
- 조합(Composed) 애노테이션
    - 한개 혹은 여러 메타 애노테이션을 조합해서 만든 애노테이션
    - 코드를 간결하게 줄일 수 있다.
    - 보다 구체적인 의미를 부여할 수 있다.
- @Retention
    - 해당 애노테이션 정보를 언제까지 유지할 것인가
    - Source : 소스 코드까지만 유지. 즉, 컴파일 하면 해당 애노테이션 정보는 사라진다는 이야기
    - Class : 컴파일 한 .class 파일에도 유지. 즉, 런타임 시, 클래스를 메모리로 읽어오면 해당 정보는 사라진다.
    - Runtime : 클래스를 메모리에 읽어왔을 때까지 유지! 코드에서 이 정보를 바탕으로 특정 로직을 실행할 수 있다.
- @Target
    - 해당 애노테이션을 어디에 사용할 수 있는지 결정
- @Documented
    - 해당 애노테이션을 사용한 코드의 문서에 그 애노테이션에 대한 정보를 표기할지 결정
    
### 7.HTTP 요청 맵핑 : 연습문제
1. GET/evnets  
2. GET/events/1  
    GET/events/2  
    GET/events/3
3. POST/events CONTENT-TYPE:application/json ACCEPT:application/json
4. DELETE/events/1  
    DELETE/events/2  
    DELETE/events/3
5. PUT/events/1 CONTENT-TYPE:application/json ACCEPT:application/json  
    PUT/events/2 CONTENT-TYPE:application/json ACCEPT:application/json