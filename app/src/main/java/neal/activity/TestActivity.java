package neal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import neal.adapterview.ListView;
import neal.adapterview.core.PullToRefreshLayout;
import neal.pulltorefresh.R;

/**
 * Created by neal on 2015/4/17.
 */
public class TestActivity extends Activity {
    public ArrayList<Integer> listData=new ArrayList<>();
    int count=10;
    ImageAdapter imageAdapter;
    ListView imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<count;i++){
            listData.add(i);
        }
        imageList=(ListView)findViewById(R.id.image_list);
        imageAdapter=new ImageAdapter();
        imageList.getListView().setAdapter(imageAdapter);
        imageList.setLoadDataListener(new PullToRefreshLayout.LoadDataListener() {
            @Override
            //下拉刷新调用
            public void onRefresh() {
                //模拟1秒的时间加载数据
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadDate(true);
                    }
                },1000);
            }

            @Override
            //下拉加载更多调用
            public void onLoadMore() {
                //模拟1秒的时间加载数据
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadDate(false);
                    }
                },1000);

            }
        });
        //模拟1秒的时间加载数据
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadDate(true);
            }
        },1000);

    }

    private class ImageAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if(convertView==null){
                convertView= View.inflate(TestActivity.this, R.layout.image_list_item, null);
                viewHolder=new ViewHolder();
                viewHolder.imageListImage=(ImageView)convertView.findViewById(R.id.image_list_image);
                viewHolder.imageListText=(TextView)convertView.findViewById(R.id.image_list_text);
                convertView.setTag(viewHolder);
            }else{
                viewHolder=(ViewHolder)convertView.getTag();
            }
            viewHolder.imageListText.setText("item"+position);
            return convertView;
        }

        private class ViewHolder{
            ImageView imageListImage;
            TextView imageListText;
        }
    }

    /**
     * 模拟加载数据
     * @param needFresh 是否需要刷新清空数据还是继续增加数据
     */
    public void loadDate(final boolean needFresh){

        //刷新，则清空数据
        if (needFresh) {
            listData.clear();
        }
        //将新数据全部加入
        for(int i=0;i<count;i++){
            listData.add(i);
        }
        imageAdapter.notifyDataSetChanged();
        //是否需要更新和是否还有更多内容
        imageList.onLoadComplete(needFresh, true);

    }
}
