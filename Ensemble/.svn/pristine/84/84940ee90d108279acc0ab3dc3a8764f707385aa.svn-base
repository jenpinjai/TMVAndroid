package truecorp.ensemble.components.model;

import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import truecorp.ensemble.utils.Animator;

/**
 * Created by Jennarong Pinjai on 17/1/2561.
 */

public class TabInfo {

    private TableLayout tableInfo;
    private TableRow headerRow;
    private TextView iconView;
    private boolean isShow = true;
    private int minHeight= 30;
    private int origHeight;
    private boolean isFirstCollapse = true;


    public TableLayout getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(TableLayout tableInfo) {
        this.tableInfo = tableInfo;
        origHeight = tableInfo.getHeight();
    }

    public TableRow getHeaderRow() {
        return headerRow;
    }

    public void setHeaderRow(TableRow headerRow) {

        this.headerRow = headerRow;
        minHeight = headerRow.getHeight();
    }

    public TextView getIconView() {
        return iconView;
    }

    public void setIconView(TextView iconView) {
        this.iconView = iconView;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        if(isShow==show)return;
        isShow = show;
        if(show){
            expand();
        }else {
            collapse();
        }
    }

    private void collapse(){
        if(isFirstCollapse){
            minHeight = headerRow.getHeight();
            origHeight = tableInfo.getHeight();
            isFirstCollapse = false;
        }


        iconView.setText("+");
        Animator.collapse(tableInfo,300,minHeight);
    }
    private void expand(){
        iconView.setText("-");
        Animator.expand(tableInfo,300,origHeight-1);
    }

}
