# Keep-Links

Keep Links Application

## မှတ်ချက်
<b>Project ထဲဝင်တာနဲ့ ချက်ချင်း Update အရင် ခေါ်ပါ။<br>Code, Design & etc.. ပြင်ပြီး၊ စမ်းပြီးလို့ အဆင်ပြေ ရင် commit & push လုပ်ပါ။<br>ဘယ်နေရာမှာ ဘာလုပ်ခဲ့လဲဆိုတဲ့ Comment ရေးခဲ့ပါ။</b> 

<strong>Note Format</strong><br>
id (Object Reference) Note text

## Activity

|                Java                |                Xml                 | Notes |
|:----------------------------------:|:----------------------------------:|:-----:|
| [MainActivity.java](#MainActivity) | [activity_main.xml](#MainActivity) |       |

### MainActivity

All id from <strong>MainActivity</strong>

* mainFrame(FrameLayout)
* mainBnv(BottomNavigationView)

## Fragment

| Java | Xml | Notes |
|:----:|:---:|:-----:|
|      |     |       |


### FragmentActivity

<strong>Empty</strong>

## Java File
* Utils.java (ကုဒ်တွေကို နာမည်တိုတိုနဲ့ လွယ်လွယ် ပြန်သုံးလို့ရအောင် စုထားတဲ့ Java Class)

## Drawable

* category icon
* favorite icon
* question mark icon (temporary)
* home icon
* search icon

## Layout

- search_layout.xml<br>ဒီ Layout ကို [main_activity_menu.xml](#main_activity_menuxml)မှာ သုံးထားပါတယ်။<br>`app:actonViewClass="androidx.appcompat.widget.SearchView"`<br>ဆိုပြီးတစ်ခုတည်းသုံးရင် SearchView layout က ကြည့်ရဆိုးလို့ `android:actionLayout="search_layout"` ဆိုပြီး သီးသန့် layout ထည့်သုံးလိုက်တာ။ 

## Menu

### main_activity_menu.xml
- menu_toolbar_search(MenuItem for SearchView)
- theme_group(Menu Group)
- theme_light(MenuItem)<br>to switch to light mode
- theme_dark(MenuItem)<br>to switch to dark mode
- theme_system(MenuItem)<br>to switch to follow system setting


### main_bnv_menu.xml
- menu_bnv_home(MenuItem)
- menu_bnv_category(MenuItem)
- menu_bnv_favorite(MenuItem)
- menu_bnv_unknown1(MenuItem)<br>Don't have idea yet

