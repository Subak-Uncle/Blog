# 컬렉션

- Collection 인터페이스는 List, Set, Queue 로 크게 3가지 상위 인터페이스로 분류가 된다. 
- List와 Set, Queue는 Collection 인터페이스를 상속 받지만, 구조 상의 이유로 Map은 따로 구현되어 있다

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/a7280344-57e7-4df2-a695-aead1bb81399)

> 출처 : https://techvidvan.com/tutorials/java-collection-framework/

## Collection 주요 인터페이스 특징

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/72295404-1349-4859-a0df-2dad374c4268)



- 참조 자료형 주소 값을 저장.
- List와 Map이 유사함.
- 모두 제네릭 클래스 사용 가능.

Key + Value = Entry, Map 인터페이스



entrySet



### Collection Framework 상속 순서

자바에서 컬렉션 프레임워크의 인터페이스들은 다음과 같은 상속 구조를 가지고 있습니다:

1. `java.lang.Iterable`: 컬렉션의 요소들을 반복적으로 탐색할 수 있는 기능을 제공합니다.
2. `java.util.Collection`: 요소들의 그룹을 나타내는 컬렉션을 정의합니다. 이 인터페이스는 `Iterable`을 상속합니다.
3. `java.util.List`: 순서가 있는 요소들의 컬렉션을 나타내며, 중복 요소를 허용합니다. 이 인터페이스는 `Collection`을 상속합니다.
4. `java.util.Queue`: FIFO(First-In-First-Out) 원칙에 따라 요소들을 저장하고 액세스할 수 있는 기능을 제공합니다. 이 인터페이스는 `Collection`을 상속합니다.
5. `java.util.Deque`: 양방향 큐(Double Ended Queue)를 나타내며, 요소를 양쪽 방향에서 추가하거나 제거할 수 있습니다. 이 인터페이스는 `Queue`를 상속합니다.
6. `java.util.Set`: 중복을 허용하지 않는 요소들의 집합을 나타냅니다. 이 인터페이스는 `Collection`을 상속합니다.
7. `java.util.SortedSet`: 요소들이 정렬된 순서로 유지되는 `Set`을 나타냅니다. 이 인터페이스는 `Set`을 상속합니다.
8. `java.util.NavigableSet`: 요소들 사이에서 탐색과 정렬에 관련된 작업을 수행할 수 있는 `SortedSet`을 나타냅니다. 이 인터페이스는 `SortedSet`을 상속합니다.
9. `java.util.Queue`와 `java.util.Deque`는 다음과 같은 하위 인터페이스를 추가로 상속합니다:
   - `java.util.concurrent.BlockingQueue`: 멀티스레드 환경에서 사용하기 위한 블로킹 큐를 나타냅니다.
   - `java.util.concurrent.TransferQueue`: 특정 스레드로 요소를 전달할 수 있는 기능을 제공하는 큐를 나타냅니다.
   - `java.util.concurrent.BlockingDeque`: 멀티스레드 환경에서 사용하기 위한 양방향 블로킹 큐를 나타냅니다.





## List

배열과 리스트 차이. 배열은 데이터 타입을 한 가지만 가지고 가지만, 리스트는 제네릭 클래스를 사용하지 않으면 Object라 여러 타입을 저장할 수도 있다.

