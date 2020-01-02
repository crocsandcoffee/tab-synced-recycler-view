# Tab Synced Recycler View
[![](https://jitpack.io/v/omid-io/tab-synced-recycler-view.svg)](https://jitpack.io/#omid-io/tab-synced-recycler-view)

## Getting start with TabSyncedRecyclerView

#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```groovy
  allprojects {
     repositories {
       ....
       maven { url 'https://jitpack.io' }
     }  
  }
```
  
#### Step 2. Add the dependency
```groovy
  dependencies {
      implementation 'com.github.omid-io:tab-synced-recycler-view:<version>
  }
```

List of versions available can be found at https://jitpack.io/#omid-io/tab-synced-recycler-view.

#### Step 3. Either add the TabSyncedRecyclerView to your layout xml or programmmatically create an instance and add the required setup.
```kotlin
      val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
      val recyclerView = findViewById<TabSyncedRecyclerView>(R.id.recycler_view)

      // pass the tab layout reference
      recyclerView.setTabLayout(tabLayout)
      
      // pass a list containing the # of items in each tab where the count passed in pos 0 corresponds 
      // to the # of items in the first tab (tab pos 0)
      // e.g. Given the following scenario: 
      // 1.) TabLayout has 3 tabs
      // 2.) The data set size is 12 items 
      // 3.) the first 3 items belong to tab 1, the next 2 belong to tab 2, and the last 7 items belong to tab 3
      recyclerView.setCountItemsByTabIndex(listOf(3, 2, 7))

      // pass an instance of the TabSyncedScrollListener
      recyclerView.addOnScrollListener(TabSyncedScrollListener())
      
      // pass an instance of the LinearLayoutManagerWithSmoothScroller
      recyclerView.layoutManager = LinearLayoutManagerWithSmoothScroller(context, RecyclerView.VERTICAL, false)

      recyclerView.adapter = <your adapter instance>
```



## Demo

![Tab Synced horizontal and vertical recycler views](demo.gif)


## License

This project is licensed under the terms of the MIT license.

MIT License

Copyright (c) 2020 Omid Ghenatnevi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
