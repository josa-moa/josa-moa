# 조사모아(josa-moa) 한국어 조사 처리 프로젝트
```html
<!-- repository 추가 -->
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<!-- 의존성 추가 -->
<dependency>
  <groupId>com.github.josa-moa</groupId>
  <artifactId>josa-moa</artifactId>
  <version>1.0.2</version>
</dependency>
```
# 조사모아(josa-moa)란?
> ### 문자열의 종성의 받침에 따라 조사를 붙여주는 *__한국어 조사 처리 라이브러리__*
> ###### * setJosamoa는 받침이 있는 경우 앞 글자를, 받침이 없는 경우 뒷 글자를 반환합니다.
<br>

### - 한글 조사 처리
```java
Josamoa josamoa = new Josamoa();

josamoa.setJosa("영철", "은는"); // 영철은    
josamoa.setJosa("철수", "은는"); // 철수는

josamoa.setJosa("장갑", "을를"); // 장갑을    
josamoa.setJosa("모자", "을를"); // 모자를
```
### - 숫자 조사 처리
```java
// 0 1 2 3 4 5 6 7 8 9 (영 일 이 삼 사 오 육 칠 팔 구)
josamoa.setJosa("사람1", "은는"); // 사람1은 > 사람일은
josamoa.setJosa("사람3", "은는"); // 사람3은 > 사람삼은

josamoa.setJosa("사람2", "은는"); // 사람2는 > 사람이는
josamoa.setJosa("사람4", "은는"); // 사람4는 > 사람사는
```
### - 영문자 조사 처리
```java
// 글자 길이가 3 미만일 경우 한 글자 씩 읽는다.
josamoa.setJosa("L", "은는");  // 엘은
josamoa.setJosa("ai", "은는"); // 에이아이는

// b와 c는 앞문자가 모음일 경우 받침을 갖는다.
josamoa.setJosa("lib", "은는");   // lib은 > 립은
josamoa.setJosa("basic", "은는"); // basic은 > 베이직은

// p는 앞문자가 받침문자(l, m, n)가 아닐 경우 받침을 갖는다.
josamoa.setJosa("cap", "은는");   // cap은 > 캡은
josamoa.setJosa("help", "은는");  // help는 > 헬프는

// e는 앞문자가 받침문자(l, m, n)일 경우 받침을 갖는다.
josamoa.setJosa("smile", "은는"); // smile은 > 스마일은
josamoa.setJosa("juice", "은는"); // help는 > 헬프는

// k는 앞문자가 'c'인 경우 받침을 갖는다.
josamoa.setJosa("kick", "은는");  // kick은 > 킥은

// g는 앞문자가 'n'인 경우 받침을 갖는다.
josamoa.setJosa("long", "은는");  // long은 > 롱은
```
### - 특수문자 조사 처리
```java
// ! ? , . ~ ' " ; : { } [ ] ( ) < > 는 무시
josamoa.setJosa("조사!", "은는");  // 조사!는 > 조사는
josamoa.setJosa("모양?", "은는");  // 모양?은 > 모양은

// @ # % & * 등은 받침없음으로 처리
josamoa.setJosa("이@@", "은는");  // 이@@는
josamoa.setJosa("인★", "은는");  // 인★는
```

# 조사모아(josa-moa) 패치노트
## 1.0.2
메서드 setJosa 생성 - 한글, 영문자, 특수문자 조사 처리 완료
## 1.0.1
설정 추가 - JUnit4 추가
<br><br>

# 조사모아 로고(josa-moa logo)
<img src=https://user-images.githubusercontent.com/113405581/191260453-19912840-bee8-4e9c-a948-6a7723d2bd43.jpg width="300"> <img src=https://user-images.githubusercontent.com/113405581/191261422-63219ccd-fa14-4ee5-825a-3dc0e286a625.jpg width="300">
