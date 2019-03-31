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
    - WebMvcConfigurationSuppo
