## Simple HTTP Client 

## 목표
- 매우 직관적이고 사용하기 쉬운 Java HTTP Client Library를 구현해본다.
- Maven Central Repository에 등록하는 것까지 목표
- Github Star 50개? 100개?

## 구현 범위
1. Socket을 직접 사용한다.
2. binary byte 수준까지 직접 다룬다. (ByteBuffer in Java or ByteBuf in Netty)
3. HTTP message를 직접 파싱한다. 
4. 만약 동시성이 필요하다고 해도, 스레드를 직접 다루진 않는다. (java.util.concurrent)
5. JSON, XML 같은 데이터구조 파싱은 Gson 같은 기존의 라이브러리를 사용한다.

## 필수 요구사항
1. HTTP 모든 메서드 구현
2. 많이 사용되는 HTTP Header 구현 (어디까지가 '많이' 인지는 논의 필요)
3. byte 단위의 정확한 message IO (데이터 손실이 일어나지 않도록) 
4. multipart 업로드/다운로드 구현

### 선택 요구사항 (혹은 추가 개발사항)
1. 병렬 업로드/다운로드 (Range header)
2. 플러그인 형태의 Add-on (ex. logging, tuning, file, AOP) 
3. 10GB 파일 업로드/다운로드. 즉, 메모리에 모든 binary를 올리지 않고 relaying
4. zero-copy
5. 뛰어난 성능
6. HTTP2 지원
7. TLS 지원 (tls 1.2까지. tls 1.3까지)
8. keep-alive 등 connection과 관련된 HTTP Header 지원
9. Upgrade Header -> Websocket 지원
10. 엄격한 HTTP 명세 따르기 (ex. Content-Length
Any Content-Length greater than or equal to zero is a valid value.)
11. Proxy 지원
12. compressing, decompressing (br, gzip, ...)
13. auto retry
14. auto-close when request with closable resource
15. response pipeline
16. MIME 타입 추측 지원
17. redirect 지원
18. cache 헤더 지원

## 방법
1. 어떤 HTTP 버전을 지원할 것인지 정한다. 일단은 HTTP1.1 이겠지만.
2. 기존 구현체를 살펴보거나, RFC2616 HTTP1.1 명세, 소켓 통신, TCP/IP, java.nio 패키지, ByteBuffer등 사전 조사(라 쓰고 공부)를 진행한다.
3. 인터페이스를 결정한다. 반드시 사용하기 쉽고 **직관적**이어야 한다!
4. 전체적인 설계를 잡는다. 추가적인 기능추가까지 고려하여 설계를 진행한다.
5. 이 때 언제나 **테스트**에 대한 것을 염두에 둔다.
6. 각자 개발 파트를 정한 뒤, 구현한다.
7. 브랜치 전략, 리뷰 전략 및 지속적인 피드백과 함께 프로젝트를 진행한다.

## 주의사항
1. 멀티스레드를 사용하지 않는다해도, 불변스타일로 작성
2. 로깅 전략 구축

## 학습효과
1. 명세가 이미 모두 나와있기 때문에, 우리가 명세를 정의하지 않아도 된다.
2. 명세는 기능에 대한 것은 아무것도 말해주지 않기 때문에 구현에 유연함이 있다.
3. 이미 유명한 구현체들이 많고, 유명한 프로토콜이므로 구현상 막혔을 때 도움을 얻기가 편하다.
4. 추가적인 기능 구현이 용이하다. 다른 구현체들을 참고해도 좋고, 우리가 편의 기능에 대한 스펙을 따로 정의해도 된다.
5. 의존성이 명확하다. 오직 네트워크! 그런데 명세를 직접 구현하므로 의존성의 부분은 최소화 된다. (모두 로직으로 산정)
6. 네트워크와 웹에 대해서 많은 공부를 할 수 있다.
7. 병렬성과 비동기에 대한 지식을 얻을 수 있다.
8. 소켓 통신과 TCP/IP에 대한 지식을 얻을 수 있다.
9. 자바의 기본 Network API에 대한 학습을 병행할 수 있다.
10. HTTP에 대한 깊은 이해가 가능하다.

## 참고할만한 기존 구현체
1. Java 9, Java 11 - HttpClient
2. Spring RestTemplate (above Spring 5, WebClient)
3. Apache Http Client
4. Unirest
5. OkHttp
6. Netty (참고용)
