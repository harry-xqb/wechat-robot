package cn.zhouyafeng.itchat4j.beans.tulin;

/**
 * description: 文本信息
 * author: Harry
 * Date time:6/21/19 2:11 PM
 */
public class InputText {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public InputText(String text) {
        this.text = text;
    }

    public InputText() {
    }
}
