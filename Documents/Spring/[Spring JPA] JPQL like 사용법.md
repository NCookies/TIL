## 1. 개요

JPA는 Java Persistence API의 약자로, 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스이다. 이를 구현해둔 것이 Hibernate이고, 이걸 스프링에서 편하게 쓸 수 있도록 한게 Spring Data JPA이다.

스프링에 대한 감을 잡기 위해서 [스프링 MVC 하루만에 배우기](https://wikidocs.net/book/5792)을 보면서 코드를 따라서 쳐보았다. 이 프로젝트에서는 maven과 jdbc를 사용했는데 나는 gradle과 JPA를 사용하고 싶어 상황에 맞게 변환하였다. 

그 중 keyword에 해당하는 데이터를 검색하는 기능이 있었는데, Spring data JPA는 많았어도, RAW JPA 자료는 거의 없어서 애를 먹었었다.


## 2. TypedQuery

EntityManager 자체적으로는 keyword 검색 메소드가 없었기 때문에 직접 쿼리문을 작성해야 했다. 

TypedQuery는 EntityManager 객체에서 createQuery() 메소드를 호출하면 생성되는 쿼리의 엔티티가 정해져 있을 때 사용하는 타입이다.


## 3. 쿼리문

query 문법은 여타 sql과 별반 다른 내용이 없다. 다만 select from 뒤에 나오는 객체는 엔티티의 이름이며(@Entity 어노테이션을 달아준 클래스), as를 생략하여 별칭을 붙일 수 있다.

```
select m from Book m where m.title like concat('%', :keyword, '%')
```

위 query를 설명해보자면, 내가 선언한 Book 엔티티의 별칭을 m으로 설정하였고, m에서 모든 데이터를 조회하도록 하였다. 그리고 조건으로 title에 keyword가 포함되는 데이터라고 설정하였다.

%는 LIKE 연산자에서 사용하는 패턴 기호로, 모든 문자를 의미하는 % 외에 한 글자를 의미하는 _ 도 있다.
'%패턴'은 앞에 어떤 문자가 오던 끝에 '패턴'이라는 단어로 끝나는 경우,
'패턴%'은 뒤에 어떤 문자가 오던 시작 부분에 '패턴'이라는 단어로 시작하는 경우,
'%패턴%'은 '패턴'이라는 단어가 포함된 모든 경우를 의미한다.

:keyword에서 ':'는 keyword 파라미터값을 사용한다는 의미이다. 자세한건 뒤에서 설명한다.


## 4. 사용

```java
public List<Book> findByKeyword(String keyword) {
    TypedQuery<Book> query = em.createQuery("select m from Book m where m.title like concat('%', :keyword, '%')" +
            "or m.category like concat('%', :keyword, '%')", Book.class);
    query.setParameter("keyword", keyword);

    return query.getResultList();
}
```

쿼리문은 위에서 설명한 내용에서 조건만 추가한 것이다. title과 category 중 'keyword'를 포함한 단어가 있다면 조회하도록.

그리고 setParameter를 사용하여 쿼리문 내의 keyword 파라미터 값을 설정해주었다. 이 예제에서는 코드를 따로 분리해두었는데 사실 체인 형식으로 한 번에 작성할 수도 있다. 자세한 내용은 참고 링크에서 볼 수 있다.

```java
public List<Book> findByKeyword(String keyword) {
    return em.createQuery("select m from Book m where m.title like concat('%', :keyword, '%')"
        + " or m.category like concat('%', :keyword, '%')", Book.class)
        .setParameter("keyword", keyword)
        .getResultList();
    }
```


## 5. 참고
[JPA, Hibernate, 그리고 Spring Data JPA의 차이점](https://suhwan.dev/2019/02/24/jpa-vs-hibernate-vs-spring-data-jpa/)
[[Spring JPA] JPQL ( Java Persistence Query Language )](https://victorydntmd.tistory.com/m/205)
