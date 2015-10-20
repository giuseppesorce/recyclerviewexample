package com.gsorce.recyclerviewexample;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Giuseppe Sorce  on 20/10/15.
 */
public class AnimationUtils {

    public void animate(RecyclerView.ViewHolder holder, boolean godown){
        slidingAmimation(holder, godown);
    }

    private void slidingAmimation(RecyclerView.ViewHolder holder, boolean godown) {

        ObjectAnimator animatorTranslateY= ObjectAnimator.ofFloat(holder.itemView, "translationY", godown ? 200 : -200, 0);
        animatorTranslateY.setDuration(700);
        animatorTranslateY.start();
    }
}
