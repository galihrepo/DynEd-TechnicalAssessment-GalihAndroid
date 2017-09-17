# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/galihadityo/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keepclasseswithmembernames class * {
 native <methods>;
}

-keep public class * extends android.view.View {
 public <init>(android.content.Context);
 public <init>(android.content.Context, android.util.AttributeSet);
 public <init>(android.content.Context, android.util.AttributeSet, int);
 public void set*(...);
}

-keepclasseswithmembers class * {
 public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
 public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
 public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
 public static **[] values();
 public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
 public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
 public static <fields>;
}

-keepattributes Signature
-keep class sun.misc.** { *; }
-dontwarn com.dyned.app.android.home.**

# retrofit logging
-keep class okhttp3.** { *; }
-keep class okio.** { *; }
-keepattributes InnerClasses

-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }

# Appcompat and support
-keep interface android.support.v7.** { *; }
-keep class android.support.v7.** { *; }

# android support
-dontwarn android.support.**

# jackson
-keep class com.fasterxml.jackson.** { *; }
-dontwarn com.fasterxml.jackson.**

-keep class com.google.gson.** { *; }
-keep class io.realm.** { *; }

# fast android networking
-dontwarn okio.**
-dontwarn okhttp3.**

-keep class io.realm.annotations.RealmModule
-keep @io.realm.annotations.RealmModule class *
-keep class io.realm.internal.Keep
-keep @io.realm.internal.Keep class *

-dontwarn javax.**
-dontwarn io.realm.**
-dontwarn com.google.gson.**

-keep class **$$ViewBinder { *; }

-keep class su.levenetc.android.textsurface.** { *; }