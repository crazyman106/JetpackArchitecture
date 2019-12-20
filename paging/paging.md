
* PagedList:异步加载页面中的数据集合,PagedList可以用来从我们定义的源加载数据，并在UI中使用一个RecyclerView轻松地呈现它。
* DataSource,DataSource.Factory:DataSource 是将加载数据快照映射到PagedList的基类,DataSource.Factory是创建DataSource的工厂
* LivePagedListBuilder:构建一个LiveData <PagedList>,基于DataSource.Factory和PagedList.Config
* BoundaryCallback:当PagedList到达可用数据的末端时发出信号。
* PagedListAdapter:  