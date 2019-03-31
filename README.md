# WebMVCConfigurer

## Formatter
- Printer : 해당 객체를 (Locale 정보를 참고하여) 문자열로 어떻게 출력할 것인가
- Parser : 해당 문자열을 (Locale 정보를 참고하여) 객체로 어떻게 변환할 것인가

1. Formatter를 구현하는 객체 Formatter를 생성 (PersonFormatter)
2. WebConfig에 해당 formatter 등록(WebConfig)

### Spring Boot 사용하는 경우
- Spring Boot를 사용하는 경우에는 WebConfig에 Formatter를 따로 등록해 주지 않고 생성한 Formatter파일을 Bean으로만 등록해주면 사용이 가능하다.
