package truecorp.ensemble.components.model;

import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import truecorp.ensemble.R;
import truecorp.ensemble.utils.Animator;

/**
 * Created by Jennarong Pinjai on 17/1/2561.
 */

public class PaggingTable {

    private TableLayout table;
    private int currentPage = 1;
    private int pageSize;
    private List<TableRow> rows = new ArrayList<TableRow>();
    private int startIndexDataRow=1;
    private int totalPage;
    private int totalItem;
    private int totalColumn;


    public PaggingTable(TableLayout table,List<TableRow> rows,int startDataRow,int totalColumn,int pageSize){
        this.table=table;
        this.rows=rows;
        this.pageSize=pageSize;
        this.totalColumn = totalColumn;
        this.startIndexDataRow = startDataRow;

        this.totalPage = rows.size()/pageSize;
        if(rows.size()%pageSize!=0){
            this.totalPage++;
        }

        this.totalItem = rows.size();

        printPaggingTable();

        addRowOfPageNumber();

    }
    public void addRowOfPageNumber(){

        TableRow dataRowMaster = new TableRow(table.getContext());

        //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

        dataRowMaster.setBackground(table.getResources().getDrawable(R.drawable.onrowtouched));


        layParams.setMargins(0, 0, 0, 0);
        dataRowMaster.setLayoutParams(layParams);
        dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
        dataRowMaster.setPadding(0, 10, 10, 10);

        LinearLayout linearLayout = new LinearLayout(table.getContext());

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
        layoutParams.width= LinearLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height= LinearLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.span = totalColumn;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER);

        int headshow=0;
        int tailshow=0;

        headshow = currentPage-2;
        tailshow = currentPage+2;

        if(headshow<1){
            tailshow+=Math.abs(headshow);
            headshow=1;
        }
        if(tailshow>totalPage){
            tailshow=totalPage;
        }




        TextView prevShowView = new TextView(new ContextThemeWrapper(table.getContext(), R.style.dataText_not_selectable));

        prevShowView.setHeight(80);
        LinearLayout.LayoutParams layoutParams3 = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);



        layoutParams3.rightMargin=40;
        prevShowView.setLayoutParams(layoutParams3);
        prevShowView.setPadding(0,10,0,10);
        prevShowView.setText("<");
        prevShowView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        prevShowView.setPadding(10, 0, 0, 0);
        prevShowView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        prevShowView.setTextColor(table.getResources().getColor(R.color.red_gray));
        prevShowView.setBackground(table.getResources().getDrawable(R.drawable.onrowtouched));
        setOnClickPageNumber(prevShowView,currentPage-1);
        linearLayout.addView(prevShowView);

        if(headshow>1){
            TextView firstShowView = new TextView(new ContextThemeWrapper(table.getContext(), R.style.dataText_not_selectable));

            firstShowView.setHeight(80);
            LinearLayout.LayoutParams layoutParams4 = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams4.rightMargin=20;
            firstShowView.setLayoutParams(layoutParams4);
            firstShowView.setPadding(10,10,10,10);
            firstShowView.setText(" 1 ");
            firstShowView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            firstShowView.setPadding(10, 0, 10, 0);
            firstShowView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            firstShowView.setTextColor(table.getResources().getColor(R.color.red_gray));
            firstShowView.setBackground(table.getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
            setOnClickPageNumber(firstShowView,1);


            linearLayout.addView(firstShowView);

            TextView spotShowView = new TextView(new ContextThemeWrapper(table.getContext(), R.style.dataText_not_selectable));

            spotShowView.setHeight(80);
            spotShowView.setLayoutParams(layoutParams4);
            spotShowView.setPadding(0,10,0,10);
            spotShowView.setText("...");
            spotShowView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            spotShowView.setPadding(10, 0, 10, 0);
            spotShowView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            spotShowView.setTextColor(table.getResources().getColor(R.color.red_gray));
            // setOnClickPageNumber(firstShowView,1);


            linearLayout.addView(spotShowView);

        }

        for(int i=headshow;i<=tailshow;i++) {
            TextView numberShowView = new TextView(new ContextThemeWrapper(table.getContext(), R.style.dataText_not_selectable));

            numberShowView.setHeight(80);
            LinearLayout.LayoutParams layoutParams4 = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams4.rightMargin=20;
            numberShowView.setLayoutParams(layoutParams4);
            numberShowView.setPadding(10,10,10,10);
            numberShowView.setText(" "+i+" ");
            numberShowView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            numberShowView.setPadding(10, 0, 10, 0);
            numberShowView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            numberShowView.setTextColor(table.getResources().getColor(R.color.red_gray));
            numberShowView.setBackground(table.getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
            setOnClickPageNumber(numberShowView,i);

            if(i==currentPage){

                numberShowView.setBackgroundColor(table.getResources().getColor(R.color.yellowSoft));

            }

            linearLayout.addView(numberShowView);
        }
        if(tailshow<totalPage){

            TextView spotShowView = new TextView(new ContextThemeWrapper(table.getContext(), R.style.dataText_not_selectable));

            spotShowView.setHeight(80);
            LinearLayout.LayoutParams layoutParams4 = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            spotShowView.setLayoutParams(layoutParams4);
            spotShowView.setPadding(0,10,0,10);
            spotShowView.setText("...");
            spotShowView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            spotShowView.setPadding(10, 0, 10, 0);
            spotShowView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            spotShowView.setTextColor(table.getResources().getColor(R.color.red_gray));
            // setOnClickPageNumber(firstShowView,1);


            linearLayout.addView(spotShowView);

            TextView lastShowView = new TextView(new ContextThemeWrapper(table.getContext(), R.style.dataText_not_selectable));

            lastShowView.setHeight(80);
            layoutParams4.rightMargin=20;
            lastShowView.setLayoutParams(layoutParams4);
            lastShowView.setPadding(10,10,10,10);
            lastShowView.setText(" "+totalPage+" ");
            lastShowView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            lastShowView.setPadding(10, 0, 10, 0);
            lastShowView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            lastShowView.setTextColor(table.getResources().getColor(R.color.red_gray));
            lastShowView.setBackground(table.getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
            setOnClickPageNumber(lastShowView,totalPage);


            linearLayout.addView(lastShowView);



        }
        TextView nextShowView = new TextView(new ContextThemeWrapper(table.getContext(), R.style.dataText_not_selectable));

        nextShowView.setHeight(80);
        LinearLayout.LayoutParams layoutParams5 = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams5.leftMargin=20;
        nextShowView.setLayoutParams(layoutParams5);
        nextShowView.setPadding(0,10,0,10);
        nextShowView.setText(">");
        nextShowView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        nextShowView.setPadding(10, 0, 0, 0);
        nextShowView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        nextShowView.setTextColor(table.getResources().getColor(R.color.red_gray));
        nextShowView.setBackground(table.getResources().getDrawable(R.drawable.onrowtouched));
        setOnClickPageNumber(nextShowView,currentPage+1);
        linearLayout.addView(nextShowView);

        dataRowMaster.addView(linearLayout);
        table.addView(dataRowMaster);

    }

    public void setOnClickPageNumber(TextView numberView, final int pageNumber){

            numberView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(pageNumber<1){
                        PaggingTable.this.currentPage = 1;
                    }else
                    if(pageNumber>totalPage){
                        PaggingTable.this.currentPage = totalPage;
                    }else{
                        PaggingTable.this.currentPage = pageNumber;
                    }


                    printPaggingTable();
                    addRowOfPageNumber();


                }
            });



    }

    public void printPaggingTable(){

        try{

            int headIndex = (currentPage-1)*pageSize;
            int tailIndex = headIndex+pageSize;

            if(tailIndex>totalItem){
                tailIndex=totalItem;
            }

            try{
                table.removeViews(startIndexDataRow,table.getChildCount()-startIndexDataRow);

            }catch (Exception ex){ex.printStackTrace();}

            for (TableRow row :  rows.subList(headIndex,tailIndex)){

                table.addView(row);

            }


        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }


    }

    public TableLayout getTable() {
        return table;
    }

    public void setTable(TableLayout table) {
        this.table = table;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<TableRow> getRows() {
        return rows;
    }

    public void setRows(List<TableRow> rows) {
        this.rows = rows;
    }

    public int getStartIndexDataRow() {
        return startIndexDataRow;
    }

    public void setStartIndexDataRow(int startIndexDataRow) {
        this.startIndexDataRow = startIndexDataRow;
    }
}
