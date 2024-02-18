# 传递图片的URL,获取图片中的人数(基于百度人形识别API)

## 一.部署-推荐使用docker部署
docker run -d -p 8310:8310 -e CLIENT_ID=百度申请的CLIENT_ID -e CLIENT_SECRET=百度申请的CLIENT_SECRET hiasia/people-flow-statistics:latest

## 二.使用方法,直接调用api使用
http://部署的IP地址:8310/people-flow?imageUrl=图片的URL

## 三.在node-red中使用


## 四.TODO
- [ ] 1.数据持久化
- [ ] 2.每日/周/月 人数统计汇总