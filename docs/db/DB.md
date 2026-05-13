# DB 테이블 명세

---

## 1. 사용자

서비스를 이용하는 사용자 정보를 저장하는 테이블

**테이블명:** `users`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 사용자 ID | 1 |
|    | nickname | VARCHAR | NOT NULL | 닉네임 | 네이버쇼핑왕 |

**Example Row**

| id | nickname |
|----|----------|
| 1 | 네이버쇼핑왕 |

---

## 2. 상품

상품 상세 화면에서 표시되는 상품 정보를 저장하는 테이블

**테이블명:** `products`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 상품 ID | 101 |
|    | brand_name | VARCHAR | NOT NULL | 브랜드명 | CJ제일제당 |
|    | thumbnail_image_url | VARCHAR | NOT NULL | 썸네일 이미지 URL | https://shop.example.com/img/101.jpg |
|    | name | VARCHAR | NOT NULL | 상품명 | 비비고 왕교자 1.05kg |
|    | review_score | DOUBLE | NOT NULL | 평점 | 4.8 |
|    | recent_review_score | DOUBLE | NOT NULL | 최근 평점 | 4.9 |
|    | review_count | INT | NOT NULL | 리뷰 수 | 23841 |
|    | original_price | INT | NOT NULL | 정가 | 12900 |
|    | sale_price | INT | NOT NULL | 할인가 | 9900 |
|    | member_price | INT | NOT NULL | 회원 할인가 | 8900 |
|    | discount_rate | INT | NOT NULL | 할인율 | 23 |
|    | coupon_available | BOOLEAN | NOT NULL | 쿠폰 발급 가능 여부 | true |
|    | coupon_dday | INT | NULL | 쿠폰 만료 D-day (쿠폰 없을 시 NULL) | 3 |
|    | unit_price | INT | NULL | 단위당 가격 | 9429 |
|    | unit_quantity | INT | NULL | 기준 수량 | 100 |
|    | unit | VARCHAR | NULL | 단위 | g |
|    | free_delivery | BOOLEAN | NOT NULL | 무료배송 여부 | true |
|    | arrival_date | DATE | NOT NULL | 도착 예정 날짜 | 2025-05-13 |
|    | deadline_at | DATETIME | NULL | 주문 마감 시각 | 2025-05-12 23:00:00 |
|    | max_point | INT | NOT NULL | 최대 적립 포인트 | 495 |

**Example Row**

| id | brand_name | name | review_score | original_price | sale_price | member_price | discount_rate | coupon_available | coupon_dday | free_delivery | arrival_date | deadline_at | max_point |
|----|------------|------|-------------|----------------|------------|--------------|---------------|-----------------|-------------|---------------|--------------|-------------|-----------|
| 101 | CJ제일제당 | 비비고 왕교자 1.05kg | 4.8 | 12900 | 9900 | 8900 | 23 | true | 3 | true | 2025-05-13 | 2025-05-12 23:00:00 | 495 |

---

## 3. 카드혜택

상품 상세 화면의 카드 혜택 문구를 저장하는 테이블

**테이블명:** `card_benefits`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 카드 혜택 ID | 1 |
| FK | product_id | BIGINT | NOT NULL | 상품 ID | 101 |
|    | title | VARCHAR | NOT NULL | 카드 혜택 문구 | 현대카드 2% 적립 |

**Example Row**

| id | product_id | title |
|----|-----------|-------|
| 1 | 101 | 현대카드 2% 적립 |
| 2 | 101 | 삼성카드 5만원 이상 3개월 무이자 |

---

## 4. 카테고리

홈 화면 상위 카테고리 정보를 저장하는 테이블

**테이블명:** `categories`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 카테고리 ID | 1 |
|    | name | VARCHAR | NOT NULL | 카테고리명 | 신선식품 |
|    | icon_url | VARCHAR | NOT NULL | 아이콘 이미지 URL | https://shop.example.com/icon/fresh.png |

**Example Row**

| id | name | icon_url |
|----|------|----------|
| 1 | 신선식품 | https://shop.example.com/icon/fresh.png |

---

## 5. 추천섹션

홈 화면의 사용자별 내일배송 개인화 추천 섹션을 저장하는 테이블

**테이블명:** `recommendation_sections`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 추천 섹션 ID | 1 |
| FK | user_id | BIGINT | NOT NULL | 사용자 ID | 1 |

**Example Row**

| id | user_id |
|----|---------|
| 1 | 1 |

---

## 6. 추천상품목록

추천 섹션에 포함된 상품 목록을 저장하는 테이블

**테이블명:** `recommendation_products`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 추천 상품 ID | 1 |
| FK | recommendation_section_id | BIGINT | NOT NULL | 추천 섹션 ID | 1 |
| FK | product_id | BIGINT | NOT NULL | 상품 ID | 101 |
|    | display_order | INT | NOT NULL | 노출 순서 | 1 |

**Example Row**

| id | recommendation_section_id | product_id | display_order |
|----|--------------------------|-----------|---------------|
| 1 | 1 | 101 | 1 |
| 2 | 1 | 102 | 2 |

---

## 7. 프로모션

홈 화면 타임딜 섹션의 프로모션 정보를 저장하는 테이블

**테이블명:** `promotions`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 프로모션 ID | 1 |
|    | tag | VARCHAR | NOT NULL | 태그명 | 브랜드데이 |
|    | ends_at | DATETIME | NOT NULL | 종료 일시 | 2025-05-12 23:59:59 |

**Example Row**

| id | tag | ends_at |
|----|-----|---------|
| 1 | 브랜드데이 | 2025-05-12 23:59:59 |

---

## 8. 프로모션상품목록

프로모션에 포함된 상품 목록을 저장하는 테이블

**테이블명:** `promotion_products`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 프로모션 상품 ID | 1 |
| FK | promotion_id | BIGINT | NOT NULL | 프로모션 ID | 1 |
| FK | product_id | BIGINT | NOT NULL | 상품 ID | 101 |
|    | display_order | INT | NOT NULL | 노출 순서 | 1 |

**Example Row**

| id | promotion_id | product_id | display_order |
|----|-------------|-----------|---------------|
| 1 | 1 | 101 | 1 |
| 2 | 1 | 102 | 2 |

---

## 9. 주문

결제 화면의 주문 정보를 저장하는 테이블

**테이블명:** `orders`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 주문 ID | 1 |
|    | available_amount | INT | NOT NULL | 사용 가능 총 금액 | 50000 |
|    | available_point | INT | NOT NULL | 사용 가능 포인트 | 3000 |
|    | available_money | INT | NOT NULL | 사용 가능 머니 | 47000 |
|    | hidden_point | INT | NOT NULL | 숨은 포인트 금액 | 500 |
|    | all_use_amount | INT | NOT NULL | 전액 사용 시 적용 금액 | 50000 |

**Example Row**

| id | available_amount | available_point | available_money | hidden_point | all_use_amount |
|----|-----------------|----------------|----------------|--------------|----------------|
| 1 | 50000 | 3000 | 47000 | 500 | 50000 |

---

## 10. 적립예정포인트

결제 화면의 적립 예정 포인트 정보를 저장하는 테이블

**테이블명:** `pending_points`

| Key | Name | Type | Constraint | Description | Example |
|-----|------|------|------------|-------------|---------|
| PK | id | BIGINT | NOT NULL | 적립 예정 포인트 ID | 1 |
| FK | order_id | BIGINT | NOT NULL | 주문 ID | 1 |
|    | total_point | INT | NOT NULL | 총 적립 예정 포인트 | 850 |
|    | purchase_total_point | INT | NOT NULL | 총 구매 적립 포인트 | 700 |
|    | basic_point | INT | NOT NULL | 기본 적립 포인트 | 500 |
|    | npay_money_point | INT | NOT NULL | 네이버페이 머니 결제 적립 포인트 | 200 |
|    | review_point | INT | NOT NULL | 리뷰 적립 포인트 | 100 |
|    | membership_point | INT | NOT NULL | 멤버십 추가 적립 포인트 | 50 |

**Example Row**

| id | order_id | total_point | purchase_total_point | basic_point | npay_money_point | review_point | membership_point |
|----|---------|------------|---------------------|------------|-----------------|-------------|-----------------|
| 1 | 1 | 850 | 700 | 500 | 200 | 100 | 50 |

---

## ERD 관계

```
users           1 ─── N  recommendation_sections
recommendation_sections  1 ─── N  recommendation_products
products        1 ─── N  recommendation_products

promotions      1 ─── N  promotion_products
products        1 ─── N  promotion_products

products        1 ─── N  card_benefits

orders          1 ─── 1  pending_points
```
