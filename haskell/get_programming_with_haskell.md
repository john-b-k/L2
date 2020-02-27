## referential transparency 
- (mathematical) function 의 조건
   1. all functions must take an argument.
   2. all functions must return a value.
   3. anytime a function is called with **same argument**, it must return the **same value**.

   3번 rule이 참조 투명성을 의미한다. 


   ```
   tick()
   if (timeToReset) {
       reset()
   }
   ```

   위 처럼  **hidden state** in function call 이면 변화가 invisible.

   unsafe(side effect 발생) 함 (no args, no return)


## lambda와 lexical scope
- 정의

    when a variable is **used**, the program looks **nearest scope**;  
    if the definition of the variable isn't there,  
    it goes to the **next one up**.

- 그럼 scope는 무엇인가?  
    Whenever you create a new function(named, or not), you create **new scope**,  
    which is the **context in which a variable is defined**

- 자바스크립의 IIFE 가 하스켈의 차용함.
    자바스크립트는 네임스페이가 없어서, var로 선언안하면 global 변수 접근하고, 또한 이름같은 변수의 경우 side effect생김.
    ```
    var libraryAdd = function(a, b) {
        c = a + b // 위험성존재 global 접근.
        return c
    }

    (function() {
        var a = 2;
        var b = 3
        var c = a + b
        libraryAdd(10, 20)
        console.log(c) // 5  가장가까운scope var c 참조함.
    })()  // IIFE로 scope안 만들면 최상위 scope만있어서 30이 print.
    ```

- 하스켈에서...
    - 람다를 쓰는 이유 
        1. 즉시 함수를 생성하고 쓸수 있다
        2. 필요하다면 고유의 scope를 생성할수 있기때문에 사용
    - neaest scope에 따른 예
    ```
    x = 4 // looks to top-level defintion
    add1 y = y + x // body x : looks to top-level defintion (near scope)
                   // body y : use argument y (near scope)

    add2 y = (\x -> y + x) 3 // body y : user argument y
                             // body x : find first x in lambda arg.

    add3 y = (\y -> (\x -> x + y) 1 ) 2
                        // body y : use lambda arg y(nearest y) (ignore add3's y) 
            
    ```
