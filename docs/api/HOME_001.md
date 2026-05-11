# HOME_001 홈 API 명세

---

## API 1. 관심사 비슷한 아이템 조회

사용자의 관심사와 연관도가 높은 내일배송 상품을 개인화 추천하여 반환한다.

**GET** `/api/home/recommendations`

### Path Parameter

(없음)

### Query Parameter

(없음)

### Request Header

(없음)

### Request Body

(없음)

### Request Example

```
GET /api/home/recommendations
```

### Response Body

| Name | Type | Required | Description | Example |
|------|------|----------|-------------|---------|
| success | Boolean | Y | 요청 성공 여부 | `true` |
| status | Integer | Y | HTTP 상태 코드 | `200` |
| message | String | Y | 응답 메시지 | `"요청이 성공했습니다."` |
| data | Object | Y | 응답 데이터 | - |
| data.title | String | Y | 사용자 닉네임이 포함된 섹션 소제목. "[닉네임]님의 최근 관심사와 비슷한 아이템" 형식 | `"홍길동님의 최근 관심사와 비슷한 아이템"` |
| data.items | Array | Y | 추천 상품 목록 | - |
| data.items[].itemId | Long | Y | 상품 ID | `10023` |
| data.items[].name | String | Y | 상품명 | `"생크림 과일 모찌 참쌀 떡 딸기 모찌"` |
| data.items[].imageUrl | String | Y | 상품 이미지 URL | `"https://..."` |
| data.items[].originalPrice | Integer | Y | 정가 | `15900` |
| data.items[].discountRate | Integer | Y | 할인율 (없으면 0) | `25` |
| data.items[].discountedPrice | Integer | Y | 할인가 | `11780` |
| data.items[].isTomorrowDelivery | Boolean | Y | 내일배송 여부 | `true` |

### Success Response Example

**200 OK**

```json
{
  "success": true,
  "status": 200,
  "message": "요청이 성공했습니다.",
  "data": {
    "title": "홍길동님의 최근 관심사와 비슷한 아이템",
    "items": [
      {
        "itemId": 10023,
        "name": "생크림 과일 모찌 참쌀 떡 딸기 모찌",
        "imageUrl": "https://example.com/images/item/10023.jpg",
        "originalPrice": 15900,
        "discountRate": 25,
        "discountedPrice": 11780,
        "isTomorrowDelivery": true
      },
      {
        "itemId": 10024,
        "name": "넵담 두바이 쭌득 쿠키 4개 두쭌쿠 카다이프",
        "imageUrl": "https://example.com/images/item/10024.jpg",
        "originalPrice": 42700,
        "discountRate": 45,
        "discountedPrice": 23460,
        "isTomorrowDelivery": true
      },
      {
        "itemId": 10025,
        "name": "오뚜기 참쌀 숙 호떡 믹스 300G 5개",
        "imageUrl": "https://example.com/images/item/10025.jpg",
        "originalPrice": 24300,
        "discountRate": 8,
        "discountedPrice": 22900,
        "isTomorrowDelivery": true
      }
    ]
  }
}
```

### Error Response Example

**500 Internal Server Error**

```json
{
  "success": false,
  "status": 500,
  "message": "서버 내부 오류가 발생했습니다.",
  "code": "COM_500_001",
  "meta": {
    "path": "/api/home/recommendations",
    "timestamp": 1746835200000
  }
}
```

---

## API 2. 카테고리 조회

홈 화면에 노출할 카테고리 목록을 반환한다. 기본 상위 10개, 전체 요청 시 25개를 반환한다.

**GET** `/api/home/categories`

### Path Parameter

(없음)

### Query Parameter

| Name | Type | Required | Description | Example |
|------|------|----------|-------------|---------|
| expand | Boolean | N | `true` 시 전체 25개 카테고리 반환, `false` 또는 미입력 시 상위 10개 반환 | `true` |

### Request Header

(없음)

### Request Body

(없음)

### Request Example

```
GET /api/home/categories?expand=false
```

### Response Body

| Name | Type | Required | Description | Example |
|------|------|----------|-------------|---------|
| success | Boolean | Y | 요청 성공 여부 | `true` |
| status | Integer | Y | HTTP 상태 코드 | `200` |
| message | String | Y | 응답 메시지 | `"요청이 성공했습니다."` |
| data | Object | Y | 응답 데이터 | - |
| data.categories | Array | Y | 카테고리 목록 | - |
| data.categories[].categoryId | Long | Y | 카테고리 ID | `1` |
| data.categories[].name | String | Y | 카테고리명 | `"행사"` |
| data.categories[].iconUrl | String | Y | 카테고리 아이콘 이미지 URL | `"https://..."` |
| data.totalCount | Integer | Y | 반환된 카테고리 수 | `10` |
| data.isExpanded | Boolean | Y | 전체 카테고리 노출 여부 | `false` |

### Success Response Example

**200 OK**

```json
{
  "success": true,
  "status": 200,
  "message": "요청이 성공했습니다.",
  "data": {
    "categories": [
      {
        "categoryId": 1,
        "name": "행사",
        "iconUrl": "https://example.com/icons/category/1.png"
      },
      {
        "categoryId": 2,
        "name": "새벽배송",
        "iconUrl": "https://example.com/icons/category/2.png"
      },
      {
        "categoryId": 3,
        "name": "간편조리/밀키트",
        "iconUrl": "https://example.com/icons/category/3.png"
      },
      {
        "categoryId": 4,
        "name": "음료/커피/전통주",
        "iconUrl": "https://example.com/icons/category/4.png"
      },
      {
        "categoryId": 5,
        "name": "스낵/빵/떡",
        "iconUrl": "https://example.com/icons/category/5.png"
      },
      {
        "categoryId": 6,
        "name": "세제/세정제",
        "iconUrl": "https://example.com/icons/category/6.png"
      },
      {
        "categoryId": 7,
        "name": "화장지/물티슈",
        "iconUrl": "https://example.com/icons/category/7.png"
      },
      {
        "categoryId": 8,
        "name": "건강/다이어트",
        "iconUrl": "https://example.com/icons/category/8.png"
      },
      {
        "categoryId": 9,
        "name": "생활/주방",
        "iconUrl": "https://example.com/icons/category/9.png"
      },
      {
        "categoryId": 10,
        "name": "라면/면",
        "iconUrl": "https://example.com/icons/category/10.png"
      }
    ],
    "totalCount": 10,
    "isExpanded": false
  }
}
```

### Error Response Example

**400 Bad Request**

```json
{
  "success": false,
  "status": 400,
  "message": "expand 파라미터 값이 유효하지 않습니다.",
  "code": "HOM_400_001",
  "meta": {
    "path": "/api/home/categories",
    "timestamp": 1746835200000
  }
}
```

**500 Internal Server Error**

```json
{
  "success": false,
  "status": 500,
  "message": "서버 내부 오류가 발생했습니다.",
  "code": "COM_500_001",
  "meta": {
    "path": "/api/home/categories",
    "timestamp": 1746835200000
  }
}
```

---

## API 3. 프로모션 조회

홈 화면 타임딜 섹션에 노출할 시간 제한 특가 프로모션 목록을 반환한다. 카운트다운 종료 시각 및 프로모션 태그를 포함한다.

**GET** `/api/home/promotions`

### Path Parameter

(없음)

### Query Parameter

(없음)

### Request Header

(없음)

### Request Body

(없음)

### Request Example

```
GET /api/home/promotions
```

### Response Body

| Name | Type | Required | Description | Example |
|------|------|----------|-------------|---------|
| success | Boolean | Y | 요청 성공 여부 | `true` |
| status | Integer | Y | HTTP 상태 코드 | `200` |
| message | String | Y | 응답 메시지 | `"요청이 성공했습니다."` |
| data | Object | Y | 응답 데이터 | - |
| data.promotions | Array | Y | 프로모션 목록 | - |
| data.promotions[].promotionId | Long | Y | 프로모션 ID | `301` |
| data.promotions[].tag | String | Y | 프로모션 태그명 | `"브랜드데이"` |
| data.promotions[].endsAt | String | Y | 프로모션 종료 일시 (ISO 8601) | `"2026-05-09T23:59:59"` |
| data.promotions[].items | Array | Y | 프로모션 대상 상품 목록 | - |
| data.promotions[].items[].itemId | Long | Y | 상품 ID | `20011` |
| data.promotions[].items[].name | String | Y | 상품명 | `"프리미엄 올리브오일 500ml"` |
| data.promotions[].items[].imageUrl | String | Y | 상품 이미지 URL | `"https://..."` |
| data.promotions[].items[].originalPrice | Integer | Y | 정가 | `18000` |
| data.promotions[].items[].discountRate | Integer | Y | 할인율 | `38` |
| data.promotions[].items[].discountedPrice | Integer | Y | 할인가 | `34800` |
| data.promotions[].items[].isTomorrowDelivery | Boolean | Y | 내일배송 여부 | `true` |

### Success Response Example

**200 OK**

```json
{
  "success": true,
  "status": 200,
  "message": "요청이 성공했습니다.",
  "data": {
    "promotions": [
      {
        "promotionId": 301,
        "tag": "보장특가",
        "endsAt": "2026-04-24T23:59:59",
        "items": [
          {
            "itemId": 20011,
            "name": "다비다 호텔 달걀 키즈 등 6종",
            "imageUrl": "https://example.com/images/item/20011.jpg",
            "originalPrice": 56100,
            "discountRate": 38,
            "discountedPrice": 34800,
            "isTomorrowDelivery": true
          },
          {
            "itemId": 20012,
            "name": "다비다 퍼퓸 섬유유연제 4종",
            "imageUrl": "https://example.com/images/item/20012.jpg",
            "originalPrice": 56500,
            "discountRate": 42,
            "discountedPrice": 32800,
            "isTomorrowDelivery": true
          },
          {
            "itemId": 20013,
            "name": "다비다 호텔컬렉션 섬유유연제",
            "imageUrl": "https://example.com/images/item/20013.jpg",
            "originalPrice": 27700,
            "discountRate": 21,
            "discountedPrice": 21900,
            "isTomorrowDelivery": true
          }
        ]
      }
    ]
  }
}
```

### Error Response Example

**404 Not Found**

```json
{
  "success": false,
  "status": 404,
  "message": "현재 활성화된 프로모션이 없습니다.",
  "code": "HOM_404_001",
  "meta": {
    "path": "/api/home/promotions",
    "timestamp": 1746835200000
  }
}
```

**500 Internal Server Error**

```json
{
  "success": false,
  "status": 500,
  "message": "서버 내부 오류가 발생했습니다.",
  "code": "COM_500_001",
  "meta": {
    "path": "/api/home/promotions",
    "timestamp": 1746835200000
  }
}
```
