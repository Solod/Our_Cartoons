package ua.solodilov.jack.ourcartoons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.List;

public class DescriptionActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory, View.OnClickListener {

    private ImageSwitcher mImageSwitcher;
    private ImageButton mImageButtonRight;
    private ImageButton mImageButtonLeft;
    private TextView mTextViewUrl;
    private TextView mTextViewDescription;


    private int mSelectPositionImg = 0;
    private Cartoon mCartoon;
    private ImageButton mImageButtonNext;
    private ImageButton mImageButtonPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent intent = getIntent();
        mCartoon = getCartoons(intent);
        setTitle(mCartoon.getTitle());
        findViews();
        initView();
        initListener();
    }

    private void findViews() {
        mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        mImageButtonLeft = (ImageButton) findViewById(R.id.btn_switch_left);
        mImageButtonRight = (ImageButton) findViewById(R.id.btn_switch_right);
        mImageButtonNext = (ImageButton) findViewById(R.id.btn_next);
        mImageButtonPrev = (ImageButton) findViewById(R.id.btn_prev);
        mTextViewUrl = (TextView) findViewById(R.id.link);
        mTextViewDescription = (TextView) findViewById(R.id.tv_description_text);

    }

    private void initView() {
        if (mImageSwitcher != null) {
            mImageSwitcher.setFactory(this);
            mImageSwitcher.setImageResource(mCartoon.getScreens().get(mSelectPositionImg));
        }
        mTextViewUrl.setText(mCartoon.getLink());
        mTextViewDescription.setText(mCartoon.getmDescriptionText());


    }

    private void initListener() {
        mImageButtonRight.setOnClickListener(this);
        mImageButtonLeft.setOnClickListener(this);
        mImageButtonNext.setOnClickListener(this);
        mImageButtonPrev.setOnClickListener(this);
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
                if (mSelectPositionImg < mCartoon.getScreens().size() - 1) {
                    mImageSwitcher.setImageResource(mCartoon.getScreens().get(++mSelectPositionImg));
                }
                break;
            case R.id.btn_switch_left:
                if (mSelectPositionImg > 0) {
                    mImageSwitcher.setImageResource(mCartoon.getScreens().get(--mSelectPositionImg));
                }
                break;
            case R.id.btn_next:
                if (mCartoon.getCartoons().ordinal() < Cartoons.values().length - 1) {
                    Intent intent = new Intent(this, DescriptionActivity.class);
                    Cartoons cartoonsArr[] = Cartoons.values();
                    Cartoons cartoonsNext = cartoonsArr[mCartoon.getCartoons().ordinal() + 1];
                    intent.putExtra(MainActivity.SEL_CARTOON, cartoonsNext);
                    startActivity(intent);
                }
                break;
            case R.id.btn_prev:
                finish();
                break;

            default:
        }
    }
}
