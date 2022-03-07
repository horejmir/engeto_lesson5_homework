package com.engeto.lesson5;

import java.util.List;

public class PlantMultiException extends PlantException {

    private final List<PlantException> exceptionList;

    public PlantMultiException(List<PlantException> list) {
        super();
        this.exceptionList = list;
    }

    public void add(PlantException exp) {
        this.exceptionList.add(exp);
    }

    public List<PlantException> getExceptionList() {
        return exceptionList;
    }

    @Override
    public String getMessage() {
        StringBuilder messages = new StringBuilder();
        for (PlantException exp : exceptionList)
            messages.append(exp.getMessage()).append("\n");
        return messages.toString();
    }
}
