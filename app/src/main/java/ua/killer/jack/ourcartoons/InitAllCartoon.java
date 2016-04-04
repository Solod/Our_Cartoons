package ua.killer.jack.ourcartoons;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jack on 04.04.16.
 */
public class InitAllCartoon {

    public static List<Cartoon> fabric(Context context) {
        List<Cartoon> list = new LinkedList<>();
        list.add(new Cartoon(
                        Cartoons.LUNTIK,
                        context.getResources().getString(R.string.cartoon_luntik),
                        R.drawable.img_mini_luntik
                )
        );
        list.add(new Cartoon(
                        Cartoons.SMESHARIKI,
                        context.getResources().getString(R.string.cartoon_smeshariki),
                        R.drawable.img_mini_smeshariki
                )
        );
        list.add(new Cartoon(
                        Cartoons.FIXIKI,
                        context.getResources().getString(R.string.cartoon_fixiki),
                        R.drawable.img_mini_fixiki
                )
        );
        return list;
    }
}
