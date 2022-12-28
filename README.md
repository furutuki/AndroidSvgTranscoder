# AndroidSvgTranscoder

*Chinese README: [中文文档](README.zh-cn.md).*

AndroidSvgTranscoder makes you able to transcode svg file to Android code, with which you can render svg in canvas.



## Project Structure

- transcoder-core：core module that can transcode a svg to java file。Generally, you may not use this module directly, instead using transcoder-plugin is more convenient unless you want to do some customization job.
- transcoder-plugin：gradle plugin module, you can apply this plugin which offer a task 'svgBatchConverter' that can transcode a set of svg files at the same time.
- transcoder-sample：A sample module that show you how to use this transcoder-plugin。



## Usage：

1. Apply AndroidSvgTranscoder plugin：

```groovy
plugins {
    id 'io.github.furutuki.android-svg-transcoder' version '0.1.0'
}
```

2. Add **svgTranscoder** extension in your *build.gradle* and config the three properties below：

   **svgFolder**: directory that contains your svg files

   **javaFolder**: directory that contains java files generated

   **packageName** : package name of the java files generated

```groovy
svgTranscoder {
    svgFolder = "${projectDir}/svg"
    javaFolder = "${projectDir}/src/main/java/com/github/furutuki/androidsvgtranscoder/sample/svgobj"
    packageName = "com.github.furutuki.androidsvgtranscoder.sample.svgobj"
}
```

3. execute the task **svgBatchConverter**：

```shell
 ./gradlew svgBatchConverter
```

The task execution result will be showed in the terminal, if succeeded, you will find java files in the specified folder.

Each java file represent a svg object, you can new a object of it, and invoke **paint()** method to render the svg like this:

```kotlin
val arrowDown = ArrowDown()
arrowDown.paint(canvas, 100, 80, 300, 10)
```

The transcoder-sample module has some svg files in directory *svg*，execute the task **svgBatchConverter** and use the output java files to draw them, below is the screenshot of the sample project.

<img src="/Users/huzhong/git/AndroidSvgTranscoder/transcoder-sample/Screenshot.png" style="zoom:50%;" />

