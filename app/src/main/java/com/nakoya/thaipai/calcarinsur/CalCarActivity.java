package com.nakoya.thaipai.calcarinsur;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalCarActivity extends Activity {
    Integer[] im = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,
            R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,R.drawable.a16,
            R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a23,R.drawable.a24,
            R.drawable.a25,R.drawable.a26,R.drawable.a27,R.drawable.a28,R.drawable.a29,R.drawable.a30,R.drawable.a31,R.drawable.a32,
            R.drawable.a33,R.drawable.a34,R.drawable.a35,R.drawable.a36,R.drawable.a37,R.drawable.a38,R.drawable.a39,R.drawable.a40,
            R.drawable.a41,R.drawable.a42,R.drawable.a43,R.drawable.a44,R.drawable.a45,R.drawable.a46,R.drawable.a47,R.drawable.a48,
            R.drawable.a49,R.drawable.a50,R.drawable.a51,R.drawable.a52,R.drawable.a53,R.drawable.a54};     // bug declare im
    Spinner spBrand,spModel,spYear;
    ArrayList<String> al1;
    List<String> al2 = new ArrayList<String>();
    List<String> al3 = new ArrayList<String>();
    List<String> al4 = new ArrayList<String>();

    public TextView txtProtection,txtFinished,txtInsur,txtInsurTotal,txtRepairC,txtRepairCTotal,txtMax,txtAvg,txtMin,txtCarAge,txtMachine,txtCarGroup;
    public EditText txtInput,txtDriverAge,txtFleet,txtNcb,txtOther,txtOd,txtTp,txtName,txtRegis,txtStypeuseCar,txtMe,txtTppd,txtTpbi,txtPa,txtBail,txtDamageX,txtPersonNum;
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
        txtMax = (TextView)findViewById(R.id.txtMax);   txtMax.setText(R.string.default0);
        txtMin = (TextView)findViewById(R.id.txtMin);   txtMin.setText(R.string.default0);
        txtAvg = (TextView)findViewById(R.id.txtAvg);   txtAvg.setText(R.string.default0);
        txtCarAge = (TextView)findViewById(R.id.txtCarAge); txtCarAge.setText(R.string.default0);
        txtCarGroup = (TextView)findViewById(R.id.txtCarGroup); txtCarAge.setText(R.string.default0);
        txtMachine = (TextView)findViewById(R.id.txtMachine); txtMachine.setText(R.string.default0);
        txtProtection = (TextView)findViewById(R.id.txtProtection); txtProtection.setText(R.string.default0);
        txtFinished = (TextView)findViewById(R.id.txtFinished); txtFinished.setText(R.string.default0);

        txtDriverAge = (EditText)findViewById(R.id.txtDriverAge);   txtDriverAge.setText(R.string.default0);
        txtFleet = (EditText)findViewById(R.id.txtFleet);   txtFleet.setText(R.string.default0);
        txtNcb = (EditText)findViewById(R.id.txtNcb);   txtNcb.setText(R.string.default0);
        txtName = (EditText)findViewById(R.id.txtNcb);  txtName.setText(R.string.default0);
        txtRegis = (EditText)findViewById(R.id.txtRegis);   txtRegis.setText(R.string.default0);
        txtStypeuseCar = (EditText)findViewById(R.id.txtStypeuseCar);   txtStypeuseCar.setText(R.string.default0);
        txtMe = (EditText)findViewById(R.id.txtMe); txtMe.setText(R.string.default0);
        txtTppd = (EditText)findViewById(R.id.txtTppd); txtTppd.setText(R.string.default0);
        txtTpbi = (EditText)findViewById(R.id.txtTpbi); txtTpbi.setText(R.string.default0);
        txtPa = (EditText)findViewById(R.id.txtPa);  txtPa.setText(R.string.default0);
        txtDamageX = (EditText)findViewById(R.id.txtDamage);    txtDamageX.setText(R.string.default0);
        txtPersonNum = (EditText)findViewById(R.id.txtPerson);  txtPersonNum.setText(R.string.default0);
        txtOd = (EditText)findViewById(R.id.txtOd); txtOd.setText(R.string.default0);
        txtTp = (EditText)findViewById(R.id.txtTp); txtTp.setText(R.string.default0);
        txtOther = (EditText)findViewById(R.id.txtOther); txtOther.setText(R.string.default0);
        txtBail = (EditText)findViewById(R.id.txtBail); txtOther.setText(R.string.default0);

        txtInput.setFocusableInTouchMode(true);
        txtDriverAge.setFocusableInTouchMode(true);
        txtStypeuseCar.setFocusableInTouchMode(true);
        txtTppd.setFocusableInTouchMode(true);
        txtTpbi.setFocusableInTouchMode(true);
        txtPa.setFocusableInTouchMode(true);
        txtPersonNum.setFocusableInTouchMode(true);
        txtTp.setFocusableInTouchMode(true);
        txtOd.setFocusableInTouchMode(true);
        txtPersonNum.setFocusableInTouchMode(true);
        txtOther.setFocusableInTouchMode(true);
        txtName.setFocusableInTouchMode(true);
        txtNcb.setFocusableInTouchMode(true);
        txtFleet.setFocusableInTouchMode(true);
        txtNcb.setFocusableInTouchMode(true);

        final Dialog diaCalCar = new Dialog(CalCarActivity.this);
        diaCalCar.requestWindowFeature(diaCalCar.getWindow().FEATURE_NO_TITLE);
        diaCalCar.setContentView(R.layout.insurdetail);
        diaCalCar.setCancelable(true);

        ReadText rFt = new ReadText("");
        al1 = rFt.getBand110(getAssets());
        al11 = al1.toArray(new String[al1.size()]);

        spBrand.setAdapter(new MyCustomAdapter(this, R.layout.itemspinner,al11,im));// bug declare im
        spBrand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bandId = String.valueOf(position + 1);
                ReadText rFt = new ReadText("");
                al2 = rFt.getModel(bandId, getAssets());
                ArrayAdapter<String> ad2 = new ArrayAdapter<String>(CalCarActivity.this, R.layout.support_simple_spinner_dropdown_item, al2);
                //ArrayAdapter<String> ad2 = new ArrayAdapter<String>(CalCarActivity.this, android.R.layout.simple_spinner_item,al2);
                spModel.setAdapter(ad2);
                spModel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, final int positionModel, long id) {
                        ReadText rFt = new ReadText("");
                        al3 = rFt.getYear(getAssets());
                        ArrayAdapter<String> ad3 = new ArrayAdapter<String>(CalCarActivity.this, R.layout.support_simple_spinner_dropdown_item, al3);
                        spYear.setAdapter(ad3);
                        spYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                ReadText rFt = new ReadText("");
                                al4 = rFt.getModelId(getAssets(), bandId);
                                temp = rFt.getModel1(getAssets(), bandId, al4.get(positionModel));
                                bTemp = temp.split("\t");
                                Calendar c = Calendar.getInstance();
                                SimpleDateFormat dm = new SimpleDateFormat("dd-MM");
                                SimpleDateFormat yy = new SimpleDateFormat("yyyy");
                                String date = dm.format(c.getTime());
                                String date1 = yy.format(c.getTime());
                                numYear1 = String.valueOf(Integer.parseInt(date1 + 543));
                                numYear2 = String.valueOf(1 + Integer.parseInt(date1 + 543));
                                txtCarAge.setText(String.valueOf((2556 - Integer.parseInt(al3.get(position).substring(5))) + 1) + "ปี");
                                txtMachine.setText(bTemp[3].toString());
                                txtCarGroup.setText(bTemp[4].toString());
                                txtProtection.setText(date + numYear1);
                                txtFinished.setText(date + numYear2);     // bug
                                String mode = "";
                                getagef = Double.parseDouble(al3.get(position).substring(5));    // not same
                                mode = bTemp[4].toString().trim();
                                min = Double.parseDouble(bTemp[6].toString().trim().replace(",", ""));
                                max = Double.parseDouble(bTemp[7].toString().trim().replace(",", ""));
                                if (min == 0 && max == 0) {
                                    Toast.makeText(CalCarActivity.this, String.valueOf("ไม่มีข้อมูลของรถยี้ห้อนี้"), Toast.LENGTH_LONG).show();
                                    btnCal.setEnabled(false);
                                } else {
                                    btnCal.setEnabled(true);
                                }
                                minf = sentAmount1.maxmin(min, getagef, mode);
                                maxf = sentAmount1.maxmin(max, getagef, mode);

                                min=0.0;max=0.0;
                                min = minf * FIX80;
                                max = maxf * FIX90;
                                avg = (min+max)/2;
                                amountmin = formatter.format(min);
                                amountavg = formatter.format(avg);
                                amountmax = formatter.format(max);
                                txtMax.setText(amountmin);
                                txtAvg.setText(amountavg);
                                txtMin.setText(amountmax);
                                txtInsur.setText(R.string.default0);
                                txtInsurTotal.setText(R.string.default0);
                                txtRepairC.setText(R.string.default0);
                                txtRepairCTotal.setText(R.string.default0);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                                Toast.makeText(CalCarActivity.this, String.valueOf("Your Selected Empty"), Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(CalCarActivity.this, String.valueOf("Your Selected Empty"), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(CalCarActivity.this, String.valueOf("Your Selected Empty"), Toast.LENGTH_LONG).show();
            }
        });

        Button btnDia = (Button)findViewById(R.id.btnDialog);
        btnDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaCalCar.show();
                Button btnClose = (Button) findViewById(R.id.btnClose);
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xx1 = formatter.format(Double.parseDouble(txtTppd.getText().toString().replace(",", "").trim()));
                        xx2 = formatter.format(Double.parseDouble(txtTpbi.getText().toString().replace(",", "").trim()));
                        xx3 = formatter.format(Double.parseDouble(txtDamageX.getText().toString().replace(",", "").trim()));
                        xx4 = formatter.format(Double.parseDouble(txtPa.getText().toString().replace(",", "").trim()));
                        xx5 = formatter.format(Double.parseDouble(txtMe.getText().toString().replace(",", "").trim()));
                        xx6 = formatter.format(Double.parseDouble(txtBail.getText().toString().replace(",", "").trim()));
                        xx7 = formatter.format(Double.parseDouble(txtOd.getText().toString().replace(",", "").trim()));
                        xx8 = formatter.format(Double.parseDouble(txtTp.getText().toString().replace(",", "").trim()));

                        txtTppd.setText(xx1);
                        txtTpbi.setText(xx2);
                        txtDamageX.setText(xx3);
                        txtPa.setText(xx4);
                        txtMe.setText(xx5);
                        txtBail.setText(xx6);
                        txtOd.setText(xx7);
                        txtTp.setText(xx8);
                        bmode = Integer.parseInt(txtStypeuseCar.getText().toString().trim());
                        if (bmode == 110 || bmode == 120)
                            diaCalCar.cancel();
                        else {
                            Toast.makeText(CalCarActivity.this, String.valueOf(R.string.msgcalinsur1), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
    public class MyCustomAdapter extends ArrayAdapter<String> {
        public MyCustomAdapter(Context context, int textViewResourceId,String[] objects, Integer[] image) {super(context, textViewResourceId, objects);}
        @Override
        public View getDropDownView(int position, View convertView,ViewGroup parent) {return getCustomView(position, convertView, parent);}
        @Override
        public View getView(int position, View convertView, ViewGroup parent) { return getCustomView(position, convertView, parent);}
        public View getCustomView(int position, View convertView,ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.itemspinner, parent, false);
            TextView label = (TextView) row.findViewById(R.id.nband);
            label.setText(al11[position]);
            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            icon.setImageResource(im[position]);
            return row;
        }
    }
}
