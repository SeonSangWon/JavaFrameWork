# [Spring Boot]롬복/Lombok   


## Lombok(롬복)이란?   

자바에서 클래스를 만들 때 불필요하게 반복되는 코드들을 자동으로 만들어주는 자바 라이브러리이다.   
보통 Entity 같은 클래스를 만들면 Getter/Setter/생성자로 이루어지는 경우가 대부분이다. 이런 반복적인   
코드를 한, 두줄의 어노테이션으로 자동으로 생성해준다.   



## Lombok 설치

### 1. Maven 또는 Gradle Dependency 추가   

 - Maven   
pom.xml의 <dependencies></dependencies> 태그 사이에 아래 코드를 추가한다.   

```
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.16.20</version>
	<scope>provided</scope>
</dependency>
```

```
package com.skcc.dtwiki.springsecuritysample.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "members")
public class Member {
	
}
```


> 예를 들어 위와 같이 @Getter/@Setter 어노테이션을 적용했는데 에러가 난다면 lombok을 제대로 인식하지 못한 것이다.
>    > 해결 방법
>    >    > lombok을 실행하여 이클립스 지정하고 설치하고 STS 껐다가 켠다.
>    >    > (cmd창에서 java -jar C:\Users\Administrator\.m2\repository\org\projectlombok\lombok\1.16.8\lombok-1.16.8.jar 와 같이 명령어 실행)   

그럼에도 @Getter/@Setter을 인식못할땐, pom.xml내 dependency 확인하고, 한번 프로젝트 우클릭 →   
Maven → Update Project 하면 된다.



 - Gradle   
build.gradle에 dependency 추가한다.   


Gradle v2.12 이전 버전   


```
dependencies {
	compileOnly 'org.projectlombok:lombok:1.18.2'
	
	apt 'org.projectlombok:lombok:1.18.2'
}
```
   
Gradle v2.12 이후 버전

```
dependencies {
	provided 'org.projectlombok:lombok:1.18.2'
}
```


## Lombok 적용

> 주로 사용하는 어노테이션
>    > @Getter/@Setter   
>    > @ToString   
>    > @EqualsAndHashCode   
>    > @NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor   
>    > @Data   
>    > @Value   
>    > @Builder   


### 접근자/설정자 자동 생성

관련 어노테이션: <span style="color:blue">@Getter/@Setter </span>   
Lombok에서 가장 많이 사용되는 어노테이션이다.


필드 레벨이 아닌 클래스 레벨에 @Getter 또는 @Setter를 선언해줄 경우, 모든 필드에 접근자와 설정자가 자동으로 생성해준다.   

```
package com.skcc.dtwiki.springsecuritysample.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "members")
public class Member {
	private String name;
}
```

### 생성자 자동 생성

관련 어노테이션: <span style="color:blue">@NoArgsConstructor/ @AllArgsConstructor /@RequiredArgsConstructor </span>   
Lombok을 사용하면 생성자도 자동으로 생성할 수 있다.   

<div>
	<table>
		<tr>
			<td align="center" width="80">Anotation</td><td align="center" width="170">설명</td>
		</tr>
		<tr>
			<td>@NoArgsConstructor</td>
			<td>파라미터가 없는 기본 생성자를 생성한다.</td>
		</tr>
		<tr>
			<td>@AllArgsConstructor</td>
			<td>모든 필드 값을 파라미터로 받는 생성자를 만든다.</td>
		</tr>
		<tr>
			<td>@RequiredArgsConstructor</td>
			<td>final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만든다.</td>
		</tr>
	</table>
</div>


### ToString 메소드 자동 생성

관련 어노테이션: @ToString   
Lombok을 사용하면 @ToString 어노테이션만 클래스에 붙여주면 toString() 메소드를 자동으로 생성해준다.   
예제와 같이 exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외시킬 수도 있다고 한다.

```
@ToString(exclude = "password")
public class User {
  private Long id;
  private String username;
  private String password;
  private int[] scores;
}
```

위와 같이 클래스에 @ToString 어노테이션을 붙이고, 아래와 같이 필드를 세팅 후 출력을 하면,   

```
User user = new User();
user.setId(1L);
user.setUsername("dale");
user.setUsername("1234");
user.setScores(new int[]{80, 70, 100});

System.out.println(user);
```

다음과 같이, 클래스명(필드1명=필드1값,필드2명=필드2값,...) 식으로 출력된다.   

```
User(id=1, username=1234, scores=[80, 70, 100])
```

(Lombok을 사용하기 전에는 Apache Commons Lang 라이브러리의 ToStringBuilder를 사용)


### equals, hashCode 자동 생성

관련 어노테이션: @EqualsAndHashCode   
자바 빈을 만들 때 equals와 hashCode 메소드를 자주 오버라이딩 한다. @EqualsAndHashCode 어노테이션을 사용하면 자동으로   
이 메소드를 생성할 수 있다.   

```
@EqualsAndHashCode(callSuper = true)
public class User extends Domain {
  private String username;
  private String password;
}
```

callSuper 속성을 통해 equals와 hashCode 메소드 자동 생성 시 부모 클래스의 필드까지 감안할지 안 할지에 대해서 설정할 수 있다.   
즉, callSuper = true로 설정하면 부모 클래스 필드 값들도 동일한지 체크하며, callSuper = false로 설정(기본값)하면   
자신 클래스의 필드 값들만 고려한다.   

```
User user1 = new User();
user1.setId(1L);
user1.setUsername("user");
user1.setPassword("pass");

User user2 = new User();
user1.setId(2L); // 부모 클래스의 필드가 다름
user2.setUsername("user");
user2.setPassword("pass");

user1.equals(user2);
// callSuper = true 이면 false, callSuper = false 이면 true
```


### 한번에 설정하고 싶다면, @Data

관련 어노테이션: @Data   
@Data는 @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정해주는 매우 유용한 어노테이션이다.   

> @Data를 쓰면 해주는 기능
>    > 모든 필드를 대상으로 접근자(getter) 생성   
>    > final 선언이 되지 않은 필드에 설정자(setter) 자동으로 생성   
>    > final 또는 @NonNull 필드 값을 파라미터로 받는 생성자가 만들어지며   
>    > toString, equals, hashCode 메소드가 자동으로 생성됨


### 자동 null 체크 하려면,  @NonNull

관련 어노테이션: @NonNull   
변수에 @NonNull 를 붙이면 해당 변수가 null로 넘어온 경우, NullPointerException 예외 발생한다.   


### 빌더를 쉽게 사용하려면, @Builder

관련 어노테이션: @Builder   
다수의 필드를 가지는 복잡한 클래스의 경우, 생성자 대신에 빌더를 사용하는 경우가 많다.   
빌더 패턴을 직접 작성해보면 코딩량이 의외로 상당하다고 한다.   
이때, @Builder 어노테이션을 사용하면 자동으로 해당 클래스에 빌더를 추가해주기 때문에 매우 편리하다.   

```
@Builder
public class Member {
	private Long id;
	private String name;
	@Singular
	private List<Integer> score;
}
```

위와 같이 선언하고 사용할 때는 아래와 같이 사용하면 된다.   

```
Member member = Member.builder()
	.id(10000)
	.name("myname")
	.score(10)
	.score(20)
	.score(30)
	.build();
//Member(id=1, name=myname, score=[10,20,30])
```

컬렉션으로 된 필드에는 @Singular 어노테이션을 선언해주면 모든 원소를 한 번에 넘기지 않고 원소를 하나씩 추가할 수 있다.   

[source](https://m.blog.naver.com/PostView.nhn?blogId=ithink3366&logNo=221362246096&categoryNo=27&proxyReferer=https:%2F%2Fwww.google.com%2F)
