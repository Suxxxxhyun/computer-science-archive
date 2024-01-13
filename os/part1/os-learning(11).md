## 동기식 I/O와 비동기식 I/O의 공통점과 차이점은 무엇일까?
- 동기식 I/O (동시성 문제가 발생할 수 있다.)
  - **프로그램이 I/O요청을 했을 때, 입출력을 요청한 프로세스는 해당 I/O작업이 완료되어야 다음 작업을 할 수 있는 방식이다.**
  - 주로 읽기 작업에 사용되는데, 일반적으로 디스크, 키보드와 같은 I/O 하드웨어들이 속도가 느리므로 CPU는 입출력 작업을 기다려야한다.
  - **따라서, 일반적으로 입출력 수행 중에 CPU를 다른 프로그램에 할당해 CPU가 계속 쉬지 않고 일을 할 수 있도록 관리한다.**
  
  - 이렇게 CPU를 다른 프로그램에 할당하여 CPU를 쉬지 않게 할때, 동시성(synchronization) 문제가 발생할 수 있다.
  - 예를 들어, 프로그램A가 원래 1이었던 파일의 내용을 3으로 수정하는 I/O요청을 하고 이를 수행하는 동안 
  - 프로그램 B에게 CPU를 할당했다고 가정하자. 
  - 이때, 공교롭게도, 프로그램B도 A가 접근한 파일과 똑같은 곳에 접근하여 파일의 내용을 +1하는 요청을 했다.
  - 그러면, 입출력 컨트롤러는 A와 B의 요청을 순서를 바꾸어 처리할 수 있다. 
  - 즉, 1 -> 3 -> 4로 변해야하는 출력이 1 -> 2 -> 3으로 바뀌는 문제가 생긴다. 
  - **(A의 요청을 먼저 처리해야하는데, B의 요청을 먼저 처리한 셈이 된 꼴임!)**
  - **이런 경우를 막기 위해, 요청들을 큐(queue)에 넣어 관리하게 된다.**
  - 디스크 차원에서는 큐에 있는 요청을 순서대로 처리함으로써 동시성문제를 해결할 수 있다.

- 비동기식 I/O
  - CPU의 제어권을 입출력 연산을 호출한 프로세스에게 곧바로 다시 그 프로세스에게 부여하여 CPU는 I/O결과와 상관없이 처리가능한 작업부터 처리한다.

- 동기식I/O와 비동기식 I/O의 공통점은 I/O연산이 완료되면 인터럽트를 통해 CPU에게 알리게 된다.
- 차이점은 I/O작업이 끝나기를 Requesting process가 기다리냐, 기다리지 않느냐에 차이라고 할 수 있다.

- 참조블로그 
  - https://structuring.tistory.com/118
  - https://sy-note-0.tistory.com/28