package edu.guosong.sc.hijklmncommon.param;

public enum ResultParam {

	success(1, "成功"), nooperate(0, "无操作"), syserr(-1, "系统错误！"), sessionexpires(-2, "会话过期！"), invalidaccoundorpwd(-3,
			"账户名或者密码错误！"), emptyparam(-4, "请求参数为空！"), invalidparam(-5, "请求参数不合法！");

	private Integer code;

	private String desc;

	private ResultParam(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer code() {
		return this.code;
	}

	public String desc() {
		return this.desc;
	}

}
