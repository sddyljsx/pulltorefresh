package neal.ui.adapterview.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import pku.isharebook.R;

/**
 * Created by neal on 2014/12/23.
 */
public class FooterLayout extends FrameLayout {
    private Context context;
    public FooterLayout(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public FooterLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public FooterLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context=context;
        init();
    }

    public void init(){
        LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_footer_view, this);
    }
}
