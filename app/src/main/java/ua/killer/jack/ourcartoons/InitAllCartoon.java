package ua.killer.jack.ourcartoons;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jack on 04.04.16.
 */
public class InitAllCartoon {
    private static InitAllCartoon mInitAllCartoon = null;
    Context mContext;
    private List<Cartoon> mList;

    private InitAllCartoon(Context context) {
        mContext = context;
        fabric(context);
    }

    public static InitAllCartoon newInstance(Context context) {
        if (mInitAllCartoon == null) {
            mInitAllCartoon = new InitAllCartoon(context);
        }
        return mInitAllCartoon;
    }

    private void fabric(Context context) {
        mList = new LinkedList<>();
        mList.add(new Cartoon(
                        Cartoons.LUNTIK,
                        context.getResources().getString(R.string.cartoon_luntik),
                        R.drawable.img_mini_luntik,
                        getPicturesLuntik(),
                        context.getResources().getString(R.string.url_luntik),
                        context.getResources().getString(R.string.description_luntik)
                )
        );
        mList.add(new Cartoon(
                        Cartoons.SMESHARIKI,
                        context.getResources().getString(R.string.cartoon_smeshariki),
                        R.drawable.img_mini_smeshariki,
                        getPicturesSmeshariki(),
                        context.getResources().getString(R.string.url_smeshariki),
                        context.getResources().getString(R.string.description_smeshariki))
        );
        mList.add(new Cartoon(
                        Cartoons.FIXIKI,
                        context.getResources().getString(R.string.cartoon_fixiki),
                        R.drawable.img_mini_fixiki,
                        getPicturesFixiki(),
                        context.getResources().getString(R.string.url_fixiki),
                        context.getResources().getString(R.string.description_fixiki))
        );
    }

    private List<Integer> getPicturesLuntik() {
        List<Integer> list = new LinkedList<>();
        list.add(R.drawable.luntik_1);
        list.add(R.drawable.luntik_2);
        list.add(R.drawable.luntik_3);
        list.add(R.drawable.luntik_4);
        list.add(R.drawable.luntik_5);
        return list;
    }

    private List<Integer> getPicturesSmeshariki() {
        List<Integer> list = new LinkedList<>();
        list.add(R.drawable.smeshariki_1);
        list.add(R.drawable.smeshariki_2);
        list.add(R.drawable.smeshariki_3);
        list.add(R.drawable.smeshariki_4);
        list.add(R.drawable.smeshariki_5);
        return list;
    }

    private List<Integer> getPicturesFixiki() {
        List<Integer> list = new LinkedList<>();
        list.add(R.drawable.fixiki_1);
        list.add(R.drawable.fixiki_2);
        list.add(R.drawable.fixiki_3);
        list.add(R.drawable.fixiki_4);
        list.add(R.drawable.fixiki_5);
        return list;
    }

    public List<Cartoon> getList() {
        return mList;
    }
}
