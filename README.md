# 04. SpringBoot JSP
  
## 스프링부트에서 JSP 사용방법
1. 프로젝트 생성시 패키징을 war로 변경
    - war 프로젝트로 생성시에는 기본 Application 클래스 외에 ServletInitalizer 클래스도 같이 생성됨
    - 이 파일은 war를 was에 배포해서 사용가능하도록 도와주는 클래스
2. JSP를 사용하기 위한 의존성 추가 (pom.xml)
```aidl
<dependency>
   <groupId>javax.servlet</groupId>
   <artifactId>jstl</artifactId>
</dependency>
<dependency>
   <groupId>org.apache.tomcat.embed</groupId>
   <artifactId>tomcat-embed-jasper</artifactId>
   <scope>provided</scope>
</dependency>
```
3. webapp-WEB-INF-jsp 디렉토리 생성하여 jsp파일 생성
4. application.properties 에서 prefix, suffix 설정 후 사용