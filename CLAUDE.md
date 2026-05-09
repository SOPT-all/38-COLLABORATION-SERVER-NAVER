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
com.example.naver
├── global
│   ├── config        # 설정 (WebClient 등)
│   ├── exception     # 공통 예외 처리 (GlobalExceptionHandler, ErrorCode, ErrorResponse)
│   ├── response      # 공통 응답 객체 (ApiResponse)
│   └── persistence   # 공통 엔티티 (BaseEntity)
│
└── domain
    ├── home
    ├── product
    ├── cart
    ├── payment
    ├── delivery
    ├── coupon
    └── user
```

각 도메인의 내부 구조는 아래 패턴을 기본으로 합니다.

```
{domain}
├── controller
├── service
├── repository   # 필요한 경우
├── entity       # 필요한 경우
├── dto
│   ├── request
│   └── response
└── exception
```

---

# Branch Convention

브랜치 형식:

```
type/#issueNum-{domain}
```

예시:
```
feat/#12/home
feat/#13/product
feat/#14/cart
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
| product | 상품 |
| cart | 장바구니 |
| payment | 결제 |
| delivery | 배송 |
| coupon | 쿠폰 |
| user | 사용자 |
| global | 공통 |

---

# Commit Convention

커밋 형식:

```
type(#issueNum/domain): 작업 내용
```

### Subject

커밋 목록만 보아도 어떤 이슈에서 어떤 도메인의 어떤 작업을 했는지 알 수 있게 작성한다.

좋은 예시:
```
feat(#12/home): 홈 화면 응답 API 구현
feat(#13/product): 상품 상세 조회 API 구현
feat(#14/cart): 장바구니 상품 수량 변경 구현
fix(#15/payment): 보유 포인트 초과 사용 검증
refactor(#16/product): 상품 가격 응답 DTO 분리
docs(#17/swagger): 상품 상세 API 문서 추가
chore(#18/global): 공통 응답 객체 추가
```

### Body

- 필요한 경우에만 작성한다.
- 한 줄당 72자 이내로 작성한다.
- 어떻게 변경했는지보다 **무엇을**, **왜** 변경했는지를 설명한다.
