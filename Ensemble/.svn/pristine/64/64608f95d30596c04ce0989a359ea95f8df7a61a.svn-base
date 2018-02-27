package truecorp.ensemble;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import truecorp.core.dataservice.BillingAccountService;
import truecorp.core.model.AddressNameLinkDto;
import truecorp.core.model.AdjustmentsDto;
import truecorp.core.model.BanHierarchyTreeDto;
import truecorp.core.model.BillDto;
import truecorp.core.model.BillingAccountDto;
import truecorp.core.model.InvoiceItemDto;
import truecorp.core.model.NameDataDto;
import truecorp.core.model.ParentBillingAccountDto;
import truecorp.core.model.PaymentActivityDto;
import truecorp.core.model.PaymentDto;
import truecorp.core.model.RefundDto;
import truecorp.core.model.SelectItem;
import truecorp.core.model.SubscriberDto;
import truecorp.ensemble.components.TitleComponent;
import truecorp.ensemble.components.model.PaggingTable;
import truecorp.ensemble.components.model.TabInfo;
import truecorp.ensemble.dialogs.AdjustmentInfoDialog;
import truecorp.ensemble.dialogs.InvoiceInfoDialog;
import truecorp.ensemble.dialogs.PaymentInfoDialog;
import truecorp.ensemble.dialogs.RefundHistoryInfoDialog;
import truecorp.ensemble.dialogs.SubscriberInfoDialog;
import truecorp.ensemble.utils.Animator;

public class BillingAccountActivity extends AppCompatActivity {

    private int searchPanelHeight =0;
    private int searchPanelTopHeight =300;//px
    private boolean isInfoClicked = false;
    private boolean isSearched = false;
    private List<TabInfo>  tabinfoList = new ArrayList<TabInfo>();
    private List<Integer>  tabinfoIdList = new ArrayList<Integer>();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",Locale.US);
    public static SimpleDateFormat dateFormat_NO_CLOCK = new SimpleDateFormat("dd/MM/yyyy",Locale.US);
    private boolean createAdjustClicked = false;
    private Map<String,String> certificateTypeMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_billing_account);
        TitleComponent.setupTitle("Billing Account",false,true,false,true,this);

        final Spinner  searchCrytiria = findViewById(R.id.search_crytiria);

        ArrayAdapter<String> crytiriaListAdap = new ArrayAdapter<String>(this,R.layout.spiner_white_item);
        crytiriaListAdap.add("Ban");
        crytiriaListAdap.add("Name");
        crytiriaListAdap.add("ID");
        crytiriaListAdap.add("Subscriber");
        crytiriaListAdap.add("Invoice");
        searchCrytiria.setPrompt("Search by ");
        searchCrytiria.setAdapter(crytiriaListAdap);

        final LinearLayout idTypeLayout = findViewById(R.id.id_type_layout);
        searchCrytiria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(searchCrytiria.getSelectedItem().toString()=="ID"){

                    idTypeLayout.getLayoutParams().height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    idTypeLayout.setLayoutParams(idTypeLayout.getLayoutParams());
                    searchPanelTopHeight = 430;
                }else {
                    idTypeLayout.getLayoutParams().height = 0;
                    idTypeLayout.setLayoutParams(idTypeLayout.getLayoutParams());
                    searchPanelTopHeight = 300;
                }
                if(isSearched){
                    moveSearchPanelToTop();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final ArrayAdapter<String> cerTypeSelectorAdap = new ArrayAdapter<String>(this,R.layout.spiner_white_item);

        final Spinner  certificateTypeSelector = findViewById(R.id.id_type_selector);
        final ProgressDialog loadDialog = ProgressDialog.show(this,"Loading Certificate type...","Please wait",true,false);


        AsyncTask loadCerType = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try{

                    BillingAccountService service = new BillingAccountService();

                    List<SelectItem> selectItems = service.getCertificateType();

                    return  selectItems;
                }catch (Exception ex){
                    ex.printStackTrace();
                    return null;
                }

            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                try{
                    loadDialog.dismiss();
                    if(o==null){
                        throw new Exception("Can't get Certificate type!");
                    }
                    List<SelectItem> selectItems = (ArrayList<SelectItem>)o;
                    certificateTypeMap = new HashMap<String,String>();
                    for(SelectItem item : selectItems){

                        cerTypeSelectorAdap.add(item.getLabel());

                        certificateTypeMap.put(item.getValue(),item.getLabel().trim());
                    }
                    certificateTypeSelector.setPrompt("Select Certificate type");
                    certificateTypeSelector.setAdapter(cerTypeSelectorAdap);
                }catch (Exception ex){
                    ex.printStackTrace();
                    alert(ex.getMessage());

                }

            }
        };
        loadCerType.execute();


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate (savedInstanceState);

        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);

        final SearchView searchView = findViewById(R.id.searchBillView);
        final Button searchCenterBtn = findViewById(R.id.search_center_btn);
        final ImageButton searchButtonTop = findViewById(R.id.searchButtonTop);
        // Assumes current activity is the searchable activity

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        //searchView.setFocusable(true);
        searchView.setIconified(true);

        //searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onQueryTextSubmit(String query) {

                //Submit search
                try{

                    search();
                }catch (Exception ex){

                    ex.printStackTrace();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                collapseSearchPanel();
                return false;
            }
        });
        searchButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                LinearLayout searchPanel = findViewById(R.id.search_panel);
                Animator.collapseHorizon(searchView,500,searchView.getRootView().getWidth());
                Animator.expand(searchPanel,500,getSearchPanelHeight());
                if(isSearched)collapseInifomationPanelAndExpandListResult();
                searchView.setFocusable(true);
                searchView.setIconified(false);
                searchView.requestFocusFromTouch();
                isInfoClicked = false;
            }
        });
        searchCenterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    search();

                }catch (Exception ex){
                    ex.printStackTrace();
                    alert(ex.getMessage());
                }
            }
        });

        setupInfoTabs();

    }
    public void setupInfoTabs(){

        try{

            generateTabAttr(R.id.billing_inf_table);
            generateTabAttr(R.id.hierachy_inf_table);
            generateTabAttr(R.id.financial_summary_bill_inf_table);



        }catch(Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }

    }

    public TabInfo generateTabAttr(@IdRes int id){
        if(tabinfoIdList.contains(id))return tabinfoList.get(tabinfoIdList.indexOf(id));
        TabInfo   tab = new TabInfo();
        TableLayout tableInfo = findViewById(id);
        TableRow headerRow = (TableRow) tableInfo.getChildAt(0);

        tab.setTableInfo(tableInfo);
        tab.setHeaderRow(headerRow);


        addCollapeExpandIcon(tab);


        setOnclickRowHeaderTab(tab);

        tabinfoList.add(tab);
        tabinfoIdList.add(id);

        return tab;

    }

    public void setOnclickRowHeaderTab(final TabInfo tabInfo){

        tabInfo.getHeaderRow().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tabInfo.isShow()){
                    tabInfo.setShow(false);
                }else{
                    tabInfo.setShow(true);
                }
            }
        });

    }
    public void addCollapeExpandIcon(TabInfo tabInfo){

        TextView iconCE = new TextView(new ContextThemeWrapper(this,R.style.headerInfoText));
        iconCE.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        iconCE.setText("-");
        iconCE.setLayoutParams(new TableRow.LayoutParams(2));
        iconCE.setPadding(0,0,20,0);

        tabInfo.setIconView(iconCE);
        tabInfo.getHeaderRow().addView(iconCE);

    }

    public void collapseSearchPanel(){

        final SearchView searchView = findViewById(R.id.searchBillView);
        final ImageButton searchButtonTop = findViewById(R.id.searchButtonTop);
        LinearLayout resutl_list_layout = findViewById(R.id.billing_data_panel);
        LinearLayout searchPanel = findViewById(R.id.search_panel);
        if(searchPanel.getHeight()!=0)setSearchPanelHeight(searchPanel.getHeight());
        orig_result_list_panel_height = resutl_list_layout.getHeight();
        Animator.collapseHorizon(searchView,500,0);
        Animator.collapse(searchPanel,500,0);
        searchButtonTop.setVisibility(View.VISIBLE);
    }

    public void alert(String message){

        AlertDialog.Builder alertBuilder =  new AlertDialog.Builder(BillingAccountActivity.this);
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.show();


    }

    public void search() throws Exception{

        try{
            SearchView searchView = findViewById(R.id.searchBillView);
            Spinner crityriaView = findViewById(R.id.search_crytiria);
            Spinner certificateTypeSelector = findViewById(R.id.id_type_selector);


            final String searchValue = searchView.getQuery().toString();
            final String crityria    = ((String)crityriaView.getSelectedItem());
            final String certificateType =String.valueOf(certificateTypeSelector.getSelectedItem()).split("-")[0].trim();
            if(searchValue==null||searchValue.trim().isEmpty()){
                throw new Exception("Search key is empty.\nPlease enter some text.");
            }

            List<BillingAccountDto> billList = new ArrayList<BillingAccountDto>();

            final ProgressDialog loadDialog = ProgressDialog.show(this,"Searching...","Please wait",true,false);


            AsyncTask sendQuery = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {
                    try{
                        BillingAccountService billService = new BillingAccountService();
                        String field = "BAN";
                        Object result = null;
                        switch (crityria) {
                            case "Ban":
                                //alert("BAN");
                                field = "BAN";
                                result = billService.searchBillingAccount(field,searchValue);
                                break;

                            case "Subscriber":
                                //alert("SUBSCRIBER");
                                field = "SUBSCRIBER";
                                result = billService.searchBillingAccount(field,searchValue);
                                break;

                            case "Name":
                                //alert("NAME");
                                field = "NAME";
                                String firstName="";
                                String lastName ="";
                                if(searchValue.contains(" ")){
                                    firstName = searchValue.split(" ")[0].trim();
                                    lastName  = searchValue.split(" ")[1].trim();
                                }else{
                                    firstName=searchValue;
                                    lastName="|";
                                }
                                result = billService.searchBillingAccount(field,firstName+"|"+lastName);
                                break;
                            case "ID":
                                // alert("IDENTIFICATION");
                                field = "IDENTIFICATION";
                                String id_type =certificateType;
                                result = billService.searchBillingAccount(field,id_type+"|"+searchValue);
                                break;
                            case "Invoice":
                                // alert("INVOICE_NUMBER");
                                field = "INVOICE_NUMBER";
                                result = billService.searchBillingAccount(field,searchValue);
                                break;
                        }
                        return result;
                    }catch (Exception ex){
                        ex.printStackTrace();
                        return null;
                    }

                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);
                    try{
                        if(o==null){
                            throw new Exception("Not found!");
                        }

                        if(o instanceof ArrayList){
                            List<BillingAccountDto>  billList = (ArrayList<BillingAccountDto>)o;
                            if(billList.size()==0){
                                throw new Exception("Not found!");
                            }
                            printSearchResultToTable(billList,crityria);
                            isSearched = true;
                            SearchView searchView = findViewById(R.id.searchBillView);
                            searchView.clearFocus();
                            moveSearchPanelToTop();

                        }
                        loadDialog.dismiss();
                    }catch (Exception ex){
                        loadDialog.dismiss();
                        alert(ex.getMessage());
                        ex.printStackTrace();
                    }


                }
            };

            sendQuery.execute();

        }catch (Exception ex){

            alert(ex.getMessage());
            ex.printStackTrace();

        }

    }
    public void moveSearchPanelToTop(){
        LinearLayout searchPanel = findViewById(R.id.search_panel);
        LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                0
        );
        searchPanel.setLayoutParams(param2);
        if(searchPanel.getHeight()!=0)setSearchPanelHeight(searchPanel.getHeight());
        Animator.collapse(searchPanel,500,searchPanelTopHeight);
        final Button searchCenterBtn = findViewById(R.id.search_center_btn);
        Animator.collapse(searchCenterBtn,500,0);

    }

    public void setOnclickRowBillingData(View rowView,final BillingAccountDto bill)throws Exception {

        try {
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    fecthBillingDataToInformationView(bill);

                }
            });


        } catch (Exception ex) {
            alert(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void fecthBillingDataToInformationView(final BillingAccountDto bill){

        final ProgressDialog loadDialog = ProgressDialog.show(BillingAccountActivity.this,"Loading Information...","Please wait",true,false);

        final LinearLayout inf_layout = findViewById(R.id.billing_information_panel);
        final LinearLayout resutl_list_layout = findViewById(R.id.billing_data_panel);
        if(orig_result_list_panel_height==0)orig_result_list_panel_height = resutl_list_layout.getHeight();
        final int rootHeight = inf_layout.getRootView().getHeight();

        AsyncTask loadInfTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {

                try {
                    BillingAccountService billService = new BillingAccountService();

                    List<BillingAccountDto> billList = billService.searchBillingAccount("BAN",String.valueOf(bill.getBan()) );

                    return billList;
                }catch (Exception ex){

                    ex.printStackTrace();
                    return  null;
                }
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                try{
                    if(o==null){
                        throw new Exception("Not found!");
                    }

                    if(o instanceof ArrayList){
                        List<BillingAccountDto>  billList = (ArrayList<BillingAccountDto>)o;
                        if(billList.size()==0){
                            throw new Exception("Not found!");
                        }

                        final SearchView searchView = findViewById(R.id.searchBillView);
                        searchView.clearFocus();

                                   /* for(int i=0;i<tabinfoList.size();i++){

                                        if( i==0){
                                            tabinfoList.get(i).setShow(true);
                                        }else{
                                            tabinfoList.get(i).setShow(false);
                                        }

                                    }*/
                        printBillingAccountInformation(billList.get(0));
                        Animator.expand(inf_layout,500,rootHeight);
                        Animator.collapse(resutl_list_layout,500,0);

                        collapseSearchPanel();
                        isInfoClicked = true;


                    }
                    loadDialog.dismiss();
                }catch (Exception ex){
                    loadDialog.dismiss();
                    alert(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        };
        loadInfTask.execute();

    }

    public void printBillingAccountInformation(BillingAccountDto bill){

        try{

            ///BAN Information
            TextView banView = findViewById(R.id.ban_num_inf_tv);
            TextView idView = findViewById(R.id.id_inf_tv);
            TextView idTypeView = findViewById(R.id.id_type_inf_tv);
            TextView nameView = findViewById(R.id.name_info_tv);
            TextView subscriberView = findViewById(R.id.subscriber_info_tv);

            TextView startServiceDateView = findViewById(R.id.start_service_date_info_tv);
            TextView billingAddressView = findViewById(R.id.billing_address_info_tv);
            TextView accountTypeView = findViewById(R.id.account_type_info_tv);
            TextView banStatusView = findViewById(R.id.ban_status_info_tv);
            TextView writeOffView = findViewById(R.id.write_off_status_info_tv);
            TextView statusDateView = findViewById(R.id.status_date_info_tv);
            TextView arBalanceView = findViewById(R.id.ar_balance_info_tv);

            banView.setText(String.valueOf(bill.getBan()));
            idView.setText(bill.getCustomer().getCertificateNumber());
            idTypeView.setText(bill.getCustomer().getCertificateType()==null?"":certificateTypeMap.get(bill.getCustomer().getCertificateType()));
            NameDataDto nameData = bill.getAddressNameObj().getNameData();
            nameView.setText(nameData.getFirstName()+" "+nameData.getLastBusinessName());
            subscriberView.setText(bill.getSubscriberObj().getId().getSubscriberNo());


            startServiceDateView.setText(dateFormat.format(bill.getStartServiceDate()));
            billingAddressView.setText(String.valueOf(bill.getBillingEntityObj().getId().getBen()));
            accountTypeView.setText(bill.getAccountType());
            banStatusView.setText(bill.getBanStatus());
            statusDateView.setText(dateFormat.format(bill.getStatusLastDate()));
            arBalanceView.setText(String.format("%,.2f",bill.getArBalance()));
            writeOffView.setText(bill.getArWoInd());

            ///Hierachy information
            TextView hierachyLevelView = findViewById(R.id.hierachy_level_inf_tv);
            TextView hierachyIdView = findViewById(R.id.hierachy_id_inf_tv);
            TextView hierachyNameView = findViewById(R.id.hierachy_name_info_tv);
            TextView hierachyEffectiveDateView = findViewById(R.id.hierachy_effective_date_info_tv);
            TextView hierachyEndDateView = findViewById(R.id.hierachy_end_date_info_tv);
            TextView parentBanInfoView = findViewById(R.id.parent_ban_info_tv);



            BanHierarchyTreeDto hierachy = bill.getBanHierarchyTreeObj();

            String notFoundAlert = "< Not found >";
            int alertTextColor =getResources().getColor(R.color.grayStatus);


            ParentBillingAccountDto parentHierachry =hierachy.getParentBillingAccount();
            if(parentHierachry!=null){
                List<AddressNameLinkDto> parentAddrList =parentHierachry.getAddressNameLink();
                if(parentAddrList!=null&&parentAddrList.size()>0){
                    NameDataDto hierachyNameData =parentAddrList.get(0).getNameData();
                    if(hierachyNameData!=null){
                        hierachyNameView.setText(hierachyNameData.getFirstName()+" "+hierachyNameData.getLastBusinessName());
                        hierachyNameView.setTextColor(getResources().getColor(R.color.black));
                    }
                }
            }else {
                hierachyNameView.setText(notFoundAlert);
                hierachyNameView.setTextColor(alertTextColor);
            }
            if(hierachy.getId()!=null){
                hierachyIdView.setText(String.format("%s",String.valueOf(hierachy.getId().getBan())));
                hierachyIdView.setTextColor(getResources().getColor(R.color.black));
            }else{
                hierachyIdView.setText(notFoundAlert);
                hierachyIdView.setTextColor(alertTextColor);
            }

            if(hierachy.getTreeLevel()!=null){
                hierachyLevelView.setText(String.format("%.0f",hierachy.getTreeLevel()));
                hierachyLevelView.setTextColor(getResources().getColor(R.color.black));
            }else {
                hierachyLevelView.setText(notFoundAlert);
                hierachyLevelView.setTextColor(alertTextColor);
            }

            if(hierachy.getEffectiveDate()!=null){
                hierachyEffectiveDateView.setText(dateFormat.format(hierachy.getEffectiveDate()));
                hierachyEffectiveDateView.setTextColor(getResources().getColor(R.color.black));
            }else{
                hierachyEffectiveDateView.setText(notFoundAlert);
                hierachyEffectiveDateView.setTextColor(alertTextColor);
            }

            if(hierachy.getExpirationDate()!=null){
                hierachyEndDateView.setText(hierachy.getExpirationDate()==null?"":dateFormat.format(hierachy.getExpirationDate()));
                hierachyEndDateView.setTextColor(getResources().getColor(R.color.black));
            }else {
                hierachyEndDateView.setText(notFoundAlert);
                hierachyEndDateView.setTextColor(alertTextColor);
            }

            if(hierachy.getParentBan()!=null){
                parentBanInfoView.setText(String.format("%.0f",hierachy.getParentBan()));
                parentBanInfoView.setTextColor(getResources().getColor(R.color.black));
            }else{

                parentBanInfoView.setText(notFoundAlert);
                parentBanInfoView.setTextColor(alertTextColor);
            }


            //Financial summary bill
            //Last bill summary
            TextView billDateView = findViewById(R.id.last_bill_date_inf_tv);
            TextView taxInvoiceView = findViewById(R.id.tax_invoice_inf_tv);
            TextView billDueDateView = findViewById(R.id.due_date_info_tv);
            TextView pastDueAmountView = findViewById(R.id.past_due_amount_info_tv);
            TextView previousBalanceView = findViewById(R.id.previous_balance_info_tv);
            TextView paymentAmountView = findViewById(R.id.payment_amount_info_tv);
            TextView totalChargeView = findViewById(R.id.total_charge_info_tv);
            TextView totalAdjustView = findViewById(R.id.total_adjust_info_tv);
            TextView totalAmountDueView = findViewById(R.id.total_amount_due_info_tv);
            TextView arBalanceBillView = findViewById(R.id.ar_balance_bill_info_tv);



            if(bill.getBill()!=null && bill.getBill().size()>0){
                BillDto billing = bill.getBill().get(0);

                for(BillDto comBill: bill.getBill()){

                    BigDecimal cycleCode1 = bill.getBlLastCycCode()==null? BigDecimal.ZERO:bill.getBlLastCycCode();
                    BigDecimal cycleCode2 = comBill.getCycleCode()==null? BigDecimal.ZERO:comBill.getCycleCode();

                    BigDecimal cycleMonth1 = bill.getBlLastCycRunMnth()==null?BigDecimal.ZERO:bill.getBlLastCycRunMnth();
                    BigDecimal cycleMonth2 = comBill.getCycleRunMonth()==null?BigDecimal.ZERO:comBill.getCycleRunMonth();

                    BigDecimal cycleYear1 = bill.getBlLastCycRunYear()==null?BigDecimal.ZERO:bill.getBlLastCycRunYear();
                    BigDecimal cycleYear2 = comBill.getCycleRunYear()==null?BigDecimal.ZERO:comBill.getCycleRunYear();


                    if(cycleCode1.compareTo(cycleCode2)==0
                            &&cycleMonth1.compareTo(cycleMonth2)==0
                            &&cycleYear1.compareTo(cycleYear2)==0){


                        billing = comBill;
                        break;
                    }
                }

                if(billing.getBillDate()!=null){
                    billDateView.setText(dateFormat.format(billing.getBillDate()));
                }
                if(billing.getTaxTotalInvAmount()!=null){
                    taxInvoiceView.setText(billing.getInvoiceNumber());
                }else{
                    taxInvoiceView.setText("0.00");
                }

                if(billing.getBillDueDate()!=null){
                    billDueDateView.setText(dateFormat.format(billing.getBillDueDate()));
                }
                if(billing.getPastDueAmt()!=null){
                    pastDueAmountView.setText(String.format("%,.2f",billing.getPastDueAmt()));
                }
                if(billing.getPrevBalanceAmt()!=null){
                    previousBalanceView.setText(String.format("%,.2f",billing.getPrevBalanceAmt()));
                }
                if(billing.getPymReceivedAmt()!=null){
                    paymentAmountView.setText(String.format("%,.2f",billing.getPymReceivedAmt()));
                }
                if(billing.getTotalBilledCharge()!=null){
                    totalChargeView.setText(String.format("%,.2f",billing.getTotalBilledCharge()));
                }
                if(billing.getTotalBilledAdjust()!=null){
                    totalAdjustView.setText(String.format("%,.2f",billing.getTotalBilledAdjust()));
                }
                if(billing.getTotalDueAmt()!=null){
                    totalAmountDueView.setText(String.format("%,.2f",billing.getTotalDueAmt()));
                }
                if(bill.getArBalance()!=null){
                    arBalanceBillView.setText(String.format("%,.2f",bill.getArBalance()));
                }

                //Last bill detail

                TextView documenTypeView = findViewById(R.id.document_type_info_tv);
                TextView lastBillStatusView = findViewById(R.id.status_last_bill_info_tv);
                TextView lastBillDateView = findViewById(R.id.last_bill_date_info_tv);
                TextView paymentMethodView = findViewById(R.id.payment_method_info_tv);


                documenTypeView.setText(billing.getBlDocumentType()==null?"":billing.getBlDocumentType());
                lastBillStatusView.setText(billing.getProductionType()==null?"":billing.getProductionType());
                lastBillDateView.setText(billing.getBillDate()==null?"":dateFormat.format(billing.getBillDate()));
                paymentMethodView.setText(billing.getPaymentMethod()==null?"":billing.getPaymentMethod());

            }




            //End if Billing

            int timeShowWidth = 150;

            TableLayout invoiceTable = findViewById(R.id.financial_summary_invoice_inf_table);
            try{invoiceTable.removeViews(3,invoiceTable.getChildCount()-3);}catch (Exception ex){}
            if(bill.getInvoiceItem().size()==0){
                TableRow dataRowMaster = new TableRow(this);

                //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));


                layParams.setMargins(0, 0, 0, 0);
                dataRowMaster.setLayoutParams(layParams);
                dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                dataRowMaster.setPadding(0, 10, 10, 10);
                TextView notFoundTView = new TextView(new ContextThemeWrapper(this,R.style.dataText));

                notFoundTView.setHeight(80);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                layoutParams.span = 4;
                notFoundTView.setLayoutParams(layoutParams);

                notFoundTView.setText(" Not found ");
                notFoundTView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                notFoundTView.setPadding(10, 0, 0, 0);
                notFoundTView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                notFoundTView.setTextColor(getResources().getColor(R.color.dark_gray));
                dataRowMaster.addView(notFoundTView);
                invoiceTable.addView(dataRowMaster);

            }else {
                int seq=0;
                for(InvoiceItemDto invoice : bill.getInvoiceItem()){
                    seq++;
                    TableRow dataRowMaster = new TableRow(this);

                    //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                    TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                    if(seq%2!=0) {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
                    }else {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouched));
                    }

                    layParams.setMargins(0, 0, 0, 0);
                    dataRowMaster.setLayoutParams(layParams);
                    dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                    dataRowMaster.setPadding(0, 10, 10, 10);
                    TextView invoiceNoTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                    invoiceNoTV.setHeight(80);
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                    invoiceNoTV.setLayoutParams(layoutParams);

                    invoiceNoTV.setText(invoice.getInvoiceNumber());
                    invoiceNoTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    invoiceNoTV.setPadding(10, 0, 0, 0);
                    invoiceNoTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    invoiceNoTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));



                    TextView invCreationDateTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                    invCreationDateTV.setHeight(80);
                    TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(2);
                    invCreationDateTV.setLayoutParams(layoutParams2);

                    invCreationDateTV.setText(invoice.getInvCreationDate()==null?"":dateFormat.format(invoice.getInvCreationDate()));
                    invCreationDateTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                    invCreationDateTV.setPadding(10, 0, 0, 0);
                    invCreationDateTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    invCreationDateTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    invCreationDateTV.setEllipsize(TextUtils.TruncateAt.END);
                    invCreationDateTV.setHorizontallyScrolling(false);
                    invCreationDateTV.setMaxWidth(60);


                    TextView invDueDateTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                    invDueDateTV.setHeight(80);
                    TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(3);
                    invDueDateTV.setLayoutParams(layoutParams3);

                    invDueDateTV.setText(invoice.getInvDueDate()==null?"":dateFormat.format(invoice.getInvDueDate()));
                    invDueDateTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                    invDueDateTV.setPadding(10, 0, 0, 0);
                    invDueDateTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    invDueDateTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    invDueDateTV.setEllipsize(TextUtils.TruncateAt.END);
                    invDueDateTV.setHorizontallyScrolling(false);
                    invDueDateTV.setMaxWidth(timeShowWidth);

                    TextView statusView = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));
                    statusView.setLayoutParams(new TableRow.LayoutParams(4));
                    statusView.setText(invoice.getInvStatus());
                    statusView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    statusView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    statusView.setGravity(Gravity.CENTER);
                    statusView.setPadding(0,0,10,0);


                    dataRowMaster.addView(invoiceNoTV);
                    dataRowMaster.addView(invCreationDateTV);
                    dataRowMaster.addView(invDueDateTV);
                    dataRowMaster.addView(statusView);
                    invoiceTable.addView(dataRowMaster);


                    setOnClickInvoiceRowInf(dataRowMaster,invoice,bill);

                }

            }
            TabInfo invTab = generateTabAttr(R.id.financial_summary_invoice_inf_table);

            //Set Payment history
            TableLayout pymTable = this.findViewById(R.id.financial_summary_payment_inf_table);
            List<TableRow>  rows = new ArrayList<TableRow>();

            if(bill.getPayment().size()==0){
                TableRow dataRowMaster = new TableRow(this);

                //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));


                layParams.setMargins(0, 0, 0, 0);
                dataRowMaster.setLayoutParams(layParams);
                dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                dataRowMaster.setPadding(0, 10, 10, 10);
                TextView notFoundTView = new TextView(new ContextThemeWrapper(this,R.style.dataText));

                notFoundTView.setHeight(80);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                layoutParams.span = 4;
                notFoundTView.setLayoutParams(layoutParams);

                notFoundTView.setText(" Not found ");
                notFoundTView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                notFoundTView.setPadding(10, 0, 0, 0);
                notFoundTView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                notFoundTView.setTextColor(getResources().getColor(R.color.dark_gray));
                dataRowMaster.addView(notFoundTView);
                pymTable.addView(dataRowMaster);

            }else {

                int seq=0;

                for(PaymentDto payment : bill.getPayment()) {
                    for (PaymentActivityDto payAct : payment.getPaymentActivity()) {
                        seq++;
                        TableRow dataRowMaster = new TableRow(this);

                        //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                        TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                        if (seq % 2 != 0) {
                            dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
                        } else {
                            dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouched));
                        }

                        layParams.setMargins(0, 0, 0, 0);
                        dataRowMaster.setLayoutParams(layParams);
                        dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                        dataRowMaster.setPadding(0, 10, 10, 10);


                        TextView postingDateTV = new TextView(new ContextThemeWrapper(this, R.style.dataText_not_selectable));

                        postingDateTV.setHeight(80);
                        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                        postingDateTV.setLayoutParams(layoutParams);

                        postingDateTV.setText(payAct.getActvDate() == null ? "" : dateFormat_NO_CLOCK.format(payAct.getActvDate()));
                        postingDateTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                        postingDateTV.setPadding(10, 0, 0, 0);
                        postingDateTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        postingDateTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        postingDateTV.setEllipsize(TextUtils.TruncateAt.END);
                        postingDateTV.setHorizontallyScrolling(false);
                        postingDateTV.setMaxWidth(timeShowWidth);

                        TextView sourceTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                        sourceTV.setHeight(80);
                        TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(2);
                        sourceTV.setLayoutParams(layoutParams2);

                        String sourceType =payment.getSourceType()==null?"":payment.getSourceType();
                        String sourceId   =payment.getSourceId()==null?"":payment.getSourceId();

                        sourceTV.setText(sourceType+" "+sourceId);
                        sourceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                        sourceTV.setPadding(10, 0, 0, 0);
                        sourceTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        sourceTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));


                        TextView invoiceNoTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                        invoiceNoTV.setHeight(80);
                        TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(3);
                        invoiceNoTV.setLayoutParams(layoutParams3);

                        invoiceNoTV.setText(payment.getInvoiceNumber()==null?"":payment.getInvoiceNumber());
                        invoiceNoTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                        invoiceNoTV.setPadding(10, 0, 0, 0);
                        invoiceNoTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        invoiceNoTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));


                        TextView methodTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                        methodTV.setHeight(80);
                        TableRow.LayoutParams layoutParams4 = new TableRow.LayoutParams(4);
                        methodTV.setLayoutParams(layoutParams4);

                        String pymType=payment.getPymType()==null?"":payment.getPymType();
                        String pymSubType=payment.getPymSubType()==null?"":payment.getPymSubType();
                        String method = pymType+" "+pymSubType;

                        methodTV.setText(method);
                        methodTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                        methodTV.setPadding(10, 0, 0, 0);
                        methodTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        methodTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                        dataRowMaster.addView(postingDateTV);
                        dataRowMaster.addView(sourceTV);
                        dataRowMaster.addView(invoiceNoTV);
                        dataRowMaster.addView(methodTV);
                        rows.add(dataRowMaster);
                        //try{pymTable.addView(dataRowMaster);}catch (Exception ex){ex.printStackTrace();}
                        setOnClickPaymentRowInf(dataRowMaster,String.format("%d",bill.getBan()),payment,payAct);
                    }
                }
                //setPaggingTable(pymTable,rows,10);
                PaggingTable pagging = new PaggingTable(pymTable,rows,3,4,7);

            }
            TabInfo pymTab = generateTabAttr(R.id.financial_summary_payment_inf_table);



            //Set Subscriber Detail

            TableLayout subscriberTable = findViewById(R.id.financial_summary_subscriber_inf_table);
            try{subscriberTable.removeViews(3,subscriberTable.getChildCount()-3);}catch (Exception ex){}
            if(bill.getSubscriber().size()==0){

                TableRow dataRowMaster = new TableRow(this);

                //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));


                layParams.setMargins(0, 0, 0, 0);
                dataRowMaster.setLayoutParams(layParams);
                dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                dataRowMaster.setPadding(0, 10, 10, 10);
                TextView notFoundTView = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                notFoundTView.setHeight(80);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                layoutParams.span = 4;
                notFoundTView.setLayoutParams(layoutParams);

                notFoundTView.setText(" Not found ");
                notFoundTView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                notFoundTView.setPadding(10, 0, 0, 0);
                notFoundTView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                notFoundTView.setTextColor(getResources().getColor(R.color.dark_gray));
                dataRowMaster.addView(notFoundTView);
                subscriberTable.addView(dataRowMaster);


            }else{

                int seq=0;
                for(SubscriberDto subscriber : bill.getSubscriber()){
                    seq++;
                    TableRow dataRowMaster = new TableRow(this);
                    TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                    if (seq % 2 != 0) {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
                    } else {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouched));
                    }

                    layParams.setMargins(0, 0, 0, 0);
                    dataRowMaster.setLayoutParams(layParams);
                    dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                    dataRowMaster.setPadding(0, 10, 10, 10);


                    TextView subscrNumberTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                    subscrNumberTV.setHeight(80);
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                    subscrNumberTV.setLayoutParams(layoutParams);

                    subscrNumberTV.setText(subscriber.getId().getSubscriberNo());
                    subscrNumberTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    subscrNumberTV.setPadding(10, 0, 0, 0);
                    subscrNumberTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    subscrNumberTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    dataRowMaster.addView(subscrNumberTV);

                    TextView subscrStatusTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                    subscrStatusTV.setHeight(80);
                    TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(2);
                    subscrStatusTV.setLayoutParams(layoutParams2);

                    subscrStatusTV.setText(subscriber.getSubStatus()==null?"":subscriber.getSubStatus());
                    subscrStatusTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    subscrStatusTV.setPadding(10, 0, 0, 0);
                    subscrStatusTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    subscrStatusTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    dataRowMaster.addView(subscrStatusTV);


                    TextView initActvDateTV = new TextView(new ContextThemeWrapper(this, R.style.dataText_not_selectable));
                    initActvDateTV.setHeight(80);
                    TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(3);
                    initActvDateTV.setLayoutParams(layoutParams3);

                    initActvDateTV.setText(subscriber.getInitActivationDate() == null ? "" : dateFormat_NO_CLOCK.format(subscriber.getInitActivationDate()));
                    initActvDateTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                    initActvDateTV.setPadding(10, 0, 0, 0);
                    initActvDateTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    initActvDateTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    initActvDateTV.setEllipsize(TextUtils.TruncateAt.END);
                    initActvDateTV.setHorizontallyScrolling(false);
                    initActvDateTV.setMaxWidth(timeShowWidth);

                    dataRowMaster.addView(initActvDateTV);

                    TextView subscrReasonTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));
                    subscrReasonTV.setHeight(80);
                    TableRow.LayoutParams layoutParams4 = new TableRow.LayoutParams(4);
                    subscrReasonTV.setLayoutParams(layoutParams4);

                    subscrReasonTV.setText(subscriber.getSubStatusRsnCode()==null?"":subscriber.getSubStatusRsnCode());
                    subscrReasonTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    subscrReasonTV.setPadding(10, 0, 0, 0);
                    subscrReasonTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    subscrReasonTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    dataRowMaster.addView(subscrReasonTV);
                    try{subscriberTable.addView(dataRowMaster);}catch (Exception ex){ex.printStackTrace();}
                    setOnClickSubscriberRowInf(dataRowMaster,subscriber);

                }


            }

            TabInfo subscriberTab = generateTabAttr(R.id.financial_summary_subscriber_inf_table);

            //Set Adjustment history

            TableLayout adjustHistoryTable = findViewById(R.id.adjustment_history_inf_table);
            try{adjustHistoryTable.removeViews(3,adjustHistoryTable.getChildCount()-3);}catch (Exception ex){}
            if(bill.getAdjustment().size()==0){
                TableRow dataRowMaster = new TableRow(this);

                //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));


                layParams.setMargins(0, 0, 0, 0);
                dataRowMaster.setLayoutParams(layParams);
                dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                dataRowMaster.setPadding(0, 10, 10, 10);
                TextView notFoundTView = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                notFoundTView.setHeight(80);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                layoutParams.span = 4;
                notFoundTView.setLayoutParams(layoutParams);

                notFoundTView.setText(" Not found ");
                notFoundTView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                notFoundTView.setPadding(10, 0, 0, 0);
                notFoundTView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                notFoundTView.setTextColor(getResources().getColor(R.color.dark_gray));
                dataRowMaster.addView(notFoundTView);
                adjustHistoryTable.addView(dataRowMaster);

            }else{
                int seq=0;
                for(AdjustmentsDto adjust : bill.getAdjustment()){
                    seq++;
                    TableRow dataRowMaster = new TableRow(this);
                    TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                    if (seq % 2 != 0) {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
                    } else {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouched));
                    }

                    layParams.setMargins(0, 0, 0, 0);
                    dataRowMaster.setLayoutParams(layParams);
                    dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                    dataRowMaster.setPadding(0, 10, 10, 10);

                    TextView adjDateTV = new TextView(new ContextThemeWrapper(this, R.style.dataText_not_selectable));
                    adjDateTV.setHeight(80);
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                    adjDateTV.setLayoutParams(layoutParams);

                    adjDateTV.setText(adjust.getActvDate() == null ? "" : dateFormat_NO_CLOCK.format(adjust.getActvDate()));
                    adjDateTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                    adjDateTV.setPadding(10, 0, 0, 0);
                    adjDateTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    adjDateTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    adjDateTV.setEllipsize(TextUtils.TruncateAt.END);
                    adjDateTV.setHorizontallyScrolling(false);
                    adjDateTV.setMaxWidth(timeShowWidth);
                    dataRowMaster.addView(adjDateTV);

                    TextView adjReasonTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));
                    adjReasonTV.setHeight(80);
                    TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(2);
                    adjReasonTV.setLayoutParams(layoutParams2);
                    adjReasonTV.setText(adjust.getActvReasonCode()==null?"":adjust.getActvReasonCode());
                    adjReasonTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    adjReasonTV.setPadding(10, 0, 0, 0);
                    adjReasonTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    adjReasonTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    dataRowMaster.addView(adjReasonTV);

                    TextView adjDescTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));
                    adjDescTV.setHeight(80);
                    TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(3);
                    adjDescTV.setLayoutParams(layoutParams3);
                    adjDescTV.setText(adjust.getAdjustmentReason()==null?"":(adjust.getAdjustmentReason().getAdjDsc()==null?"":adjust.getAdjustmentReason().getAdjDsc()));
                    adjDescTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                    adjDescTV.setPadding(10, 0, 0, 0);
                    adjDescTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    adjDescTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    adjDateTV.setEllipsize(TextUtils.TruncateAt.END);
                    adjDateTV.setMaxWidth(200);
                    dataRowMaster.addView(adjDescTV);

                    try{adjustHistoryTable.addView(dataRowMaster);}catch (Exception ex){}
                    setOnClickAdjusmentHistoryRowInf(dataRowMaster,adjust);

                }


            }


            TabInfo adjustmentHistoryTab = generateTabAttr(R.id.adjustment_history_inf_table);

            //Set Refund history Table tab


            TableLayout refundHistoryTable = findViewById(R.id.refund_history_inf_table);
            try{refundHistoryTable.removeViews(3,refundHistoryTable.getChildCount()-3);}catch (Exception ex){}
            if(bill.getRefund().size()==0){

                TableRow dataRowMaster = new TableRow(this);

                //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));


                layParams.setMargins(0, 0, 0, 0);
                dataRowMaster.setLayoutParams(layParams);
                dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                dataRowMaster.setPadding(0, 10, 10, 10);
                TextView notFoundTView = new TextView(new ContextThemeWrapper(this,R.style.dataText));

                notFoundTView.setHeight(80);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                layoutParams.span = 4;
                notFoundTView.setLayoutParams(layoutParams);

                notFoundTView.setText(" Not found ");
                notFoundTView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                notFoundTView.setPadding(10, 0, 0, 0);
                notFoundTView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                notFoundTView.setTextColor(getResources().getColor(R.color.dark_gray));
                dataRowMaster.addView(notFoundTView);
                refundHistoryTable.addView(dataRowMaster);
            }else{
                int seq=0;
                for(RefundDto refund : bill.getRefund()){

                    seq++;
                    TableRow dataRowMaster = new TableRow(this);
                    TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

                    if (seq % 2 != 0) {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
                    } else {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouched));
                    }

                    layParams.setMargins(0, 0, 0, 0);
                    dataRowMaster.setLayoutParams(layParams);
                    dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                    dataRowMaster.setPadding(0, 10, 10, 10);

                    TextView refundDateTV = new TextView(new ContextThemeWrapper(this, R.style.dataText_not_selectable));
                    refundDateTV.setHeight(80);
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(1);
                    refundDateTV.setLayoutParams(layoutParams);

                    refundDateTV.setText(refund.getActvDate() == null ? "" : dateFormat_NO_CLOCK.format(refund.getActvDate()));
                    refundDateTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                    refundDateTV.setPadding(10, 0, 0, 0);
                    refundDateTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    refundDateTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    refundDateTV.setEllipsize(TextUtils.TruncateAt.END);
                    refundDateTV.setHorizontallyScrolling(false);
                    refundDateTV.setMaxWidth(timeShowWidth);
                    dataRowMaster.addView(refundDateTV);

                    TextView refundReasonTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));
                    refundReasonTV.setHeight(80);
                    TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(2);
                    refundReasonTV.setLayoutParams(layoutParams2);
                    refundReasonTV.setText(refund.getRefundReason()==null?"":refund.getRefundReason().getRefundReasonCode());
                    refundReasonTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    refundReasonTV.setPadding(10, 0, 0, 0);
                    refundReasonTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    refundReasonTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    dataRowMaster.addView(refundReasonTV);

                    TextView refundDescTV = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));
                    refundDescTV.setHeight(80);
                    TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(3);
                    refundDescTV.setLayoutParams(layoutParams3);
                    refundDescTV.setText(refund.getRefundReason()==null?"":refund.getRefundReason().getRefundDesc());
                    refundDescTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    refundDescTV.setPadding(10, 0, 0, 0);
                    refundDescTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    refundDescTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    dataRowMaster.addView(refundDescTV);
                    try{refundHistoryTable.addView(dataRowMaster);}catch (Exception ex){ex.printStackTrace();}

                    setOnClickRefundHistoryRowInf(dataRowMaster,refund);

                }

            }

            TabInfo refundHistoryTab = generateTabAttr(R.id.refund_history_inf_table);


        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }

    }
    public void setOnClickInvoiceRowInf(TableRow row,final InvoiceItemDto invoice,final BillingAccountDto bill){
        try{
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showInvoiceDetailPopup(invoice,bill);

                }
            });

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }

    }
    public void setOnClickPaymentRowInf(TableRow row,final String ban,final PaymentDto payment,final PaymentActivityDto paymentActivity){
        try{
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showPaymentDetailPopup(ban,payment,paymentActivity);

                }
            });

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }

    }
    public void setOnClickSubscriberRowInf(TableRow row,final SubscriberDto subscriber){
        try{
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showSubscriberDetailPopup(subscriber);

                }
            });

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }

    }
    public void setOnClickAdjusmentHistoryRowInf(TableRow row,final AdjustmentsDto adjusment){
        try{
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showAdjusmentHistoryDetailPopup(adjusment);

                }
            });

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }

    }
    public void setOnClickRefundHistoryRowInf(TableRow row,final RefundDto refund){
        try{
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showRefundHistoryDetailPopup(refund);

                }
            });

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }

    }
    public void showInvoiceDetailPopup(final InvoiceItemDto invoice,final BillingAccountDto bill){

        try{


            // create the popup window
            final ConstraintLayout mainlayout = findViewById(R.id.billing_account_main_layout);
            final InvoiceInfoDialog invoiceDialog = new InvoiceInfoDialog();
            int width = (int)(mainlayout.getWidth()/1.1);
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;

            invoiceDialog.setWidth(width);
            invoiceDialog.setHeight(height);
            invoiceDialog.setBill(bill);
            invoiceDialog.setMainView(mainlayout);
            invoiceDialog.setInvoice(invoice);


            invoiceDialog.show(getFragmentManager(),"Invoice detail");


            invoiceDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                    if(invoiceDialog.isCreateAdjustClicked()){
                        fecthBillingDataToInformationView(bill);
                        invoiceDialog.setCreateAdjustClicked(false);
                    }

                }
            });


        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }


    }
    public void showPaymentDetailPopup(final String ban,final PaymentDto payment,final PaymentActivityDto paymentActivity){

        try{

            LinearLayout infLayout = findViewById(R.id.billing_information_panel);

            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            final View popupView = inflater.inflate(R.layout.payment_detail_layout, null);

            // create the popup window

            final PaymentInfoDialog paymentInfoDialog = new PaymentInfoDialog();

            paymentInfoDialog.setBan(ban);
            paymentInfoDialog.setPayment(payment);
            paymentInfoDialog.setPaymentActivity(paymentActivity);



            boolean focusable = true; // lets taps outside the popup also dismiss it
            final ConstraintLayout mainlayout = findViewById(R.id.billing_account_main_layout);

            int width = (int)(mainlayout.getWidth()/1.1);
            int height = (int)(mainlayout.getHeight()/1.05);
            paymentInfoDialog.setMainView(mainlayout);
            paymentInfoDialog.setWidth(width);
            paymentInfoDialog.setHeight(height);

            paymentInfoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                    try{
                        if(paymentInfoDialog.isRefundSuccess()||paymentInfoDialog.isSuccessBackout()){

                                BillingAccountDto bill = new BillingAccountDto();
                                bill.setBan(Long.valueOf(ban));
                                fecthBillingDataToInformationView(bill);

                        }

                    }catch (Exception ex){

                        ex.printStackTrace();
                        alert(ex.getMessage());
                    }


                }
            });

            paymentInfoDialog.show(getFragmentManager(),"Payment Detail");



        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }


    }



    public void showSubscriberDetailPopup(final SubscriberDto subscriber){

        try{

            LinearLayout infLayout = findViewById(R.id.billing_information_panel);

            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.subscriber_detail_layout, null);

            // create the popup window

            boolean focusable = true; // lets taps outside the popup also dismiss it
            final ConstraintLayout mainlayout = findViewById(R.id.billing_account_main_layout);

            int width = (int)(mainlayout.getWidth()/1.2);
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;

            SubscriberInfoDialog subscriberInfoDialog = new SubscriberInfoDialog();

            subscriberInfoDialog.setWidth(width);
            subscriberInfoDialog.setHeight(height);
            subscriberInfoDialog.setSubscriber(subscriber);

            subscriberInfoDialog.show(getFragmentManager(),"Subscriber Detail");

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }


    }
    public void showAdjusmentHistoryDetailPopup(final AdjustmentsDto adjusment){

        try{


            LinearLayout infLayout = findViewById(R.id.billing_information_panel);

            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.adjustment_detail_layout, null);

            // create the popup window

            boolean focusable = true; // lets taps outside the popup also dismiss it
            final ConstraintLayout mainlayout = findViewById(R.id.billing_account_main_layout);

            int width = (int)(mainlayout.getWidth()/1.2);
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;

            AdjustmentInfoDialog adjustmentInfoDialog = new AdjustmentInfoDialog();

            adjustmentInfoDialog.setWidth(width);
            adjustmentInfoDialog.setHeight(height);
            adjustmentInfoDialog.setAdjustment(adjusment);

            adjustmentInfoDialog.show(getFragmentManager(),"Adjustment Detail");

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }


    }
    public void showRefundHistoryDetailPopup(final RefundDto refund){

        try{

            LinearLayout infLayout = findViewById(R.id.billing_information_panel);

            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.refund_detail_layout, null);

            // create the popup window

            boolean focusable = true; // lets taps outside the popup also dismiss it
            final ConstraintLayout mainlayout = findViewById(R.id.billing_account_main_layout);

            int width = (int)(mainlayout.getWidth()/1.2);
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;

            RefundHistoryInfoDialog refundHistoryInfoDialog = new RefundHistoryInfoDialog();

            refundHistoryInfoDialog.setWidth(width);
            refundHistoryInfoDialog.setHeight(height);
            refundHistoryInfoDialog.setRefund(refund);

            refundHistoryInfoDialog.show(getFragmentManager(),"Refund History Detail");


        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());

        }


    }
    public int  orig_result_list_panel_height =0;
    public void collapseInifomationPanelAndExpandListResult(){

        LinearLayout inf_layout = findViewById(R.id.billing_information_panel);
        LinearLayout resutl_list_layout = findViewById(R.id.billing_data_panel);
        int rootHeight = inf_layout.getRootView().getHeight();

        Animator.collapse(inf_layout,500,0);
        Animator.expand(resutl_list_layout,500,orig_result_list_panel_height);

    }

    public void printSearchResultToTable(List<BillingAccountDto> billList,String criteria){

        try{

            LinearLayout linDataResult = findViewById(R.id.billing_data_panel);
            LinearLayout linearBillInf = findViewById(R.id.billing_information_panel);
            TableLayout billingDataTable=findViewById(R.id.billing_search_result_tablelayout);
            linDataResult.setVisibility(View.VISIBLE);
            linearBillInf.setVisibility(View.VISIBLE);
            try {billingDataTable.removeViews(1, billingDataTable.getChildCount()-1);}catch (Exception ex){}
            int seq=0;
            for(int i=0;i<1;i++) {
                for (BillingAccountDto bill : billList) {
                    seq++;

                    TableRow dataRowMaster = new TableRow(this);

                    //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                    TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
                    if (seq % 2 != 0) {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouched));
                    } else {
                        dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
                    }

                    layParams.setMargins(0, 0, 0, 0);
                    dataRowMaster.setLayoutParams(layParams);
                    dataRowMaster.setGravity(Gravity.CENTER_VERTICAL);
                    dataRowMaster.setPadding(0, 10, 10, 10);
                    TextView banTextView = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                    banTextView.setHeight(80);
                    banTextView.setLayoutParams(new TableRow.LayoutParams(1));
                    banTextView.setText("" + bill.getBan());
                    banTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    banTextView.setPadding(10, 0, 0, 0);
                    banTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    banTextView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    TextView nameView = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                    nameView.setHeight(80);
                    nameView.setLayoutParams(new TableRow.LayoutParams(2));

                    NameDataDto nameData = bill.getAddressNameLink().get(0).getNameData();

                    nameView.setText(nameData.getFirstName() + " " + nameData.getLastBusinessName());
                    nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    nameView.setPadding(10, 0, 0, 0);
                    nameView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    TextView col3View = new TextView(new ContextThemeWrapper(this,R.style.dataText_not_selectable));

                    col3View.setHeight(80);
                    col3View.setLayoutParams(new TableRow.LayoutParams(3));
                    col3View.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    col3View.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    TextView billingCol3Header = findViewById(R.id.billint_data_col3_header);


                    switch (criteria) {

                        case "ID":
                            // alert("IDENTIFICATION");
                            col3View.setText(bill.getCustomer().getCertificateNumber());
                            billingCol3Header.setText(criteria);
                            break;
                        case "Invoice":
                            // alert("IDENTIFICATION");
                            col3View.setText(bill.getInvoiceItem().get(0).getInvoiceNumber());
                            billingCol3Header.setText(criteria);
                            break;

                        default:
                            col3View.setText(bill.getSubscriberObj().getId().getSubscriberNo());
                            break;
                    }
                    col3View.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    col3View.setPadding(10, 0, 0, 0);

                    dataRowMaster.addView(banTextView);
                    dataRowMaster.addView(nameView);
                    dataRowMaster.addView(col3View);
                    setOnclickRowBillingData(dataRowMaster,bill);
                    billingDataTable.addView(dataRowMaster);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());
        }
    }


    @Override
    public void onBackPressed() {
        if(!isInfoClicked)super.onBackPressed();
        else{
            isInfoClicked = false;
            final ImageButton searchButtonTop = findViewById(R.id.searchButtonTop);
            final SearchView searchView = findViewById(R.id.searchBillView);
            searchButtonTop.callOnClick();
            searchView.clearFocus();
        }

    }



    public int getSearchPanelHeight() {
        return searchPanelHeight;
    }

    public void setSearchPanelHeight(int searchPanelHeight) {
        this.searchPanelHeight = searchPanelHeight;
    }



}
