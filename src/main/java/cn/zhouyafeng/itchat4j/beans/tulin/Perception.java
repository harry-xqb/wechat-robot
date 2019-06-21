package cn.zhouyafeng.itchat4j.beans.tulin;

import jdk.internal.util.xml.impl.Input;

/**
 * description: 图灵机器人 输入信息
 * author: Harry
 * Date time:6/21/19 2:10 PM
 */
public class Perception {

    private InputText inputText;

    private InputImage inputImage;

    public Perception(InputText inputText, InputImage inputImage) {
        this.inputText = inputText;
        this.inputImage = inputImage;
    }

    public Perception() {
    }

    public InputText getInputText() {
        return inputText;
    }

    public void setInputText(InputText inputText) {
        this.inputText = inputText;
    }

    public InputImage getInputImage() {
        return inputImage;
    }

    public void setInputImage(InputImage inputImage) {
        this.inputImage = inputImage;
    }
}
