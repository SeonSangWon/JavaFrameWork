#[Spring Boot]롬복/Lombok   


## Lombok(롬복)이란?   

자바에서 클래스를 만들 때 불필요하게 반복되는 코드들을 자동으로 만들어주는 자바 라이브러리이다.   
보통 Entity 같은 클래스를 만들면 Getter/Setter/생성자로 이루어지는 경우가 대부분이다. 이런 반복적인   
코드를 한, 두줄의 어노테이션으로 자동으로 생성해준다.   



## Lombok 설치

### 1. Maven 또는 Gradle Dependency 추가   

 - Maven   
pom.xml의 <dependencies></dependencies> 태그 사이에 아래 코드를 추가한다.   

<pre><code>
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.16.20</version>
	<scope>provided</scope>
</dependency>
</code></pre>


<pre><code>
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
</code></pre>


> 예를 들어 위와 같이 @Getter/@Setter 어노테이션을 적용했는데 에러가 난다면 lombok을 제대로 인식하지 못한 것이다.
>    > 해결 방법
>    >    > lombok을 실행하여 이클립스 지정하고 설치하고 STS 껐다가 켠다.
>    >    > (cmd창에서 java -jar C:\Users\Administrator\.m2\repository\org\projectlombok\
>    >    > lombok\1.16.8\lombok-1.16.8.jar 와 같이 명령어 실행)   

그럼에도 @Getter/@Setter을 인식못할땐, pom.xml내 dependency 확인하고, 한번 프로젝트 우클릭 →   
Maven → Update Project 하면 된다.
