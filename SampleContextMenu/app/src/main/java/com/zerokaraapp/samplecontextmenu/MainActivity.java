package com.zerokaraapp.samplecontextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リストビューの取得
        ListView listView = findViewById(R.id.planet_list_view);
        //コンテキストメニューの実装
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo){
        //オーバーライド元のメソッド呼び出し
        super.onCreateContextMenu(contextMenu,view,contextMenuInfo);

        //メニューのインフレーターオブジェクトを取得
        MenuInflater menuInflater = getMenuInflater();
        //コンテキストメニュー用のmenuXMLファイルをインフレート
        menuInflater.inflate(R.menu.context_menu,contextMenu);
        //コンテキストメニューのタイトルを設定
        contextMenu.setHeaderTitle(R.string.context_menu_title);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //長押しされた項目の情報をinfoに格納する
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        //レイアウトからテキストビューの取得
        TextView textView =findViewById(R.id.textView);

        //1.English、日本語どちらを押されたかで条件分岐
        //2.長押しされた項目のpositionで条件分岐
        switch (item.getItemId()) {
            case R.id.Menu_English:
                switch(info.position){
                    case 0:
                        textView.setText(R.string.mercury_title);
                        break;
                    case 1:
                        textView.setText(R.string.venus_title);
                        break;
                    case 2:
                        textView.setText(R.string.earth_title);
                        break;
                    case 3:
                        textView.setText(R.string.mars_title);
                        break;
                    case 4:
                        textView.setText(R.string.jupiter_title);
                        break;
                    case 5:
                        textView.setText(R.string.saturn_title);
                        break;
                    case 6:
                        textView.setText(R.string.uranus_title);
                        break;
                    case 7:
                        textView.setText(R.string.neptune_title);
                        break;    
                }
                return true;
            case R.id.Menu_Japanese:
                switch(info.position){
                    case 0:
                        textView.setText(R.string.mercury);
                        break;
                    case 1:
                        textView.setText(R.string.venus);
                        break;
                    case 2:
                        textView.setText(R.string.earth);
                        break;
                    case 3:
                        textView.setText(R.string.mars);
                        break;
                    case 4:
                        textView.setText(R.string.jupiter);
                        break;
                    case 5:
                        textView.setText(R.string.saturn);
                        break;
                    case 6:
                        textView.setText(R.string.uranus);
                        break;
                    case 7:
                        textView.setText(R.string.neptune);
                        break;
                }
                return true;
            default:
                //例外時の処理は、オーバーライド元のメソッド呼び出しで対応
                return super.onContextItemSelected(item);
        }
    }

}