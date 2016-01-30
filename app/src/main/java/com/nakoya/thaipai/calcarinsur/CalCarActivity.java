package com.nakoya.thaipai.calcarinsur;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CalCarActivity extends Activity {
    Integer[] im = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,
            R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,R.drawable.a16,
            R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a23,R.drawable.a24,
            R.drawable.a25,R.drawable.a26,R.drawable.a27,R.drawable.a28,R.drawable.a29,R.drawable.a30,R.drawable.a31,R.drawable.a32,
            R.drawable.a33,R.drawable.a34,R.drawable.a35,R.drawable.a36,R.drawable.a37,R.drawable.a38,R.drawable.a39,R.drawable.a40,
            R.drawable.a41,R.drawable.a42,R.drawable.a43,R.drawable.a44,R.drawable.a45,R.drawable.a46,R.drawable.a47,R.drawable.a48,
            R.drawable.a49,R.drawable.a50,R.drawable.a51,R.drawable.a52,R.drawable.a53,R.drawable.a54};
    Spinner spBrand,spModel,spYear;
    ArrayList<String> al1;
    List<String> al2 = new ArrayList<String>();
    List<String> al3 = new ArrayList<String>();
    List<String> al4 = new ArrayList<String>();

    public TextView sStart,sEnd,txtInsur,txtInsurTotal,txtRepairC,txtRepairCTotal,txtMax,txtAvg,txtMin,sAgecar,sMotor,sGroup;
    public EditText txtInput,iAgedrive,iFleet,iNcb,iOther,iOd,iTp,iName,iRegis,iMode,iMe,iTppd,iTpbi,iPa,iBail,iDamageX,iPersonNum;
    public ImageView pic;
    public Button btnCal,btnPrint;

    public ReadText rFt = new ReadText("");
    public Formula sentAmount1 = new Formula();

    public DecimalFormat formatter = new DecimalFormat("#,###,###,###,###");
    public DecimalFormat formatter1 = new DecimalFormat("#,###,###,###,###.00");
    public DecimalFormat formatter2 = new DecimalFormat("#,###,###,##0,000");

    public String amount3x,amount4x,amountmin,amountavg,amountmax,xx1,xx2,xx3,xx4,xx5,xx6,xx7,xx8;
    public String numYear1,numYear2,temp,bandId;
    public String[] bTemp,al11;

    public int bmode=0;

    public Double rateModeCar=0.0, rateMotorCar=0.0, rateDriverAge=0.0,rateCarAge=0.0, rateCapIsur=0.0,rateGroupCar=0.0, rateF=0.0, rateG=0.0, rateH=0.0;
    public Double avg=0.0,min=0.0,max=0.0,minf=0.0,maxf=0.0,getagef=0.0;
    public Double amount1=0.0,amount2=0.0,amount3=0.0,amount4=0.00;
    public Double amount11=0.0 ,amount21=0.0,amount31=0.0,amount41=0.00;

    public static final Double FIX80=0.8;
    public static final Double FIX90=0.9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calinsur);
        spBrand = (Spinner)findViewById(R.id.spinnerBrand);
        spModel = (Spinner)findViewById(R.id.spinnerModel);
        spYear = (Spinner)findViewById(R.id.spinnerYear);
        btnCal = (Button)findViewById(R.id.btnCal);
        btnPrint = (Button)findViewById(R.id.btnPrint);
        txtInput = (EditText)findViewById(R.id.txtInput);
        txtInsur = (TextView)findViewById(R.id.txtInput);
        txtInsurTotal = (TextView)findViewById(R.id.txtInsurTotal);
        txtRepairC = (TextView)findViewById(R.id.txtRepairC);
        txtRepairCTotal = (TextView)findViewById(R.id.txtRepairCTotal);
        txtMax = (TextView)findViewById(R.id.txtMax);
        txtMin = (TextView)findViewById(R.id.txtMin);
        txtAvg = (TextView)findViewById(R.id.txtAvg);


        final Dialog diaCalCar = new Dialog(CalCarActivity.this);
        diaCalCar.requestWindowFeature(diaCalCar.getWindow().FEATURE_NO_TITLE);
        diaCalCar.setContentView(R.layout.insurdetail);
        diaCalCar.setCancelable(true);

        Button btnDia = (Button)findViewById(R.id.btnDialog);
        btnDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaCalCar.show();
                Button btnClose = (Button)findViewById(R.id.btnClose);
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xx1 = formatter.format(Double.parseDouble(iTppd.getText().toString().replace(",","").trim()));
                        xx2 = formatter.format(Double.parseDouble(iTpbi.getText().toString().replace(",","").trim()));
                        xx3 = formatter.format(Double.parseDouble(iDamageX.getText().toString().replace(",","").trim()));
                        xx4 = formatter.format(Double.parseDouble(iPa.getText().toString().replace(",","").trim()));
                        xx5 = formatter.format(Double.parseDouble(iMe.getText().toString().replace(",","").trim()));
                        xx6 = formatter.format(Double.parseDouble(iBail.getText().toString().replace(",","").trim()));
                        xx7 = formatter.format(Double.parseDouble(iOd.getText().toString().replace(",","").trim()));
                        xx8 = formatter.format(Double.parseDouble(iTp.getText().toString().replace(",","").trim()));

                        iTppd.setText(xx1);
                        iTpbi.setText(xx2);
                        iDamageX.setText(xx3);
                        iPa.setText(xx4);
                        iMe.setText(xx5);
                        iBail.setText(xx6);
                        iOd.setText(xx7);
                        iTp.setText(xx8);
                        bmode = Integer.parseInt(iMode.getText().toString().trim());
                        if(bmode == 110 || bmode == 120)
                            diaCalCar.cancel();
                        else{
                            Toast.makeText(CalCarActivity.this, String.valueOf(R.string.msgcalinsur1), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
