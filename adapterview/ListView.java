package neal.ui.adapterview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import neal.ui.adapterview.core.PullToRefreshLayout;
import neal.utils.VersionUtil;
import pku.isharebook.R;

/**
 * Created by neal on 2014/12/23.
 */
public class ListView extends PullToRefreshLayout {
    private Context context;
    public ListView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public ListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public ListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context=context;
        init();
    }

    @Override
    public void init() {
        android.widget.ListView listView=new android.widget.ListView(context);
        listView.setDividerHeight(0);
        listView.setVerticalScrollBarEnabled(true);
        setContentView(listView);
        super.init();
    }

    public android.widget.ListView getListView(){
        return (android.widget.ListView)contentView;
    }
}
