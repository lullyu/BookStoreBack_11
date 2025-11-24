# BookStoreBack_11 - 在线书店系统后端实现



> **学号：2024131011**
> 
> 一个基于Spring Boot和MySQL的完整在线书店系统后端API
## 项目概述

BookStoreBack_11是一个完整的在线书店系统后端服务，采用现代化的技术栈构建，提供稳定的RESTful API接口。项目涵盖了电商系统的核心业务流程，包括用户管理、商品展示、购物车、订单处理等完整功能。

## 核心特性

### 完整的电商业务流程
1. **用户旅程**：注册 → 登录 → 浏览 → 搜索 → 加购 → 下单 → 支付（模拟）
2. **状态管理**：完整的订单状态机（待支付、已确认、已发货、已完成、已取消）
3. **库存控制**：实时库存监控，防止超卖


### 安全的用户系统
1. **密码安全**：采用加密存储（生产环境可升级为BCrypt）
2. **数据验证**：前后端数据校验，防止非法输入
3. **会话管理**：基于Token的用户状态维护

### 智能图书管理
1. **多维度搜索**：支持标题、作者、ISBN、描述全文搜索
2. **分类浏览**：按图书分类快速筛选
3. **库存预警**：库存数量实时监控

### 高性能API设计
1. **RESTful规范**：符合REST架构风格的API设计
2. **响应式编程**：基于Spring Boot的响应式处理
3. **数据库优化**：JPA+Hibernate性能调优

### 分层架构设计
1. **Controller层**：接收请求，参数校验，返回响应
2. **Service层**：业务逻辑处理，事务管理
3. **Repository层**：数据持久化操作
4. **Entity层**：数据模型定义，ORM映射


## 技术选型

### 后端技术栈
| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 3.2.0 | 核心框架，快速开发 |
| Spring Data JPA | 3.2.0 | 数据持久化解决方案 |
| MySQL | 8.0+ | 关系型数据库 |
| Maven | 3.6+ | 项目构建和依赖管理 |
| Java | 21 | 编程语言和运行环境 |

### 开发工具链
| 工具 | 用途 | 优势 |
|------|------|------|
| IntelliJ IDEA | 开发IDE | 智能代码提示，强大调试功能 |
| Navicat | 数据库管理 | 可视化操作，SQL调试 |
| Postman | API测试 | 接口调试，文档生成 |
| Git | 版本控制 | 代码管理，团队协作 |


## 快速开始

### 环境要求

1. **JDK**: 21 或更高版本
2. **MySQL**: 8.0 或更高版本
3. **Maven**: 3.6 或更高版本

### 数据库配置

1. 创建数据库：
   ```sql
    CREATE DATABASE liu CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
2. 使用数据库
   ```sql
   USE liu;
3. 自动建表
- 项目使用JPA自动建表功能

- 首次运行时会自动创建所有数据表

- 测试数据会自动插入

### 运行步骤
1. 克隆项目
   ```bash
   git clone https://github.com/lullyu/BookStoreBack_11.git
   cd BookStoreBack_11
2. 配置数据库连接 编辑 src/main/resources/application.properties：

    ```bash
   # 数据库连接配置
   spring.datasource.url=jdbc:mysql://localhost:3306/liu?useSSL=false&serverTimezone=UTC
   spring.datasource.username=你的MySQL用户名
   spring.datasource.password=你的MySQL密码

    # JPA配置
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
3. 运行项目

打开 BookstoreApplication.java

右键点击 → Run 'BookstoreApplication.main()'

等待控制台显示 Started BookstoreApplication
4. 验证安装
   ```bash
   http://localhost:8080/api/books
## API文档
详细API文档请查看：API接口文档
## 核心功能
### 用户管理模块
1. 用户注册和登录

2. 个人信息管理

### 图书管理模块
1. 图书浏览和搜索

2. 分类管理

3. 库存控制

### 购物车模块
1. 商品添加删除

2. 数量修改

3. 价格计算

### 订单模块
1. 订单创建
2. 状态管理
3. 历史查询
## 许可证
本项目基于 Apache License 2.0 许可证 - 查看 LICENSE 文件了解详情。
## 作者
2024131011

GitHub:lullyu







