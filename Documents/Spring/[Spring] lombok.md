#### [사용 방법](https://dev-coco.tistory.com/86)
#### [주의 사항](https://www.popit.kr/%EC%8B%A4%EB%AC%B4%EC%97%90%EC%84%9C-lombok-%EC%82%AC%EC%9A%A9%EB%B2%95/)

## lombok 이란?
- Lombok은 Java 기반에서 기계적으로 작성하는 VO, DTO, Entity 관련 작업을 쉽게 할 수 있게 해주는 라이브러리
- Getter, Setter, ToString, hashCode 등의 메소드들을 간편하게 사용할 수 있게 해줌
- Spring 프로젝트에서 사용할 경우 JPA 환경과 함께 일관화 되고 가독성이 좋은 어플리케이션을 작성할 수 있음

### @Getter @Setter
- 가장 많이 사용되는 어노테이션
- 자동으로 getter 메소드와 setter 메소드를 생성해주는 어노테이션

```java
import lombok.Getter;
import lombok.Setter;
 
@Getter @Setter
public class Student {
    private int studentNum;
    private String name;
    private int age;
}
```

### @NoArgsConstructor , @AllArgsConstructor , @RequiredArgsConstructor
- @NoArgsConstructor : 기본 생성자를 만들어주는 어노테이션
- @AllArgsConstructor : 모든 필드 값을 사용하는 생성자를 만들어주는 어노테이션
- @RequiredArgsConstructor : final 이나 @NonNull 인 필드 값만 파라미터로 받는 생성자를 만들어주는 어노테이션

```java
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
 
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    private int studentNum;
    private String name;
    private int age;
}
```

### @EqualsAndHashCode
- 클래스에 대한 equals 함수와 hashCode 함수를 자동으로 생성

```java
import lombok.EqualsAndHashCode;
 
@EqualsAndHashCode
public class Student {
    private int studentNum;
    private String name;
    private int age;
}
```

### @ToString
- 클래스의 변수들을 기반으로 ToString 메소드를 자동으로 완성시켜줌
- 출력을 원하지 않는 변수가 있다면 해당 변수에 @ToString.Exclude 을 붙여주면 제외할 수 있음

```java
import lombok.ToString;
 
@ToString(exclude = "age")
public class Student {
    private int studentNum;
    private String name;
    private int age;
}
```