# 传递图片的URL,获取图片中的人数(基于百度人形识别API)


## 一.部署-推荐使用docker部署
docker run -d -p 8310:8310 -e TOKEN=百度静态人形识别的TOKEN hiasia/people-flow-statistics:latest

## 二.使用方法,可以直接到api使用
http://部署的IP地址:8310/people-flow?imageUrl=图片的URL

## 三.在node-red中使用

## 四.TODO
- [ ] 1.数据库的存储
- [ ] 2.每日/周/月 人数统计汇总
- [ ] 3.token的自动更新