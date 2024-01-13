## 폴링이 뭐야? 인터럽트와 비교되는 개념이라는데?
- polling과 interrupt 모두 CPU와 입출력장치의 통신방식

| polling | interrupt |
| --- | --- |
| 다른 프로세스에게 CPU를 양도하지 않고, 하드웨어 장치가 동작을 완료할때까지 계속 루프를 돌면서 하드웨어 상태를 체크하는 방식을 말한다. | CPU가 프로그램을 실행하는 도중에 I/O나 다른 예외 상황발생으로 특별한 처리가 필요할때 CPU에 이를 알려 처리하도록 하는 것을 말한다. 운영체제는 I/O를 요청한 프로세스를 블록시키고 CPU를 다른 프로세스에게 양도한다. |
- 인터럽트를 사용하면, CPU연산과 I/O장치 작업을 중첩시켜서 수행할 수 있게 되어 인터럽트를 통해 I/O처리를 하는 것이, polling보다 CPU의 사용률을 높이는 방법이다.
- 하지만 인터럽트가 폴링보다 무조건 좋은것은 아니다!
    - 예를 들어, 어떠한 작업이 단 한번의 polling만으로 끝날 정도의 빠른 하드웨어장치라면 interrupt보다는 polling이 더 효과적이라고 할 수 있다.
    - interrupt는 현재 실행중인 프로세스를 다른 프로세스로 context-switching하게 되고 많은 비용이 수반되기 때문에, 빠른 하드웨어 장치라면 polling이 더 효율적이고 느린 하드웨어 장치라면 interrupt가 더 효율적이라고 할 수 있다.

참조블로그 : https://jaebworld.tistory.com/27