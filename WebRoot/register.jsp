<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<link rel="stylesheet" href="${shop}/css/register.css" type="text/css"></link>
	<script type="text/javascript">
		$(function(){
			alert("----自己完成验证功能-----");
		});
	</script>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="header_container">
				<!--头部开始-->
				<div class="top_bar clear">
					<!--头部小导航-->
					<div class="welcom fl">欢迎光临LEISUPET SHOP!</div>
					<ul class="top_links fr">
						<li class="highlight"><a href="#">首页</a>
						</li>
						<li><a href="#">我的账户</a>
						</li>
						<li><a href="#">购物车</a>
						</li>
						<li><a href="#">注册</a>
						</li>
						<li><a href="#">登录</a>
						</li>
					</ul>
					<!--头部小导航结束-->
					<!-- logo -->
					<h1 class="logo clear fl">
						<a href="index.html"> <img src="images/logo.png" /> </a>
					</h1>
					<!-- 小购物车 -->
					<div class="minicart">
						<a class="minicart_link" href="#"> <span class="item">
								<b>2</b>件/ </span> <span class="price"> <b>￥${sessionScope.forder.total}</b>
						</span> </a>
					</div>
					<!-- 小购物车结束 -->
					<!-- 搜索框 -->
					<div class="header_search">
						<div class="form-search ">
							<input value="请输入商品名称" class="input-text" type="text" />
							<button type="submit" title="Search"></button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 头部结束 -->
		<!-- 导航栏 -->
		<div class="navigation_container">
			<!---->
			<div class="nav">
				<ul class="primary_nav">
					<li class="active highlight"><a href="#">女装</a> <!--二级菜单-->
						<ul class="sub_menu">
							<li><a href="#">裙装</a>
								<ul>
									<li><a href="#">短裙</a>
									</li>
									<li><a href="#">短裤</a>
									</li>
									<li><a href="#">裤子</a>
									</li>
									<li><a href="#">卡其裤</a>
									</li>
									<li><a href="#">休闲裤</a>
									</li>
									<li><a href="#">牛仔裤</a>
									</li>
									<li><a href="#">风衣 & 运动夹克</a>
									</li>
								</ul>
							</li>
							<li><a href="#">装饰品</a>
								<ul>
									<li><a href="#">太阳镜</a>
									</li>
									<li><a href="#">围巾</a>
									</li>
									<li><a href="#">发饰品</a>
									</li>
									<li><a href="#">帽子和手套</a>
									</li>
									<li><a href="#">生活时尚</a>
									</li>
									<li><a href="#">牛仔系列</a>
									</li>
									<li><a href="#">风衣 & 西服</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!--二级菜单结束-->
					<li><a href="#">男装</a> <!--二级菜单-->
						<ul class="sub_menu">
							<li><a href="#">男士夏装</a>
								<ul>
									<li><a href="#">裤子</a>
									</li>
									<li><a href="#">休闲裤</a>
									</li>
									<li><a href="#">卡其裤</a>
									</li>
									<li><a href="#">牛仔裤</a>
									</li>
									<li><a href="#">风衣 & 运动夹克</a>
									</li>
								</ul>
							</li>
							<li><a href="#">装饰品</a>
								<ul>
									<li><a href="#">太阳镜</a>
									</li>
									<li><a href="#">围巾</a>
									</li>
									<li><a href="#">发饰品</a>
									</li>
									<li><a href="#">帽子和手套</a>
									</li>
									<li><a href="#">生活时尚</a>
									</li>
									<li><a href="#">牛仔系列</a>
									</li>
									<li><a href="#">风衣 & 西服</a>
									</li>
								</ul>
							</li>
						</ul> <!--二级菜单结束-->
					</li>
					<li><a href="#">儿童</a>
					</li>
					<li><a href="#">时尚</a>
					</li>
					<li><a href="#">装饰品</a>
					</li>
				</ul>
			</div>
		</div>
		<!--导航栏结束-->
		<div class="section_container">
			<!-- 用户注册页面 -->
			<div id="register">
				<div id="bg">
					<form action="http://www.hao123.com" method="post" id="ff">
						<div>
							<span>用户昵称：</span> 
							<input type="text" name="login" />
							<span>用户名要在6~12位之间</span>
						</div>
						<div>
							<span> 用户姓名： </span> 
							<input type="text" name="name" />
							<span>请填写真正的姓名，方便送货</span>
						</div>
						<div>
							<span> 用户密码： </span> 
							<input type="password" name="pass" /> 
							<span>密码长度 6 ~ 16 位之间</span>
						</div>
						<div>
							<span> 确认密码： </span> 
							<input type="password" name="pass2" /> 
							<span>重复输入以上的密码</span>
						</div>
						<div>
							<span> 通讯电话： </span> 
							<input type="text" name="phone" /> 
							<span>请填写手机号码</span>
						</div>
						<div>
							<span> 电子邮件： </span> 
							<input type="text" name="email" /> 
							<span>请填写正确的电子邮箱地址</span>
						</div>
						<div style="padding-left: 60px;">
							<input type="submit" value="注册" style="width:60px;height:30px" />
							&nbsp;&nbsp;
							<input type="reset" value="重置" style="width:60px;height:30px" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 导航栏结束 -->
	<div class="footer_container">
		<div class="footer">
			<ul class="footer_links">
				<li><span>收藏本店</span>
					<ul>
						<li><a href="#">服装</a>
						</li>
						<li><a href="#">鞋子</a>
						</li>
						<li><a href="#">包包</a>
						</li>
						<li><a href="#">装饰品</a>
						</li>
						<li><a href="#">channel</a>
						</li>
						<li><a href="#">prada</a>
						</li>
						<li><a href="#">LV</a>
						</li>
					</ul>
				</li>
				<li class="seperator"><span>出售的品牌</span>
					<ul>
						<li><a href="#">Elle</a>
						</li>
						<li><a href="#">Reallxe</a>
						</li>
						<li><a href="#">Fabric</a>
						</li>
						<li><a href="#">Mayflower</a>
						</li>
						<li><a href="#">Levis Strauss</a>
						</li>
						<li><a href="#">Anzonica</a>
						</li>
						<li><a href="#">Reallxe</a>
						</li>
						<li><a href="#">Fabric</a>
						</li>
					</ul>
				</li>
				<li><span>客户服务</span>
					<ul>
						<li><a href="#">帮助</a>
						</li>
						<li><a href="#">速递</a>
						</li>
						<li><a href="#">退换货</a>
						</li>
						<li><a href="#">付款方式</a>
						</li>
						<li><a href="#">订单跟踪</a>
						</li>
						<li><a href="#">礼物包选项</a>
						</li>
						<li><a href="#">国际服务</a>
						</li>
						<li><a href="#">退运险</a>
						</li>
					</ul>
				</li>
				<li><span>个人账户</span>
					<ul>
						<li><a href="#">个人账户信息</a>
						</li>
						<li><a href="#">用户密码</a>
						</li>
						<li><a href="#">订单历史</a>
						</li>
						<li><a href="#">付款方式</a>
						</li>
						<li><a href="#">我的收货地址</a>
						</li>
						<li><a href="#">我的通知</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
