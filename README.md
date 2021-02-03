# springboot_webservice
<h2>스프링부트와 AWS로 혼자 구현하는 웹서비스 소스코드</h2>

- 개발환경
    - JAVA 8(JDK 1.8)
    - Gradle 4.8 ~ Gradle 4.10.2

- 소스코드 구성  
    - main  
<img width="410" alt="스크린샷 2021-01-30 오후 4 39 14" src="https://user-images.githubusercontent.com/42709887/106350598-b19b2880-6319-11eb-8bf5-411b942385a1.png">
    - Test 코드  
<img width="417" alt="스크린샷 2021-01-30 오후 4 39 29" src="https://user-images.githubusercontent.com/42709887/106350603-b9f36380-6319-11eb-8b5e-aa0fa4577d73.png">

<h2>StringBoot JPA</h2>
- Local H2 데이터베이스 사용   
웹 콘솔("http://localhost:8080/h2-console") -> API로 조회

(웹 콘솔 화면)
<img width="981" alt="스크린샷 2021-01-18 오후 11 03 06" src="https://user-images.githubusercontent.com/42709887/104927493-d8d22b80-59e4-11eb-8ce1-2c023129dc58.png">

(API 조회 화면)
<img width="1222" alt="스크린샷 2021-01-18 오후 11 19 05" src="https://user-images.githubusercontent.com/42709887/104927496-d96ac200-59e4-11eb-80ed-0568e7f9c300.png">


<h2>Mustache Plugin 사용</h2>  

 - 화면 관련 Controller는 모두 IndexController에 존재

 - 게시글 등록/삭제/수정 API 구현

 (게시글 등록 화면)
 <img width="614" alt="스크린샷 2021-01-21 오전 12 20 08" src="https://user-images.githubusercontent.com/42709887/105196663-3601e480-5b7f-11eb-8e0b-f2b233c4877f.png">


 <h2>OAuth2.0 - Google login 및 Naver login 기능 구현 (완료)</h2>  

 - User : 사용자 정보 담당할 도메인 클래스 (entity) 

 - Role : 권한 코드  
 - config.auth 패키지 : 시큐리티 관련 클래스  
    - SecurityConfig : 설정 코드  
    - CustomOAuth2UserService : 사용자 정보를 기반으로 가입  및 정보수정, 세션 저장 등의 기능을 지원  
- config.auth.dto 패키지   
    - OAuthAttributes   
    - SessionUser   

(로그인 전 화면)
<img width="1429" alt="스크린샷 2021-01-30 오후 4 49 40" src="https://user-images.githubusercontent.com/42709887/106350829-3b97c100-631b-11eb-9c48-29b88938c473.png">
(로그인 후 화면)
<img width="1431" alt="스크린샷 2021-01-30 오후 4 49 53" src="https://user-images.githubusercontent.com/42709887/106350821-30449580-631b-11eb-8ae9-a65fa1c48504.png">

(OAuth2 프로세스 참고)
<a href ="https://developers.payco.com/guide/development/start"> 출처 : OAuth2 페이코 로그인 가이드</a>
<img width="601" alt="스크린샷 2021-01-30 오후 4 52 19" src="https://user-images.githubusercontent.com/42709887/106350870-8580a700-631b-11eb-8803-933c434ed3f8.png">

<h2>AWS EC2 인스턴스 생성 (완료)</h2>

- AMI - 인스턴스를 시작하는데 필요한 정보를 이미지로 만들어 둔 것
[여기선 Amazon Linux AMI 사용]
- 인스턴스 유형 - T시리즈 [t2.micro]
(크래딧 : CPU 포인트 개념)
- pem 키
- 고정 IP(EIP) 할당 
- Java 8 설치 & 타임 존 변경 & Hostname 변경


<h2>EC2 서버에 배포 (완료)</h2>

- 배포 스크립트(.sh)
- 외부 security 파일 등록 (보안상 서버에서 직접 가지고 있도록)
- RDS profile
 
 <h2>배포 자동화 (완료)</h2>

- Travis CI - S3 - CodeDeploy 연동

(Travis CI)
<img width="973" alt="스크린샷 2021-02-04 오전 12 08 28" src="https://user-images.githubusercontent.com/42709887/106766314-1d182980-667d-11eb-8061-57135a107776.png">

(S3)
<img width="916" alt="스크린샷 2021-02-01 오후 7 39 57" src="https://user-images.githubusercontent.com/42709887/106766206-fa861080-667c-11eb-82c3-3cb3924d3379.png">


 <h2>무중단배포 (완료)</h2>

 - Nginx 리버스 프록시 사용
 - Nginx 1대, 스프링부트 Jar 2대 사용
 - Nginx는 80번 포트, 스프링은 각각 8081, 8082 사용
