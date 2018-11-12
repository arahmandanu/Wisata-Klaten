package adrian.com.wisataklaten;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class BannerAdapter extends SliderAdapter {
    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        switch (position){
            case 0:
                imageSlideViewHolder.bindImageSlide("http://wisata-klaten.site/gambar/jombor.jpg");
                break;
            case 1:
                imageSlideViewHolder.bindImageSlide("http://wisata-klaten.site/gambar/plaosan.jpg");
                break;
            case 2:
                imageSlideViewHolder.bindImageSlide("http://wisata-klaten.site/gambar/perwari.jpeg");
                break;
        }
    }
}
