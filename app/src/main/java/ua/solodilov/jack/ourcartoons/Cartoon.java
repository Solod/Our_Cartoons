package ua.solodilov.jack.ourcartoons;

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

    public int getMiniIMG() {
        return mMiniIMG;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<Integer> getScreens() {
        return mScreens;
    }

    public String getLink() {
        return mLink;
    }

    public String getmDescriptionText() {
        return mDescriptionText;
    }
}
