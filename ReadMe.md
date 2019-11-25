 * @InverseMethod
 作用:数据格式转换
 例如:
 Edittext中的text为String类型,但是我们viewmodel中的data是其他类型,这是就需要转换符号,例如:
 
 ```kotlin
    @BindingAdapter("numberOfSets")
    @JvmStatic
    fun setNumberOfSets(view: EditText, value: String) {
        view.setText(value)
    }

    @InverseBindingAdapter(attribute = "numberOfSets", event = "numberOfSetsAttrChanged")
    @JvmStatic
    fun getNumberOfSets(view: EditText): String {
        return view.text.toString()
    }

    @BindingAdapter("numberOfSetsAttrChanged", requireAll = false)
    @JvmStatic
    fun setNumberOfSetsListener(view: EditText, listener: InverseBindingListener?) {
        Log.e("TestActivity_Two", "__" + listener.toString())

        view.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
            val textView = focusedView as TextView
            if (hasFocus) {
                // Delete contents of the EditText if the focus entered.
                textView.text = ""
            } else {
                Log.e("TestActivityAttrChanged", "setNumberOfSetsListener")
                // If the focus left, update the listener
                listener?.onChange()
            }
        }
    }
    
    
    object BindMethods {
    
        @InverseMethod("convertStringToInt")
        @JvmStatic
        fun convertIntToString(value: Int): String {
            return value.toString()
        }
    
        @JvmStatic
        fun convertStringToInt(value: String): Int {
            try {
                return Integer.parseInt(value);
            } catch (ex: NumberFormatException) {
                return -1;
            }
        }
    }
    
    <EditText
     android:layout_width="wrap_content"
     android:layout_height="wrap_content"
     android:id="@+id/input"
     app:layout_constraintLeft_toLeftOf="parent"
     android:minHeight="35dp"
     android:minWidth="80dp"
     android:background="#33ff0000"
     android:singleLine="true"
     android:imeOptions="actionDone"
     numberOfSets="@={BindMethods.convertIntToString(viewmodel.progress)}"
     hideKeyboardOnInputDone="@{true}"
     app:layout_constraintTop_toTopOf="parent"/>
```
这样我们就可以直接使用viewmodel中的数据了

* @BindingConversion
作用:数据类型转换
例如,我们TextView中的text是String,但是输入的Integer,这是会出错,但是使用该注释就可以完成转换了
```kotlin
    @BindingConversion
    @JvmStatic
    fun intToString(value: Int): String? {
        return value.toString()
    }
```

* @BindingAdapter("numberOfSets"):将viewmodel中的data设置到view上
作用:对控件添加属性功能
例如,我们想将多个属性连接起来或添加条件语句,这是可以使用该注释
```kotlin
    @BindingAdapter("numberOfSets")
    @JvmStatic
    fun setNumberOfSets(view: EditText, value: String) {
        view.setText(value)
    }
    
    <EditText
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/input"
            app:layout_constraintLeft_toLeftOf="parent"
            android:minHeight="35dp"
            android:minWidth="80dp"
            android:background="#33ff0000"
            android:singleLine="true"
            android:imeOptions="actionDone"
            numberOfSets="@={BindMethods.convertIntToString(viewmodel.progress)}"
            hideKeyboardOnInputDone="@{true}"
            app:layout_constraintTop_toTopOf="parent"/>
```

* @InverseBindingAdapter:将view上的值设置到viewmodel上
作用:与@BindingAdapter相反,通过该函数可以获取控件中的属性值,从而修改viewmodel中的data值

* @BindingMethod(viewmodel通知控件)
作用:将控件中的属性和函数关联起来,(属性可以自定义,也可以是原始属性;方法可以自定义,也可以是原始方法)

注意:在有的时候`@BindingMethod`,`@BindingAdapter`,`@BindingConversion`可以相互转换,他们可以实现相同的效果


* @InverseBindingMethod(控件通知viewmodel)

双向绑定:
- 死循环绑定：因为数据源改变会通知view刷新，而view改变又会通知数据源刷新，这样一直循环往复，就形成了死循环绑定。
- 数据源中的数据有时需要经过转换才能在view中展示，而view中展示的内容也需要经过转换才能绑定到对应的数据源上。

双向绑定问题的解决方式
1. 死循环绑定的解决方式：
解决方式很简单，举个dataBinding源码中的例子
查看源码;
2. 数据源中的数据有时需要经过转换才能在view中展示，而view中展示的内容也需要经过转换才能绑定到对应的数据源上的解决方式
有些开发者可能不太了解什么叫数据源中的数据需要经过转换才能在view中展示，以及view中展示的内容也需要经过转换才能绑定到对应的数据源上，我举个实际开发中的场景：
在一些约车或者外卖等类型的APP中，都有订单类型这个字段，以约车APP为例，订单有立即单，预约单，接机单等其他订单类型，用户在提交订单后，在用户的订单列表或详情中是可以看到订单类型的，比如“立即单”,但是在服务端，存储立即单这个字段的时候，并不是直接存储“立即单”这几个字的，而是以字典表的形式来存储的，比如“OT00001”代表立即单，在开发中，我们肯定不能把“OT00001”展示到界面上给用户看吧，但是服务端给我们返回的json中就是“OT00001”，所以我们在接收到“OT00001”时要把“OT00001”转换成“立即单”展示到界面上给用户看，这就是数据源中的数据需要经过转换才能在view中展示；
而如果用户修改了订单类型，然后提交到服务端去修改，我们肯定是以“OT00001”的形式提交到服务端的，但是用户在输入时却是以“立即单”的形式输入的，所以在提交服务端时，我们需要把“立即单”转换为“OT00001”再去提交到服务端，这就是view中展示的内容也需要经过转换才能绑定到对应的数据源上。

如果不使用dataBinding，这些转换时机以及逻辑都要我们自己掌握，但是使用了dataBinding之后，这些操作都变得自动化，在你设置“OT00001”时，会自动转换为“立即单”在界面上展示，而当你输入“立即单”时，对应的实体类字段会自动变为“OT00001”，这会大大节省我们的开发成本。

我们可以通过@InverseMethod来做到这种自动化。
```java
public class InverseMethodDemo {

    @InverseMethod("orderTypeToString")
    public static String stringToOrderType(String value) {
        if (value == null) {
            return null;
        }
        switch (value) {
            case "立即单":
                return AppConstants.ORDER_TYPE_1;
            case "预约单":
                return AppConstants.ORDER_TYPE_2;
            case "接机单":
                return AppConstants.ORDER_TYPE_3;
            case "送机单":
                return AppConstants.ORDER_TYPE_4;
            case "半日租单":
                return AppConstants.ORDER_TYPE_5;
            case "全日租单":
                return AppConstants.ORDER_TYPE_6;
            default:
                return null;
        }
    }


    public static String orderTypeToString(String code) {
        if (code == null) {
            return null;
        }
        switch (code) {
            case AppConstants.ORDER_TYPE_1:
                return "立即单";
            case AppConstants.ORDER_TYPE_2:
                return "预约单";
            case AppConstants.ORDER_TYPE_3:
                return "接机单";
            case AppConstants.ORDER_TYPE_4:
                return "送机单";
            case AppConstants.ORDER_TYPE_5:
                return "半日租单";
            case AppConstants.ORDER_TYPE_6:
                return "全日租单";
            default:
                return null;
        }
    }
}

<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>

        <import type="com.qiangxi.databindingdemo.databinding.method.InverseMethodDemo"/>

        <variable
            name="orderTypeCode"
            type="String"/>

    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <EditText
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="55dp"
            android:gravity="center_horizontal"
            android:text="@={InverseMethodDemo.orderTypeToString(orderTypeCode)}"/>

    </LinearLayout>
</layout>

```

当使用mBinding.setOrderTypeCode("OT00001")时，EditText中会自动展示“立即单”，当EditText中的内容修改为“预约单”时，orderTypeCode字段值会自动变为“OT00002”。

要注意的是：
- 转换方法中要对参数进行判空，不然会引起空指针异常
- 记得使用双向绑定表达式，不然转换方法不起作用，双向绑定表达式的写法为“@={}”

问：当EditText中的内容修改为“预约单”时，orderTypeCode字段值会自动变为“OT00002”。这一步dataBinding是如何做到的？


答：当EditText的文本内容发生改变时，dataBinding会收到通知然后调用TextViewBindingAdapter.getTextString(textView);拿到EditText内容，然后通过@InverseMethod注解标记的转换方法InverseMethodDemo.stringToOrderType("预约单");拿到对应的编码“OT00002”，但是此时orderTypeCode字段值还没有变为“OT00002”，为了让orderTypeCode字段值变为“OT00002”，dataBinding会调用mBinding.setOrderTypeCode("OT00002")真正的把”OT00002”赋值给orderTypeCode字段

可以去看DataBinding生成的源码

* @InverseBindingMethod与@InverseBindingMethods实例
@InverseBindingMethods注解的作用与@BindingMethods类似，都相当于一个容器，只不过@InverseBindingMethods用来盛放的是@InverseBindingMethod，所以真正发挥双向绑定作用的是@InverseBindingMethod注解，下面我们以一个实例的方式来讲解@InverseBindingMethod注解

* @InverseBindingMethod注解在属性数量上只是比@BindingMethod注解多了一个String类型的event属性；其实@InverseBindingMethod注解的重点也就在于这个event属性。event属性值的生成规则在上一篇文章中详细说过，这里就不再赘述。

* @InverseBindingMethod与@InverseBindingMethods需要结合@BindingAdapter注解才能发挥作用



https://blog.csdn.net/qiang_xi/category_6995820.html

