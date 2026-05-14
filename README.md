# 38-COLLABORATION-SERVER-NAVER

### LETS SOPT 38기 합동 세미나 모바일 웹 2조 네이버 💚 🏪 🇳 🚚

<br />

## 🚀 Project Introduce

<img width="1118" height="774" alt="Image" src="https://github.com/user-attachments/assets/ee0a76d5-22dc-45dd-8e46-a066707243c9" />
<img width="1114" height="626" alt="Image" src="https://github.com/user-attachments/assets/07086dfb-33f3-4ff5-b40f-38053954532c" />
<img width="1100" height="628" alt="Image" src="https://github.com/user-attachments/assets/bae62575-40f2-45e6-ae48-2c4bef7a31c9" />
<img width="1106" height="616" alt="Image" src="https://github.com/user-attachments/assets/6334e601-a784-41ae-8ea4-bef327344029" />

<br />

## 👥 팀 소개

<table align="center">
  <tr>
    <td align="center" width="200">
      <a href="https://github.com/jsshin8128">
        <img width="200" height="200" src="https://github.com/jsshin8128.png" alt="신진수"/>
      </a>
      <br />
      <a href="https://github.com/jsshin8128"><strong>신진수</strong></a>
    </td>
    <td align="center" width="200">
      <a href="https://github.com/aneykrap">
        <img width="200" height="200" src="https://github.com/aneykrap.png" alt="박예나"/>
      </a>
      <br />
      <a href="https://github.com/aneykrap"><strong>박예나</strong></a>
    </td>
  </tr>
</table>

<br />

<br />

## 🛠️ Tech Stack

| Category      | Stack                                                                                                                                                                                                                                                                                                                                                                                       |
|---------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Language      | ![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)                                                                                                                                                                                                                                                                                      |
| Framework     | ![Spring Boot](https://img.shields.io/badge/Spring_Boot_4.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)                                                                                                                                                                                                                                                                    |
| ORM           | ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)                                                                                                                                                                                                                                                                    |
| Database      | ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![H2](https://img.shields.io/badge/H2_(Test)-09AFE5?style=for-the-badge&logoColor=white)                                                                                                                                                                                                |
| Build         | ![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)                                                                                                                                                                                                                                                                                      |
| Library       | ![Lombok](https://img.shields.io/badge/Lombok-BC4521?style=for-the-badge&logoColor=white)                                                                                                                                                                                                                                                                                                  |
| API Docs      | ![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)                                                                                                                                                                                                                                                                                   |
| Infra         | ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white) ![AWS EC2](https://img.shields.io/badge/AWS_EC2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white)                                                                                                                                                                           |
| Version Control | ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)                                                                                                                                                                                        |

<br />

<br />

## 🌿 Git Convention

### 브랜치 전략

**Format**: `type/#issueNum/{domain}`

| type       | 설명                       |
|------------|--------------------------|
| `feat`     | 새로운 기능 추가               |
| `fix`      | 버그 수정                    |
| `refactor` | 기능 변경 없는 구조 개선          |
| `docs`     | 문서, Swagger 수정           |
| `test`     | 테스트 추가 또는 수정            |
| `chore`    | 설정, 패키지 구조, 빌드 작업       |

| domain    | 대상      |
|-----------|---------|
| `home`    | 홈 화면    |
| `product` | 상품 상세   |
| `cart`    | 장바구니    |
| `payment` | 결제      |
| `global`  | 공통      |

<br />

### 커밋 메시지 컨벤션

**Format**: `type(#issueNum/domain): 작업 내용`

예시: `feat(#12/home): 카테고리 조회 API 구현`

<br />

<br />

## 💻 Coding Convention

### 1. 패키지 구조

베이스 패키지: `src/main/java/com/sopt/collaboration`

```
src/main/java/{base-package}
├── global
│   ├── config
│   ├── entity          # BaseEntity
│   ├── response        # ApiResponseBody, SuccessCode, ErrorMeta
│   ├── exception       # BusinessException, GlobalExceptionHandler, ErrorCode
│   └── util
│
└── domain
    └── {domain-name}
        ├── controller
        ├── service
        ├── repository
        ├── entity
        └── exception   # {Domain}Exception, {Domain}ErrorCode
```

<br />

### 2. 클래스 멤버 선언 순서

| 순서 | 대상 |
|------|------|
| 1 | 상수 (`static final`) |
| 2 | `static` 변수 |
| 3 | 인스턴스 변수 |
| 4 | 생성자 |
| 5 | `public` 메서드 (getter/setter는 마지막) |
| 6 | `protected` 메서드 |
| 7 | package-private 메서드 |
| 8 | `private` 메서드 |
| 9 | nested 클래스/인터페이스 |

<br />

### 3. API URL 설계 규칙

- 리소스명은 **복수형**으로 작성 (예: `/products`, `/categories`)
- 리소스명은 **kebab-case**로 작성 (예: `/promotion-items`)
- path variable 변수명은 **camelCase**로 작성 (예: `/{productId}`)
- 불필요한 상위 리소스를 포함하지 않도록 최소한의 경로로 설계
- 리소스 위치 특정 → **path variable** 사용
- 리소스 필터링/검색 → **query string** 사용