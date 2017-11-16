### activity-alias 标签
> 为Activity注册一个别名，通过这个别名可以启动对应的Activity

**使用场景：** 动态修改应用图标
**开启设置：** android:enabled="true"

```
<activity-alias
    android:name=".SplashActivity_circle"
    android:enabled="true"
    android:icon="@mipmap/ic_launcher_circle"
    android:label="@string/app_name"
    android:targetActivity=".SplashActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN"/>
        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
</activity-alias>

```

### configChanges
> 配置这个属性，当横竖屏切换的时候禁止重建Activity.
* orentation:屏幕方向改变
* uimode:用户的模式发生变化，比如夜间模式
* screensize:屏幕大小发生变化

### 添加矢量图支持
在app的build.gradle的defaultConfig标签下添加
`vectorDrawables.useSupportLibrary = true`

### 再按一次退出程序

```
@Override
public void onBackPressed() {
    long currentTime = System.currentTimeMillis();
    if ((currentTime - exitTime) < 2000) {
        super.onBackPressed();
    } else {
        Toast.makeText(this, R.string.double_click_exit, Toast.LENGTH_SHORT).show();
        exitTime = currentTime;
    }
}
```

