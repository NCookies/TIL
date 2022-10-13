# 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술

인프런 강의 링크 : https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard


## 섹션 1. 프로젝트 환경설정

### 프로젝트 생성
- https://start.spring.io/ 접속
  - gradle, java 선택
  - dependencies에서 Spring Web과 Thymeleaf 추가
  - GENERAGE 버튼 클릭해서 프로젝트 다운로드
  - InteliJ에서 Open

![start.spring.io](/Documents/img/SpringBase/스프링_프로젝트_생성.png)

- InteliJ 설정에서 gradle [Build and run]을 [InteliJ IDEA]로 바꿔주면 빌드가 더 빨리 됨

![intelij_gradle_설정](img/SpringBase/intelij_gradle_설정.png)


### 라이브러리 살펴보기
- IneliJ 우측의 Gradle 탭에서 Dependency 확인할 수 있음
- 실무에서는 System.out.print는 사용하지 않고 로그를 사용함
  - Spring 개발에서 최근 logback과 log4j 이 두 조합을 많이 사용함
  - io에서도 기본적으로 제공

> Gradle은 의존관계가 있는 라이브러리를 함께 다운로드 한다.

#### 스프링 부트 라이브러리
- spring-boot-starter-web
- spring-boot-starter-tomcat: 톰캣 (웹서버)
- spring-webmvc: 스프링 웹 MVC
- spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)
- spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
  - spring-boot
    - spring-core
  - spring-boot-starter-logging
    - logback, slf4j

#### 테스트 라이브러리
- spring-boot-starter-test
  - junit: 테스트 프레임워크
  - mockito: 목 라이브러리
  - assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
  - spring-test: 스프링 통합 테스트 지원


## 섹션 2. 스프링 웹 개발 기초

### 정적 컨텐츠
- 서버에서 가지고 있는 html 파일을 그대로 클라이언트에 보냄

### MVC와 템플릿 엔진
- Model, View, Controller

### API
- @ResponseBody
  - viewResolver를 사용하지 않음
  - HTTP BODY에 데이터를 직접 반환함
  - viewResolver 대신에 HttpMessageConverter가 동작함
  - 반환 데이터가 문자열일 경우 그대로 보내주고(StringConverter), 객체일 때에는 JSON으로 변환함(StringConverter)


## 섹션 3. 회원 관리 예제 - 백엔드 개발

### 회원 리포지토리 테스트 케이스 작성
- 테스트는 메소드의 순서와 상관없이, 의존관계 없이 싫행되어야 함
- 구현 클래스보다 테스트 케이스와 테스트 코드를 먼저 작성하는 것을 TDD(테스트 주도 개발)이라고 함


## 섹션 4. 스프링 빈과 의존관계
- XML로 설정하는 방식도 있지만 최근에는 잘 사용하지 않음
- DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있음
  - 의존관계가 실행 중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입이 권장됨
- 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용함
- 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해(@Configuration) 스프링 빈으로 등록함