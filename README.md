# Basic[ ![Download](https://api.bintray.com/packages/ooftf/maven/basic/images/download.svg) ](https://bintray.com/ooftf/maven/basic/_latestVersion)
## 描述
目的：减少同一功能类反复编写  
要求：只收录使用率在90%以上的lib和class  
目标：可以作为所有库的基础库的
## 引入方式
    repositories {
        maven {
            url  "https://dl.bintray.com/ooftf/maven"
        }
    }
    implementation 'com.ooftf:basic:0.0.1'


## 混淆
    -keepnames class com.ooftf.basic.engine.serializable.Serializable
    -keepnames class * extends com.ooftf.basic.engine.serializable.Serializable