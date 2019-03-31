# 08.HTTP Message Converter

## HTTP 메시지 컨버터
- 요청 본문에서 메시지를 읽어들이거나 (@RequestBody), 응답 본문에 메시지를 작성할 때(@ResponseBody) 사용한다.

## 기본 HTTP 메시지 컨버터
- 바이트 컨버터
- 문자열 컨버터
- Resource 컨버터
- Form 컨버터(폼 데이터 to/form MultiValueMap<String, String>)
- ...

## 설정 방법
- 기본으로 등록해주는 컨버터에 새로운 컨버터 추가하기 : extendMessageConverters
- 기본으로 등록해주는 컨버터는 다 무시하고 새로 컨버터 설정하기 : configureMessageConverters
- 의존성 추가로 컨버터 등록하기
    - 메이븐 또는 그래들 설정에 의존성을 추가하면 그에 따른 컨버터가 자동으로 등록 된다.
    - WebMvcConfigurationSupport


## HTTP 메시지 컨버터 : JSON
- 스프링 부트를 사용하지 않는 경우 
    - 사용하고 싶은 JSON 라이브러리를 의존성으로 추가
    - GSON
    - JacksonJSON
    - JacksonJSON 2
    
- 스프링 부트를 사용하는 경우
    - 기본적으로 JacksonJSON 2가 의존성에 들어있다
    - 즉, JSON용 HTTP 컨버터가 기본적으로 등록되어 있다
    
- Test시 데이터를 보낼 때 contentType을 json타입으로 보내어 테스트..

 