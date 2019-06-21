package cn.zhouyafeng.itchat4j.beans.tulin;

/**
 * description: 图片信息
 * author: Harry
 * Date time:6/21/19 2:12 PM
 */
public class InputImage {

    private String url;

    public InputImage(String url) {
        this.url = url;
    }

    public InputImage() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
