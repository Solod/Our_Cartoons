package ua.killer.jack.ourcartoons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.List;

public class DescriptionActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory, View.OnClickListener {

    private ImageSwitcher mImageSwitcher;
    private ImageButton mImageButtonRight;
    private ImageButton mImageButtonLeft;
    private int mSelectPositionImg = 0;
    private Cartoon mCartoon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent intent = getIntent();
        mCartoon = getCartoons(intent);
        initView();
        initListener();
    }

    private void initListener() {
        mImageButtonRight.setOnClickListener(this);
        mImageButtonLeft.setOnClickListener(this);
    }

    private Cartoon getCartoons(Intent intent) {
        List<Cartoon> allCartoon = InitAllCartoon.newInstance(this).getList();
        Cartoon resCartoon;
        if (intent != null) {
            Cartoons cartoons = (Cartoons) intent.getSerializableExtra(MainActivity.SEL_CARTOON);
            for (Cartoon cartoon : allCartoon) {
                if (cartoon.getCartoons() == cartoons) {
                    resCartoon = cartoon;
                    return resCartoon;
                }
            }
        }
        return allCartoon.get(0);
    }

    private void initView() {
        mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        if (mImageSwitcher != null) {
            mImageSwitcher.setFactory(this);
            mImageSwitcher.setImageResource(mCartoon.getScrins().get(mSelectPositionImg));
        }
        mImageButtonLeft = (ImageButton) findViewById(R.id.btn_switch_left);
        mImageButtonRight = (ImageButton) findViewById(R.id.btn_switch_right);
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        return imageView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_switch_right:
                if (mSelectPositionImg < mCartoon.getScrins().size() - 1) {
                    mImageSwitcher.setImageResource(mCartoon.getScrins().get(++mSelectPositionImg));
                }
                break;
            case R.id.btn_switch_left:
                if (mSelectPositionImg > 0) {
                    mImageSwitcher.setImageResource(mCartoon.getScrins().get(--mSelectPositionImg));
                }
                break;
            default:
        }
    }
}
