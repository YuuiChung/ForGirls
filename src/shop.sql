/*删除商城数据库,如果存在*/
drop database if exists shop;
/*创建数据库,并设置编码*/
create database shop default character set utf8;

use shop;
/*删除管理员表*/
drop table if exists account;
/*删除商品类别表*/
drop table if exists category;
/*删除商品信息表*/
drop table if exists product;

drop table if exists forder;

drop table if exists sorder;

drop table if exists status;

drop table if exists user;

/*============================*/
/* Table: 管理员表结构 		  */
/*============================*/
create table account
(
   /* 管理员编号,自动增长 */
   id                  int not null auto_increment,
   /* 管理员登录名  */
   login               varchar(20),
   /* 管理员姓名  */
   name                varchar(20),
   /* 管理员密码 */
   pass                varchar(20),
   /* 是否为超级管理员  */
   system               boolean default false,
   /* 设置编号为主键 */
   primary key (id)
);

/*=============================*/
/* Table: 商品类别表结构 		   */
/*=============================*/
create table category
(
   /* 类别编号,自动增长 */
   id                  int not null auto_increment,
   /* 类别名称 */
   type                varchar(20),
   /* 类别是否为热点类别,热点类别才有可能显示在首页 */
   hot                 bool default false,
   /* 外键,此类别由哪位管理员管理 */
   aid                  int,
   /* 设置类别编号为主键 */
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   login                varchar(20),
   name                 varchar(20),
   pass                 varchar(20),
   sex                  varchar(1),
   phone                varchar(20),
   email                varchar(20),
   primary key (id)
);

/*=============================*/
/* Table: 商品表结构	 		   */
/*=============================*/
create table product
(
   /* 商品编号,自动增长 */
   id                  int not null auto_increment,
   /* 商品名称 */
   name                varchar(20),
   /* 商品价格 */
   price               decimal(8,2),
   /* 商品图片 */
   pic                 varchar(200),
   /* 商品简单介绍 */
   remark              longtext,
   /* 商品详细介绍 */
   xremark             longtext,
   /* 商品生产日期 */
   date                timestamp default CURRENT_TIMESTAMP,
   /* 是否为推荐商品,推荐商品才有可能显示在商城首页 */
   commend             bool,
   /* 是否为有效商品,有效商品才有可能显示在商城首页 */
   open                bool,
   /* 商品所在的类别编号*/
   cid                  int,
   /* 设置商品编号为主键 */
   primary key (id)
);

/*==============================================================*/
/* Table: 购物车(订单表)                                            */
/*==============================================================*/
create table forder
(
   id                   int not null auto_increment,
   name                 varchar(20),
   phone                varchar(20),
   remark               varchar(20),
   date                 timestamp default CURRENT_TIMESTAMP,
   total                double(8,2),
   post                 varchar(20),
   address              varchar(20),
   uid                  int,
   sid                  int,
   primary key (id)
);

/* 修改自动增长的初始值 */
ALTER TABLE forder AUTO_INCREMENT = 123320325;

/*==============================================================*/
/* Table: 购物项(订单项)                                               */
/*==============================================================*/
create table sorder
(
   id                   int not null auto_increment,
   name                 varchar(20),
   price                double(10,2),
   number               int,
   fid                  int,
   pid                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: 订单状态表                                                                               						*/
/*==============================================================*/
create table status
(
   id                   int not null auto_increment,
   status               varchar(20),
   primary key (id)
);


/*插入测试用例*/
INSERT INTO account(login,name,pass,system) values ('admin','小强','admin',true);
INSERT INTO account(login,name,pass,system) values ('user','旺财','user',false);

INSERT INTO category (type,hot,aid) VALUES ('男士休闲',true,1);
INSERT INTO category (type,hot,aid) VALUES ('女士休闲',true,1);
INSERT INTO category (type,hot,aid) VALUES ('儿童休闲',true,2);
INSERT INTO category (type,hot,aid) VALUES ('老人休闲',false,2);


/* 商品测试用例 */
INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('圣得西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('罗蒙西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('衫衫西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('金利来西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('韩版女装',199.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('雪地靴',299.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('欧版女装',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('女款手套',4999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('佳能单反机',3998.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('金士顿优盘',299.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('日立硬盘',599.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('大水牛机箱',399.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('电脑桌',150.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('老板椅',199.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('空调',3599.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('电视',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

/* 用户测试用例 */
INSERT INTO user (login,name,pass,sex,phone,email) VALUES ('user','小刚','user','男','18027364651','soft03_test@sina.com');

INSERT INTO user (login,name,pass,sex,phone,email)
VALUES ('user2','小琴','user2','女','18027364651','soft03_test@sina.com');

/*插入状态测试用例*/
INSERT INTO status (status) VALUES ('未支付');
INSERT INTO status (status) VALUES ('已支付');
INSERT INTO status (status) VALUES ('配送中');
INSERT INTO status (status) VALUES ('订单完成');

/*插入购物车测试用例*/
INSERT INTO forder (name,phone,remark,date,total,address,post,uid,sid) VALUES ('bb','123','备注',default,200.3,'广州天河区','1000',1,1);

/*插入购物车项测试用例*/
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('空调',200,1,15,201407013);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('电视',0.3,1,16,201407013);

/* 报表测试用例  */
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('空调',200,3,15,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('电视',0.3,4,16,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('雪地靴',0.1,1,6,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('欧版女装',0.1,2,7,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('女士手套',0.1,7,8,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('老板椅',100,10,14,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('日立硬盘',12,6,11,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('圣得西服',0.01,12,1,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('罗蒙西服',0.05,10,2,201407014);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('杉杉西服',0.01,11,3,201407014);

SELECT * FROM account;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM user;
SELECT * FROM status;
SELECT * FROM forder;
SELECT * FROM sorder;


drop table if exists privilege_role;
drop table if exists privilege;
drop table if exists role;

/*==============================================================*/
/* Table: privilege                                             */
/*==============================================================*/
create table privilege
(
   id                   int not null auto_increment,
   name                 varchar(50),
   pid                  int,
   primary key (id)
);

create table url(
   id   int not null auto_increment,
   url  varchar(200),
   pid  int,
   primary key (id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   int not null auto_increment,
   name                 varchar(20),
   detail               varchar(200),
   primary key (id)
);

/*==============================================================*/
/* Table: privilege_role                                        */
/*==============================================================*/
create table privilege_role
(
   pid                  int not null,
   rid                  int not null,
   primary key (pid, rid)
);

create table account_role(
	aid int,
	rid int,
	primary key(aid,rid)
);

/*----插入角色信息-----*/
INSERT INTO role (name,detail) VALUES ('管理员','可以所有功能');
INSERT INTO role (name,detail) VALUES ('客服','可以完成商品的查询和添加功能');

/*----插入权限信息-----*/
INSERT INTO privilege (name,pid) VALUES ('商品管理',null);
INSERT INTO privilege (name,pid) VALUES ('类别管理',null);
INSERT INTO privilege (name,pid) VALUES ('账户管理',null);
INSERT INTO privilege (name,pid) VALUES ('角色管理',null);
INSERT INTO privilege (name,pid) VALUES ('公共资源',null);

/*----插入权限信息-----*/
INSERT INTO privilege (name,pid) VALUES ('查询商品',1);
INSERT INTO privilege (name,pid) VALUES ('添加商品',1);

INSERT INTO privilege (name,pid) VALUES ('查询类别',2);
INSERT INTO privilege (name,pid) VALUES ('添加类别',2);
INSERT INTO privilege (name,pid) VALUES ('更新类别',2);
INSERT INTO privilege (name,pid) VALUES ('删除类别',2);

INSERT INTO privilege (name,pid) VALUES ('查询账户',3);
INSERT INTO privilege (name,pid) VALUES ('添加账户',3);
INSERT INTO privilege (name,pid) VALUES ('更新账户',3);
INSERT INTO privilege (name,pid) VALUES ('授予角色',3);
INSERT INTO privilege (name,pid) VALUES ('删除账户',3);

INSERT INTO privilege (name,pid) VALUES ('查询角色',4);
INSERT INTO privilege (name,pid) VALUES ('添加角色',4);
INSERT INTO privilege (name,pid) VALUES ('更新角色',4);
INSERT INTO privilege (name,pid) VALUES ('删除角色',4);

INSERT INTO privilege (name,pid) VALUES ('后台首页',5);

/*-----插入资源的url信息-----*/
INSERT INTO url (url,pid) VALUES ('/send_product_query.action',6);
INSERT INTO url (url,pid) VALUES ('/product_queryJoinCategory.action',6);
INSERT INTO url (url,pid) VALUES ('/send_product_save.action',7);
INSERT INTO url (url,pid) VALUES ('/product_save.action',7);

INSERT INTO url (url,pid) VALUES ('/send_category_query.action',8);
INSERT INTO url (url,pid) VALUES ('/category_queryJoinAccount.action',8);
INSERT INTO url (url,pid) VALUES ('/send_category_save.action',9);
INSERT INTO url (url,pid) VALUES ('/category_save.action',9);
INSERT INTO url (url,pid) VALUES ('/send_category_update.action',10);
INSERT INTO url (url,pid) VALUES ('/category_update.action',10);
INSERT INTO url (url,pid) VALUES ('/category_deleteByIds.action',11);


INSERT INTO url (url,pid) VALUES ('/send_account_query.action',12);
INSERT INTO url (url,pid) VALUES ('/account_queryForPage.action',12);
INSERT INTO url (url,pid) VALUES ('/send_account_save.action',13);
INSERT INTO url (url,pid) VALUES ('/account_save.action',13);
INSERT INTO url (url,pid) VALUES ('/send_account_update.action',14);
INSERT INTO url (url,pid) VALUES ('/account_updateHql.action',14);
INSERT INTO url (url,pid) VALUES ('/account_getAccount.action',15);
INSERT INTO url (url,pid) VALUES ('/account_grantRole.action',15);
INSERT INTO url (url,pid) VALUES ('/account_deleteByIds.action',16);

INSERT INTO url (url,pid) VALUES ('/send_role_query.action',17);
INSERT INTO url (url,pid) VALUES ('/role_query.action',17);
INSERT INTO url (url,pid) VALUES ('/send_role_save.action',18);
INSERT INTO url (url,pid) VALUES ('/role_save.action',18);
INSERT INTO url (url,pid) VALUES ('/send_role_update.action',19);
INSERT INTO url (url,pid) VALUES ('/role_update.action',19);
INSERT INTO url (url,pid) VALUES ('/role_deleteByIds.action',20);

INSERT INTO url (url,pid) VALUES ('/send_public_index.action',21);

INSERT INTO account_role (aid,rid) values (1,1);

/*-----配置哪些角色拥有什么权限------*/
INSERT INTO privilege_role (rid,pid) values (1,1);
INSERT INTO privilege_role (rid,pid) values (1,2);
INSERT INTO privilege_role (rid,pid) values (1,3);
INSERT INTO privilege_role (rid,pid) values (1,4);
INSERT INTO privilege_role (rid,pid) values (1,5);
INSERT INTO privilege_role (rid,pid) values (1,6);
INSERT INTO privilege_role (rid,pid) values (1,7);
INSERT INTO privilege_role (rid,pid) values (1,8);
INSERT INTO privilege_role (rid,pid) values (1,9);
INSERT INTO privilege_role (rid,pid) values (1,10);
INSERT INTO privilege_role (rid,pid) values (1,11);
INSERT INTO privilege_role (rid,pid) values (1,12);
INSERT INTO privilege_role (rid,pid) values (1,13);
INSERT INTO privilege_role (rid,pid) values (1,14);
INSERT INTO privilege_role (rid,pid) values (1,15);
INSERT INTO privilege_role (rid,pid) values (1,16);
INSERT INTO privilege_role (rid,pid) values (1,17);
INSERT INTO privilege_role (rid,pid) values (1,18);
INSERT INTO privilege_role (rid,pid) values (1,19);
INSERT INTO privilege_role (rid,pid) values (1,20);
INSERT INTO privilege_role (rid,pid) values (1,21);

SELECT * FROM privilege;
SELECT * FROM account;
SELECT * FROM url;
SELECT * FROM role;
SELECT * FROM privilege_role;
SELECT * FROM account_role;
