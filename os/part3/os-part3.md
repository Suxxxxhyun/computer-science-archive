## operating-system
- CPU 스케줄링
  - [기아상태? 이를 위한 해결방법은?](https://github.com/Suxxxxhyun/computer-science-archive/blob/main/os/part3/os-learning(1).md)
    - Starvation : 특정 프로세스의 우선순위가 낮아서 원하는 자원을 계속 할당받지 못하는 상태
    - DeadLock : 두개 이상의 작업이 서로 상대방의 작업이 끝나기만을 기다리고 있기때문에 다음 단계로 진행하지 못하는 상태
  - [cpu스케줄링의 의미와 종류?](https://github.com/Suxxxxhyun/computer-science-archive/blob/main/os/part3/os-learning(2).md)
    - cpu스케줄링 : 어느 프로세스에 cpu를 할당할 것인가
    - 장기(현재 사용X), 중기, 단기
  - [preemptive / non-preemptive](https://github.com/Suxxxxhyun/computer-science-archive/blob/main/os/part3/os-learning(3).md)
    - preemptive 스케줄링은 어떤 프로세스가 cpu를 할당받아 실행중인 상태에서, 다른 프로세스가 실행중인 프로세스를 중지하고 cpu를 강제로 점유하는 방식
    - non-preemptive 스케줄링은 어떤 프로세스가 cpu를 할당받으면 그 프로세스가 종료되거나 입출력 요구에 의해 프로세스가 자발적으로 중지될때까지 계속 실행하는 것
