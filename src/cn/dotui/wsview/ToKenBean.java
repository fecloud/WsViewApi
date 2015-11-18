/**
 * ToKenBean.java Created on 2015-11-18
 */
package cn.dotui.wsview;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The class <code>ToKenBean</code>
 * 
 * @author Feng OuYang
 * @version 1.0
 */
@XStreamAlias("PRespQXC")
public class ToKenBean {

	@XStreamAlias("resultCode")
	private int resultCode;

	@XStreamAlias("resultMsg")
	private String resultMsg;

	@XStreamAlias("token")
	private String token;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ToKenBean [resultCode=" + resultCode + ", resultMsg="
				+ resultMsg + ", token=" + token + "]";
	}

}
