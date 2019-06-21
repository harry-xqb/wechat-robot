package cn.zhouyafeng.itchat4j.beans.tulin;

/**
 * description: 图灵机器人 个人信息
 * author: Harry
 * Date time:6/21/19 2:13 PM
 */
public class SelfInfo {
    private Location location;

    public SelfInfo(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SelfInfo() {
    }
}
