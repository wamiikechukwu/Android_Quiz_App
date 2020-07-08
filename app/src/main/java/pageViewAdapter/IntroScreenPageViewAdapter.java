package pageViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.wamiikechukwukanu.quizapp.Intro_Screen.introScreenDataModel;
import com.wamiikechukwukanu.quizapp.R;

import java.util.List;

public class IntroScreenPageViewAdapter extends PagerAdapter {

    Context mContext;
    List<introScreenDataModel> mDataModel;

    public IntroScreenPageViewAdapter(Context mContext, List<introScreenDataModel> mDataModel) {
        this.mContext = mContext;
        this.mDataModel = mDataModel;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = layoutInflater.inflate(R.layout.intro_screens, null);

        ImageView imageSlide = layoutScreen.findViewById(R.id.intro_screen_image);
        TextView middleText = layoutScreen.findViewById(R.id.intro_screen_middle_text);
        TextView lowerText = layoutScreen.findViewById(R.id.intro_screen_lower_text);

        middleText.setText(mDataModel.get(position).getTitle());
        lowerText.setText(mDataModel.get(position).getDescrip());
        imageSlide.setImageResource(mDataModel.get(position).getScreenImage());

        container.addView(layoutScreen);

        return layoutScreen;
    }

    @Override
    public int getCount() {
        return mDataModel.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
