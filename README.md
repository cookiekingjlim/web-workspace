# Web Server와 WAS

## 웹 서버(Web Server)

- 웹에서 서버 기능을 수행하는 프로그램으로 HTML 문서나 JPG, PNG 같은 이미지를 HTTP 프로토콜을 통해 웹 브라우저에 제공하는 서버
- 서버 내부의 이미 만들어져 있는 정적인 요소들을 화면에 제공하는 역할
- Apache : Apache Software Foundation에서 만든 웹 서버로 HTTP 통신에 대한 여러 라이브러리 제공

## 웹 애플리케이션 서버(WAS, Web Application Server)

- 웹 서버가 할 수 없는 다양한 비즈니스 로직을 수행하고 동적인 페이지를 만들어 제공하는 서버
- 웹 애플리케이션 서버는 웹 서버와 컨테이너로 구성되어 있다.
- Tomcat : Apache Software Foundation에서 Servlet과 JSP를 통한 동적인 웹 문서를 처리하기 위해 만든 웹 애플리케이션 서버이다.

# 서블릿(Servlet)

- 웹 서비스를 위한 자바 클래스를 말하며 자바를 사용해서 웹을 만들기 위한 기술
- 웹 브라우저로부터 요청을 받아 처리하고 결과를 다시 웹 브라우저로 전송하는 역할

## 동작 구조

1. 클라이언트가 웹 브라우저를 통해 요청을 보냄
2. 해당 요청이 서블릿에 대한 요청이면 서블릿 컨테이너에게 처리를 넘긴다.
3. 서블릿에서 요청에 대한 실행이 완료된 후에는 서블릿 컨테이너가 실행 결과를 웹서버에 전달한다.
4. 웹 서버는 서비스를 요청한 클라이언트에 응답한다.
5. 컨테이너의 서블렛에 대한 설정은 배포 서술자(web.xml)에 작성한다.

### 배포 서술자(Deployment Descriptor)

- 배포 서술자(Deployment Descriptor)는 애플리케이션에 대한 전체 설정 정보를 가지고 있는 파일
- 배포 서술자의 정보를 가지고 웹 컨테이너가 서블릿을 구동한다.

### 서블릿 매핑

- 사용자의 요청을 서블릿에게 전달하기 위해서는 서블릿을 등록하고 매핑해야 한다.
- 매핑하는 방법은 web.xml과 @annotation을 이용하는 방법이 있다.

```xml
<servlet>
    <servlet-name>서블릿 이름</servlet-name>
    <servlet-class>서블릿 클래스</servlet-class>
</servlet>
<servelt-mapping>
    <servlet-name>서블릿 이름</servlet-name>
    <url-pattern>접근 URL 패턴 </url-pattern>
</servelt-mapping>
```

## HttpServlet

- 서블릿이 웹상에서 HTTP 프로토콜을 이용해 서비스를 처리하기 위해 반드시 상속해야 하는 클래스

```java
public class 클래스명 extends HttpServlet {

}
```

### HttpServletRequest

- 클라이언트(웹 브라우저)에서 서버에 보내는 요청 정보를 제공하는 객체
- javax.servlet.ServletRequest를 상속
- getParameter(String) : client가 보내준 값이 저장된 명칭이 매개변수와 같은 명칭에 저장된 값을 불러오는 메소드( => name에다가 key가 들어가는 것)
- getParameterValues(String) : client가 보내준 값이 여러 개일 경우 그 값을 배열로 불러오는 메소드
- setCharacterEncoding(String) : 전송받은 request 객체의 값들의 CharacterSet을 설정해 주는 메소드

### HttpServletResponse

- 서버가 클라이언트(웹 브라우저)로 보내는 응답 정보를 처리하는 객체
- javax.servlet.ServletResponse를 상속 받음
- getWriter() : 문자를 페이지 전송을 위한 Stream을 가져오는 메소드
- setContentType(String) : 응답으로 작성하는 페이지의 MIME type을 정하는 메소드
