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


## 섹션 6. 스프링 DB 접근 기술
- DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체임
  - 스프링 부트는 데이터베이스 커넥션 정보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둠
- 스프링 JdbcTemplate과 MyBatis 같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분 제거해준다. 하지만 SQL은 직접 작성해야 한다.

#### JPA
- JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해준다.
- JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다.
- JPA를 사용하면 개발 생산성을 크게 높일 수 있다.

> show-sql
 JPA가 생성하는 SQL을 출력

> ddl-auto
JPA는 테이블을 자동으로 생성하는 기능을 제공하는데 **none** 를 사용하면 해당 기능을 끈다
**create** 를 사용하면 엔티티 정보를 바탕으로 테이블도 직접 생성해준다


## 섹션 7. AOP
- AOP : Aspect Oriented Programming
- 공통 관심 사항(cross-cutting concern)과 핵심 관심 사항(core concern)을 분리할 수 있음
- Ex) 메소드마다 수행 시간 측정 코드를 따로 분리할 수 있음
- 핵심 관심 사항(비즈니스 로직)을 깔끔하게 유지할 수 있고 원하는 적용 대상을 선택할 수 있음


## 섹션 8. 다음으로
이번 강의는 스프링의 세부적인 것을 깊게 파보는 것보다는, 전체적인 로드맵을 그려보며 직접 체험할 수 있는 기회였다. 김영한 님의 다른 강의 목록들도 살펴봤는데, 전부 중요해보이고 언젠가 내게 필요할 것 같은 내용들이었다. 

그러나 우선은 직접 코딩해보면서 몸으로 부딛혀보고 이런저런 경험을 쌓은 다음에 수강하려고 한다. 그 편이 훨씬 이해와 체감도 잘 되고 얻는게 더 많을 것 같기 떄문이다.


#### 의문점들
======================

스프링 빈 의존성 주입(DI)를 쓰는 이유는?

관계를 명시적으로 확실히 하기 위해서? 개발자의 실수를 방지?

========================

스프링 빈이 대체 뭔데?

=============

스프링 controller에서 쓰는 Model은 뭘까?

===============

안녕하세요! 강의 잘 보고 있습니다.

저도 이 질문글 올리신 분과 같은 에러가 발생했었습니다.

그리고 올려주신 코드를 그대로 복붙하니 제대로 동작하는데, 차이라고는 SpringDataJpaMemberRepository 인터페이스의 findByName 위에 @Override 어노테이션의 유무 뿐이었습니다.

오버라이드 어노테이션을 지우니 바로 정상적으로 동작하네요.

영상과 강의자료 pdf에서는 오버라이드가 달려있어도 정상적으로 동작하는 것 같던데 어떤 것 때문에 그럴까요...?