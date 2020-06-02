# BottomNavView

BottomNavView是一个简单的底部导航库，适合使用两套图，有图标和标题，没有动画的场景，并且增加了未读消息设置

***

使用方法

1. Maven

   ```xml
      <dependency>
        <groupId>com.parade.bottomNavView</groupId>
        <artifactId>bottomNav</artifactId>
        <version>1.0.0</version>
        <type>pom</type>
       </dependency>
   ```

   Gradle

   ```
   implementation 'com.parade.bottomNavView:bottomNav:1.0.0'
   ```

2. 从xml文件创建

   ```xml
   <com.parade.bottomNavView.BottomNavView
       android:id="@+id/bottomNavView"
       android:layout_width="match_parent"
       android:layout_height="47dp"
       android:layout_alignParentBottom="true"
       android:background="@android:color/white"/>
   ```

3. 自定义属性介绍

   | 字段               | 含义                 | 默认值  |
   | ------------------ | -------------------- | ------- |
   | titleSize          | 文本字号             | 9sp     |
   | normalColor        | 普通状态下的颜色     | #000000 |
   | selectedColor      | 选中状态下的颜色     | #3e97df |
   | titleTopMargin     | 文本上边距           | 5dp     |
   | titleBottomMargin  | 文本下边距           | 5dp     |
   | unReadBackground   | 未读消息的背景       | resId   |
   | unReadNumTopMargin | 未读消息距顶部的距离 | 2dp     |
   | maxUnreadNum       | 未读数字的最大值     | 99      |

4. 创建tab

   <pre><code class="java">bottomNavView.setmListText(mListText)
           .setmListNormalIcons(mListNormalIcon)
           .setmListSelectedIcons(mListSelectedIcon)
           .setOnItemSelectedListener(this)//选中事件监听，代表的是当一个 item 由 未选中状态 变成 选中状态 时的回调
           .setOnItemReSelectedListener(this)//已选中状态下的事件监听，代表的是当一个 item 已经是选中状态 并且 又点击该 item 时的回调
           .build();
</code></pre>