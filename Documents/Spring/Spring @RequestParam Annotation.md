백엔드 개발을 하는데 파이썬만으로는 한계가 있다고 여겨 얼마 전까지 자바 기초를 공부하다가 드디어 스프링까지 접하게 되었다. 이번에는 기존에 내가 하던 원리나 이론부터 알아가는게 아닌, 실전에서 먼저 부딪혀보고 그 이후에 차차 알아가려고 한다. 적어도 개발에서는 이게 더 효율적인 것 같다.


## 1. 개요

스프링에서 request를 Controller 안의 메소드에 @RequestMaping 어노테이션을 붙혀서 처리한다. @RequestParam을 사용하여 query 파라미터, form 파라미터 등을 request에서 추출하여 사용할 수 있다.


## 2. 간단한 예시

/list에 접속하면 책들의 전체 목록들을 보여주고, /list?keyword=example에서는 'example'이라는 키워드로 검색하여 리스트를 뽑아주는 프로그램이 있다고 하자.

'keyword' query 파라미터는 다음과 같이 처리할 수 있다. 이 때 파라미터 변수 이름은 query 파라미터의 이름과 동일해야 한다.

```java
@GetMapping("/list")
public String selectList(@RequestParam String keyword) {
    System.out.println("KEYWORD : " + keyword);
    return "book/list";
}
```

```
http://localhost:8080/book/list?keyword=test
--------------------------------------------------
KEYWORD : test
```

위 예제에서 @RequestParam 어노테이션을 사용하여 'keyword' query 파라미터를 추출해보았다. 다음은 이 어노테이션의 속성값들을 알아보자.

## 3. Attributes

### name(OR value)

위의 예시에서처럼 query 파라미터와 메소드의 매개변수 이름을 다르게 주고 싶은 경우에는 name 또는 value 값을 지정하여 사용할 수 있다.

```java
@GetMapping("/list")
public String selectList(@RequestParam(name = "keyword") String searchKeyword) {
    System.out.println("KEYWORD : " + searchKeyword);
    return "book/list";
}
```

또는 @RequestParam(value = "keyword"), @RequestParam("keyword")로 사용할 수도 있다.

### Optional 파라미터

query 파라미터 값이 있을 때도 있고 없을 때도 있는 경우도 있다. 예를 들어 /list 일 때는 전체 목록을 보여주고, /list?keyword=test 이면 키워드를 검색하여 매칭되는 리스트만 뽑아올 수 있다. 그러나 위의 코드를 그대로 사용하면 'Required request parameter 'keyword' for method parameter type String is not present'라는 메세지가 뜨면서 request를 처리하지 못한다.

두 가지 방법을 사용할 수 있다. 첫쨰는 'required' 속성값을 사용하는 것이다.

```java
@GetMapping("/list")
public String selectList(@RequestParam(name = "keyword", required = false) String searchKeyword) {
    System.out.println("KEYWORD : " + searchKeyword);
    return "book/list";
}
```

두 번째 방법으로 java8부터 지원하는 Optional을 사용할 수 있다.

```java
 @GetMapping("/list")
public String selectList(@RequestParam(value = "keyword") Optional<String> keyword, Model model) {
    if (keyword.isPresent()) {
        List<Book> books = bookService.findByKeyword(keyword.get());
        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword.get());
    } else {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
    }

    return "book/list";
}
```


### default 값

위에서처럼 파라미터가 들어오지 않았을 때 default 값을 설정할 수 있다.

```java
@GetMapping("/list")
public String selectList(@RequestParam(name = "keyword", default = "test") String searchKeyword) {
    System.out.println("KEYWORD : " + searchKeyword);
    return "book/list";
}
```

참고로 default 값을 설정해두면 내부적으로 required 값은 false가 된다.


## 4. 파라미터 Mapping

여러 개의 파라미터를 일일이 지정해주지 않고 한 번에 처리할 수 있다.

```java
@GetMapping("/list")
public String selectList(@RequestParam Map<String, String> allParams) {
    System.out.println("Parameters : " + allParams.entrySet());
    return "book/list";
}
```


## 5. multi parameter mpping

하나의 @RequestParam은 여러 개의 값을 가질 수 있다.

```java
@GetMapping("/list")
public String selectList(@RequestParam List<String> id) {
    System.out.println("IDs are : " + id);
    return "book/list";
}
```

```
http://localhost:8080/book/list?id=1,2,3
--------------------------------------------------
IDs are [1,2,3]
```


## 6. 마치며
처음에는 유용한 정보라 생각하면서 다른 블로그의 내용을 거의 베끼다시피 해서 번역했었는데, 막상 하고나니 그렇게 의미있는지는 잘 모르겠다. 차라리 핵심 내용만 요약하고 자세한건 링크를 첨부하는게 낫지 않았나 싶다.

앞으로 이런 것들의 타협점도 좀 찾아봐야겠다.


## 5. 참고
#### [Spring @RequestParam Annotation](https://www.baeldung.com/spring-request-param)