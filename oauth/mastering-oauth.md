## OAuth 2.0

### 기본용어 및 개념 설명

#### - OAuth2.0 : 서로 다른 두 집단이 정보와 리소스를 안정하고 신뢰 할 수 있는 방법으로 공유할 수 있게 해주는 프로토콜이다.
  - 예1 : 구글계정으로 스택오버플로에 로그인(연합된 신원 federated indentity)
  - 예2 : 링크드인이 사용자의 구글 연락처 리스트를 보고 링크드인 친구등록 추천(권한 위임 delegated authority)

<br/>

#### - 인증 / 인가
  - 인증 : 그 사람(혹은 그 시스템)이 맞는지 확인
  - 인가 : 인증된 후 어떤 일을 할 수 있는 권한이 있는지 판단. (OAuth2.0 은 인가프레임워크)


##### 플레이어

 ###### - User(사용자)
 ###### - Client(클라이언트, App, 사용자가 현재 사용하는 앱 혹은 웹)
 ###### - Service Provider(서비스 제공자, 사용자의 보호된 리소스 가짐 ex Facebook)

<br/>

#### 두가지 유형 Client
  - 신뢰 클라이언트 : 프론트 - 서버 - DB 계층으로 나뉘어서 기밀정보를 안전하게 저장하는 앱/웹
  - 비신뢰 클라이언드 : 기밀정보 안전하게 저장 기능이없다. 단순 HTML/JS 애플리케이션으로 모든 정보가 브라우저에만 저장이된다.(즉 노출됨)

<br/>

#### 동작 흐름
  OAuth2는 정보교환을 위한 여러 방법지원하는데 그중 인가코드그랜트(Authorization code grant), 암시적 그랜트(implicit grant) 를 가장 많이 제공.
  - 신뢰 클라이언트는 인가 코드 그랜트 - 서버사이드 플로우
  - 비신뢰 클라이언트는 암시적 그랜트 를 사용(저장기능이 없으므로) - 클라이언트 플로우

<br/><br/><br/>

### 실행 단계
1. 클라이언트 애플리케이션을 서비스제공자에 등록 (1번만)
2. 액세스 토큰 얻기
3. 액세스 토큰을 이용해 보호된 리소스 접근
4. 액세스 토큰 갱신(인가코드그랜트만 refresh token 으로 가능)

<br/>

#### 1. 등록
서비스 제공자 마다 용어가 다를수 있지만 아래 5개를 얻는다
- Client ID : goodapp-1231
- Client Secret : 12913nfdi193nf9d
- 리다이렉션 포인트 : www.goodapp.com/callback
  - 서비스 제공자에서 토큰 발급후 클라이언트 앱에 전달하기위한 연결점
  - 서비스제공자 302 응답 -> 브라우저의 redirection 302, Location Header 를 통해 클라이언트에 전달
- 인가 앤드 포인트 : api.facebook.com/auth
  - 토큰을 받기위해 서비스 제공자에 인가 받아야함 필요하다면 로그인, 그리고 사용자가 인가함.
- 토큰 앤드 포인트 : api.facebook.com/token
  - 인가받은 후 토큰 발급 받기위한 연결점

<br/>

#### 2. 사용흐름(액세스 토큰얻기, 리소스접근, 갱신)
<br/>

**비신뢰 클라이언트 예 (implicit grant):**
 1. `facebook 으로 로그인 버튼` Click (domain : goodapp)
 2. www.facebook.com/dialog/auth 로 브라우저 이동 (domain :fb)
    - 이동예 : html/js앱은 window.location.href = www.facebook.com/dialog/oauth?reponse_type=token&client_id=... 방식 사용
 
 3. 사용자 facebook 로그인 (domain : fb) 3에 의해서 사용자 비번은 goodapp은 알수없으로 안전
 4. goodapp 이 facebooek담벼락접근 합니다 허용 (domain : fb)
 5. fb 이 302 응답 -> 브라우저 goodapp.com/callback 으로 리다이렉션 (w/ token정보) (domain : goodapp)
 6. goodapp.com/callback 페이지에서 token 으로 보호된 리소스 접근해서 자신의 서비스에 활용
    - 보호 리소스 접근 예 : graph.facebook.com/someresource?access_token=3r3kdfen  (ajax 활용)


**신뢰 클라이언트 예 (authorization code grant)**
  1. facebook에서 친구목록 가져오기 클릭 (domain : goodapp)
  2. fb 로그인 페이지(인가포인트)로 user-agent  이동(사용자 권한승인 위해) (domain : fb)  

  (3 ~ 4 authorization code (일회용) 받기)
  
  3. 로그인 후 인가 승인하면, 302 응답 Location : goodapp.com/callback?code=123nb2&scope=...  (인가코드 응답) (domain : fb)
  4. 302 리다이렉션으로 user-agent(browser)가 goodapp.com/callback?code=dfadafd&... 형태로 goodapp 서버에 GET 요청보냄 (domain : goodapp)

  (5~7 goodapp backend에서 처리, authorization code <-> access_token 교환)

  5. /callback URI매핑된 서블릿(or Controller)에서 전달받은 인가코드로 토큰 엔드
   포인트(api.facebook.com/oauth/access_token (w/ code))에 접근해해서token을 받음.
  6. 5에서 활용된 서블릿(Controller)의 아래 코드 에서는 이제 받은 token 으로 보호된 리소스 가져올수 있다. (token 은 brower에 전달 되지 않아서 더 안전)
  7. 보호된 리소스로 goodapp 에서 원하는 데이터 처리 및 응답
  8. user-agent 는 사용자에 goodapp with fb resource 를 보여줌 (domain : goodapp)

  * refresh token 활용 : access_token이 만료되었을 경우 refresh_token으로 재발급
  /갱신한다 : 6 ~ 7 사이에 token 갱신이 가능하다.


<br/>
<br/>
<br/>

### 코드
#### client side flow (implicit grant)

**index.html**
```html
<!DOCTYPE html>
<html>
  <head>
    <script>
      $(document).ready(function() {
        $("#goButton").click(makeRequest);
      });
      function makeRequest() {
        // 리다이렉션 포인트(토큰받는) 등 설정
        var AUTH_ENDPOINT = "https://www.facebook.com/dialog/oauth";
        var RESPONSE_TYPE = "token";
        var CLIENT_ID = "INSERT_CLIENT_ID";
        var REDIRECT_URI = "http://goodapp.com/callback.html";
        var SCOPE = "public_profile user_posts";
        // Build authorization request endpoint
        var requestEndpoint = AUTH_ENDPOINT + "?" +
          "response_type=" + encodeURIComponent(RESPONSE_TYPE) + "&" +
          "client_id=" + encodeURIComponent(CLIENT_ID) + "&" +
          "redirect_uri=" + encodeURIComponent(REDIRECT_URI) + "&" +
          "scope=" + encodeURIComponent(SCOPE);
        // 서비스 제공자 요청 엔드 포인트에 요청
        window.location.href = requestEndpoint;
        // fb 로그인 창에 로그인 및 인가 허용 하면
        // status : 302  Location : http://wmiig.com/callback.html#token=afd91&scope=user_posts&... 으로 응답
        // good app callback.html 에 요청 fragment 형태로 토큰 전달
      }
    </script>
  </head>
  <body>
    <button id="goButton" type="button">Go!</button>
    <div id="results"></div>
  </body>
</html>
```
**callback.html**
```html
<!DOCTYPE html>
<html>
  <head>
    <script>
      $(document).ready(function() {
        var responseProperties = fragment.split("&");
        // 리다이렉션으로 넘어온 토큰 정보를 파싱해서 추출 (fragment 파라미터에서 추출)
        var accessToken = "";
        ...

        // fb의 보호 리소스 요청 (전달(파싱) 받은 토큰으로)
        $.ajax({ type: "POST",
          url: "https://graph.facebook.com/v2.5/me?fields=name",
          data: {
            access_token: encodeURIComponent(accessToken),
            method: "get"
          },
          success: function(data) {
            //보호된 리소스 가져오기 성공하면 여기서 goodapp이 원하는 형태로 재가공
          }
        });
      });
    </script>
  </head>
  <body>
    <div id="response">
      ... fb에서 얻은 리소스 정보를 활용해서 재가공 하는 view
    </div>
  </body>
</html>
```

<br/>


#### server side flow (authoriztion code grant)

**index.jsp**
```html
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <script>
      $(document).ready(function() {
        $("#goButton").click(makeRequest);
      });
      function makeRequest() {
        // Define properties
        var AUTH_ENDPOINT = "https://www.facebook.com/dialog/oauth";
        var RESPONSE_TYPE = "code";
        var CLIENT_ID = "INSERT_CLIENT_ID";
        var REDIRECT_URI = "http://goodapp.com/callback"; // 인가 성공하면 browser redirect 로 /callback Controller로 요청감(w/ authorization code)
        var SCOPE = "public_profile user_posts";
        // Build authorization request endpoint
        var requestEndpoint = AUTH_ENDPOINT + "?" +
        "response_type=" + encodeURIComponent(RESPONSE_TYPE) + "&" +
        "client_id=" + encodeURIComponent(CLIENT_ID) + "&" +
        "redirect_uri=" + encodeURIComponent(REDIRECT_URI) + "&" +
        "scope=" + encodeURIComponent(SCOPE);
        // fb인가 포인트에 요청 (필요하다면 fb 로그인, domain : goodapp -> fb)
        window.location.href = requestEndpoint;
      }
    </script>
  </head>
  <body>
  <button id="goButton" type="button">Go!</button>
    <div id="results"></div>
  </body>
</html>

```

**Callback Controller**

fb인가 성공후 응답 302 , Location : http://goodapp.com/callback?code=1ndf3&scope=user_email&...
User-Agent(브라우저)는 Callback Controller 로 redirection Get 요청
```java
@GetMapping("/callback")
public class CallbackController {
  //Authoriztion code 추출
  String authorizationCode = request.getParameter("code");
  //authoriztion code 로 access_token 획득
  final String TOKEN_ENDPOINT = "https://graph.facebook.com/oauth/access_token";
  final String GRANT_TYPE = "authorization_code";
  final String REDIRECT_URI = "http://goodapp.com/callback";
  final String CLIENT_ID = "INSERT_CLIENT_ID";
  final String CLIENT_SECRET = "INSERT_CLIENT_SECRET";

  HttpPost httpPost = new HttpPost(TOKEN_ENDPOINT
        + "?grant_type=" + URLEncoder.encode(GRANT_TYPE, StandardCharsets.UTF_8.name())
        + "&code=" + URLEncoder.encode(authorizationCode, StandardCharsets.UTF_8.name())
        + "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8.name())
        + "&client_id=" + URLEncoder.encode(CLIENT_ID, StandardCharsets.UTF_8.name()));

  // Server(goodapp) 2 Server(토큰 엔트포인트) 호출로 Token 획득
  CloseableHttpClient httpClient = HttpClients.createDefault();
  HttpResponse httpResponse = httpClient.execute(httpPost);
  String accessToken = parseAndGetAccessToken(httpResponse);

  // 획득한 token으로 리소스 접근
  String requestUrl = "https://graph.facebook.com/v2.5/me/feed?limit=25"; //리소스
  httpClient = HttpClients.createDefault();
  httpPost = new HttpPost(requestUrl);
  httpPost.addHeader("Authorization", "Bearer " + accessToken);
  ...

  // 리소스 핸들링 해서 Goodapp 에서 활용
}
```
