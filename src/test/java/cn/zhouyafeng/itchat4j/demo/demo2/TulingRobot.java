package cn.zhouyafeng.itchat4j.demo.demo2;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import cn.zhouyafeng.itchat4j.beans.tulin.InputText;
import cn.zhouyafeng.itchat4j.beans.tulin.Perception;
import cn.zhouyafeng.itchat4j.beans.tulin.UserInfo;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.itchat4j.Wechat;
import cn.zhouyafeng.itchat4j.beans.BaseMsg;
import cn.zhouyafeng.itchat4j.core.Core;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;
import cn.zhouyafeng.itchat4j.utils.MyHttpClient;
import cn.zhouyafeng.itchat4j.utils.enums.MsgTypeEnum;
import cn.zhouyafeng.itchat4j.utils.tools.DownloadTools;

/**
 * 图灵机器人示例
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年4月24日 上午12:13:26
 * @version 1.0
 *
 */
public class TulingRobot implements IMsgHandlerFace {
	Logger logger = Logger.getLogger("TulingRobot");
	MyHttpClient myHttpClient = Core.getInstance().getMyHttpClient();
	String url = "http://openapi.tuling123.com/openapi/api/v2";
	String apiKey = "ec79cf4707ea4b14959a8e43169cb461"; // 这里是我申请的图灵机器人API接口，每天只能5000次调用，建议自己去申请一个，免费的:)
	String userId = "468473";
	@Override
	public String textMsgHandle(BaseMsg msg) {
		String result = "";
		String text = msg.getText();
		Map<String, Object> paramMap = new HashMap<>(16);
		paramMap.put("info", text);
		paramMap.put("userInfo", new UserInfo(apiKey, userId));
		Perception perception = new Perception();
		perception.setInputText(new InputText(text));
		paramMap.put("perception", perception);
		String paramStr = JSON.toJSONString(paramMap);
		try {
			HttpEntity entity = myHttpClient.doPost(url, paramStr);
			result = EntityUtils.toString(entity, "UTF-8");
			JSONObject obj = JSON.parseObject(result);
			System.out.println("obj:" + obj);
			if (obj.getString("code").equals("100000")) {
				result = obj.getString("text");
			} else {
				result = "处理有误";
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	@Override
	public String picMsgHandle(BaseMsg msg) {
		return "收到图片";
	}

	@Override
	public String voiceMsgHandle(BaseMsg msg) {
		String fileName = String.valueOf(new Date().getTime());
		String voicePath = "/home/harry/Desktop/wechat-code/chat-voice" + File.separator + fileName + ".mp3";
		DownloadTools.getDownloadFn(msg, MsgTypeEnum.VOICE.getType(), voicePath);
		return "收到语音";
	}

	@Override
	public String viedoMsgHandle(BaseMsg msg) {
		String fileName = String.valueOf(new Date().getTime());
		String viedoPath = "/home/harry/Desktop/wechat-code/chat-viedo" + File.separator + fileName + ".mp4";
		DownloadTools.getDownloadFn(msg, MsgTypeEnum.VIEDO.getType(), viedoPath);
		return "收到视频";
	}

	public static void main(String[] args) {
		IMsgHandlerFace msgHandler = new TulingRobot();
		Wechat wechat = new Wechat(msgHandler, "/home/harry/Desktop/wechat-code/chat-file");
		wechat.start();
	}

	@Override
	public String nameCardMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sysMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public String verifyAddFriendMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mediaMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
