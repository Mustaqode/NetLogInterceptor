![JitPack](https://img.shields.io/jitpack/v/github/Mustaqode/NetLogInterceptor?color=%23f44336&label=Release)

# NetLogInterceptor
 A simple library to log network calls in our android device | Works with Square's okHttp client
 
# Install

### Add the following dependencies in your root level and project level gradle files.

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
dependencies {
	        implementation 'com.github.Mustaqode:NetLogInterceptor:Tag'
	}
 ```
 
 ### Initialize the library in your application class
 
 ```
   NetLog.init(context)
 ```
 
 ### Then add this interceptor into your okHttp client
 
 ```
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor())
        .addNetworkInterceptor(NetLogInterceptor())
        .build()
 ```
 ## That's it! You are good to go. 
 
 Open your app (probably beta build), and start using it as usual; all the network calls made in your app will be    automatically logged in a text file.
 
 #### You will find the file in `Android` -> `Your app` -> `files` -> `Netlog` -> `Netlog.txt`
 
 
 ## Thank you for visiting this page!

