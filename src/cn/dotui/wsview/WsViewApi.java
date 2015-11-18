/**
 * WsViewApi.java Created on 2015-11-18
 */
package cn.dotui.wsview;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * The class <code>WsViewApi</code> 万视直播api
 * 
 * @author Feng OuYang
 * @version 1.0
 */
public class WsViewApi {

	/**
	 * 设置请求超时时间
	 */
	public static int HTTP_CONNECTTIMEOUT = 10000;

	/**
	 * 设置连接读取超时时间
	 */
	public static int HTTP_READTIMEOUT = 10000;

	private static String urlEncoder(String str) {
		if (null != str) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}

	// private static String urlDecoder(String str) {
	// if (null != str) {
	// try {
	// return URLDecoder.decode(str, "UTF-8");
	// } catch (UnsupportedEncodingException e) {
	// }
	// }
	// return null;
	// }

	/**
	 * http get
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	private static String httpGet(String url) {
		if (url != null) {
			HttpURLConnection conn = null;
			try {
				conn = (HttpURLConnection) new URL(url).openConnection();
				conn.setDoInput(true);
				conn.setDoOutput(false);
				conn.setConnectTimeout(HTTP_CONNECTTIMEOUT);
				conn.setReadTimeout(HTTP_READTIMEOUT);
				conn.connect();

				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					final ByteArrayOutputStream out = new ByteArrayOutputStream();
					final InputStream in = conn.getInputStream();
					final byte[] buffer = new byte[1024 * 2];
					int len = -1;
					while (-1 != (len = in.read(buffer))) {
						out.write(buffer, 0, len);
					}

					return new String(out.toByteArray(), "UTF-8");
				}
			} catch (IOException e) {
			} finally {
				if (null != conn) {
					conn.disconnect();
				}
			}
		}
		return null;
	}

	/**
	 * 获取token(注意token 十分钟后就过期了)
	 * 
	 * @param userName
	 *            用户名(注意请不要用中文)
	 * @param password
	 *            用户密码
	 * @return
	 * @throws IOException
	 */
	public String getToken(String userName, String password) throws IOException {
		if (userName != null && password != null) {
			final String url = String
					.format("http://open.wsview.com:8090/iWSViewPortalData?bizCode=IPUQXC&pReqQXC.userName=%s&pReqQXC.password=%s",
							userName, MD5.md5(password).toLowerCase());
			final String result = httpGet(url);

			if (null != result) {
				XStream stream = new XStream(new DomDriver());
				// 指定使用别名
				stream.autodetectAnnotations(true);
				stream.alias("PRespQXC", ToKenBean.class);
				ToKenBean toKenBean = (ToKenBean) stream.fromXML(result);
				if (null != toKenBean && toKenBean.getResultCode() == 0) {
					return toKenBean.getToken();
				} else {
					throw new IOException(result);
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * 
	 * @param userName
	 * @param token
	 * @param liveName
	 *            直播名称(名称最长不超过20个字符)
	 * @param liveStreamName
	 *            标签(最大25个字符；默认标签为720P)
	 * @return
	 * @throws IOException
	 */
	public String createLive(String userName, String token, String liveName,
			String liveStreamName) throws IOException {
		if (liveName != null) {
			final String url = String
					.format("http://open.wsview.com:8090/iWSViewPortalData?bizCode=IPVULC&userName=%s&pReqVULC.liveName=%s&token=%s&pReqVULC.liveStreamName=%s&pReqVULC.liveType=1",
							userName, urlEncoder(liveName), token,
							urlEncoder(liveStreamName == null ? ""
									: liveStreamName));
			final String result = httpGet(url);

			if (null != result) {
				XStream stream = new XStream(new DomDriver());
				// 指定使用别名
				stream.autodetectAnnotations(true);
				stream.alias("PRespVULC", CreateLiveBean.class);
				CreateLiveBean createLiveBean = (CreateLiveBean) stream
						.fromXML(result);
				if (null != createLiveBean
						&& createLiveBean.getResultCode() == 0) {
					return createLiveBean.getLiveID();
				} else {
					throw new IOException(result);
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * 取直播室信息
	 * 
	 * @param userName
	 * @param token
	 * @param liveID
	 *            直播id
	 * @return
	 * @throws IOException
	 */
	public LiveInfoBean getLiveInfo(String userName, String token, String liveID)
			throws IOException {
		if (liveID != null) {
			final String url = String
					.format("http://open.wsview.com:8090/iWSViewPortalData?bizCode=IPVULL&userName=%s&token=%s&pReqVULL.liveID=%s",
							userName, token, liveID);
			final String result = httpGet(url);

			if (null != result) {
				XStream stream = new XStream(new DomDriver());
				// 指定使用别名
				stream.autodetectAnnotations(true);
				stream.alias("PRespVULL", LivesBean.class);
				stream.alias("contUL", LiveInfoBean.class);
				LivesBean livesBean = (LivesBean) stream.fromXML(result);
				if (null != livesBean && livesBean.getResultCode() == 0) {
					if (livesBean.getContUL() != null
							&& livesBean.getContUL().size() > 0) {
						return livesBean.getContUL().get(0);
					}
				} else {
					throw new IOException(result);
				}
			}
		}
		return null;
	}

	/**
	 * 删除直播
	 * 
	 * @param userName
	 * @param token
	 * @param liveID
	 *            直播id
	 * @return
	 * @throws IOException
	 */
	public boolean deleteLive(String userName, String token, String... liveID)
			throws IOException {
		if (liveID != null && liveID.length > 0) {
			final StringBuilder builder = new StringBuilder();
			for (int i = 0; i < liveID.length; i++) {
				builder.append(liveID[i]);
				if (i != 0) {
					builder.append(",");
				}
			}
			final String url = String
					.format("http://open.wsview.com:8090/iWSViewPortalData?bizCode=IPVULD&userName=%s&token=%s&pReqVULD.liveID=%s",
							userName, token, builder.toString());
			final String result = httpGet(url);

			if (null != result) {
				XStream stream = new XStream(new DomDriver());
				// 指定使用别名
				stream.autodetectAnnotations(true);
				stream.alias("PRespVULD", DeleteLiveBean.class);
				final DeleteLiveBean deleteLiveBean = (DeleteLiveBean) stream
						.fromXML(result);
				if (null != deleteLiveBean
						&& deleteLiveBean.getResultCode() == 0) {
					return true;
				} else {
					throw new IOException(result);
				}
			}
		}
		return false;
	}
}
