# PRODUCT_001 상품 상세 API 명세

---

## API 1. 상품 상세 조회

상품 ID로 상품 상세 정보를 조회하여 반환한다.

**GET** `/api/products/{productId}`

### Path Parameter

| Name | Type | Required | Description | Example |
|------|------|----------|-------------|---------|
| productId | Long | Y | 상품 ID | `1001` |

### Query Parameter

(없음)

### Request Header

(없음)

### Request Body

(없음)

### Request Example

```
GET /api/products/1001
```

### Response Body

| Name | Type | Required | Description | Example |
|------|------|----------|-------------|---------|
| success | Boolean | Y | 요청 성공 여부 | `true` |
| status | Integer | Y | HTTP 상태 코드 | `200` |
| message | String | Y | 응답 메시지 | `"요청이 성공했습니다."` |
| data | Object | Y | 상품 상세 데이터 | - |
| data.productId | Long | Y | 상품 ID | `1001` |
| data.brandName | String | Y | 브랜드명 | `"광동제약"` |
| data.thumbnailImageUrl | String | Y | 상품 썸네일 이미지 URL | `"https://..."` |
| data.productName | String | Y | 상품명 | `"(광동 직영) 제주 삼다수 그린(무라벨) 500ml 40개입"` |
| data.reviewScore | Double | Y | 상품 평점 | `4.91` |
| data.recentReviewScore | Double | Y | 최근 평점 | `4.92` |
| data.reviewCount | Integer | Y | 리뷰 개수 | `120445` |
| data.discountRate | Integer | Y | 할인율 | `5` |
| data.originalPrice | Integer | Y | 정가 | `19700` |
| data.salePrice | Integer | Y | 할인가 | `19200` |
| data.memberPrice | Integer | Y | 나의 할인가 | `18700` |
| data.couponAvailable | Boolean | Y | 쿠폰 발급 가능 여부 | `true` |
| data.couponDday | Integer | Y | 쿠폰 만료까지 남은 일 수 (D-day) | `6` |
| data.delivery | Object | Y | 배송 정보 | - |
| data.delivery.isFreeDelivery | Boolean | Y | 무료배송 여부 | `true` |
| data.delivery.arrivalDate | String | Y | 도착 예정 날짜 (`yyyy-MM-dd`) | `"2026-04-25"` |
| data.delivery.deadlineAt | String | Y | 주문 마감 시각 (`yyyy-MM-dd'T'HH:mm:ss`) | `"2026-04-24T23:59:59"` |
| data.unitPrice | Integer | Y | 단위당 가격 | `96` |
| data.unitQuantity | Integer | Y | 기준 수량 | `100` |
| data.unit | String | Y | 단위 (g, ml 등) | `"ml"` |
| data.pointBenefit | Object | Y | 적립 혜택 정보 | - |
| data.pointBenefit.maxPoint | Integer | Y | 최대 적립 가능 포인트 | `1608` |

### Success Response Example

**200 OK**

```json
{
  "success": true,
  "status": 200,
  "message": "요청이 성공했습니다.",
  "data": {
    "productId": 1001,
    "brandName": "광동제약",
    "thumbnailImageUrl": "https://image.example.com/products/samdasu.png",
    "productName": "(광동 직영) 제주 삼다수 그린(무라벨) 500ml 40개입 (유 무라벨 랜덤) [원산지:상세설명에 표시]",
    "reviewScore": 4.91,
    "recentReviewScore": 4.92,
    "reviewCount": 120445,
    "discountRate": 5,
    "originalPrice": 19700,
    "salePrice": 19200,
    "memberPrice": 18700,
    "couponAvailable": true,
    "couponDday": 6,
    "unitPrice": 96,
    "unitQuantity": 100,
    "unit": "ml",
    "delivery": {
      "isFreeDelivery": true,
      "arrivalDate": "2026-04-25",
      "deadlineAt": "2026-04-24T23:59:59"
    },
    "pointBenefit": {
      "maxPoint": 1608
    }
  }
}
```

### Error Response Example

**404 Not Found**

```json
{
  "success": false,
  "status": 404,
  "message": "존재하지 않는 상품입니다.",
  "code": "PRD_404_001",
  "meta": {
    "path": "/api/products/1001",
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
    "path": "/api/products/1001",
    "timestamp": 1746835200000
  }
}
```
