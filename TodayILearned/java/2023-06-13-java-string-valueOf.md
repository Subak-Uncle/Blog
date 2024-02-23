- # toString과 valueOf의 차이점
  
  >### toString() : 
  >객체의 문자열 표현을 반환하는 메소드. 
  >이 메소드는 모든 클래스가 가지고 있으며, 기본적으로 클래스 이름과 해시코드를 반환합니다. 
  >하지만 String 클래스와 같이 이 메소드를 **Overriding**하여 자신만의 문자열 표현을 반환하는 클래스가 많습니다.
  
  >### valueOf() : 
  >주어진 인수를 문자열로 변환하는 메소드.
  >이 메소드는 **Overloading**이 되어있어서, 다양한 타입의 인수를 받아 문자열로 변환할 수 있습니다.
  
  두 메소드 모두 Object의 값을 String으로 형변환을 시키는 것에서는 동일하지만,
  Object 값이 "null"인 경우에서 차이가 난다.
  
  ### toString() : 
  
  Object가 **null**일 경우, NullPointException(NPE)가 발생한다.
  
  ### String.valueOf() : 
  
  Object가 **null**일 경우, "null" 값을 리턴해줌.
  
  
  ```java
  public class Main {
      public static void main(String[] args) {
          // 객체 생성
          Object obj = new Object();
          String str = "Hello, World!";
  
          // toString() 사용
          System.out.println(obj.toString());
          System.out.println(str.toString());
  
          // valueOf() 사용
          System.out.println(String.valueOf(obj));
          System.out.println(String.valueOf(str));
          
          // null 처리
          Object nullObj = null;
          String nullStr = null;
          
          System.out.println(nullObj.toString()); // NullPointException 발생
          System.out.println(String.valueOf(nullObj)); // "null" 문자열 출력
          System.out.println(nullStr.toString()); // NullPointException 발생
          System.out.println(String.valueOf(nullStr)); // "null" 문자열 출력
      }
  }
  ```