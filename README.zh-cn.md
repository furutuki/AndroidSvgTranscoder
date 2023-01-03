# AndroidSvgTranscoder

AndroidSvgTranscoder是一款可以批量转换SVG文件为Android代码文件（Java）的gradle插件。如果您的Android项目需要在canvas中直接渲染绘制svg，那么本插件正是您所需要的。



## 项目结构

- transcoder-core：svg转换为java文件的核心逻辑module。
- transcoder-plugin：gradle插件module，基于transcoder-core提供的转换功能，暴露一个任务svgBatchConverter和扩展svgTranscoder，您的工程引用这个插件后，就可以实现svg转换为java文件的目的。
- transcoder-sample：如何使用transcoder-plugin的范例工程。



## 使用方法：

1. 添加仓库。如果您的AGP版本较低不支持pluginManagement的写法，可以把仓库添加到根目录的build.gradle。

```groovy
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
```

2. 在您项目的build.gradle文件中引用插件：

```groovy
plugins {
    id 'io.github.furutuki.android-svg-transcoder' version '0.1.1'
}
```

3. 添加svgTranscoder扩展节点，配置3个属性：svg文件所在的目录，生成的java文件目录，java文件的包名

```groovy
svgTranscoder {
    svgFolder = "${projectDir}/svg"
    javaFolder = "${projectDir}/src/main/java/com/github/furutuki/androidsvgtranscoder/sample/svgobj"
    packageName = "com.github.furutuki.androidsvgtranscoder.sample.svgobj"
}
```

4. 命令行执行任务或者在AndroidStudio右侧的gradle任务列表中点击sag-transcoder分组的svgBatchConverter任务，这里以命令行为例：

```shell
 ./gradlew svgBatchConverter
```
可以在命令行看任务执行情况，如果执行成功，在您指定的目录中就会有生成的java文件。

每个java对应一个svg的绘制代码，直接new出对象，执行paint()方法即可绘制出此svg图形。

```kotlin
val arrowDown = ArrowDown()
arrowDown.paint(canvas, 100, 80, 300, 10)
```

在范例工程transcoder-sample演示了如何使用本插件，预先在svg目录放置了一些svg文件，执行svgBatchConverter任务生成对应的java文件后，在canvas中调用这些java类绘制svg图形，下图是范例工程运行的截图。

<img src="https://github.com/furutuki/AndroidSvgTranscoder/blob/main/transcoder-sample/Screenshot.png" style="zoom:30%;" />
