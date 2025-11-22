# API接口文档

## 基础信息
- 地址：http://localhost:8080/api
- 格式：JSON

## 用户接口
- 注册：POST /users/register
- 登录：POST /users/login

## 图书接口
- 获取所有图书：GET /books
- 搜索图书：GET /books/search?keyword=Java

## 购物车接口
- 查看购物车：GET /cart/1
- 添加商品：POST /cart/1/add?bookId=1&quantity=1

## 订单接口
- 创建订单：POST /orders/create/1
- 查看订单：GET /orders/user/1
