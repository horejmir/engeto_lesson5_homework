package com.engeto.lesson5;

import java.util.ArrayList;
import java.util.List;

public class PlantMultiException extends PlantException{

    private List<PlantException> exceptionList;

    public PlantMultiException(List<PlantException> list) {
        super("");
        this.exceptionList = list;
    }

    public void add(PlantException exp){
        this.exceptionList.add(exp);
    }

    public List<PlantException> getExceptionList() {
        return exceptionList;
    }

    @Override
    public String getMessage() {
            String messages = "";
            for(PlantException exp : exceptionList)
                messages += exp.getMessage() + "\n";
            return messages;
    }
}
