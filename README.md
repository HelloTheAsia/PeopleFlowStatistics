# 传递图片的URL,获取图片中的人数(基于百度人形识别API)

## 一.打包镜像
```shell
docker buildx build . -t hiasia/people-flow-statistics:latest --platform linux/arm64,linux/amd64 --push
```

## 二.部署-推荐使用docker部署
**目前支持AMD64与ARM64架构**
```shell
docker run -d -p 8310:8310 \
-e CLIENT_ID=百度申请的CLIENT_ID \
-e CLIENT_SECRET=百度申请的CLIENT_SECRET \
-v /path/pfs/pfs.db:/app/pfs.db \
--name=pfs \
registry.cn-hangzhou.aliyuncs.com/hiasia/people-flow-statistics
```

## 三.使用方法,直接调用api使用
http://部署的IP地址:8310/people-flow?imageUrl=图片的URL


## 三.TODO
- [ ] 1.每日/周/月 人数统计汇总