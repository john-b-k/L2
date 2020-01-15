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