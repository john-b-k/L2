# Javascript Hoisting
- **Hoist** : 끌어올리다.

#### 참고 - 함수 정의
- 함수선언문(function statement) : `function a(){}` - *함수 리터럴* 로 함수생성
- 함수표현식(function expression): `var a = function(){}` - *함수 리터럴* 로 함수생성
- Function() 생성자 함수 : `new Function(arg1,..,argN,funcBody)`

함수 정의 3가지 방법이지만 내부적으로 모두 Function()를 사용

## 함수 호이스팅
1. 함수 선언문 형태로 생성  

```Javascript  
add(2,3);  //5

function add(x,y){
  return x+y;
}
```
위 코드에서 함수 호이스팅이 일어난다(함수 선언문으로 생성된경우.)
```Javascript
var add = function(x,y){     //호이스팅된 함수.
  return x+y;
}

add(2,3) //5
```


2. 함수 표현식 형태로 생성  

```Javascript
add(2,3);   // uncaugt **type error**

var add = function(x,y){
  return x+y;
}
add(3,4);   //7

```
위 코드에서는 함수 호이스팅은 일어나지 않음. *변수 호이스팅* 은 일어난다  

```Javascript
var add;  // (실행시var add = undefinde 로 초기화), (변수 호이스팅)
add(2,3); // Type error

add = function(x,y){
  return x+y;
}
add(3,4);  //7

```

## 변수 호이스팅
- 함수호이스팅 2에서 보인것 처럼, 변수가 사용된 **scope 맨위** 로 끌어올려짐
- **변수 선언과 초기화가 분리됨**.  

Ex1)
```Javascript
function example(){
  console.log(x);   //undefined
  var x = 100;  
  console.log(x);   //100
}
```
위코드는 실제로 변수선언과 초기화가 분리되는 호이스팅이 일어남.  
```Javascript
function example(){
  var x;            //Hoisting
  console.log(x);  //undefined
  x = 100;
  console.log(x);   //100
}
```


Ex2)  
```
var name = "global";
function testHoisting(){
  console.log(name);
  var name = "local";
  console.log(name);
}
```
'global' , 'local'로 예상되지만..  위 코드는 아래와 같이 Hoisting 됨.  
*Hoisting때문에* global name 은 local name scope 변수에의해 **shadowing** 됨.  

```
var name = 'global';
function testHoisting(){
  var name; //undefined할당
  console.log(name);  //undefined
  name = 'local';
  console.log(name);  //'local'
}
```
