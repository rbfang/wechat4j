wechat4j
========

---
####介绍：

wechat4j是一个使用纯JAVA来封装的一个微信JAVA框架，此框架主要是为了方便处理与微信服务器交互。

---
####功能模块：
1. 普通消息处理
2. 事件消息处理
3. 消息回复
4. 用户信息处理
5. 用户组处理
6. 按钮创建和查看功能
7. 用户备注名称
8. 关注用户列表

---

####项目package介绍：


 * wechat4j.bean.*		`功能bean`
 * wechat4j.handler.*	`功能操作`
 * wechat4j.message.* 	`消息处理	`
 * wechat4j.support.*  `基础处理`
 * wechat4j.unitl.*		`工具类`

---

####使用方法：

1、配置appId和appSecret。
	
	在resources文件夹下面新建文件wechat4j.properties
	示例内容：
		appId=wxd30e31bfd8c207ex
		appSecret=d0f9c44269c0283a1a7337efea1950a1

---

####示例代码：

获取用户分组列表：

		Wechat wechat = WechatFactory.newInstance();
        List<Group> groupList = wechat.findAllGroup();

        for (Group group : groupList) {
            System.out.println(group.toString());
        }