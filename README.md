# N배송 서버

네이버 플러스 스토어 N배송 서비스의 백엔드 API 서버입니다.

---

## 기술 스택

| 분류 | 기술 |
|------|------|
| Language | Java 21 |
| Framework | Spring Boot 4.0.6 |
| Build | Gradle 9.4.1 (Kotlin DSL) |

---

## 패키지 구조

```
src/main/java/com/example/naver
├── global
│   ├── config        # 설정
│   ├── exception     # 공통 예외 처리
│   ├── response      # 공통 응답 객체
│   └── persistence   # 공통 엔티티
│
└── domain
    ├── home          # 홈
    ├── product       # 상품
    ├── cart          # 장바구니
    ├── payment       # 결제
    ├── delivery      # 배송
    ├── coupon        # 쿠폰
    └── user          # 사용자
```

---

## 로컬 실행

```bash
./gradlew bootRun
```

---

## 브랜치 전략

```
type/#issueNum/domain
```

| type | 설명 |
|------|------|
| feat | 새로운 기능 추가 |
| fix | 버그 수정 |
| refactor | 기능 변경 없는 구조 개선 |
| docs | 문서, Swagger 수정 |
| test | 테스트 추가 또는 수정 |
| chore | 설정, 패키지 구조, 빌드 작업 |

---

## 커밋 컨벤션

```
type(#issueNum/domain): 작업 내용
```

예시:

```
feat(#12/home): 홈 화면 응답 API 구현
fix(#15/payment): 보유 포인트 초과 사용 검증
```
