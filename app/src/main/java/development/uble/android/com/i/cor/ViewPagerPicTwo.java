package development.uble.android.com.i.cor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ederpadilla on 11/01/17.
 */

public class ViewPagerPicTwo extends Fragment {

    @BindView(R.id.image_pager_two)
    ImageView image_pager_two;

    private String url_two="http://www.zeleb.mx/sites/default/files/styles/news_main_image/public/jime.jpg?itok=5gi1lfwT";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_pic_two,container,false);
        ButterKnife.bind(this,view);
        setImages();
        return view;
    }

    private void setImages(){
        Glide.with(getActivity())
                .load(url_two)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                        return false;
                    }
                })
                .into(image_pager_two);
    }

    public static ViewPagerPicTwo newInstance() {
        ViewPagerPicTwo viewPager_pic_two = new ViewPagerPicTwo();
        return viewPager_pic_two;
    }
}
