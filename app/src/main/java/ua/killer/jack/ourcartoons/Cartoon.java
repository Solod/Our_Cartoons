package ua.killer.jack.ourcartoons;

import java.util.List;

/**
 * Created by jack on 04.04.16.
 */
public class Cartoon {
    private String mDescriptionText;
    private Cartoons mCartoons;
    private int mMiniIMG;
    private String mTitle;
    private List<Integer> mScreens;
    private String mLink;

    public Cartoon(Cartoons cartoon, String title, int resoursImg, List<Integer> screensList, String url, String description) {
        mCartoons = cartoon;
        mTitle = title;
        mMiniIMG = resoursImg;
        mScreens = screensList;
        mLink = url;
        mDescriptionText = description;
    }

    public Cartoons getCartoons() {
        return mCartoons;
    }

    public void setCartoons(Cartoons mCartoons) {
        this.mCartoons = mCartoons;
    }

    public int getMiniIMG() {
        return mMiniIMG;
    }

    public void setMiniIMG(int mMiniIMG) {
        this.mMiniIMG = mMiniIMG;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public List<Integer> getScreens() {
        return mScreens;
    }

    public void setScreens(List<Integer> mScreens) {
        this.mScreens = mScreens;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmDescriptionText() {
        return mDescriptionText;
    }

    public void setDescriptionText(String mDescriptionText) {
        this.mDescriptionText = mDescriptionText;
    }
}
