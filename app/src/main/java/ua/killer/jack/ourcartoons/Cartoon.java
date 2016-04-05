package ua.killer.jack.ourcartoons;

import java.util.List;

/**
 * Created by jack on 04.04.16.
 */
public class Cartoon {
    private Cartoons mCartoons;
    private int mMiniIMG;
    private String mTitle;
    private List<Integer> mScrins;
    private String mLink;

    public Cartoon(Cartoons cartoon, String title, int resoursImg, List<Integer> resourseList, String url) {
        mCartoons = cartoon;
        mTitle = title;
        mMiniIMG = resoursImg;
        mScrins = resourseList;
        mLink = url;
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

    public List<Integer> getScrins() {
        return mScrins;
    }

    public void setScrins(List<Integer> mScrins) {
        this.mScrins = mScrins;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String mLink) {
        this.mLink = mLink;
    }
}
