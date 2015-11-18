/**
 * DeleteLiveBean.java Created on 2015-11-18
 */
package cn.dotui.wsview;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The class <code>DeleteLiveBean</code>
 * 
 * @author Feng OuYang
 * @version 1.0
 */
@XStreamAlias("PRespVULD")
public class DeleteLiveBean {

	@XStreamAlias("resultCode")
	private int resultCode;

	@XStreamAlias("resultMsg")
	private String resultMsg;

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

	@Override
	public String toString() {
		return "DeleteLiveBean [resultCode=" + resultCode + ", resultMsg="
				+ resultMsg + "]";
	}

}
