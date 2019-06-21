package cn.zhouyafeng.itchat4j.beans.tulin;

/**
 * description: 图灵机器人用户信息
 * author: Harry
 * Date time:6/21/19 2:08 PM
 */
public class UserInfo {

    private String apiKey;

    private String userId;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserInfo() {
    }

    public UserInfo(String apiKey, String userId) {

        this.apiKey = apiKey;
        this.userId = userId;
    }
}
