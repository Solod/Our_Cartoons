package ua.killer.jack.ourcartoons;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jack on 04.04.16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private List<Cartoon> mCartoonList;

    MyRecyclerAdapter(List<Cartoon> cartoonList) {
        mCartoonList = cartoonList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cartoon cartoon = mCartoonList.get(position);
        holder.imageView.setImageResource(cartoon.getMiniIMG());
        holder.textView.setText(cartoon.getTitle());
    }

    @Override
    public int getItemCount() {
        return mCartoonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_mini);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
