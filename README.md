# pulltorefresh
Android下拉刷新库，利用viewdraghelper实现

集成了下拉刷新，底部加载更多，以及刚进入加载数据的loadview。包括了listview与gridview的改写。

效果1：

![](https://github.com/sddyljsx/pulltorefresh/blob/master/001.png?raw=true)


效果2：

![](https://github.com/sddyljsx/pulltorefresh/blob/master/002.png?raw=true)


效果3：

![](https://github.com/sddyljsx/pulltorefresh/blob/master/003.png?raw=true)


效果4：

![](https://github.com/sddyljsx/pulltorefresh/blob/master/004.png?raw=true)


效果5：

![](https://github.com/sddyljsx/pulltorefresh/blob/master/005.png?raw=true)

**使用说明:**


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

