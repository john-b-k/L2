# ABOUT CORS

### 개요

- CORS는 W3C스펙, BROWSER의 Cross Domain Communication 허용을 위한.
- XMLHttpRequest객체를 개발자가 same-domain request롤 활용할 수 있게 허용.(same-origin policy 회피)

간단한 예  
- bob.com 이 alice.com 에 접근하고 싶다. (same-origin policy에 의해 허용되지 않는 상황)
- 그러나, CORS 요청을 지원하고, alice.com도 응답으로 특정 Header을 보낸다면, bob.com이 접근가능
- Client는 cross-origin request를 만들어야하고 (브라우저가 함)
- Server 에서도 CORS-support 설정을 해야한다.


### CORS 요청 생성
```javascript
function createCORSRequest(method, url){
  var xhr = new XMLHttpRequest();
  if("withCredentials" in xhr){
    // XMLHttpRequest 객체에 withCredentials property가 있으면 XMLHttpReuqest2 객체이다.
    xhr.open(method, url, true);
  }else if(typeof XDomainRequest != "undefined"){
    //IE 환경 지원
    xhr = new XDomainRequest();
    xhr.open(method, url);
  }else{
    xhr = null;
  }
  return xhr;
}

var xhr = createCORSRequest('GET', url);
if(!xhr){
  throw new Error('Cors not Supported');
}

```

#### Event handler
- 전통적으로 XMLHttpRequest는 onreadystatechange 이벤트 핸들러 가짐  
XHLHttpReuqest2 는 더 가짐.  

| Event Handler   |      Desc      |
|----------|:-------------:|
| onloadstart| 요청이 start되었을때 |
| onload |    요청이 성공적으로 완료되었을때   |
| onloadend | 요청이 완료되었을때 (성공실패 무관) |
| onprogress | 데이터가 로딩되거나 보내질때 |
등등 있음  

활용 케이스

```javascript
xhr.onload = function(){
  var responseText = xhr.responseText;
  console.log(responseText;)
}
```

#### withCredentials
cookies 요청에 포함하려면  
`xhr.withCredentials = true;`  
`Access-Control-Allow-Credentials: true`(preflight response) 해야한다.

#### 요청보내기
모든 설정이 완료되면 ,`xhr.send();`로 요청 보내기  
```javascript
function makeCORSRequest(){
  var url = 'http://otherdomain.com';
  var xhr = createCORSRequest('GET',url);

  xhr.onload = function(){
    var text = xhr.responseText;
    console.log('XHR LOADED, Response is', text);
  }

  xhr.send();
}
```


### 서버에 CORS supporting 설정
- CORS는 browser와 server간 다뤄지는 문제이다.
- 브라우저는 헤더를 더 추가하고, 때로는 추가 요청(preflight)을 보낸다
- 물론 이런 브라우저의 조치는 Client는 겉보기로는 알수 없다.  

<img src='./cors-flow.png'>
- 이런것들에 대한 구현은 Browser Manufacturer에서도 올바르게 구현해야한다


#### CORS type
- Cors 요청 타입은
  1. simple request
  2. not-so-simple request  

1. Simple Reuqest 는  
HTTP METHOD : HEAD GET POST  
HTTP HEADER : Accept, Accept-Language, Content-Language, Last-Event-ID, Content-Type(only application/x-www-form-urlencoded, multipart/form-data, text/plain)    
일 경우.  
예)JSON-P corss-domain GET 요청, HTML from POST 요청 경우
위 조건을 만족하지 않으면   not-so-simple

2. not-so-simple Request는  
- preflight, actual request로 구성된다


#### Handling a simple Request
GET JS 요청
```javascript
var url = 'http://otherdomain.com/cors';
var xhr =  createCORSRequest('GET',url);
xhr.send();
```
HTTP Request
```
GET /cors HTTP/1.1
Origin: http://otherdomain.com/cors    //CORS요청에 항상있는 헤더(scheme+domain+port) 브라우저 영역, 유저가 컨트롤 불가
Host: api.alice.com                   //요청을 보낼 서버
Accept-Language: en-US
Connection: keep-alive
User-Agent: Mozilla/5.0...
```

simple request에서는 브라우저는 CORS응답 기대하지 않는다.
```
Access-Control-Allow-Origin: http://otherdomain.com    //요청 Origin이 여기에 포함되지 않으면 서버는 물론 에러를 보냄
Access-Control-Allow-Credentials: true
Access-Control-Expose-Headers: FooBar
Content-Type: text/html; charset=utf-8
```








http://hanmomhanda.github.io/2015/07/21/Cross-Origin-Resource-Sharing/
www.html5rocks.com/en/tutorials/cors/

cors ==w3c 스펙 브라우저의  cross domain comm. 허용을 위한
cors는 XMLHttpReuqest객체를 개발자가 same-dmaon requestㄹ 화룡할수있게 허용

Simple : bob.com  wanto access alice.com
alice.com response로 헤더 추가하면 bob.com 이 접근가능
CORS를 위해서 Client 는 cross-origin reuqest를 만들어야하고
Server는  CORS-support config를 만들어야한다

Making a CORS Request(Client)

 creatCORSRequest();

이벤트 핸들러
original XMLHTTPReques 는 onreadystatechange 이벤트 핸들러 가짐
XMLHTTPReques2는 추가로 더가짐

최총 코드



Adding CORS supporto the server
CORS는 browser와 server 간의 다뤄지는 문제이다
-추가적은 헤더 추가하고, 때로는 추가 요청을 보낸다.(client를 대신해서)
물론 이런 브라우저의 조치를 클라이언트는 알수없다(패킷분석 없이는)
(browser manufacturer에서 구현해야한다

simple request는 CORS없이  브라우저 주체로 만들수 있다(JSON-P cross-domain GET requeset, HTML form POST request)


not-so-simple request : browser & server에 추가 communication필요.(preflight request)

Handling a simple Requet

브라우저가  Origin (scheme+ domain + port)헤더를 추가(CORS 요청에서 항상 있는 헤더) 유저가 컨트롤 할 수 없다  HTML 퍼브리싱된곳  (HOST : 요청보낼곳)

sample origin request(Orgin==Host)  simple request에서는 browser는 CORS 응답을 기대하지ㄴ는 않는다
서버 응답이 그대로 clientdp rksek

응답해더  에 포함되는 도메인 리스트에 Origin이 포함되지 않으면 서버는 에러 내보냄Access-Control-Allow-Origin: http://api.bob.com (allowed domains)


All CORS related header == Access-Control-

Access-Control-Allow-Origin (required) : 모든 Valid한 CORS응답에 포함되야함
Origin 요청헤더 값이 들어있거나, 모든모든 사이트가 접근하느거 허용한다면 *

Access-Control-Allow-Credentials (optional) : 디폴트로 cookies는 CORS 요청에 포함되어있지 않지만.  이 헤더는 CORS request에 cookeis가 포함되야
함을 가리킨다. 응답해더
XMLHttpRequest2 객체의 withCredentials 프로퍼티와 관계되있다 둘다 값이 true로 되어있어야지.  cookies가 포함됨을 가리킨거임

Access-Control-Expose-Headers 응답(optional) 브라우저에 노출되는 헤더확장하게함
XMLHttpRequest2 객체에는 getResponseHeader() 메서드가 있는데 CORS요청동안에  특정 response의 헤더에 접근하는 메서드이다
(Cache-Control, Conent-Language, Content-Type, Expires, Last-Modified, Pragma)
만약 클라이언트에게 다른 header도 접근을 허용하려면,(getResponseHeader() 가용)  이 Access-Control-Expose-Headers 헤관더 값에  응답헤더를 리스팅해준다


Handling a not-so-simple request
(PUT DELETE application/json)
하나의 요처응로 보이지만 시제로는 2개의 요청으로 구성된다
1. browser가 preflight요청을 보낸다 : 서버에 실제 요청을 만들 수 있는지 물어보는 행위
2. grant되면 실제 요청을 보낸다.

<prefligth>
The preflight request is a way of asking permissions for the actual request, before making the actual request

preflight 를 지원하려면 서버에서  OPTIONS 메서드 지원해야한다.

요청의 Access-Control-Request-Method : 실제요청(2번재 요청)의  HTTP method

Access-Control-Request-Headers : 실제요청에서 사용될 헤더 기술 , 로구분
The Access-Control-Request-Headers header indicates which headers will be used in the actual request as part of the preflight request.

preflight의 위 2개 해더(Method와 Header 정보가짐을 보고 서버는 actual request를 허용할것인지 파악  accepted될것인가..

허용되면 서버는 Preflight Response 보냄

Access-Control-Allow-Origin (required) "접근 허용할 도메인 리스트
Access-Control-Allow-Methods (required) : 접근 허용할 메서드 리스트 supported모든 메서드 리턴 (preflight에서 1개 메서드 물어써도
Access-Control-Allow-Headers(Access-Control-Request-Headers가 요청에 있었다면 required) 서버에서 서포트되는 요청 헤더 리스트
Access-Control-Allow-Credentials (optional)
Access-Control-Max-Age (optional) - 브라우저가 해당시간동안  preflight response 캐시함

prefligth request가 허용되면 acutal request

preflight 요청을 통해온  메서드와 헤더(Access-Control-Request-Headers, 요청의 Access-Control-Request-Method ) 가 서버가 허용하지 않으면 서버는 거부할수있다. -> CORS 헤더없이 응답 보내면된다 -> 그러면 브라우저는  actual request를 만들지 않는다.
