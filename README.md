# Keep-Links

Keep Links Application

## မှတ်ချက်
<b>Project ထဲဝင်တာနဲ့ ချက်ချင်း Update အရင် ခေါ်ပါ။<br>Code, Design & etc.. ပြင်ပြီး၊ စမ်းပြီးလို့ အဆင်ပြေ ရင် commit & push လုပ်ပါ။<br>ဘယ်နေရာမှာ ဘာလုပ်ခဲ့လဲဆိုတဲ့ Comment ရေးခဲ့ပါ။</b> 

<strong>Note Format</strong><br>
id (Object Reference) Note text

## Activity

|                        Java                        |                         Xml                         | Notes |
|:--------------------------------------------------:|:---------------------------------------------------:|:-----:|
|         [MainActivity.java](#MainActivity)         |         [activity_main.xml](#MainActivity)          |       |
| [SplashScreenActivity.java](#SplashScreenActivity) | [activity_splash_screen.xml](#SplashScreenActivity) |       |

### MainActivity

All id from <strong>MainActivity</strong>

* mainFrame(FrameLayout)
* mainBnv(BottomNavigationView)

### SplashScreenActivity

All id from <strong>SplashScreenActivity</strong>

* imageView (ImageView) to display app icon
* textView (TextView) to display app name


## Fragment

|                    Java                    |                    Xml                     | Notes |
|:------------------------------------------:|:------------------------------------------:|:-----:|
|     [HomeFragment.java](#HomeFragment)     |     [fragment_home.xml](#HomeFragment)     |       |
| [CategoryFragment.java](#CategoryFragment) | [fragment_category.xml](#CategoryFragment) |       |
| [FavoriteFragment.java](#FavoriteFragment) | [fragment_favorite.xml](#FavoriteFragment) |       |


### HomeFragment

All id from <strong>HomeFragment</strong>
* home_recycler (RecyclerView)
* btn_fab (FloatingActionButton)

### CategoryFragment

All id from <strong>CategoryFragment</strong>
* category_recycler (RrcyclerView)
* btn_fab (FloatingActionButton)

### FavoriteFragment


## Java File

* HomeAdapter.java 
* DataBaseHelper.java
* Utils.java (ကုဒ်တွေကို နာမည်တိုတိုနဲ့ လွယ်လွယ် ပြန်သုံးလို့ရအောင် စုထားတဲ့ Java Class)

## Drawable

* category icon [bnv_menu.xml](#bnv_menuxml) မှာသုံးထား
* favorite icon [bnv_menu.xml](#bnv_menuxml) မှာသုံးထား
* question mark icon (temporary) [bnv_menu.xml](#bnv_menuxml) မှာသုံးထား
* home icon [bnv_menu.xml](#bnv_menuxml) မှာသုံးထား
* search icon [activity_menu.xml](#activity_menuxml) မှာသုံးထား

## Layout

- search_layout.xml<br>ဒီ Layout ကို [activity_menu.xml](#activity_menuxml)မှာ သုံးထားပါတယ်။<br>`app:actonViewClass="androidx.appcompat.widget.SearchView"`<br>ဆိုပြီးတစ်ခုတည်းသုံးရင် SearchView layout က ကြည့်ရဆိုးလို့ `android:actionLayout="search_layout"` ဆိုပြီး သီးသန့် layout ထည့်သုံးလိုက်တာ။ 

## Menu

### activity_menu.xml
- menu_toolbar_search(MenuItem for SearchView)
- theme_group(Menu Group)
- theme_light(MenuItem)<br>to switch to light mode
- theme_dark(MenuItem)<br>to switch to dark mode
- theme_system(MenuItem)<br>to switch to follow system setting


### bnv_menu.xml
- menu_bnv_home(MenuItem)
- menu_bnv_category(MenuItem)
- menu_bnv_favorite(MenuItem)
- menu_bnv_unknown1(MenuItem)<br>Don't have idea yet

