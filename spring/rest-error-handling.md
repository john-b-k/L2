# Spring Rest Service 에서 Exception 처리


#### Error Message 처리 방법
1. controller 에서 try-catch 후 catch문에서 Error Respones 리턴
2. controller 에서 AOP 걸어서 Error 발생하면 Error Handle Advice 실행하게 함.
3. @ControllerAdvice 사용


#### @ControllerAdvice 사용
- 모든 RuntimeException을 throw해서, 결국 @ControllerAdvice 에서 처리하도록함

```java
@RestController
class MyController {
  // DB or Service에서 발생한 RuntimeException 이 던져짐.
}

@ControllerAdvice
class GlobalErrorHanler {

  @ExceptionHandler(InvalidParameterException.class)
  public ResponseEntity<T> invalidHandle(Exception e, HttpServletRequest req){
    //에러 메시지 리턴 수행
  }

  @ExceptionHandler(AException.class, BException.classs)
  public ResponseEntity<T> moreHandles(Exception e, HttpServletRequest req){
    //에러 메시지 리턴 수행
  }
}

```

이렇게 하면 1곳에서  Exception 응답 다루고, 컨트롤럭, 서비스 try-catch 줄어 듬.


#### 톰켓 에러가 나면 어떻게 처리?
1. URL을 잘못 입력
2. Method를 잘못 호출  
등 에러는 @ControllerAdvice-@ExceptionHandler(API정의Exception.class)  에서 다룰수는 없다....?


__ResponseEntityExceptionHandler__ 를 상속한다.  (웬만한 API밖에러는 커버함.)

```java
@ControllerAdvice
class GlobalErrorHanler extends ResponseEntityExceptionHandler {
}
```

```java
@ExceptionHandler(value={
 			NoSuchRequestHandlingMethodException.class,
 			HttpRequestMethodNotSupportedException.class,
 			HttpMediaTypeNotSupportedException.class,
 			HttpMediaTypeNotAcceptableException.class,
 			MissingServletRequestParameterException.class,
 			ServletRequestBindingException.class,
 			ConversionNotSupportedException.class,
			TypeMismatchException.class,
			HttpMessageNotReadableException.class,
			HttpMessageNotWritableException.class,
			MethodArgumentNotValidException.class,
			MissingServletRequestPartException.class,
			BindException.class
		})
	public final ResponseEntity<Object> handleException
```
이 메서드가 제공되어서 ExceptionHandling을 해준다 -> tomcat html 에러 응답 안남
