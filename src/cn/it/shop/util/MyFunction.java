package cn.it.shop.util;
/*
 * 自定义函数: 所有的方法都为静态方法
 * */
public class MyFunction {
	
	public static boolean contains(int rid,int[] myRid){
		for(int my:myRid){
			// 当前管理员拥有当前角色
			if(my==rid){
				return true;
			}
		}
		return false;
	}
}
