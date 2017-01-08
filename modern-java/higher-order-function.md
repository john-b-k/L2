### Higher Order Function(HOF)
고계함수

####- 다음 2조건중 1개 만족하면된다.
######  1. 파라미터로 함수를 받는 함수  
: ``` Function<Function<Integer,Integer>, String>>```
######  2. 리턴값으로 함수를 리턴하는 함수
: ``` Function<Integer,Function<Integer,String>> ```

#### 에제 코드
ex1.
```java
import java.util.function.Function;

public class HOFTest {

	public static void main(String [] args) {
		//Case 1.
		Function<Function<Integer,String>,String> f = g -> g.apply(10) + "$";

		Function<Integer, String> g = x -> "#" + x;

		System.out.println(
			//Function f 에 파라미터로 function 전달.
			f.apply(g)  // == f(g(x))  JVAV는 객체로 표현해야하기때문에 f.apply 로 사횽
		);
		//결과값 : #10$
		//파라미터로 들어온 함수(행동) 적용하고, 그 다음 원래 함수(행동) 적용



		//Case 2.
		Function<Integer, Function<Integer, String>> func = i -> ( i2 -> Integer.toHexString(i2 + i) );

		Function<Integer, String> plus2AndToHexa = func.apply(2); // == i2 -> i2 + '2' and toHexa
		Function<Integer, String> plus9AndToHexa = func.apply(9); // == i2 -> i2 + '9' and toHexa

		System.out.println(
				plus9AndToHexa.apply(2)  // 9를 더하는 함수에 2를 인자로 집어넣음.f(2) (f 는 +9 함수)
		);
		//결과값 : b (11)


		//Case 2. 에서 커링 관련.
		Function<Integer, Function<Integer, Function<Integer, Integer>>> func2 = i -> ( i2 -> ( i3 -> ( i + i2 + i3 ) ) );
		//커링
		System.out.println(
				func2.apply(9).apply(4).apply(2)
		);
		//결과값 15

	}
}

```
<br/><br/>
ex2.
```java
//E type 리스트를 R type 리스트로 변환
	public static <T,R> List<R> map(Function<T, R> mapper, List<T> list){
		List<R> mappedList = new ArrayList<>();		
		for(final T t : list){
			R r = mapper.apply(t);
			mappedList.add(r);
		}
		return mappedList;
	}

	public static void getListElementsLength(){
		//map( (String s) -> s.length() , Arrays.asList("hi", "hello", "good"));
		map(String::length , Arrays.asList("hi", "hello", "good"));
	}
```
