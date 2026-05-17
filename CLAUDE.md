# Role

당신은 시니어 소프트웨어 엔지니어입니다.

---

# 사전 확인 (작업 시작 전 필수)

모든 작업 시작 전, 아래 문서를 반드시 읽고 맥락을 파악한 뒤 진행하세요.

| 문서 | 경로 |
|------|------|
| 화면 설계서 | `docs/plan/pages/` |
| IA | `docs/plan/IA.md` |
| 사용자 시나리오 | `docs/plan/scenario.md` |
| API 명세 | `docs/api/` |

---

# 작업 규칙

## Plan 단계

1. 항상 Plan Mode로 시작하세요.
2. 작업을 기능 단위로 나누고 전체 작업 범위를 정의하세요.
3. 작업 범위를 간단히 브리핑한 뒤, 확인을 받으세요.
4. 승인 전에는 구현을 시작하지 마세요.

## 작업 진행

5. 기능 단위로 작업하세요.
6. 각 작업 완료 후 반드시 멈추세요.
7. 다음 단계 진행 전 확인을 받으세요.

## 표준 작업 흐름

모든 작업은 다음 순서로 진행합니다.

1. 새 이슈 생성 (`[TYPE]` 형식, 이슈 템플릿 기반)
2. 브랜치 생성: `type/#{issueNum}/{domain}`
3. 기능 구현
4. 커밋: `type(#{issueNum}/{domain}): 작업 내용`
5. PR 생성 (reviewer 지정, PR 템플릿 기반)
6. 머지 후 로컬 브랜치 정리

### 예시: EC2 배포 스크립트 추가

1. `[CHORE]` 이슈 생성
2. 브랜치: `chore/#{issueNum}/global`
3. `scripts/deploy.sh` 생성 + `chmod +x scripts/deploy.sh`
4. 커밋: `chore(#{issueNum}/global): EC2 배포 스크립트 추가`
5. PR 생성 (reviewer: aneykrap)

## 커밋 규칙

8. 커밋 생성 전, 변경 요약을 먼저 제시하고 승인을 받으세요.
9. 승인 후에만 커밋하세요.
10. 커밋 메시지에 `Co-Authored-By` 를 포함하지 마세요.

## 출력 규칙

- 항상 구조화된 형식으로 작성하세요.
- 불필요한 설명은 생략하세요.
- 실행 가능한 수준으로 명확하게 작성하세요.

---

# 패키지 구조

베이스 패키지: `src/main/java/com/example/naver`

```
src/main/java/{base-package}
├── global
│   ├── config
│   │   └── ...
│   │
│   ├── entity
│   │   └── BaseEntity.java
│   │
│   ├── response
│   │   ├── ApiResponseBody.java
│   │   ├── SuccessCode.java
│   │   └── ErrorMeta.java
│   │
│   ├── exception
│   │   ├── BusinessException.java
│   │   ├── GlobalExceptionHandler.java
│   │   └── ErrorCode.java
│   │
│   └── util
│       └── ...
│
└── domain
    └── {domain-name}
        ├── controller
        │   └── ...
        │
        ├── service
        │   └── ...
        │
        ├── repository
        │   └── ...
        │
        ├── entity
        │   └── ...
        │
        └── exception
            ├── {Domain}Exception.java
            └── {Domain}ErrorCode.java
```

---

# 클래스 멤버 선언 순서

1. 상수 (`static final`)
2. `static` 변수
3. 인스턴스 변수
4. 생성자
5. `public` 메서드 (getter/setter는 `public` 메서드 모두 작성 후 마지막에)
6. `protected` 메서드
7. package-private 메서드
8. `private` 메서드
9. nested 클래스/인터페이스

---

# API URL 설계 규칙

1. 리소스명은 **복수형**으로 작성
2. 리소스명은 **kebab-case**로 작성
3. path variable 변수명은 **camelCase**로 작성
4. 불필요한 상위 리소스를 포함하지 않도록 최소한의 경로로 설계
5. 리소스 위치 특정 → **path variable** 사용
6. 리소스 필터링/검색 → **query string** 사용

---

# Branch Convention

브랜치 형식:

```
type/#issueNum/{domain}
```

### Type

| type | 설명 |
|------|------|
| feat | 새로운 기능 추가 |
| fix | 버그 수정 |
| refactor | 기능 변경 없는 구조 개선 |
| docs | 문서, Swagger 수정 |
| test | 테스트 추가 또는 수정 |
| chore | 설정, 패키지 구조, 빌드 작업 |

### Domain

| domain | 대상 |
|--------|------|
| home | 홈 화면 |
| product | 상품 상세 |
| cart | 장바구니 |
| payment | 결제 |
| global | 공통 |

---

# Commit Convention

커밋 형식:

```
type(#issueNum/domain): 작업 내용
```

### Subject

커밋 목록만 보아도 어떤 이슈에서 어떤 도메인의 어떤 작업을 했는지 알 수 있게 작성한다.

### Body

- 필요한 경우에만 작성한다.
- 한 줄당 72자 이내로 작성한다.
- 어떻게 변경했는지보다 **무엇을**, **왜** 변경했는지를 설명한다.
