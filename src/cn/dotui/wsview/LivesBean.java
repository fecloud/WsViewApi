/**
 * LivesBean.java Created on 2015-11-18
 */
package cn.dotui.wsview;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * The class <code>LivesBean</code>
 * 
 * @author Feng OuYang
 * @version 1.0
 */
@XStreamAlias("PRespVULL")
public class LivesBean {

	@XStreamAlias("resultCode")
	private int resultCode;

	@XStreamAlias("resultMsg")
	private String resultMsg;// string 应该描述 对返回信息进行描述

	@XStreamAlias("resultCount")
	private int resultCount;// 记录条数

	@XStreamImplicit()  
	private List<LiveInfoBean> contUL; // 节目信息 以列表形式返回多条记录

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

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public List<LiveInfoBean> getContUL() {
		return contUL;
	}

	public void setContUL(List<LiveInfoBean> contUL) {
		this.contUL = contUL;
	}

	@Override
	public String toString() {
		return "LivesBean [resultCode=" + resultCode + ", resultMsg="
				+ resultMsg + ", resultCount=" + resultCount + ", contUL="
				+ contUL + "]";
	}

}
