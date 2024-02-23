자바에서 int 배열에서 List<Integer>과의 변형에 대해서 알아보겠습니다.

## int[] <-> List< Integer >


```java
  import java.util.stream.*;
  
  class main {
  
    public int[] Solution(int[] num_array) {

        /* int[] -> IntStream */
        IntStream intStream = Arrays.stream(num_array);
        // Arrays.stream() : Returns a sequential IntStream with the specified array as its source.

        /* IntStream -> Stream<Integer> */
        Stream<Integer> stream = intStream.boxed();
        // IntStream.boxed() : Returns a Stream consisting of the elements of this stream, each boxed to an Integer.

        /* Stream<Integer> -> List<Integer> */
        List<Integer> int_list = stream.collect(Collectors.toList();
  	 	// java16 부터는 Stream 클래스에 toList() 메소드가 생겨 collect(Collectors.toList())를 대체할 수 있다고 합니다.
  
  
        /* List<Integer> -> int[] */

        // 방법 1
        int num_array_length = num_array.length;
        int[] new_array = new int[num_array_length];
        for (int i=0; i<num_array_length; i++) {
            new_array[i] = int_list.get(i);
        }
        return new_array;

        // 방법 2
        return int_list.stream().mapToInt(i -> i).toArray();

        // 방법 3
        return  int_list.stream().mapToInt(Integer::intValue).toArray();

    }
  }
```

  ## int[] -> List< Integer > 
  ```java
  List<Integer> int_list = Arrays.stream(int_array).boxed().collect(Collectors.toList());
List<Integer> int_list = IntStream.of(int_array).boxed().collect(Collectors.toList());
  ```