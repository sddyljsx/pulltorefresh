package neal.ui.adapterview;

import android.content.Context;
import android.util.AttributeSet;

import neal.ui.adapterview.core.PullToRefreshLayout;

/**
 * Created by neal on 2014/12/23.
 */
public class GridView extends PullToRefreshLayout {
    private Context context;
    public GridView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public GridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context=context;
        init();
    }
    @Override
    public void init() {
        setContentView(new android.widget.GridView(context));
        super.init();
    }
    public android.widget.GridView getGridView(){
        return (android.widget.GridView)contentView;
    }
}
