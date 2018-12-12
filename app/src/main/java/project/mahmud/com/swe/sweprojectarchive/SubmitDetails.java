package project.mahmud.com.swe.sweprojectarchive;

public class SubmitDetails {
    private String title,language,des;

    public SubmitDetails(String title, String language, String des) {
        this.title = title;
        this.language = language;
        this.des = des;
    }

    public SubmitDetails() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
