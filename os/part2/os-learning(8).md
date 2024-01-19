## Thread-Safe의 의미와 설계방법
- Thread-Safe란 멀티 스레드 프로그래밍에서 일반적으로 어떤 함수나 변수, 혹은 객체가 여러 스레드로부터 동시에 접근이 이루어져도 프로그램의 실행에 문제가 없는 것을 말한다.
- 하나의 함수가 한 스레드로부터 호출되어 실행중일때, 다른 스레드가 그 함수를 호출하여 동시에 함께 실행되더라도 각 스레드에서의 함수의 수행결과가 올바르게 나오는 것을 의미한다.


## Thread-Safe 구현방법
- Re-entrancy(재진입성)
  - 어떤 함수가 한 스레드에 의해 호출되어 실행중일때, 다른 스레드가 그 함수를 호출하더라도 그 결과가 각각에게 올바르게 주어져야한다.
- Thread-Local Storage(스레드 지역 저장소)
  - 공유자원이 사용을 최대한 줄여, 각각의 스레드에만 접근 가능한 저장소들을 사용함으로써 동시접근을 막는다.
- Mutual exclusion(상호배제)
  - Thread에 Lock이나 Semaphore를 걸어서 공유자원에는 하나의 thread만 접근 가능하게 한다.
  - Java를 예로 들면, `synchronized`키워드를 이용한다.
  ```java
    public class BusSynchronizedMethod {
    private final int minOccupancy = 10;
    private int reservation = 0;
    
        public synchronized void getBusTicket() {
            try {
                Thread.sleep(100);
                reservation++;
                if (reservation < minOccupancy) {
                    Thread.sleep(10);
                    System.out.println("인원 부족으로 버스 운행이 취소될 수 있습니다. 현재 예약 인원: " + reservation);
                }
            } catch (InterruptedException e) {
                System.out.println("ERROR!");
            }
        }
    }
    ```
- Atomic operations(원자 연산)
  - 데이터 변경시 atomic하게 데이터에 접근하도록 한다.
    - atomic
      - 프로그래밍에서 데이터의 변경이 동시에 일어난 것처럼 보이게 하는 것을 의미한다.
      - 데이터의 값을 변경하는 것은 항상 그 시간이 필요하다. atomic한 데이터의 변경이 이루어지는 시간에는 lock을 건다.
      - 그래서 데이터를 변경하는 시간동안에는 접근이 이루어지지 않게 한다.
    - java를 예로 들면, AtomicInteger, AtomicLong, AtomicBoolean등의 atomic클래스를 제공한다.
    ```java
    public class BusAtomic {
    private final int minOccupancy = 10;
    private final AtomicInteger reservation = new AtomicInteger();
    
        public void getBusTicket() {
            try {
                Thread.sleep(100);
                int newReservation = reservation.incrementAndGet();
                if (newReservation < minOccupancy) {
                    Thread.sleep(1);
                    System.out.println("인원 부족으로 버스 운행이 취소될 수 있습니다. 현재 예약 인원: " + newReservation);
                }
            } catch (InterruptedException e) {
                System.out.println("ERROR!");
            }
        }
    }
    ```
- Immutable Object
  - 객체 생성 이후에 값을 변경할 수 없도록 만든다.
  - Java를 예로 들면, 클래스 변수와 인스턴스 변수를 private, final로 선언한 뒤, setter를 제공하지 않는 것이다.
    ```java
    public class MessageService {
    
        private final String message;
    
        public MessageService(String message) {
            this.message = message;
        }
    
        // getter
    
    }
    ```


- 참고 블로그
  - https://masiljangajji-coding.tistory.com/38
  - https://junghyungil.tistory.com/200
  - https://sup2is.github.io/2021/05/03/thread-safe-in-java.html
  - https://hoho-hobi.tistory.com/233
  - https://velog.io/@mangoo/java-thread-safety
