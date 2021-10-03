# Java - W03

### 一、代码工作原理理解

#### (一)编码隐写术图

通过`SteganographyFactory.java`将BubbleSorter.class的字节码编码进自选图片`example/resources/bubble.jpeg`，得到隐写术图**example.BubbleSorter.png**；

#### (二)自定义加载器

在`example/classloader/SteganographyClassLoader.java`中自定义加载器`SteganographyClassLoader`，根据隐写术图的URL返回其中隐藏类。

变量及核心函数：

`URL url`:隐写术图的路径

`findClass(String name)`：重载父类ClassLoader函数，重定义了加载器加载类的过程。

​	1.创建隐写术图解码器，获得字节码`byte[] bytes`

​	2.通过defineClass()以字节码创建类名name的class



#### (三)调用自定义加载器

Scene中手动调用了加载器的loadClass函数，

查阅父类loadClass函数如下：

```java
protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                ...........
                  if (parent != null) {
                        c = parent.loadClass(name, false);
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                }
           
             if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);
            .......   
    }
```

`example.BubbleSorter`尚未加载过，向上委派，因为不存在`BubbleSorter.java/class` 文件，Application ClassLoader及其上层加载器均找不到该类，无法加载，最终调用被重载的findClass函数。



### 二、自编隐写术图

> InsertionSort

![](https://github.com/jwork-2021/jw03-aaaabang/blob/main/S191220057.InsertSorter.png)

> QuickSort

![](https://github.com/jwork-2021/jw03-aaaabang/blob/main/S191220057.QuickSorter.png)



### 三、解码自编隐写术图

动画链接：

> InsertionSort

[[InsertionSort video](https://asciinema.org/a/epin2vj6QdhPGJjIwntdQqf4S]()

> QuickSort

[[QuickSort vedio](https://asciinema.org/a/4ckpWUHdIHfJ3HBF2vQkRNImP)]()



### 四、解码他人隐写术图

借助同学202220008刘睿哲上传的example.ShellSorter.png，

这边静态展示排序过程，正确。
https://user-images.githubusercontent.com/60206647/135749976-ab9cb92f-0207-41eb-82b1-5a4101381186.png
