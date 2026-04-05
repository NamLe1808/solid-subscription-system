# SOLID OOP Principles Demo - Subscription System

## 📋 Mô tả dự án

Dự án này là một hệ thống quản lý đăng ký (Subscription Management System) đơn giản được xây dựng bằng Java để minh họa việc áp dụng các nguyên tắc **SOLID** trong lập trình hướng đối tượng.

Hệ thống cho phép người dùng:

- Chọn các gói đăng ký
- Tính giá với các chiến lược khác nhau
- Xử lý thanh toán bằng nhiều phương thức
- Gửi thông báo
- Lưu trữ dữ liệu thông qua pattern Repository

## 🎯 Mục tiêu

Dự án này được tạo ra để:

- Minh họa cách áp dụng 5 nguyên tắc SOLID trong thiết kế phần mềm
- Demo các design pattern như Strategy, Repository, Dependency Injection
- Hiểu rõ lợi ích của việc viết code linh hoạt và dễ mở rộng

## 🏗️ Kiến trúc hệ thống

### Các thành phần chính:

#### 🗂️ Repository Layer

- `PlanRepository` - Quản lý gói đăng ký
- `SubscriptionRepository` - Quản lý đăng ký

#### 💰 Strategy Pattern

- `PricingStrategy` - Chiến lược tính giá
  - `NormalPricing` - Giá bình thường
  - `NewUserDiscountPricing` - Giảm giá cho user mới
  - `LongTermDiscountPricing` - Giảm giá dài hạn

#### 💳 Payment Methods

- `PaymentMethod` - Interface thanh toán
  - `MomoPayment` - Thanh toán Momo
  - `CreditCardPayment` - Thanh toán thẻ tín dụng

#### 📢 Notification Services

- `NotificationService` - Interface thông báo
  - `EmailNotification` - Thông báo email
  - `SMSNotification` - Thông báo SMS

#### 🔧 Service Layer

- `SubscriptionService` - Service xử lý đăng ký với Dependency Injection

## ✅ SOLID Principles được áp dụng

### 🔸 Single Responsibility Principle (SRP)

Mỗi class chỉ có một trách nhiệm duy nhất:

- `SubscriptionService` chỉ xử lý logic đăng ký
- `PricingStrategy` chỉ tính giá
- `PaymentMethod` chỉ xử lý thanh toán

### 🔸 Open/Closed Principle (OCP)

Code mở rộng nhưng không sửa đổi:

- Thêm chiến lược giá mới mà không thay đổi `SubscriptionService`
- Thêm phương thức thanh toán mới mà không ảnh hưởng code cũ

### 🔸 Liskov Substitution Principle (LSP)

Các implementation có thể thay thế interface:

- Bất kỳ `PricingStrategy` nào cũng có thể dùng trong `SubscriptionService`
- Bất kỳ `PaymentMethod` nào cũng tương thích

### 🔸 Interface Segregation Principle (ISP)

Interface nhỏ, chuyên biệt:

- `PricingStrategy` chỉ có method `calculate()`
- `PaymentMethod` chỉ có method `pay()`
- `NotificationService` chỉ có method `send()`

### 🔸 Dependency Inversion Principle (DIP)

Phụ thuộc vào abstraction, không phải concrete class:

- `SubscriptionService` nhận interface qua constructor injection
- Dễ test và mock dependencies

## 🚀 Cách chạy

### Yêu cầu hệ thống

- Java 8 hoặc cao hơn
- IDE như IntelliJ IDEA, Eclipse, hoặc VS Code

### Các bước chạy:

1. **Clone hoặc download project**

   ```bash
   cd path/to/project
   ```

2. **Compile code**

   ```bash
   javac *.java
   ```

3. **Chạy chương trình**
   ```bash
   java Main
   ```

### Kết quả mẫu:

```
===== DANH SÁCH GÓI =====
SubscriptionPlan{id=1, name='Basic', price=10.0}
SubscriptionPlan{id=2, name='Premium', price=20.0}

===== CASE 1: NORMAL USER =====
Thanh toán Momo: 10.0
Gửi email: Thanh toán thành công: 10.0

===== CASE 2: NEW USER DISCOUNT =====
Thanh toán Credit Card: 18.0
Gửi SMS: Thanh toán thành công: 18.0
```

## 📁 Cấu trúc project

```
SOLID_OOP_1/
├── Main.java                    # Class chính để demo
├── User.java                    # Model User
├── Subscription.java            # Model Subscription
├── SubscriptionPlan.java        # Model Plan
├── SubscriptionService.java     # Service xử lý đăng ký
├── PricingStrategy.java         # Interface chiến lược giá
├── NormalPricing.java           # Implementation giá bình thường
├── NewUserDiscountPricing.java  # Implementation giảm giá user mới
├── LongTermDiscountPricing.java # Implementation giảm giá dài hạn
├── PaymentMethod.java           # Interface phương thức thanh toán
├── MomoPayment.java             # Implementation thanh toán Momo
├── CreditCardPayment.java       # Implementation thanh toán thẻ
├── NotificationService.java     # Interface dịch vụ thông báo
├── EmailNotification.java       # Implementation thông báo email
├── SMSNotification.java         # Implementation thông báo SMS
├── PlanRepository.java          # Interface repository plan
├── MemoryPlanRepository.java    # Implementation in-memory
├── SubscriptionRepository.java  # Interface repository subscription
└── MemorySubscriptionRepository.java # Implementation in-memory
```

## 🔧 Công nghệ sử dụng

- **Ngôn ngữ**: Java
- **Paradigm**: Object-Oriented Programming
- **Design Patterns**: Strategy, Repository, Dependency Injection
- **Principles**: SOLID

## 📚 Tài liệu tham khảo

- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [Design Patterns](https://en.wikipedia.org/wiki/Design_Patterns)
- [Clean Code](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)

## 🤝 Đóng góp

Dự án này được tạo cho mục đích học tập. Nếu bạn muốn đóng góp:

1. Fork project
2. Tạo feature branch
3. Commit changes
4. Push và tạo Pull Request

## 📄 License

Dự án này sử dụng license MIT. Xem file LICENSE để biết thêm chi tiết.
