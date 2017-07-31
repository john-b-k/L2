### 필요이상으로 노출하지마라
#### 프렌드 코드에서만 접근을 허용해라

- 기본적으로 접근 권한을 firend 코드에만 부여  
- 프랜드에 대한 2가지 기준이 있다.
1. 보통 **같은 패키지** 에있는 클래스들이 서로 friend.  
이때는  private-package 접근 제한자를 사용.
```java
public final class Item {
    private int value;
    private ChangeLinstener listener;

    /** 프랜드만 인스턴스 생성 할 수 있다.**/
    Item () {
    }

    /** 누구나 항목의 값을 변경할 수 있다.**/
    public void setValue(int newValue) {
        value = newValue;
        ChangeListener l = listener;
        if ( l != null) {
            l.stateChanged(new ChangeEvent(this));
        }
    }
    /**프랜드만 값 변경 전달 받을 수 있다. **/
    void addChangeListener(ChangeListener l) {
        assert listener == null;
        listener = l;
    }
}
```

2. 다른 패키지지만  넓은 범위 클래스로 서로 프랜드관계 일 수 도 있다.  
이때 private-package 접근 제한자로는 호출 불가능 하다.  
프랜즈 이지만 항목의 Item 값 변경에 대한 알림을 못받는다.
: 일종의 Bridge 가 필요.  
2개 패키지 api package 와 api-a 패키지 가 있다고 하자.(서로 프랜드)  


-  해결방법  
	1. api-s 패키지에 Accessor를 정의 : Item의 "프랜드"에만 제공하는 기능 대한 추상메서드 가짐.
	2. api 패키지에서 Accessor를 구현하고, Item 접근시 Bridge 활성화!   

 **api-a패키지**  

 ```java
 public abstract class Accessor {
     private static volitile Accessor DEFAULT;

     public Accessor(){}

     public static Accessor getDefault() {
         if(DEFAULT != null) }
             return DEFAULT;
         }
         try{
             Class.forName(Item.class.getName(), true, Item.class.getClassLoader());
         }catch(Exception e) {
         }
     }
     /**Bridge 활성화**/
     public static void setDefault(Accessor accessor) {
         if(DEFAULT != null) {
             throw IllegalStateException();
         }
         DEFAULT = accessor;
     }

     /**프랜즈만 제공하는 기능**/
     protected abstract Item newItem();
     protected abstract void addChangeListener(Item i, ChangeListener l);
 }
 ```
 <br/>  

 **api패키지**  


  ```java
  final class AccessorImpl extends Accessor {
      protected Item newItem() {
          return new Item();
      }
      protected void addChangeListener(Item i, ChangeListener l) {
          item.addChangeListener(l);
      }
  }
  ```
  api패키지에서 Accesor구현체 package-private로 만들고 Item 기능 제공.
  <br/>
  <br/>
  Item에 접근했을때 Bridge 활성화하는 코드 작성  

  ```java
public final class Item {
    private int value;
    private ChangeLinstener listener;

    /**Bridge활성화 : 이제 api-a 패키지에서 프랜드only 제공 기능 활용 가능.**/
    static {
        Accessor.setDefault(new AccessorImpl());
    }

    /** 프랜드만 인스턴스 생성 할 수 있다.**/
    Item () {
    }

    /** 누구나 항목의 값을 변경할 수 있다.**/
    public void setValue(int newValue) {
        value = newValue;
        ChangeListener l = listener;
        if ( l != null) {
            l.stateChanged(new ChangeEvent(this));
        }
    }
    /**프랜드만 값 변경 전달 받을 수 있다. **/
    void addChangeListener(ChangeListener l) {
        assert listener == null;
        listener = l;
    }
}
```  

<br/><br/>
이제 api-a 패키지에서 Bridge 통해서 프랜드 only 기능 사용가능.
예를 들면 api-a 패키지에서 아래처럼 리스너 등록할 수 있다.
```java
Item item = Accessor.getDefault().newItem();
Accessor.getDefault().addChangeListener(item, this)
```

##### 번외설명
**Object의 초기화** 는 new 연산자로 이루어지고 (Heap에 할당 Instance 변수 초기화  
**Class의 초기화** 는 클래스로더를 통해 로딩이 될때 이루어진다. (static 블록에 코드 실행됨.)  
따라서 위의 코드
```java
    try{
        Class.forName(Item.class.getName(), true, Item.class.getClassLoader());
    }catch(Exception e) {
    }
```
는 Item이 로딩되야지 Accessor로 접근할수 있는데(static 블록) 로딩이 안된경우  
```Class.forName``` 으로  Item을 로딩시켜줘서 Bridge를 활성화하는 코드다.
