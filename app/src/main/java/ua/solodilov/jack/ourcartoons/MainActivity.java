package ua.solodilov.jack.ourcartoons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String SEL_CARTOON = "selected cartoon ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        List<Cartoon> list = InitAllCartoon.newInstance(this).getList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.select_cartoon);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new MyRecyclerAdapter(this, list));
        }
    }
}
