# springboot_webservice
<h2>스프링부트와 AWS로 혼자 구현하는 웹서비스 소스코드</h2>

- 개발환경
    - JAVA 8(JDK 1.8)
    - Gradle 4.8 ~ Gradle 4.10.2

- 소스코드 구성  
    - main  
<img width="357" alt="스크린샷 2021-01-18 오후 11 19 29" src="https://user-images.githubusercontent.com/42709887/104926933-24380a00-59e4-11eb-9f0a-be2fb1a70fae.png">  
    - Test 코드  
<img width="339" alt="스크린샷 2021-01-18 오후 11 19 41" src="https://user-images.githubusercontent.com/42709887/104926936-25693700-59e4-11eb-95bc-d7888bd838e0.png">

<h2>StringBoot JPA</h2>
- Local H2 데이터베이스 사용   
웹 콘솔("http://localhost:8080/h2-console") -> API로 조회

<img width="981" alt="스크린샷 2021-01-18 오후 11 03 06" src="https://user-images.githubusercontent.com/42709887/104927493-d8d22b80-59e4-11eb-8ce1-2c023129dc58.png">

<img width="1222" alt="스크린샷 2021-01-18 오후 11 19 05" src="https://user-images.githubusercontent.com/42709887/104927496-d96ac200-59e4-11eb-80ed-0568e7f9c300.png">

<h2>Mustache Plugin 사용</h2>  

 - 화면 관련 Controller는 모두 IndexController에 존재

 - 게시글 등록 API 구현
 <img width="614" alt="스크린샷 2021-01-21 오전 12 20 08" src="https://user-images.githubusercontent.com/42709887/105196663-3601e480-5b7f-11eb-8e0b-f2b233c4877f.png">
 