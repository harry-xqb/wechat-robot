package cn.zhouyafeng.itchat4j.beans.tulin;

/**
 * description: 图灵机器人 位置信息
 * author: Harry
 * Date time:6/21/19 2:14 PM
 */
public class Location {

    private String city;

    private String province;

    private String street;

    public Location(String city, String province, String street) {
        this.city = city;
        this.province = province;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Location() {

    }
}
