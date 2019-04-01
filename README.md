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

### 1.HTTP 요청 맵핑 : 요청 메소드
### 2.HTTP 요청 맵핑 : URI 패턴 맵핑
### 3.HTTP 요청 맵핑 : 컨텐츠 타입 맵핑

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
    - 매치 되지 않는 경우에 415 Not Supported MediaType
    
- 특정한 타입의 응답을 만드는 핸들러
    - @RequestMapping(produces="application/json")
    - Accept 헤더로 필터링
    - 매치 되지 않는 경우에 406 Not Supported 응답
    
- 문자열을 입력하는 대신 MediaType을 사용하면 상수를 자동 완성으로 사용할 수 있다.

- 클래스에 선언한 @RequestMapping에 사용한 것과 조합이 되지 않고 메소드에 사용한 @RequestMapping의 설정으로 덮어쓴다.

