package project.mahmud.com.swe.sweprojectarchive;

import android.content.Context;

public class ProjectModel
{
    String text1,text2,text3;
    Context context;

    public ProjectModel(String text1, String text2, String text3) {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.context = context;
    }
    public ProjectModel(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.context = context;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }
}