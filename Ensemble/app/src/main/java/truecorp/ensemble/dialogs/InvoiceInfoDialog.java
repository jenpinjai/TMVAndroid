package truecorp.ensemble.dialogs;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import truecorp.core.model.AdjustmentDto;
import truecorp.core.model.BillingAccountDto;
import truecorp.core.model.InvoiceItemDto;
import truecorp.ensemble.AdjustmentActivity;
import truecorp.ensemble.BillingAccountActivity;
import truecorp.ensemble.R;

/**
 * Created by Jennarong Pinjai on 19/2/2561.
 */

public class InvoiceInfoDialog extends BaseDialogFragment {

    private BillingAccountDto bill;
    private InvoiceItemDto invoice;
    private boolean createAdjustClicked=false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        try{

            View popupView = inflater.inflate(R.layout.invoice_inf_layout,container,false);

            TextView iconClose = popupView.findViewById(R.id.icon_close_popup);
            final Dialog popupWindow = getDialog();
            iconClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            String amountFormat ="%,.2f";


            TextView  invoiceNoTextView = popupView.findViewById(R.id.invoice_numer_detail_text_popup);
            invoiceNoTextView.setText(invoice.getInvoiceNumber());
            invoiceNoTextView.setEllipsize(TextUtils.TruncateAt.END);
            invoiceNoTextView.setHorizontallyScrolling(false);
            invoiceNoTextView.setMaxWidth(200);

            TextView  invoiceTypeTextView = popupView.findViewById(R.id.invoice_type_detail_text_popup);
            invoiceTypeTextView.setText(invoice.getInvType());

            TextView  billDateTextView = popupView.findViewById(R.id.invoice_bill_date_detail_text_popup);
            billDateTextView.setEllipsize(TextUtils.TruncateAt.END);
            billDateTextView.setHorizontallyScrolling(false);
            billDateTextView.setMaxWidth(150);
            if(invoice.getBill()!=null){
                Date billDate =invoice.getBill().getBillDate();
                billDateTextView.setText(billDate==null?"": BillingAccountActivity.dateFormat_NO_CLOCK.format(billDate));
            }
            double charge = invoice.getChargesAmt()==null?0:invoice.getChargesAmt().doubleValue();
            double credit = invoice.getBillCreditAmt()==null?0:invoice.getBillCreditAmt().doubleValue();
            double discount = invoice.getBillDiscountAmt()==null?0:invoice.getBillDiscountAmt().doubleValue();
            double tax = invoice.getTaxTotInvAmt()==null?0:invoice.getTaxTotInvAmt().doubleValue();
            double origInvAmt =charge-credit-discount;
            final double totalInvAmt = origInvAmt + tax;

            TextView  invoiceChargeTextView = popupView.findViewById(R.id.invoice_charge_detail_text_popup);
            invoiceChargeTextView.setText(String.format(amountFormat,charge));

            TextView  invoiceCreditTextView = popupView.findViewById(R.id.invoice_credit_detail_text_popup);
            invoiceCreditTextView.setText(String.format(amountFormat,credit));

            TextView  invoiceDiscountTextView = popupView.findViewById(R.id.invoice_discount_detail_text_popup);
            invoiceDiscountTextView.setText(String.format(amountFormat,discount));

            TextView  totalOrigInvoiceTextView = popupView.findViewById(R.id.invoice_total_original_detail_text_popup);
            totalOrigInvoiceTextView.setText(String.format(amountFormat,origInvAmt));

            TextView  invoiceTaxTextView = popupView.findViewById(R.id.invoice_tax_detail_text_popup);
            invoiceTaxTextView.setText(String.format(amountFormat,tax));


            TextView  invoiceTotalAmtView = popupView.findViewById(R.id.invoice_total_invoice_amount_text_popup);
            invoiceTotalAmtView.setText(String.format(amountFormat,totalInvAmt));


            double invPayment = invoice.getTotPymCrdAmt()==null?0:invoice.getTotPymCrdAmt().doubleValue();
            double nonSpecPayment = invoice.getTotSpecificPymAmt()==null?0:invoice.getTotSpecificPymAmt().doubleValue();
            double totalCovered = invPayment + nonSpecPayment;

            TextView  invoicePaymentAmtView = popupView.findViewById(R.id.invoice_payment_amount_text_popup);
            invoicePaymentAmtView.setText(String.format(amountFormat,invPayment));

            TextView  invoiceNonSpecPaymentAmtView = popupView.findViewById(R.id.invoice_non_spec_payment_text_popup);
            invoiceNonSpecPaymentAmtView.setText(String.format(amountFormat,nonSpecPayment));

            TextView  invoiceTotalCoveredAmtView = popupView.findViewById(R.id.invoice_total_covered_text_popup);
            invoiceTotalCoveredAmtView.setText(String.format(amountFormat,totalCovered));

            double specAdjustment = invoice.getTotGenAdjAmt()==null?0:invoice.getTotGenAdjAmt().doubleValue();
            double taxAdj         = invoice.getTaxTotAdjAmt()==null?0:invoice.getTaxTotAdjAmt().doubleValue();
            double nonSpecAdjustment = invoice.getDsptAdjAmt()==null?0:invoice.getDsptAdjAmt().doubleValue();
            final double totalAdjustment = specAdjustment + taxAdj + nonSpecAdjustment;

            TextView  invoiceSpecAdjustmentTextView = popupView.findViewById(R.id.invoice_spec_adjustment_text_popup);
            invoiceSpecAdjustmentTextView.setText(String.format(amountFormat,specAdjustment));

            TextView  invoiceTaxAdjustmentTextView = popupView.findViewById(R.id.invoice_tax_adjustment_text_popup);
            invoiceTaxAdjustmentTextView.setText(String.format(amountFormat,taxAdj));

            TextView  invoiceNonSpecAdjustmentTextView = popupView.findViewById(R.id.invoice_non_spec_adjustment_text_popup);
            invoiceNonSpecAdjustmentTextView.setText(String.format(amountFormat,nonSpecAdjustment));

            TextView  invoiceTotalAdjustmentTextView = popupView.findViewById(R.id.invoice_total_adjustment_text_popup);
            invoiceTotalAdjustmentTextView.setText(String.format(amountFormat,totalAdjustment));

            Button createAdjBtn = popupView.findViewById(R.id.create_adjust_btn);

            createAdjBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try{
                        createAdjustClicked = true;
                        Intent Intent = new Intent(v.getContext(), AdjustmentActivity.class);
                        AdjustmentDto adj = new AdjustmentDto();
                        adj.setBan(invoice.getId().getBan());
                        adj.setAmount(BigDecimal.valueOf(totalInvAmt));
                        adj.setCreditNoteNo("");
                        adj.setInvoicePeriod(String.format("%.0f",invoice.getPostingPeriod()));
                        adj.setSubscriberNo(invoice.getSubscriberNo()==null?(bill.getSubscriberObj().getId().getSubscriberNo()):invoice.getSubscriberNo());
                        adj.setEntSeqNo(invoice.getBillSeqNo()==null?0:invoice.getBillSeqNo().longValue());
                        adj.setTaxSeqNo(invoice.getTaxSeqNo()==null?0:invoice.getTaxSeqNo().longValue());
                        adj.setLogicalDate(Calendar.getInstance().getTime());
                        Intent.putExtra("adjustment",adj);
                        v.getContext().startActivity(Intent);



                    }catch (Exception ex){

                        ex.printStackTrace();

                    }

                }
            });

            return popupView;
        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }

    }

    public BillingAccountDto getBill() {
        return bill;
    }

    public void setBill(BillingAccountDto bill) {
        this.bill = bill;
    }

    public InvoiceItemDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceItemDto invoice) {
        this.invoice = invoice;
    }

    public boolean isCreateAdjustClicked() {
        return createAdjustClicked;
    }

    public void setCreateAdjustClicked(boolean createAdjustClicked) {
        this.createAdjustClicked = createAdjustClicked;
    }



}
