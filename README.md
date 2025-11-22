# bookstoreback_11 - 在线书店系统后端实现

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![License](https://img.shields.io/badge/License-Apache%202.0-blue)
![GitHub](https://img.shields.io/badge/GitHub-Open--Source-success)

> **学号：2024131011** 

## 项目概述

**BookStore 11** 是一个基于Spring Boot和MySQL的完整在线书店系统后端解决方案。本项目采用现代化的软件开发实践，实现了电商平台的核心业务流程，包括用户管理、商品展示、购物车、订单处理等完整功能链。

作为课程期末项目，本项目不仅实现了业务功能，更注重代码质量、架构设计和文档完整性，体现了软件工程的最佳实践。

## 核心特性

### 完整的电商业务流程
- **用户旅程**：注册 → 登录 → 浏览 → 搜索 → 加购 → 下单 → 支付（模拟）
- **状态管理**：完整的订单状态机（待支付、已确认、已发货、已完成、已取消）
- **库存控制**：实时库存监控，防止超卖

### 安全的用户系统
- **密码安全**：采用加密存储（生产环境可升级为BCrypt）
- **数据验证**：前后端数据校验，防止非法输入
- **会话管理**：基于Token的用户状态维护

### 智能图书管理
- **多维度搜索**：支持标题、作者、ISBN、描述全文搜索
- **分类浏览**：按图书分类快速筛选
- **库存预警**：库存数量实时监控

### 高性能API设计
- **RESTful规范**：符合REST架构风格的API设计
- **响应式编程**：基于Spring Boot的响应式处理
- **数据库优化**：JPA+Hibernate性能调优

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

### 环境准备

#### 系统要求
- **操作系统**：Windows 10+/macOS 10.14+/Linux Ubuntu 16.04+
- **内存**：至少 4GB RAM
- **磁盘空间**：至少 2GB 可用空间

#### 软件安装
1. **安装JDK 21**
   ```bash
   # 验证安装
   java -version
   javac -version

2. **安装MySQL**
#### 数据库配置
1. **创建数据库**
   ```bash
   CREATE DATABASE liu CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   USE liu;
### 应用配置
1. **克隆项目**
    ```bash
   git clone https://github.com/你的用户名/bookstore_11.git
   cd bookstore_11
2. **修改配置文件**
   *编辑 src/main/resources/application.properties：*
   ```bash
   server.port=8080
   server.servlet.context-path=/api

   spring.datasource.url=jdbc:mysql://localhost:3306/liu?useSSL=false&serverTimezone=Asia/Shanghai
   spring.datasource.username=root
   spring.datasource.password=你的密码

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
### 运行项目
1.打开IntelliJ IDEA

2.导入项目

3.找到 BookstoreApplication.java

4.右键 → Run 'BookstoreApplication.main()'
## API文档
详细API文档请查看：API接口文档
## 核心功能
### 用户管理模块
- 用户注册和登录

- 个人信息管理

### 图书管理模块
- 图书浏览和搜索

- 分类管理

- 库存控制

### 购物车模块
- 商品添加删除

- 数量修改

- 价格计算

### 订单模块
- 订单创建

- 状态管理

- 历史查询
## 许可证
本项目基于 Apache License 2.0 许可证 - 查看 LICENSE 文件了解详情。
## 作者
- 刘璐（2024131011）

- GitHub:lullyu
## 致谢
- 感谢课程老师的指导

- 感谢同学们的测试反馈
 ```<div align="center">
如果这个项目对你有帮助，请给它一个 ⭐ Star 支持！
