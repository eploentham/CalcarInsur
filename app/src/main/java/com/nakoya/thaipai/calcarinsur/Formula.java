package com.nakoya.thaipai.calcarinsur;

/**
 * Created by ekapop on 1/28/2016.
 */
public class Formula {
    public Double amount1(int in1,int in2){
        Double INSURSMODECAR110=0.0;
        Integer in3=0;
        if(in1>=1 && in1<=5){
            in3 = 7600;
        }
        else if(in1>=6 && in1<=10){
            in3 = 8600;
        }
        else{
            in3 = 9600;
        }
        if((in2 >= 1) && (in2 <= 4)){
            INSURSMODECAR110 = (double) in3;
        }
        else if((in2 == 5) && (in1 <= 10)){
            INSURSMODECAR110 = (double) in3+(in3*10/100);
        }
        else{
            //INSURSMODECAR110 = (double) 11000;
            INSURSMODECAR110 = 11000.0;
        }
        return INSURSMODECAR110;
    }
    public Double amount1210(int in1,int in2){
        Double in3=0.00;
        if(in1>=1 && in1<=5){
            in3 = 12000.00;
        }
        else if(in1>=6 && in1<=10){
            in3 = 13500.00;
        }
        else{
            in3 = 15000.00;
        }
        return in3;
    }
    public Double amount1320(int in1,int in2){
        Double in3=0.00;
        if(in1>=1 && in1<=5){
            in3 = 13000.00;
        }
        else if(in1>=6 && in1<=10){
            in3 = 14500.00;
        }
        else{
            in3 = 16000.00;
        }
        return in3;
    }
    public Double amount2(int in1,Double amount1){
        Double paAmount =0.0, meAmount=0.0,bailbondAmount=0.0, amount2=0.0;
        if(in1>= 1 && in1 <= 5){
            paAmount = 10.0;
            meAmount = 10.0;
            bailbondAmount = 10.0;
        }
        else if((in1>=6) && (in1 <= 10)){
            paAmount = 450.0;
            meAmount = 30.0;
            bailbondAmount = 500.0;
        }
        else{
            paAmount = 900.0;
            meAmount = 60.0;
            bailbondAmount = 1000.0;
        }
        amount2 = amount1 + (paAmount+meAmount+bailbondAmount);
        return amount2;
    }
    public Double amount2210(int in1,Double amount1,String mode){
        Double paAmount =0.0, meAmount=0.0,bailbondAmount=0.0, amount2=0.0;
        if(mode.equalsIgnoreCase("210"))
            if(in1>= 1 && in1 <= 5){
                paAmount = 270.0;
                meAmount = 45.0;
                bailbondAmount = 300.0;
            }
            else{
                paAmount = 900.0;
                meAmount = 150.0;
                bailbondAmount = 1000.0;
            }
        else if(mode.equalsIgnoreCase("220")||mode.equalsIgnoreCase("230")){
            paAmount = (double) 900;
            meAmount = (double) 250;
            bailbondAmount = (double) 1000;
        }
        amount2 = amount1 + (paAmount+meAmount+bailbondAmount);
        return amount2;
    }
    public Double amount2320(int in1,Double amount1,String mode){
        Double paAmount =0.0, meAmount=0.0,bailbondAmount=0.0, amount2=0.0;
        if(mode.equalsIgnoreCase("320")||mode.equalsIgnoreCase("340"))
            if(in1>= 1 && in1 <= 5){
                paAmount = 300.0;
                meAmount = 75.0;
                bailbondAmount = 500.0;
            }
            else{
                paAmount = 600.0;
                meAmount = 150.0;
                bailbondAmount = (double) 1000;
            }
        amount2 = amount1 + (paAmount+meAmount+bailbondAmount);
        return amount2;
    }
    public Double amount2410(int in1,Double amount1,String mode){
        Double paAmount =0.0, meAmount=0.0,bailbondAmount=0.0, amount2=0.0;
        if(mode.equalsIgnoreCase("210"))
            if(in1>= 1 && in1 <= 5){
                paAmount = 585.0;
                meAmount = 108.0;
                bailbondAmount = 300.0;
            }
            else{
                paAmount = 1950.0;
                meAmount = 360.0;
                bailbondAmount = 1000.0;
            }
        else if(mode.equalsIgnoreCase("220") || mode.equalsIgnoreCase("230")){
            paAmount = 1950.0;
            meAmount = 600.0;
            bailbondAmount = 1000.0;
        }
        amount2 = amount1 + (paAmount+meAmount+bailbondAmount);
        return amount2;
    }
    public Double amount3(Double odInput,Double tpInput,Double amount2,Double fleet1,Double ncb1,Double other1){
        Double tp=0.0, discountGroup=0.0, temp=0.0,discountHis=0.0, discountOther=0.0,amount3=0.0;
        if(odInput <=5000){
            odInput = odInput;
        }else{
            odInput = (5000+((odInput-5000)*0.1));
        }
        if(tpInput<=5000){
            tp = tpInput*0.1;
        }else{
            tp = (5000*0.1) + ((tpInput-5000)*0.01);
        }
        temp = amount2 - (odInput+tp);
        discountGroup = (temp - Math.floor(temp * (fleet1/100)));
        discountHis = (discountGroup - Math.floor(discountGroup *(ncb1/100)));
        amount3 = (discountHis - Math.floor(discountHis *(other1/100)));
        return amount3;
    }
    public Double amount3210(Double odInput,Double tpInput,Double amount2,Double fleet1,Double ncb1,Double other1){
        Double tp=0.0, discountGroup=0.0, temp=0.0,discountHis=0.0, discountOther=0.0,amount3=0.0;
        if(odInput <=5000){
            odInput = odInput;
        }else{
            odInput = (5000+((odInput-5000)*0.1));
        }
        if(tpInput<=5000){
            tp = tpInput*0.1;
        }else{
            tp = (5000*0.1) + ((tpInput-5000)*0.01);
        }
        temp = amount2 - (odInput+tp);
        discountGroup = (temp - Math.ceil(temp * (fleet1/100)));
        discountHis = (discountGroup - Math.ceil(discountGroup *(ncb1/100)));
        amount3 = (discountHis - Math.ceil(discountHis *(other1/100)));
        return amount3;
    }
    public Double amount3210x1(Double odInput,Double tpInput,Double amount2,Double fleet1,Double ncb1,Double other1,Integer in1){
        Double tp=0.0, discountGroup=0.0, temp=0.0,discountHis=0.0, discountOther=0.0,amount3=0.0;
        ncb1 = (double) 0;
        fleet1 = (double) 0;
        other1 = (double) 0;
        if(in1 == 1){
            other1 = (double) 15;
        }
        if(odInput <=5000){
            odInput = odInput;
        }else{
            odInput = (5000+((odInput-5000)*0.1));
        }
        if(tpInput<=5000){
            tp = tpInput*0.1;
        }else{
            tp = (5000*0.1) + ((tpInput-5000)*0.01);
        }
        temp = amount2 - (odInput+tp);
        discountGroup = (temp - Math.ceil(temp * (fleet1/100)));
        discountHis = (discountGroup - Math.ceil(discountGroup *(ncb1/100)));
        amount3 = (discountHis - Math.ceil(discountHis *(other1/100)));
        return amount3;
    }
    public Double amount3410x1(Double odInput,Double tpInput,Double amount2,Double fleet1,Double ncb1,Double other1,Integer in1,int bmode){
        Double tp=0.0, discountGroup=0.0, temp=0.0,discountHis=0.0, discountOther=0.0,amount3=0.0;
        ncb1 = (double) 0;
        fleet1 = (double) 0;
        other1 = (double) 0;
        if(in1 == 1 && bmode == 210){
            other1 = (double) 15;
        }
        if(odInput <=5000){
            odInput = odInput;
        }else{
            odInput = (5000+((odInput-5000)*0.1));
        }
        if(tpInput<=5000){
            tp = tpInput*0.1;
        }else{
            tp = (5000*0.1) + ((tpInput-5000)*0.01);
        }
        temp = amount2 - (odInput+tp);
        discountGroup = (temp - Math.ceil(temp * (fleet1/100)));
        discountHis = (discountGroup - Math.ceil(discountGroup *(ncb1/100)));
        amount3 = (discountHis - Math.ceil(discountHis *(other1/100)))
        ;
        return amount3;
    }
    public Double amount3320(Double odInput,Double tpInput,Double amount2,Double fleet1,Double ncb1,Double other1,Integer in1){
        Double tp=0.0, discountGroup=0.0, temp=0.0,discountHis=0.0, discountOther=0.0,amount3=0.0;
        ncb1 = 0.0;
        fleet1 = 0.0;
        other1 = 0.0;
        if(odInput <=5000){
            odInput = odInput;
        }else{
            odInput = (5000+((odInput-5000)*0.1));
        }
        if(tpInput<=5000){
            tp = tpInput*0.1;
        }else{
            tp = (5000*0.1) + ((tpInput-5000)*0.01);
        }
        temp = amount2 - (odInput+tp);
        discountGroup = (temp - Math.ceil(temp * (fleet1/100)));
        discountHis = (discountGroup - Math.ceil(discountGroup *(ncb1/100)));
        amount3 = (discountHis - Math.ceil(discountHis *(other1/100)));
        return amount3;
    }
    public Double amount4(Double amount3){
        final Double TAX1=0.004;
        final Double TAX=0.07;
        Double amount4=0.00, tempTax=0.0, tempThird=0.0;
        tempTax = (double) Math.ceil(amount3 * TAX1);
        tempThird = (tempTax+amount3) * TAX;
        amount4 = amount3+tempTax+tempThird;
        return amount4;
    }
    public Double maxmin(Double max,Double getagef,String mode){
        Double maxf = 0.0;
        if(mode.equalsIgnoreCase("1") || mode.equalsIgnoreCase("2")){
            maxf = max * (Math.pow(0.865,getagef));
        }
        if(mode.equalsIgnoreCase("3") || mode.equalsIgnoreCase("4") || mode.equalsIgnoreCase("5")){
            maxf = max * (Math.pow(0.9,getagef));
        }
        return maxf;
    }
    public Double maxmin210(Double max,Double getagef){
        Double maxf = 0.0;
        maxf = max * (Math.pow(0.9,getagef));
        return maxf;
    }
}
