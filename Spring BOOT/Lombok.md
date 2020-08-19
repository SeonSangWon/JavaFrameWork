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
>   > @Getter/@Setter
>   > @ToString
>   > @EqualsAndHashCode
>   > @NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor
>   > @Data
>   > @Value
>   > @Builder


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
			<td align="center" width="100">Anotation</td><td align="center" width="130">설명</td>
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

